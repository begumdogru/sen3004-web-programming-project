package sen3004.app4.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import sen3004.app4.model.SampleObject;
import sen3004.app4.service.App4Service;


@Controller
public class App4Controller {

	@Autowired
	App4Service service;

	@RequestMapping(value = "/add-to", method = RequestMethod.GET)
	public ModelAndView displayForm() {
		ModelAndView modelAndView = new ModelAndView("form");
		modelAndView.addObject("product", new SampleObject());
		
		return modelAndView;
	}

	@RequestMapping(value = "/send-form-data", method = RequestMethod.POST)
	public ModelAndView processForm(@Valid @ModelAttribute("product") SampleObject product, BindingResult result) {
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("product", product);
		
		if(result.hasErrors())
			modelAndView.setViewName("form");
		else
			modelAndView.setViewName("form-result");
			service.create(product);
			modelAndView.addObject("product", service.findAll());

		return modelAndView;
	}
	
	@RequestMapping(value = {"/list-products", "list.html"}, method = RequestMethod.GET)
	public ModelAndView list() {
		ModelAndView mv = new ModelAndView("product-list");
		mv.addObject("product", service.findAll());		
		return mv;
	}
	
	@RequestMapping(value = "/delete/{name}", method = RequestMethod.GET)
	public ModelAndView delete(@PathVariable String name) {
		ModelAndView mv = new ModelAndView("product-list");
		service.delete(name);
		mv.addObject("product", service.findAll());
		
		return mv;
	}

}
