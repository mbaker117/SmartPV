package com.psut.smartpv.mvc.controller;

import java.util.stream.Collectors;

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

import com.psut.smartpv.exception.SmartPvException;
import com.psut.smartpv.exception.type.SmartPvExceptionType;
import com.psut.smartpv.model.User;
import com.psut.smartpv.service.UserService;

@Controller
public class UserPageController {

	@Autowired
	private UserService userService;

	@RequestMapping("/user")
	public String user(Model model) {
		model.addAttribute("users", userService.getAllUsers());
		return "user";
	}

	@GetMapping("/deleteUser")
	public String deleteUser(@RequestParam("userId") long id) throws SmartPvException {
		userService.deleteUser(id);
		return "redirect:/user";
	}

	@RequestMapping("/addUserForm")
	public String addUserForm(Model model) {
		model.addAttribute("user", new User());

		return "userForm";
	}

	@PostMapping("saveUser")
	public String saveStudent(@Valid @ModelAttribute("user") User user, BindingResult bindingResult) {
		System.out.println(bindingResult);
		if (bindingResult.hasErrors())
				return "userForm";

		try {

			if (user.getId() == 0)
				userService.addUser( user.getEmail(),user.getFirstName(), user.getLastName(), user.getPassword());
			else {

				String password = userService.getUserById(user.getId()).get().getPassword();
				user.setPassword(password);
				userService.updateUser(user);
			}

		} catch (SmartPvException e) {
			if(e.getType()==SmartPvExceptionType.EMAIL_ALREADY_EXIST)
				bindingResult.rejectValue("email", "error.user",e.getMessage());
			
		
			return "userForm";
		}

		return "redirect:/user";
	}

	@RequestMapping("/editUserForm")
	public String editUserForm(Model model, @RequestParam("userId") long id) {
		model.addAttribute("user", userService.getUserById(id).get());

		return "userForm";
	}

	@RequestMapping("/userDevice")
	public String userDevices(Model model, @RequestParam("userId") long id) {
		model.addAttribute("devices", userService.getUserById(id).get().getDevices().stream().sorted().collect(Collectors.toList()));

		return "userDevices";
	}
	
	@InitBinder
	public void validate(WebDataBinder webDataBinder) {
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
		webDataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
	}
}
