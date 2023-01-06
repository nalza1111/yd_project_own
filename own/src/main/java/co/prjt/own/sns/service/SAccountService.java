package co.prjt.own.sns.service;

import java.util.List;

public interface SAccountService {
	//SNS가입 계정 전체 조회
	public List<SAccountVO> getSnsUserList(SAccountVO SAccountVO);
	
	//계정 한건 조회
	SAccountVO getSnsUser(String snsNickname);
	
	//SNS 계정가입
	int insertSnsUser(SAccountVO SAccountVO);
	
	//프로필 수정
	int updateSnsUser(SAccountVO SAccountVO);
	
	//SNS계정 탈퇴
	int deleteSnsUser(String snsNickname);
	
}
