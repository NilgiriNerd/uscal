package com.uscal.core;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.cache.support.SimpleValueWrapper;


public class USCALMethodInterceptor implements MethodInterceptor {

	ITagGenerator tg;
	
	public USCALMethodInterceptor(ITagGenerator tg) {
		this.tg = tg;
	}
	
	@Override 
	public Object invoke(MethodInvocation invocation) throws Throwable {

		String mName = invocation.getMethod().getName();
		if (mName.equalsIgnoreCase("get")){
			Object[] args = invocation.getArguments();
			if (args[0] instanceof String){
				args[0] = tg.getId()+"|"+args[0];
			} else {
				args[0] = new ValueWrapper(tg.getId(), args[0]);
			}
			
			Object o = invocation.proceed();
			
			Object value = o;
			if (o instanceof SimpleValueWrapper){
				value = ((SimpleValueWrapper) o).get();
			}
			
			if (value instanceof String) {
				String[] parts = ((String)value).split("\\|", 2);
				if (parts.length == 2){
					if (parts[0].equals(tg.getId())){
						return new SimpleValueWrapper(parts[1]);
					}
				}
				
				return null;
			} else {
				if (value instanceof ValueWrapper){
					if (((ValueWrapper) value).getTag().equals(tg.getId())){
						return new SimpleValueWrapper(((ValueWrapper) value).getValue());
					}					
				}
				
				return null;
			}
		} else if (mName.equalsIgnoreCase("put") || mName.equalsIgnoreCase("putIfAbsent")){
			
			Object[] args = invocation.getArguments();
			
			if (args[0] instanceof String){
				args[0] = tg.getId()+"|"+args[0];
			} else {
				args[0] = new ValueWrapper(tg.getId(), args[0]);
			}	
			
			if (args[1] instanceof String){
				args[1] = tg.getId()+"|"+args[1];
			} else {
				args[1] = new ValueWrapper(tg.getId(), args[1]);		
			}
			
			Object o = invocation.proceed();
			
			
			return o;
		}
		
		return null;

	}

}
