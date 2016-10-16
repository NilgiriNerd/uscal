package com.uscalexample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.uscalexample.bo.MyBO;
import com.uscalexample.dto.QuoteDTO;

@RestController
@RequestMapping("uscalexample")
public class Controller {
	
	@Autowired
	private MyBO bo;
	
	@RequestMapping("/quote")
	public QuoteDTO quote(@RequestParam(value="code",required=false,defaultValue="DFS") String code ){
			return bo.quote(code);
	}

}
