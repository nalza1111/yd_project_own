package co.prjt.own.ownhome.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import co.prjt.own.common.Paging;
import co.prjt.own.common.service.ReportVO;
import co.prjt.own.sns.service.SAccountVO;

public interface OwnhomeService {
	//모든회원정보 페이징
	public List<OwnUserVO> getPagingUserList(OwnUserVO vo, Paging paging);
	//모든회원정보
	public List<OwnUserVO> getUserList(OwnUserVO vo);
	//회원 카운트
	public int ownUsercount(OwnUserVO vo);
	
	//회원가입
	public int insertUser(OwnUserVO UserVO);
	//아이디 중복체크
	public int idcheck(String id);	
	//로그인
	public OwnUserVO login(String id);
	//아이디찾기
	public String searchId(String email);
	//이메일보내기
	public String sendMail(String info, String email);
	//내정보 수정
	public int myupdate();
	//비밀번호 체크
	public int pwcheck(String pw, String newpw);
	//비밀번호 재설정
	public String setPassword(String appNo, String id);
	
	//=====================SNS=================
	public SAccountVO snsLogin(String id);
	//sns 유저 회원가입
	public int updateSnsUser(@Param ("snsNickname") String nickname, @Param ("userId") String id);
	//=============관리자============
	//질문목록 불러오기
	public List<QuestionVO> questionList(Paging paging);
	//전체질문 갯수
	public int adQuestionCount();
	//전체질문 페이징 처리..
	public List<QuestionVO> getPagingAdQuestlist(QuestionVO vo, Paging paging);
	//제목 선택시 제목에 맞는 질문 가져오기
	public QuestionVO selectQuest(String qno);
	
	//질문 답변등록
	public int questionUpdate(QuestionVO vo);
	
	
	//신고처리
	public int reportUpdate(ReportVO vo);
	//신고목록 불러오기
	public List<ReportVO> reportList(Paging paging);
	//신고 카운트
	public int reportCount();
	//신고 페이징처리
	public List<ReportVO> getPagingReportList(ReportVO vo, Paging paging);
	//신고 한건조회
	public ReportVO selectReport(String rno);
	//========================마이페이지
	//내 질문 가져오기
	public List<QuestionVO> myQuestion(QuestionVO vo);
	//내질문 갯수
	public int myquestionCount(QuestionVO VO);
	//내 질문 페이징처리
	public List<QuestionVO> getPagingmyQuestlist(QuestionVO vo, Paging paging);
	
}
