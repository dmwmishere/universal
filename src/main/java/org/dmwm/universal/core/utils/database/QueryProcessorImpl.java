package org.dmwm.universal.core.utils.database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.dmwm.universal.sys1.data.xsds.MemeInfoType;
import org.dmwm.universal.sys1.data.xsds.MemeType;
import org.dmwm.universal.sys1.data.xsds.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class QueryProcessorImpl implements QueryProcessor {

	private static final Logger log = Logger.getLogger(QueryProcessorImpl.class);

	private JdbcTemplate jdbct;

	@Autowired
	public void setJdbct(DataSource dataSource) {
		log.info("Setting connection...");
		jdbct = new JdbcTemplate(dataSource);
	}

	@Override
	public Response getMeme(int id) {
		log.info("Quering db with id = " + id);
		return jdbct.queryForObject("select * from memes where id = ?", new Object[]{id}, new RowMapper<Response>(){
			@Override
			public Response mapRow(ResultSet resst, int rownum) throws SQLException {
				Response rs = new Response();
				MemeInfoType mi = new MemeInfoType();
				mi.setName(resst.getString("name"));
				mi.setBadge(resst.getString("badge"));
				mi.setOrigin(resst.getString("origin"));
				mi.setStatus(resst.getString("status"));
				mi.setType(resst.getString("type")==null?null:MemeType.valueOf(MemeType.class, resst.getString("type").toUpperCase()));
				mi.setYear(resst.getInt("year"));
				rs.setMemeInfo(mi);
				return rs;
			}

		});
		
	}

	@Override
	public void insertMeme(MemeInfoType mit) {
		jdbct.update("insert into memes (name, type, year, status, origin, badge) values (?, ?, ?, ?, ?, ?)",
				mit.getName(), mit.getType(), mit.getYear(), mit.getStatus(), mit.getOrigin(), mit.getBadge());
	}

	@Override
	public void startOperation(String uuid, int operId, String data, int state) {
		jdbct.update("insert into operations (uuid, operationid, data, state) values (?, ?, ?, ?)", uuid, operId, data, state);
	}

	@Override
	public Long stopOperation(String uuid) {
		jdbct.update("update operations set stoptime = ?, state = 1 where uuid = ?", Timestamp.valueOf(LocalDateTime.now()), uuid);
		return null;
	}
	

}
