package com.company.mvc.emp;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TestController {
	//스트링[] request.getParameterValues() 대신해서
	
	@RequestMapping("/paramtest2")
	public ModelAndView paramtest2() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("parameter");
		mv.addObject("param1","test");
		return mv; 
	}
	
	@RequestMapping("/paramtest")
	public String parameter(Model model) {
		model.addAttribute("param1","test");
		return "parameter";
	}
	
	@GetMapping("/req1")
	public void req1(HttpServletResponse response,
						@RequestParam(required=false, defaultValue="park") String id) throws IOException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.print(id);
	}
	
	@GetMapping("/req2")
	public void req2(HttpServletResponse response,
						String[] ids) throws IOException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.print(ids[0]);
	}
	
	@GetMapping("/req3")
	public void req3(HttpServletResponse response,
						@RequestParam Map<String,Object> map) throws IOException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.print(map);
	}
	
	@GetMapping("/req4")
	public void req4(HttpServletResponse response,
						ReqVO vo) throws IOException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.print(vo.toString());
	}
	
	@GetMapping("/req5")
	public void req5(HttpServletResponse response,
			ListReqVO list) throws IOException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.print(list.toString());
	}
	
	@RequestMapping("/req6")
	public void req6(HttpServletResponse response,
						ReqVO vo, MultipartFile[] pic) {
		try {
			PrintWriter out;
			response.setContentType("text/html; charset=UTF-8");
			out = response.getWriter();
			
			//첨부파일 업로드
			//어디에서 임시폴더로 옮겨주는 방법
			for(MultipartFile temp : pic) {
				if(temp !=null && temp.getSize() > 0) {
					temp.transferTo(new File("D:/upload", temp.getOriginalFilename()));
					out.print(temp.getOriginalFilename()+"<br>");
					out.print(temp.getSize());
				}
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@GetMapping("/req7/{id}/{age}")
	public void req7(HttpServletResponse response,
			@PathVariable String id,
			@PathVariable int age) throws IOException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.print(id);
		out.print(age);
	}
	
	
	@GetMapping("/array")
	//string 배열로 받고 싶으면 배열로 받고, 아니면 그냥 받기
	//@RequestParam List<String> idList도 가능
	public void array(@RequestParam String id,
						@RequestParam String [] ids,
						HttpServletResponse response) {
		PrintWriter out;
		try {
			out = response.getWriter();
			out.print(id);
			out.print(ids);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//return "home";
	}
	

	
}
