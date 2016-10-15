package com.uscalexample;

import java.util.Properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.gemfire.client.ClientCacheFactoryBean;
import org.springframework.data.gemfire.support.ConnectionEndpoint;
import org.springframework.data.gemfire.support.GemfireCacheManager;

import com.gemstone.gemfire.cache.Cache;
import com.gemstone.gemfire.cache.client.ClientCache;
import com.gemstone.gemfire.cache.client.ClientRegionShortcut;
	 
@Configuration
@EnableCaching
public class CacheConfiguration {

	private ClientCache getClientCache() throws Exception {

		CacheResourceDetails crd = getCacheResourceDetails();
		ClientCacheFactoryBean ccf = new ClientCacheFactoryBean();
		ConnectionEndpoint[] ce = new ConnectionEndpoint[crd.getLocators().length];
		for (int i = 0; i < ce.length; i++) {
			ce[i] = new ConnectionEndpoint(crd.getLocators()[i].getHost(), crd.getLocators()[i].getPort());
		}

		ccf.setLocators(ce);
		ccf.setReadTimeout(crd.getReadTimeout());
		ccf.setMaxConnections(crd.getMaxConnections());
		ccf.setMinConnections(crd.getMinConnections());
		ccf.setProperties(gemfireProperties());

		ClientCache cache = (ClientCache) ccf.getObject();

		System.out.println("about to create proxy");
		cache.createClientRegionFactory(ClientRegionShortcut.PROXY).create("quote");

		System.out.println("proxy created");

		return cache;
	}

	@Bean(name = "cacheManager")
	public CacheManager cacheManager() throws Exception {
		GemfireCacheManager cacheManager = new GemfireCacheManager();
		cacheManager.setCache((Cache) getClientCache());

		return cacheManager;
	}

	@Bean
	@ConfigurationProperties("cache.gemfire")
	public CacheResourceDetails getCacheResourceDetails() {
		// TODO still working on how to provide these properties
		return new CacheResourceDetails();
	}

//	@Bean
//	public ICacheActivationStrategy getCacheActiviationStrategy() {
//		return new DeactivateOnErrorThresholdWithAutoRetry();
//	}

	public Properties gemfireProperties() {
		Properties gemfireProperties = new Properties();
		gemfireProperties.setProperty("name", "uscal-example");
		gemfireProperties.setProperty("log-level", "warning");
		//gemfireProperties.setProperty("security-client-auth-init", "");
		//gemfireProperties.setProperty("security-username", "");
		//gemfireProperties.setProperty("security-password", "");
		gemfireProperties.setProperty("mcast-port", "0");
		//gemfireProperties.setProperty("cluster-ssl-enabled", "true");
		//gemfireProperties.setProperty("cluster-ssl-keystore-type", "jks");
		//gemfireProperties.setProperty("cluster-ssl-protocols", "TLSv1.2");
		//gemfireProperties.setProperty("cluster-ssl-require-authentication", "true");
		//gemfireProperties.setProperty("cluster-ssl-truststore", "");
		//gemfireProperties.setProperty("cluster-ssl-truststore-password", "");

		return gemfireProperties;
	}

}

