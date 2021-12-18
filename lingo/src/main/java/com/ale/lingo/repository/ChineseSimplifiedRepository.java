package com.ale.lingo.repository;

import com.ale.lingo.model.ChineseSimplified;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ChineseSimplifiedRepository extends JpaRepository<ChineseSimplified, Long> {
    @Query("SELECT * from ChineseSimplified zhs WHERE zhs.value = ?1")
    ChineseSimplified findByValue(String value);
}
