package com.ale.lingo.repository;

import com.ale.lingo.model.Korean;
import com.ale.lingo.model.Noun;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KoreanRepository extends JpaRepository<Korean, Long> {
    Noun findByValue(String value);
}
