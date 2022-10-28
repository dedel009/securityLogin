package com.exam.repository;

import com.exam.domain.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardRepository extends JpaRepository<Board, Integer>{

    Board findOneById(Integer boardId);
}
