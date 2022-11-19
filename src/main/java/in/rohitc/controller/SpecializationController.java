package in.rohitc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import in.rohitc.entity.Specialization;
import in.rohitc.service.ISpecializationService;

@Controller
@RequestMapping("/spec")
public class SpecializationController {

	@Autowired
	private ISpecializationService service;

	/**
	 * 1.Show Register Page
	 */
	@GetMapping("/register")
	public String displayRegister() {
		return "SpecializationRegister";
	}

	/**
	 * 2.On Submit Form Save Data
	 */
	/**
	 * 1.Display All Specialization
	 */
	@GetMapping("/all")
	public String viewAll(Model model) {

		List<Specialization> list = service.getAllSpecialization();
		model.addAttribute("list", list);
		return "SpecializationData";

	}

	@GetMapping("/edit")
	public String showEditPage(@RequestParam Long id, Model model) {
		Specialization spec = service.getOneSpecialization(id);
		model.addAttribute("specialization", spec);
		return "SpecializationEdit";
	}

}
