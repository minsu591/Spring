package com.example.demo.emp.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.emp.mapper.EmpMapper;
import com.example.demo.emp.service.DeptVO;
import com.example.demo.emp.service.EmpVO;
import com.example.demo.emp.service.JobVO;

@Controller
public class EmpController {
	@Autowired EmpMapper mapper;
	
	@RequestMapping("/empList")
	public String empList(Model model) {
		model.addAttribute("empList", mapper.getEmpList(null));
		return "empList";
	}
	
	@RequestMapping("/test")
	public String test(Model model) {
		model.addAttribute("str1", "<u>test</u>");
		return "test";
	}
	
	//등록페이지
	@GetMapping("/empInsert")
	public String empInsert(Model model) {
		model.addAttribute("empId",mapper.getEmpId());
		return "empInsert";
	}
	
	@PostMapping("/empInsert")
	public String empInsertPro(Model model, EmpVO vo) {
		mapper.insert(vo);
		return "redirect:empInsert";
	}
	
	@ModelAttribute("jobs")
	public List<JobVO> getJobs(){
		return mapper.getJobs();
	}
	
	@ModelAttribute("depts")
	public List<DeptVO> getDepts(){
		return mapper.getDepartments();
	}
	
	@GetMapping("/empUpdate")
	public String empUpdate(Model model, EmpVO vo) {
		model.addAttribute("emp",mapper.getEmp(vo));
		return "empUpdate";
	}
	
}
