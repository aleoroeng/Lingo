package com.ale.lingo.repository;

import com.ale.lingo.model.Japanese;
import com.ale.lingo.model.Noun;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JapaneseRepository extends JpaRepository<Japanese, Long> {
    Noun findByValue(String value);
}
