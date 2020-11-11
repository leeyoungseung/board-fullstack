package com.board.back.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.board.back.model.Board;

public interface BoardRepository extends JpaRepository<Board, Integer> {

}
