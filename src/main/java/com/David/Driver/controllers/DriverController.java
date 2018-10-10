package com.David.Driver.controllers;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.David.Driver.models.License;
import com.David.Driver.models.Person;
import com.David.Driver.services.DriverService;

@Controller
public class DriverController {
	private final DriverService dService;
	
	public DriverController(DriverService x) {
		this.dService = x;
	}
	
	@RequestMapping("/")
	public String index(@ModelAttribute("person") Person person) {
		return "new.jsp";
	}
	
	@RequestMapping(value = "/new", method=RequestMethod.POST)
	public String create(@Valid @ModelAttribute("person") Person person, BindingResult result) {
		if(result.hasErrors()) {
			return "new.jsp";
		}
		else {
			dService.createPerson(person);
			return "redirect:/";
		}
	}
	
	@RequestMapping("/newLicense")
	public String license(Model model , @ModelAttribute("license") License newLicense) {
		List<Person> people = dService.allPeople();
		model.addAttribute("people", people);
		return "license.jsp";
	}
	
	@RequestMapping(value = "/newLicense", method=RequestMethod.POST)
	public String create(@Valid @ModelAttribute("license") License newLicense, BindingResult result) {
		if(result.hasErrors()) {
			return "license.jsp";
		}
		else {
			dService.createLicense(newLicense);
			return "redirect:/";
		}
	}
	
	@RequestMapping("/person/{id}")
	public String person(Model model, @PathVariable("id") Long id) {
		Person x = dService.findPerson(id);
		model.addAttribute("first_name", x.getFirst_name());
		model.addAttribute("last_name", x.getLast_name());
		model.addAttribute("license", x.getLicense());
		model.addAttribute("id", x.getId());
		
		return "person.jsp";
	}
	
	@RequestMapping("/getAll")
	public List<License> get(){
		return dService.allLicense();
	}
	
}
