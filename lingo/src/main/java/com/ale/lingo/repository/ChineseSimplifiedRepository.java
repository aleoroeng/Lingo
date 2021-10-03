package com.ale.lingo.repository;

import com.ale.lingo.model.ChineseSimplified;
import com.ale.lingo.model.Noun;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChineseSimplifiedRepository extends JpaRepository<ChineseSimplified, Long> {
    Noun findByValue(String value);
}
