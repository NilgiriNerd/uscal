package com.uscal.core;

public class AppIdTagGenerator implements ITagGenerator {

	
	private String applicationId = null;
	
	public AppIdTagGenerator(String applicationId){
		this.applicationId = applicationId;
	}
	
	@Override
	public String getId() {
		return applicationId;
	}

}
