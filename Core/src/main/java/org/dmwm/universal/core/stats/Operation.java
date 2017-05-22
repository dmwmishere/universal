package org.dmwm.universal.core.stats;

public class Operation {
	private final String id;
	private final String name;
	private final long startTime;
	private final long responseTime;
	public Operation(String id, String name, long startTime, long responseTime) {
		this.id = id;
		this.name = name;
		this.startTime = startTime;
		this.responseTime = responseTime;
	}
	public String getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public long getResponseTime() {
		return responseTime;
	}
	@Override
	public String toString(){
		return "Operations,ID=" + id + ",Name=" + name + " value=" + responseTime + " " + startTime + "\n";
	}
	
}
