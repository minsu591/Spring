package com.company.app.emp.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.company.app.emp.service.EmpReqVO;
import com.company.app.emp.service.EmpService;
import com.company.app.emp.service.EmpVO;

@Controller
public class EmpController {
	
	@Autowired EmpService service;
	Logger logger = LoggerFactory.getLogger(EmpController.class);
	
	//단건조회
	@RequestMapping("/emp")
	public String emp(EmpVO vo, Model model) {
		logger.info("파라미터 : "+vo.toString());
		model.addAttribute("emp", service.getEmp(vo));
		return "emp/emp";
	}
	
	//목록
	@RequestMapping("/empList")
	public String empList(EmpReqVO vo, Model model) {
		model.addAttribute("empList",service.getEmpReqList(vo));
		return "emp/empList";
	}
	
	//등록
	@GetMapping("/empInsert")
	public String empInsert() {
		return "emp/empInsert";
	}
	
	//등록처리
	//@RequestMapping(value = "/empInsert", method= RequestMethod.POST)
	@PostMapping("/empInsert")
	public String empInsert(EmpVO vo) {
		//커맨드 객체
		logger.info(vo.toString());
		service.insert(vo);
		return "redirect:empList";
	}
	
	//수정페이지
	@RequestMapping("/empUpdate/{empId}")
	public String empUpdate(Model model, EmpVO vo,
			@PathVariable String empId) {
		//vo에 들어온 employee_id를 이용해서 employee의 정보를 찾고
		vo.setEmployeeId(empId);
		model.addAttribute("emp",service.getEmp(vo));
		return "emp/empUpdate";
	}
	//수정처리
	//@RequestMapping(value = "/empInsert", method= RequestMethod.POST)
		@PostMapping("/empUpdate")
		public String empUpdate(EmpVO vo) {
			//커맨드 객체
			logger.info(vo.toString());
			service.update(vo);
			return "redirect:empList";
		}
		
	//삭제
	@RequestMapping("/empDelete")
	public String empDelete(EmpVO vo, Model model) {
		service.delete(vo);
		return "redirect:empList";
	}
}
