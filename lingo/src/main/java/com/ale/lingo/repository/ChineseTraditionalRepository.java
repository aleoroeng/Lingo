package com.ale.lingo.repository;

import com.ale.lingo.model.ChineseTraditional;
import com.ale.lingo.model.Noun;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChineseTraditionalRepository extends JpaRepository<ChineseTraditional, Long> {
    Noun findByValue(String value);
}
