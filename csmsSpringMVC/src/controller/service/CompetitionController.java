package controller.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "compelition")
public class CompetitionController {
	@RequestMapping(value = "status")
	public void StatusManagement(HttpServletRequest request,
			HttpServletResponse response, Model model) {

	}
}
