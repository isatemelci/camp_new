package tr.org.lkd.lyk2015.camp.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import tr.org.lkd.lyk2015.camp.controllers.validators.ApplicationFormValidator;
import tr.org.lkd.lyk2015.camp.models.dto.ApplicationFormDto;
import tr.org.lkd.lyk2015.camp.service.ApplicationService;
import tr.org.lkd.lyk2015.camp.service.CourseService;

@Controller
@RequestMapping("/applicationform")
public class ApplicationFormController {

	@Autowired
	ApplicationFormValidator applicationFormValidator;

	@Autowired
	private CourseService courseService;

	@Autowired
	private ApplicationService applicationService;

	@InitBinder
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(this.applicationFormValidator);
	}

	@RequestMapping(value = "", method = RequestMethod.GET)
	public String get(@ModelAttribute("form") ApplicationFormDto applicationFormDto, Model model) {

		model.addAttribute("courses", this.courseService.getAllActive());

		return "applicationForm";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String create(@ModelAttribute("form") @Valid ApplicationFormDto applicationFormDto,
			BindingResult bindingResult, Model model) {

		// String a = this.applicationService.generateEmailUUID();
		//
		// String b =
		// this.applicationService.sendEmailConfirmation(applicationFormDto.getStudent().getEmail(),
		// "mail yolla", a);
		//
		// model.addAttribute("mailmessage", b);

		if (!bindingResult.hasErrors()) {

			model.addAttribute("courses", this.courseService.getAllActive());

			return "applicationForm";

		} else {

			this.applicationService.create(applicationFormDto);
			return "applicationSuccess";
		}

		// model.addAttribute("courses", this.courseService.getAllActive());
		//
		// return "applicationForm";
	}

}