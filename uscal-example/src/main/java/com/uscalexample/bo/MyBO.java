package com.uscalexample.bo;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import com.uscalexample.dto.QuoteDTO;

@Component
public class MyBO {
	
	private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd:hh:mm:ss");
	
	@Cacheable(cacheNames="quote",key="#code")
	public QuoteDTO quote(String code){
		System.out.println("Getting data from the backend");
		String dateStr = sdf.format(new Date());
		return new QuoteDTO(code,dateStr,new BigDecimal(50.0));
	}
}
