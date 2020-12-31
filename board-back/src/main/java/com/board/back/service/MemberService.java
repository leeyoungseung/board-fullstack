package com.board.back.service;

import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.board.back.exception.ResourceNotFoundException;
import com.board.back.exception.SystemMaintenanceException;
import com.board.back.exception.ValidationCheckException;
import com.board.back.model.Member;
import com.board.back.repository.MemberRepository;
import com.board.back.util.EncryptUtil;
import com.board.back.util.ValidationUtil;

@Service
public class MemberService {
	
	@Autowired
	private MemberRepository memberRepository;
	
	ValidationUtil vUtil = ValidationUtil.getInstance();
	EncryptUtil eUtil = EncryptUtil.getInstance();

	/**
	 * 회원가입
	 * @param member
	 * @return
	 */
	public Member createMember(Member member) {
		// 1. Member 의 유효성 체크
		if (!vUtil.validationEmail(member.getId()) ||
			!vUtil.validationPWD(member.getPassword()) ||
			!vUtil.validationNum(member.getCp_number())) {
			new ValidationCheckException();
		}
		
		// 2. 패스워드의 암호화 
		try {
			member.setPassword(eUtil.encryptSHA256(member.getPassword()));
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			new SystemMaintenanceException();
		}
		
		member.setUserStatus(0);
		member.setJoinedDate(new Date());
		member.setCreatedDate(new Date());
		member.setUpdatedDate(new Date());
		
		// 3. DB에 등록 
		return memberRepository.save(member);
	}

	/**
	 * 회원 정보가져오기
	 * @param no
	 * @return
	 */
	public ResponseEntity<Member> getMember(Integer no) {
		Member member = memberRepository.findById(no)
				.orElseThrow(() -> new ResourceNotFoundException("Not exist Member Data by no : ["+no+"]"));
		return ResponseEntity.ok(member);
	}

	public ResponseEntity<Boolean> getMemberFromId(String id) {
		List<Member> memberList = memberRepository.findByUserId(id);
		Boolean result = false;
		try {
			result = (memberList != null && memberList.size() != 0 &&!memberList.get(0).getId().equals("")) ? true : false;
		} catch (Exception e) {e.printStackTrace();}
		
		return ResponseEntity.ok(result);
	}
	
	
	

}
