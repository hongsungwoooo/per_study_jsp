package com.koreait.web.dao;
public interface MemberService {
	
	public Member selectOneMember(String userId, String userPwd);
	
	public int insertOneMember(Member m);

	public int updateOneMember(Member m);
	
	public int deleteOneMemeber(int userNo);
	
	public Member refreshOneMember(int userNo);
	
	public boolean selectIdCheck(String userId);

	public int updatePwdMember(String userId, String pwd, String newPwd);
}