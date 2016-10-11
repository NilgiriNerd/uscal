package test.uscal.core;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.uscal.core.ValueWrapper;

public class ValueWrapperTest {
    @Test 
    public void testValueWrapper() {
    	ValueWrapper vw = new ValueWrapper("tag", "value");
    	assertTrue("tag".equals(vw.getTag()));
    	assertTrue("value".equals(vw.getValue()));
    }
}
