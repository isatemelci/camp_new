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

import tr.org.lkd.lyk2015.camp.models.Course;
import tr.org.lkd.lyk2015.camp.service.CourseService;

@Controller
@RequestMapping("/courses")
public class CourseController {

	@Autowired
	private CourseService courseService;

	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String test(@ModelAttribute Course course) {

		return "courseCreateForm";
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String create(@ModelAttribute Course course) {

		courseService.create(course);

		return "redirect:/courses";
	}

	@RequestMapping("")
	public String list(Model model) {

		List<Course> courses = courseService.getAll();

		model.addAttribute("coursesList", courses);

		return "courseList";
	}

	// @RequestMapping(value = "/update", method = RequestMethod.GET, params =
	// "id")
	// public String editGet(@ModelAttribute Course course, Model model,
	// @RequestParam(value = "message", required = false) String message) {
	//
	// Course courseNew = courseService.getById(course.getId());
	//
	// model.addAttribute("course", courseNew);
	// model.addAttribute("message", message);
	//
	// return "updateForm";
	// }
	
	@RequestMapping(value = "/update/{id}")
	public String edit(@PathVariable("id") String id, @ModelAttribute Course course, Model model) {

		Course courseNew = courseService.getById(course.getId());

		model.addAttribute("course", courseNew);
//		model.addAttribute("message", message);

		return "courseUpdateForm";
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST, params = "id")
	public String editPost(@ModelAttribute Course course, Model model,
			@RequestParam(value = "message", required = false) String message) {

		Course courseNew = courseService.update(course);

		model.addAttribute("course", courseNew);
		model.addAttribute("message", message);

		return "redirect:/courses";
	}

}
