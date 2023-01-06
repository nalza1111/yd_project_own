package co.prjt.own.ownhome.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import co.prjt.own.exercise.mapper.ExerRecordMapper;
import co.prjt.own.ownhome.mapper.OwnhomeMapper;
import co.prjt.own.ownhome.service.OwnUserVO;

@Controller
public class OwnhomeController {

	@Autowired
	OwnhomeMapper ownMapper;
	ExerRecordMapper exerMapper;

	// 수정테스트
	// 통신 방식이 상관없다면 Request~로 퉁치기. 아니라면 get.. post..정해주기
	@RequestMapping(value = "/own/home", method = RequestMethod.GET)
	public String ownHome(Model model) { // 오운홈으로 가는 페이지이동
		model.addAttribute("empList", ownMapper.getEmpList(null));
		return "content/own/ownhome";
	}

	@RequestMapping(value = "/own/login", method = RequestMethod.GET)
	public String ownLogin(Model model) { // 오운로그인으로..
		return "content/own/ownlogin";
	}

	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String test(Model model) { // 오운홈으로 가는 페이지이동
		return "fragments/header";
	}

	// 등록
	@PostMapping("/own/userInto")
	public OwnUserVO insert(OwnUserVO vo) {
		ownMapper.insertUser(vo);
		return vo;
	}
	
	// 오운완(나의운동기록) 페이지 이동
	@RequestMapping(value = "/own/ownRecordForm", method = RequestMethod.GET)
	public String ownRecordForm(Model model) {
		return "content/own/ownRecordForm";
	}
}
