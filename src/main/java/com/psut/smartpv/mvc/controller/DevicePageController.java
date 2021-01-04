package com.psut.smartpv.mvc.controller;

import java.text.ParseException;
import java.util.Collections;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.psut.smartpv.dto.HistoryNumbersDto;
import com.psut.smartpv.exception.SmartPvException;
import com.psut.smartpv.facade.DeviceReadingFacade;
import com.psut.smartpv.model.Device;
import com.psut.smartpv.model.RealTimeReading;
import com.psut.smartpv.service.DeviceService;
import com.psut.smartpv.service.ExpectedReadingService;
import com.psut.smartpv.service.RealTimeReadingService;

@Controller
public class DevicePageController {
	@Autowired
	private DeviceService deviceService;

	
	@Autowired
	private RealTimeReadingService realTimeReadingService;
	
	@Autowired
	private ExpectedReadingService expectedReadingService;
	
	@Autowired
	private DeviceReadingFacade deviceReadingFacade;
	
	@RequestMapping("/device")
	public String device(Model model) {
		model.addAttribute("devices", deviceService.getAllDevices());
		return "device";
	}

	@GetMapping("/deleteDevice")
	public String deleteUser(@RequestParam("deviceId") long id) throws SmartPvException {
		deviceService.deleteDevice(id);
		return "redirect:/device";
	}

	@RequestMapping("/addDeviceForm")
	public String addUserForm(Model model) {
		model.addAttribute("device", new Device());

		return "deviceForm";
	}

	@PostMapping("saveDevice")
	public String saveStudent(@Valid @ModelAttribute("device") Device device, BindingResult bindingResult) {
		System.out.println(bindingResult);
		if (bindingResult.hasErrors())
			return "deviceForm";

		try {

			if (device.getId() == 0)
				deviceService.addDevice(device.getImei(), device.getLongitude(), device.getLatitude(),
						device.getRatedOut(), device.getRatedCapacity(), device.getTiltAngleHorizontal(),
						device.getTiltAngleVertical());

			else {

				deviceService.updateDevice(device.getId(), device.getImei(), device.getLongitude(),
						device.getLatitude(), device.getRatedOut(), device.getRatedCapacity(),
						device.getTiltAngleHorizontal(), device.getTiltAngleVertical());
				if (!device.isActivated()) {
					deviceService.deActivateDevice(device.getId());
					deviceService.setWorking(device.getId(), false);
				}
			}

			if (device.isActivated())
				deviceService.activateDeviceById(device.getId());
		} catch (SmartPvException e) {
				bindingResult.rejectValue("imei","imei.device",e.getMessage());
			return "deviceForm";
		}

		return "redirect:/device";
	}

	@RequestMapping("/editDeviceForm")
	public String editUserForm(Model model, @RequestParam("deviceId") long id) {
		model.addAttribute("device", deviceService.getDeviceById(id).get());

		return "deviceForm";
	}
	
	
	@RequestMapping("/deviceRealTimeReading")
	public String realTimeReadings(Model model, @RequestParam("deviceId") long id) {
		try {
			List<RealTimeReading> realTimeReadingByDevice = realTimeReadingService.getRealTimeReadingByDevice(id);
			Collections.reverse(realTimeReadingByDevice);
			model.addAttribute("readings",realTimeReadingByDevice);
		} catch (SmartPvException e) {
			model.addAttribute("readings",Collections.EMPTY_LIST);
		}

		return "deviceRealTimeReadings";
	}
	
	
	@RequestMapping("/deviceExpectedReading")
	public String expectedReadings(Model model, @RequestParam("deviceId") long id) {
		try {
			String imei = deviceService.getDeviceById(id).get().getImei();
			List<HistoryNumbersDto> historyNumbers = deviceReadingFacade.getHistoryNumbers(imei);
			
			  Collections.reverse(historyNumbers);
			 
			model.addAttribute("readings",historyNumbers);
		} catch (SmartPvException | ParseException e) {
			model.addAttribute("readings",Collections.EMPTY_LIST);
		}

		return "deviceExpectedReadings";
	}
	
	
	

	@InitBinder
	public void validate(WebDataBinder webDataBinder) {
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
		webDataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
	}

}
