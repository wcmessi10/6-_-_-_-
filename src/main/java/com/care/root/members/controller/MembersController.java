package com.care.root.members.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.care.root.common.SessionName;
import com.care.root.members.dto.MembersDTO;
import com.care.root.members.service.MembersService;

@Controller
@RequestMapping("members")
public class MembersController implements SessionName {
	@Autowired
	MembersService ms;
	
	@GetMapping("**")
	public void getMapping() {}
	
	@PostMapping("userCheck")
	public String userCheck(HttpServletRequest request, RedirectAttributes rs) {
		int result = ms.userCheck(request);//form 태그로 받아온 데이터들을 가져오기 위해 request 사용
		if(result==0) {//로그인 성공 : 0 
			rs.addAttribute("mid", request.getParameter("id"));//redirect 시 데이터를 전달하는 방법
			return "redirect:completeLogin";//로그인 완료
		}
		
		
		return "redirect:login";
	}
	@GetMapping("completeLogin")
	public String completeLogin(@RequestParam String id, HttpSession session) {//addAttribute를 통해 가져온 mid
		session.setAttribute(LOGIN, id);
		
		return "members/home";
	}
	@PostMapping("register")
	public String regiter(MembersDTO dto) {
		String[] str = dto.getMaddr().split(" ");
		int result = ms.register(dto);
		if(result==0) {
			return "redirect:login";
		}
		return "redirect:register";
	}
}
