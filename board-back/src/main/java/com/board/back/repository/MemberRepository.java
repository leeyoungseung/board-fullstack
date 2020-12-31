package com.board.back.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.board.back.model.Member;

public interface MemberRepository extends JpaRepository<Member, Integer> {

	@Query("SELECT mb FROM Member mb WHERE mb.id = :id")
	List<Member> findByUserId(@Param("id") String id);

}
