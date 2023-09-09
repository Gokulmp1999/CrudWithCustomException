package com.interview.demo.service;

import com.interview.demo.entity.Employe;

import java.util.List;

public interface EmplServiceInterface {
    List<Employe> getAllEmploy();

    Employe findEmplById(Long id);

    Employe saveEmploye(Employe employe);

    void deleteEmpById(Long id);
}
