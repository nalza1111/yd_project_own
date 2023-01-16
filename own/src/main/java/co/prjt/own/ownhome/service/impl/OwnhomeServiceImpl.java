package co.prjt.own.ownhome.service.impl;

import java.security.SecureRandom;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import co.prjt.own.ownhome.mapper.OwnhomeMapper;
import co.prjt.own.ownhome.service.CustomUser;
import co.prjt.own.ownhome.service.OwnUserVO;
import co.prjt.own.ownhome.service.OwnhomeService;
import co.prjt.own.sns.service.SAccountVO;

@Service
public class OwnhomeServiceImpl implements OwnhomeService,UserDetailsService {

	@Autowired
	OwnhomeMapper ownhomeMapper;
	
	@Autowired
	JavaMailSender javaMailSender;
	
	
	@Override
	public int insertUser(OwnUserVO UserVO) {
		return ownhomeMapper.insertUser(UserVO);
	}

	@Override
	public OwnUserVO login(String id) {
		return ownhomeMapper.login(id);
	}

	@Override
	public List<OwnUserVO> getUserList(OwnUserVO vo) {
		return ownhomeMapper.getUserList(vo);
	}

	@Override
	public SAccountVO snsLogin(String id) {
		return ownhomeMapper.snsLogin(id);
	}

	 @Override
	   public int updateSnsUser(@Param ("snsNickname") String nickname, @Param ("userId") String id) {
	      return ownhomeMapper.updateSnsUser(nickname, id);
	   }


	@Override
	public int idcheck(String id) {
		// TODO Auto-generated method stub
		return ownhomeMapper.idcheck(id);
	}

	@Override
	public String searchId(String email) {
		return ownhomeMapper.searchId(email);
	}
	

	@Override
	public UserDetails loadUserByUsername(String username)  {
		// TODO Auto-generated method stub
		OwnUserVO vo = ownhomeMapper.login(username);
		System.out.println("체크==="+vo);
		if (vo ==null) {
			throw new UsernameNotFoundException(""); 
		}
		return new CustomUser(vo);
	}
	
	@Override
	   public String sendMail(String info, String email){
	      SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
	      
	      final String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
	      SecureRandom random = new SecureRandom();
       StringBuilder sb = new StringBuilder();

       // 루프의 각 반복은 주어진 문자에서 무작위로 문자를 선택합니다.
       // ASCII 범위를 `StringBuilder` 인스턴스에 추가합니다.

       for (int i = 0; i < 6; i++)
       {
           int randomIndex = random.nextInt(chars.length());
           sb.append(chars.charAt(randomIndex));
       }
       String appNo = sb.toString();
	       try{
	           // 1. 메일 수신자 설정
	           String[] receiveList = {email};
	           System.out.println(info);	           
	           //아이디 찾기
	           if(info.equals("id"))
	           {
	           System.out.println("아이디찾기 들어옴");
	           simpleMailMessage.setTo(receiveList);
	           // 2. 메일 제목 설정
	           simpleMailMessage.setSubject("아이디입니다");
	           // 3. 메일 내용 설정
	           String id = ownhomeMapper.searchId(email);
	           System.out.println("아이디 입니다"+id);
	           simpleMailMessage.setText(id);
	           javaMailSender.send(simpleMailMessage);
	           }
	           else
	           {
	              simpleMailMessage.setTo(receiveList);
	              // 2. 메일 제목 설정
	              simpleMailMessage.setSubject("임시비밀번호입니다");
	              // 3. 메일 내용 설정
	              simpleMailMessage.setText(appNo);
	              javaMailSender.send(simpleMailMessage);
	           }   
	           // 4. 메일 전송
	       } catch(Exception e){
	           System.out.println((e.toString()));
	       }
		return appNo;
	   }

	@Override
	public String setPassword(String appNo, String id) {
		// TODO Auto-generated method stub
		return ownhomeMapper.setPassword(appNo, id);
	}

	@Override
	public int myupdate() {
		// TODO Auto-generated method stub
		return ownhomeMapper.myupdate();
	}

	@Override
	public int pwcheck(String pw, String newpw) {
		// TODO Auto-generated method stub
		return ownhomeMapper.pwcheck(pw, newpw);
	}

}
