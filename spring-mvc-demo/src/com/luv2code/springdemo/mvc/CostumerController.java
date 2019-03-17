package com.luv2code.springdemo.mvc;

import javax.validation.Valid;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/costumer")
public class CostumerController {

	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		StringTrimmerEditor stringTimmerEditor = new StringTrimmerEditor(true);
		dataBinder.registerCustomEditor(String.class, stringTimmerEditor);
	}

	@RequestMapping("/showForm")
	public String showForm(Model model) {
		model.addAttribute("costumer", new Costumer());
		return "costumer-form";
	}

	@RequestMapping("/processForm")
	public String processForm(@Valid @ModelAttribute("costumer") Costumer theCustomer, BindingResult theBindingREsult) {
		if (theBindingREsult.hasErrors()) {
			return "costumer-form";
		} else {
			return "costumer-confirmation";
		}
	}

}
