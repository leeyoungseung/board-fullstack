package com.board.back.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.board.back.model.Member;
import com.board.back.service.MemberService;

//@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
public class MemberController {

	@Autowired
	private MemberService memberService;
	
	@PostMapping("/member")
	public Member createMember(@RequestBody Member member) {
		System.out.println("@PostMapping(\"/member\")");
		System.out.println(member.toString());
		
		return memberService.createMember(member);
	}
	
	@GetMapping("/member/{no}")
	public ResponseEntity<Member> getMemberNo(
			@PathVariable Integer no) {
		return memberService.getMember(no);
	}
	
	@GetMapping("/member")
	public ResponseEntity<Boolean> getMemberNo(
			@RequestParam String id) {
		return memberService.getMemberFromId(id);
	}
}
