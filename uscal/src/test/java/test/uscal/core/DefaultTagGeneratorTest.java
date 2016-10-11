package test.uscal.core;

import static org.junit.Assert.assertTrue;

import java.util.HashMap;

import org.junit.Test;

import com.uscal.core.DefaultTagGenerator;

public class DefaultTagGeneratorTest {
    @Test 
    public void testDefaultIdGeneration() {
    	int SAMPLE_SIZE = 10000;
    	HashMap<String, String> hashMap = new HashMap<String, String>(SAMPLE_SIZE);
    	for (int i=0;i<SAMPLE_SIZE;i++){
      		DefaultTagGenerator tagGen = new DefaultTagGenerator();
    		String id = tagGen.getId();
    		assertTrue(hashMap.get(id) == null);
    		hashMap.put(id, id);
    	}
    }
}
