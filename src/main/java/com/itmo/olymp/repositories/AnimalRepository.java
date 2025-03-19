package com.itmo.olymp.repositories;

import com.itmo.olymp.entities.Animal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnimalRepository extends JpaRepository<Animal,Long> {

    List<Animal> findAllByWorkerId(Long workerId);
    @Query(value = "SELECT * FROM animals WHERE worker_id IS NULL",
            nativeQuery = true)
    List<Animal> findAllAvailableAnimals();
}
