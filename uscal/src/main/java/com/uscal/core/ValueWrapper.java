package com.uscal.core;
/**
 * This class wraps the value being placed into cache and includes
 * the unique identifier associated with the application
 * for added controls.
 * 
 * @author NilgiriNerd
 *
 */
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
