package com.itmo.olymp.repositories;

import com.itmo.olymp.entities.IllnessDiary;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IllnessDiaryRepository extends JpaRepository<IllnessDiary, Long> {
    List<IllnessDiary> findAllByAnimalId(Long id);
}
