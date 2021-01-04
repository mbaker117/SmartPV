package com.psut.smartpv.mvc.controller;

import java.text.DecimalFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.psut.smartpv.data.AiInfoData;
import com.psut.smartpv.service.AiService;

@Controller
public class AiPageController {
	
	@Autowired
	private AiService aiService;
	
	@RequestMapping("/ai")
	public String aiInfo(Model model) {
		try {
			AiInfoData aiInfoData = aiService.getAiInfoData();
			DecimalFormat formater = new DecimalFormat("##.##");
			aiInfoData.setEfficiency(Double.valueOf(formater.format(aiInfoData.getEfficiency()*100)));
			model.addAttribute("info",aiInfoData);
		
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
		
		return "aiModule";
		
	}

}
