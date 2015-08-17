package tr.org.lkd.lyk2015.camp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/test")
public class TestController {

	@RequestMapping("")
	public String test(Model model) {

		return "admin/test";
	}
}
