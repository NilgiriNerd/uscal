package com.uscalexample.bo;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import com.uscalexample.dto.QuoteDTO;

@Component
public class MyBO {
	
	@Value("${cache.enable}")
	private boolean enableCaching;
	
	private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd:hh:mm:ss");
	
	@Cacheable(cacheNames="quote",key="#code",condition="{#root.target.enableCaching}") // WORKED
	//@Cacheable(cacheNames="quote",key="#code",condition="#root.target.systemProperties['cache.enable']") // NOT WORKING Property or field 'systemProperties' cannot be found on object of type 
	//@Cacheable(cacheNames="quote",key="#code",condition="{#systemProperties['cache.enable']}") // NOT WORKING org.springframework.expression.spel.SpelEvaluationException: EL1012E:(pos 18): Cannot index into a null value
	public QuoteDTO quote(String code){
		System.out.println("Getting data from the backend");
		String dateStr = sdf.format(new Date());
		return new QuoteDTO(code,dateStr,new BigDecimal(50.0));
	}
	
	public boolean isEnableCaching(){
		return enableCaching;
	}
}
