package org.dmwm.universal.sys1.processors;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.CRC32;
import java.util.zip.Deflater;
import java.util.zip.GZIPOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.commons.lang3.RandomUtils;
import org.apache.log4j.Logger;
import org.dmwm.universal.core.stats.StatsHolder;
import org.dmwm.universal.core.data.xsds.Memedesc;
import org.springframework.beans.factory.annotation.Autowired;


public class GzPacker implements Processor {

	@Autowired
	StatsHolder sh;
	
	private static final Logger log = Logger.getLogger(GzPacker.class);

	public byte[] getCompressed(Map<String, byte[]> files) throws IOException {
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		ZipOutputStream zos = new ZipOutputStream(bos);
		for (String file : files.keySet()) {
			zos.putNextEntry(new ZipEntry(file));
			zos.write(files.get(file));
			zos.closeEntry();
		}
		zos.close();
		bos.close();
		return bos.toByteArray();
	}

	public byte[] getGzCompressed(byte[] data) throws IOException {
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		GZIPOutputStream gzos = new GZIPOutputStream(bos){{def.setLevel(Deflater.NO_COMPRESSION);}};
		gzos.write(data, 0, data.length);
		gzos.finish();
		gzos.close();
		bos.close();
		return bos.toByteArray();
	}

	@Override
	public void process(Exchange msg) throws Exception {
		log.info("Generating a file...");
		Memedesc md = msg.getIn().getBody(Memedesc.class);
		log.info("id = " + md.getId() + ", value = " + md.getUuid());
		byte[] file = null;
		long start1 = System.currentTimeMillis();
		int size = md.getFileType().getSize();
		switch (md.getFileType().getExtension()) {
		case GZ:
			file = getGzCompressed(RandomUtils.nextBytes(size));
			break;
		case ZIP:
			Map<String, byte[]> files = new HashMap<>();
			files.put("2spooky4me.exe", RandomUtils.nextBytes(1024));
			files.put(md.getId() + "_" + md.getUuid(), RandomUtils.nextBytes(size));
			file = getCompressed(files);
			break;
		case PLAIN:
		default:
			file = RandomUtils.nextBytes(size);
		}
		long end1 = System.currentTimeMillis();
		CRC32 crc = new CRC32();
		crc.update(file);
		md.setCrc32(crc.getValue());
		long end2 = System.currentTimeMillis();
		log.info("Generating and compressing data: " + (end1 - start1) + "ms., CRC32 calculation: " + (end2 - end1) + "ms.");
		msg.getOut().setHeader(Exchange.FILE_NAME, md.getUuid() + "." + md.getFileType().getExtension().toString().toLowerCase());
		msg.getOut().setBody(file);
		sh.putStat("FILE");
	}

}
