package com.spring.controller;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PrimeController {

	private static final Logger LOGGER = LoggerFactory.getLogger(PrimeController.class);

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String init(Model model) {
		model.addAttribute("msg", "Please Enter Numbers");
		return "login";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String submit(Model model, @ModelAttribute("primeBean") PrimeNumber primeBean) {
		LOGGER.info("Prime Numbers : "+primeBean);
		if (primeBean != null && primeBean.getNumber() != null ) {
			List<Integer> list=new ArrayList<Integer>();
			String str=primeBean.getNumber();
			str=str.replace("{ ", "");
			str=str.replace(" }", "");
			String[] splitComma = str.split(" , ");
			for(String s : splitComma){
				String str2=s.replace("[", "");
				String str3=str2.replace("]", "");
				String[] ss = str3.split(",");
				int i=Integer.parseInt(ss[0]);
				int n=Integer.parseInt(ss[1]);
				int num =0;
				for (i = i; i <= n; i++) { 		 		  
					int counter=0; 		  
					for(num =i; num>=1; num--) {
						if(i%num==0) {
							counter = counter + 1;
						}
					}
					if (counter ==2){
						list.add(i);
					}	
					model.addAttribute("msg", list);
				}
			}
			return "success";
		} else {
			model.addAttribute("error", "Invalid Numbers");
			return "login";
		} 
	}
}
