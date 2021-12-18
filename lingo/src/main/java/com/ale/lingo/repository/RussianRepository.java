package com.ale.lingo.repository;

import com.ale.lingo.model.Noun;
import com.ale.lingo.model.Russian;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RussianRepository extends JpaRepository<Russian, Long> {
    Russian findByValue(String value);
}
