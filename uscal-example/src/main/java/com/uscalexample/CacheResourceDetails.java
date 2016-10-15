package com.uscalexample;

public class CacheResourceDetails {
	private LocatorEndPointInfo[] locators;
	private int readTimeout;
	private int minConnections;
	private int maxConnections;
	
	public LocatorEndPointInfo[] getLocators() {
		return locators;
	}
	public void setLocators(LocatorEndPointInfo[] locators) {
		this.locators = locators;
	}
	public int getReadTimeout() {
		return readTimeout;
	}
	public void setReadTimeout(int readTimeout) {
		this.readTimeout = readTimeout;
	}
	public int getMinConnections() {
		return minConnections;
	}
	public void setMinConnections(int minConnections) {
		this.minConnections = minConnections;
	}
	public int getMaxConnections() {
		return maxConnections;
	}
	public void setMaxConnections(int maxConnections) {
		this.maxConnections = maxConnections;
	}
}
