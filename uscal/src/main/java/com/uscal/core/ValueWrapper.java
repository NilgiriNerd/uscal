package com.uscal.core;

public class ValueWrapper {
	private String tag;
	private Object value;
	
	public ValueWrapper(){
		
	}
	
	public ValueWrapper(String tag,Object value){
		this.tag =tag;
		this.value =value;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}
}
