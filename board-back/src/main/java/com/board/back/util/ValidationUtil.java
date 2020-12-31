package com.board.back.util;

import java.util.regex.Pattern;

public class ValidationUtil {

	public static ValidationUtil getInstance() {
		return ValidationUtilHolder.INSTANCE;
	}
	
	private static class ValidationUtilHolder {
		private static final ValidationUtil INSTANCE = new ValidationUtil();
	}
	
	public final String P_NUM = "^[0-9]*$";          // 숫자
	public final String P_ENG = "^[a-zA-Z]*$";       // 영어
	public final String P_ENG_UPPER = "^[A-Z]*$";    // 영어 대문자
	public final String P_ENG_LOWER = "^[a-z]*$";    // 영어 소문자
	public final String P_KR = "^[가-힣]*$";          // 한글
	public final String P_N_ENG = "^[a-zA-Z0-9]*$";  // 숫자+영어
	
	public final String P_PASSWD_ENHANCE = "^.*(?=^.{8,16}$)(?=.*\\d)(?=.*[a-zA-Z])(?=.*[!@#$%^&+=]).*$";       // 패스워드(숫자, 문자, 특수문자 포함 8-16자리 이내)
	public final String P_EMAIL = "	^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$";
	public final String P_CPHONE = "^\\d{3}-\\d{3,4}-\\d{4}$";

	/**
	 * 지정 문자열(target)이 패턴(pattern)에 일치하는지 여부 확인 
	 * 
	 * @param pattern
	 * @param target
	 * @return
	 */
	protected boolean isMatch(String pattern, String target) {
		if (pattern == null || pattern.equals("")|| target == null || target.equals(""))
			return false;
		
		Pattern p = Pattern.compile(pattern);
		return p.matcher(target).matches();
	}
	
	
	public boolean validationPWD(String password) {
		return isMatch(P_PASSWD_ENHANCE, password);
	}
	
	public boolean validationEmail(String mail) {
		return isMatch(P_EMAIL, mail);
	}
	
	public boolean validationNum(String number) {
		return isMatch(P_NUM, number);
	}
	
}
