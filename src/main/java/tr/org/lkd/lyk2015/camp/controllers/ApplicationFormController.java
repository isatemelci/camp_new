package tr.org.lkd.lyk2015.camp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import tr.org.lkd.lyk2015.camp.models.Application;
import tr.org.lkd.lyk2015.camp.models.dto.ApplicationFormDto;
import tr.org.lkd.lyk2015.camp.service.CourseService;

@Controller
@RequestMapping("/applicationform")
public class ApplicationFormController {

	@Autowired
	private CourseService courseService;

	@RequestMapping(value = "", method = RequestMethod.GET)
	public String get(@ModelAttribute("form") ApplicationFormDto applicationFormDto, Model model) {

		model.addAttribute("courses", courseService.getAllActive());

		return "applicationForm";
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String create(@ModelAttribute Application applicationForm) {

		return "redirect:/applicationform";
	}

}