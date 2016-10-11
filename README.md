#USCAL
##Unified Side-Cache for Application Layer

Spring Cache Abstraction provides an easy way to implement side caches within applications. However, when using distributed Caching solutions such as Gemfire/Geode as the backing infrastructure, it is required to setup individual Regions for each use case to avoid Key Conflicts. This adds to the setup required to leverage Gemfire for side-caching.	

USCAL provides a Customized CacheManager for use with Spring Cache Abstraction Annotations that facilitates utilizing a single global Side Cache Region across multiple applications. It appends application specific unique key prefixes to cache requests on the fly. This avoids key conflicts and hence removes the need to create regions specific to each use-case.


###Usage

To use the CacheManager create the following beans in your Configuration Class

```Java
@Configuration
@EnableCaching
public class CacheConfiguration {
	...
	...
	...
    
    @Primary
    @Bean(name="cacheManager")
    public CacheManager cacheManager() throws Exception {
        GemfireCacheManager cacheManager = new GemfireCacheManager();
        cacheManager.setCache((Cache) getClientCache());

        return cacheManager;
    }    
	
    @Bean(name="uscalCacheManager")
    public USCALCacheManager myCacheManager() throws Exception {
    	USCALCacheManager mycachemanager = new USCALCacheManager();
       return mycachemanager;
    }    
	  
    @Bean
    public ITagGenerator tagGenerator(){
    	ITagGenerator tg = new DefaultTagGenerator();
    	return tg;
    }
    
```

