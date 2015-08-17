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

import tr.org.lkd.lyk2015.camp.models.Instructor;
import tr.org.lkd.lyk2015.camp.service.CourseService;
import tr.org.lkd.lyk2015.camp.service.InstructorService;

@Controller
@RequestMapping("/instructors")
public class InstructorController {

	@Autowired
	private InstructorService instructorService;

	@Autowired
	private CourseService courseService;

	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String test(@ModelAttribute Instructor instructor, Model model) {

		model.addAttribute("courses", courseService.getAll());

		return "admin/instructorCreateForm";
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String create(@ModelAttribute Instructor instructor, @RequestParam("courseIds") List<Long> ids) {

		instructorService.create(instructor, ids);

		return "redirect:/instructors";
	}

	@RequestMapping(value = "/update/{id}")
	public String edit(@PathVariable("id") String id, @ModelAttribute Instructor instructor, Model model) {

		Instructor instructorNew = instructorService.getById(instructor.getId());

		model.addAttribute("instructor", instructorNew);
		// model.addAttribute("message", message);

		return "/admin/updateInstructor";
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST, params = "id")
	public String editPost(@ModelAttribute Instructor instructor, Model model,
			@RequestParam(value = "message", required = false) String message) {

		Instructor instructorNew = instructorService.update(instructor);

		model.addAttribute("instructor", instructorNew);
		model.addAttribute("message", message);

		return "redirect:/instructors";
	}

	@RequestMapping("")
	public String list(Model model) {
		List<Instructor> instructors = instructorService.getAll();

		model.addAttribute("instructorsList", instructors);

		return "admin/instructorList";
	}

}
