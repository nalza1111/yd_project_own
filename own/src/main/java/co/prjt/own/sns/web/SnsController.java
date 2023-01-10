package co.prjt.own.sns.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import co.prjt.own.sns.service.SAccountService;
import co.prjt.own.sns.service.SBoardService;
import co.prjt.own.sns.service.SBoardVO;
import co.prjt.own.sns.service.SFollowService;
import co.prjt.own.sns.service.SFollowVO;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
@RequestMapping("/own")
public class SnsController {
	
	@Autowired
	SAccountService snsService;

	
	@Autowired
	SBoardService boardService;
	
	@Autowired
	SFollowService followService;
	
	 //통신 방식이 상관없다면 Request~로 퉁치기. 아니라면 get.. post..정해주기
	
	//1. sns홈으로 이동
	@RequestMapping(value = "/sns", method = RequestMethod.GET)
	public String getSnsUserList(Model model) {
		model.addAttribute("snsHome", snsService.getSnsUserList(null));
		return "content/sns/snsHome"; 
	}
	
	//2. 개인피드	
	@RequestMapping(value = "/snsFeed", method = RequestMethod.GET)
	public String getSnsUser(Model model, SFollowVO vo) {
		model.addAttribute("snsFeed", boardService.getSnsBoardList(null));
		model.addAttribute("snsFollow", followService.getFollowList(vo));
		System.out.println(vo);
		return "content/sns/snsFeed"; 
	}
	
	@RequestMapping(value = "/snsFeed2", method = RequestMethod.GET)
	public String getSnsUser2(Model model) {
		model.addAttribute("snsFeed2", boardService.getSnsBoardList(null));
		return "content/sns/snsFeed2"; 
	}
	//3. 파일 업로드

	
	//3. 게시글작성
	@PostMapping("/snsWriteFeed")
	public String insertSnsBoard(SBoardVO vo) {
		boardService.insertSnsBoard(vo);
		//mvo.set(vo.pk값)
		//mvo.구분값('string값')
		//첨부파일 처리
		return "content/sns/snsFeed";
	}

	
}
