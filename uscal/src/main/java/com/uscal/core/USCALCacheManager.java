package com.uscal.core;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.aop.framework.ProxyFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;

public class USCALCacheManager implements CacheManager {
	
	@Autowired
	@Qualifier("cacheManager")
	private CacheManager cacheManager;
	
	private Object lock = new Object();
	
	@Autowired
	private ITagGenerator tagGenerator;
	
	private Map<String,Cache> cacheMap = new HashMap<String,Cache>();
	
	public Cache getCache(String name){
		if (cacheMap.containsKey(name))
			return cacheMap.get(name);
		else {
			synchronized (lock) {
				
				if (!cacheMap.containsKey(name)){
				
					Cache cache = cacheManager.getCache(name);
			        ProxyFactory factory = new ProxyFactory(cache);
			        factory.addInterface(Cache.class);
			        factory.addAdvice(new USCALMethodInterceptor(tagGenerator));
	
			        Cache proxiedcache = (Cache) factory.getProxy();
			        
			        cacheMap.put(name, proxiedcache);	
				}
			}	
			
	        return cacheMap.get(name);
		}
		
	}

	@Override
	public Collection<String> getCacheNames() {
		return cacheManager.getCacheNames();
	}
	
}
