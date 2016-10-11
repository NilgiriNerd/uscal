package com.uscal.core;

import java.util.UUID;

/**
 * Default implementation of a TagGenerator that uses a GUID generated
 * during instantiation to derive an unique id.
 * 
 * @author NilgiriNerd
 *
 */
public class DefaultTagGenerator implements ITagGenerator {

	private String id;
	
	public DefaultTagGenerator() {
		UUID guid = UUID.randomUUID();
		int hashCode = guid.toString().hashCode();
		id = Integer.toString(hashCode);
	}
	
	@Override
	public String getId() {
		return id;
	}

}
