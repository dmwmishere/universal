package org.dmwm.universal.core.stats;

import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.dmwm.universal.core.utils.database.QueryProcessor;

public class StatsHolderImpl implements StatsHolder {

	@Resource(name="qpi1")
	QueryProcessor qp;
	
	private final String seriesName;

	private static final Logger log = Logger.getLogger(StatsHolderImpl.class);

	private final static Map<String, Long> operations = new ConcurrentHashMap<>();

	private final static Map<String, Long> resptime = new ConcurrentHashMap<>();
	
	private final static Queue<Operation> operQueue = new ConcurrentLinkedQueue<>();

	public StatsHolderImpl(String seriesName) {
		this.seriesName = seriesName;
	}

	@Override
	public void putStat(String name) {
		if (operations.containsKey(name)) {
			operations.put(name, operations.get(name) + 1L);
		} else {
			log.debug(name + " operation is new");
			operations.put(name, 1L);
		}
	}

	public Map<String, Long> getAllStats() {
		return operations;
	}

	public String getAllInfluxStats(boolean set2zero, float period) {
		String influxData = "";
		for (String name : operations.keySet()) {
			if (operations.get(name) != 0L) {
				float value = operations.get(name) / (period / 1000);
				influxData = influxData.concat(seriesName + ",operation=" + name + " " + "value=" + value + "\n");
				if (set2zero)
					operations.put(name, 0L);
			}
		}
		log.debug("Influx data = " + influxData);
		return influxData;
	}

	@Override
	public Long startOperation(String id) {
		qp.startOperation(id, 666, "", 0);
		return resptime.putIfAbsent(id, System.currentTimeMillis());
	}

	@Override
	public Long stopOperation(String id) {
		Long rt = resptime.containsKey(id)?System.currentTimeMillis()-resptime.get(id):-1L;
		qp.stopOperation(id);
		log.debug(id + " response time = " + rt);
		return rt;
	}

	@Override
	public void putOperation(String id, String name, long finishTime, long responseTime) {
		operQueue.offer(new Operation(id, name, finishTime, responseTime));
	}
	
	public String getAllInfluxOperations(int packSize){
		String influxData = "";
		while(--packSize >= 0 && operQueue.size() > 0){
			Operation oper = operQueue.poll();
			influxData = influxData.concat(oper.toString());
		}
		log.debug("Influx operation data = " + influxData);
		return influxData;
	}
}
