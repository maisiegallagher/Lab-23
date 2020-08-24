package co.grandcircus.Lab23;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import co.grandcircus.Lab23.GradesDao;
import co.grandcircus.Lab23.GradesDaoOld;
import co.grandcircus.Lab23.Grade;

@Controller
public class GradesController {
	
	@Autowired
	private GradesDao gradesDao;
	@Autowired
	private GradesDaoOld gradesDaoOld;
	
	@RequestMapping("/")
	public String index() {
		return "redirect:/grades";
	}

	@RequestMapping("/grades")
	public String list(Model model) {
		List<Grade> leListOfRooms = gradesDao.findAll();
		System.out.println(leListOfRooms);
		model.addAttribute("grades", leListOfRooms);
		return "list";
	}
	
	@RequestMapping("/grades/detail")
	public String detail(@RequestParam("id") Long id, Model model) {
		Grade grade = gradesDao.findById(id);
		System.out.println(grade);
		model.addAttribute("grade", grade);
		return "detail";
	}
	
	@RequestMapping("/grades/edit")
	public String edit(@RequestParam("id") Long id, Model model) {
		Grade grade = gradesDao.findById(id);
		model.addAttribute("grade", grade);
		return "edit";
	}
	
	@PostMapping("/grades/edit")
	public String save(@RequestParam("id") Long id, Grade grade) {
		grade.setId(id);
		
		gradesDao.update(grade);
		
		return "redirect:/grades/detail?id=" + id;
	}
	
	@RequestMapping("/grades/add")
	public String showAdd() {		
		return "add";
	}
	
	@PostMapping("/grades/add-confirm")
	public String submitAdd(Grade grade, Model model) {		
		gradesDao.create(grade);
		model.addAttribute("grade", grade);
		return "add-confirm";
	}
	
	@RequestMapping("/grades/delete")
	public String remove(@RequestParam("id") Long id) {
		gradesDao.delete(id);
		
		return "redirect:/grades";
	}
}