package tr.org.lkd.lyk2015.camp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import tr.org.lkd.lyk2015.camp.models.Admin;
import tr.org.lkd.lyk2015.camp.service.AdminService;

@Controller
@RequestMapping("/admins")
public class AdminController {

	@Autowired
	private AdminService adminService;

	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String test(@ModelAttribute Admin admin) {

		return "admin/adminCreateForm";
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)

	public String create(@ModelAttribute Admin admin) {

		adminService.create(admin);

		return "redirect:/admins";
	}

	@RequestMapping(value = "/update/{id}")
	public String edit(@PathVariable("id") String id, @ModelAttribute Admin admin, Model model) {

		Admin adminNew = adminService.getById(admin.getId());

		model.addAttribute("admin", adminNew);
		// model.addAttribute("message", message);

		return "/admin/updateAdmin";
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST, params = "id")
	public String editPost(@ModelAttribute Admin admin, Model model,
			@RequestParam(value = "message", required = false) String message) {

		Admin adminNew = adminService.update(admin);

		model.addAttribute("admin", adminNew);
		model.addAttribute("message", message);

		return "redirect:/admins";
	}

	@RequestMapping("")
	public String list(Model model) {
		List<Admin> admins = adminService.getAll();

		model.addAttribute("adminsList", admins);

		return "admin/adminList";
	}

}