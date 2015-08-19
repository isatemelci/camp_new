package tr.org.lkd.lyk2015.camp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import tr.org.lkd.lyk2015.camp.models.Application;
import tr.org.lkd.lyk2015.camp.service.ApplicationService;

@Controller
@RequestMapping("/applications")
public class ApplicationEmailValidateController {

	@Autowired
	private ApplicationService applicationService;

	@RequestMapping(value = "/validate/{id}")
	public String edit(@PathVariable String id, Model model) {

		Application application = this.applicationService.validate(id);

		if (application.getValidationId().equals(id)) {

			application.setValidated(true);

			this.applicationService.update(application);

			model.addAttribute("message", "Doğrulama Yapıldı...");
		}

		model.addAttribute("id", id);

		return "applicationSuccess";
	}

}