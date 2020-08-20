package co.grandcircus.Lab23;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GradeController {
	
	@Autowired
	private GradeDao GradeDao;
	

	@RequestMapping("/")
	public String showHome() {

		return "homepage";
	}

	@RequestMapping("/homepage")
	public String list(Model model) {
		List<Grade> leListOfGrades = GradeDao.findAll();
		System.out.println(leListOfGrades);
		model.addAttribute("grades", leListOfGrades);
		return "list";
	}
	
	
	@RequestMapping("/homepage/add-form")
	public String showAdd() {		
		return "add-form";
	}
	
	@PostMapping("/homepage/add-form")
	public String submitAdd(Grade grade) {		
		GradeDao.create(grade);
		
		return "add-confirm";
	}
	
	@RequestMapping("/homepage/delete-form")
	public String remove(@RequestParam("id") Long id) {
		GradeDao.delete(id);
		
		return "redirect:/homepage";
	}
}
