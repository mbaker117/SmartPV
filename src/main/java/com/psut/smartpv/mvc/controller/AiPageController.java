/*
 * @author MohammedBaker & Abd-Alqader Okasha
 */
package com.psut.smartpv.mvc.controller;

import java.text.DecimalFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.psut.smartpv.data.AiInfoData;
import com.psut.smartpv.service.AiService;

/**
 * The Class AiPageController.
 */
@Controller
public class AiPageController {
	
	/** The ai service. */
	@Autowired
	private AiService aiService;
	
	/**
	 * Ai info.
	 *
	 * @param model the model
	 * @return the string
	 */
	@RequestMapping("/ai")
	public String aiInfo(Model model) {
		try {
			AiInfoData aiInfoData = aiService.getAiInfoData();
			DecimalFormat formater = new DecimalFormat("##.##");
			aiInfoData.setError(Double.valueOf(formater.format(aiInfoData.getError()*100)));
			model.addAttribute("info",aiInfoData);
		
		}catch(Exception ex) {
			ex.printStackTrace();
			model.addAttribute("info",new AiInfoData());
		}
		
		
		return "aiModule";
		
	}

}
