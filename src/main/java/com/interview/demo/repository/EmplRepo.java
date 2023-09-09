package com.interview.demo.repository;

import com.interview.demo.entity.Employe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmplRepo extends JpaRepository<Employe,Long> {
}
