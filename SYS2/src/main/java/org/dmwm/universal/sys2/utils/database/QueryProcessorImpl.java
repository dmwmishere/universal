package org.dmwm.universal.sys2.utils.database;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.dmwm.universal.core.data.xsds.MemeInfoType;
import org.dmwm.universal.core.data.xsds.MemeType;
import org.dmwm.universal.core.data.xsds.Response;
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
	

}
