package org.dmwm.universal.core.stats;

public interface StatsHolder {
	public void putStat(String name);
	public Long startOperation(String id);
	public Long stopOperation(String id);
	public void putOperation(String id, String name, long finishTime, long responseTime);
//	public Map<String, Long> getAllStats();
}
