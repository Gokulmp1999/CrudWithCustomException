package com.interview.demo.service;

import com.interview.demo.customexception.BussinessException;
import com.interview.demo.entity.Employe;
import com.interview.demo.repository.EmplRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class EmplService implements EmplServiceInterface {

    Logger logger= LoggerFactory.getLogger(EmplService.class);
    @Autowired
    EmplRepo emplRepo;


    @Override
    public Employe saveEmploye(Employe employe) {
        if (employe.getName()==null ||employe.getName().isEmpty() || employe.getName().length() == 0 ) {
            throw new BussinessException("601", "employe name is null");
        }
        try {
            return emplRepo.save(employe);
        } catch (IllegalArgumentException e) {
            throw new BussinessException("602", "given Employe is null " + e.getMessage());
        } catch (Exception e) {
            throw new BussinessException("603", "Something went wrong in Service layer while Adding Employe " + e.getMessage());
        }


    }

    @Override
    public List<Employe> getAllEmploy() {
        List<Employe> employeList = null;
        try {
            logger.info("Starting gett all employ method from service with info level");
            employeList = emplRepo.findAll();
            logger.info("ended gett all employ method from service with info level");
        } catch (Exception e) {
            logger.error("throwned Exception after calling gett all employ method from service with error level");
            throw new BussinessException("605", "Something went wrong in Service layer while fetching Employe " + e.getMessage());
        }
        if (employeList.isEmpty()) {
            logger.error("throwned Exception after returning employeList  from service with error level");
            throw new BussinessException("604", "Hey List is Empty");
        }

        return employeList;
    }

    @Override
    public Employe findEmplById(Long id) {
        try {
            return emplRepo.findById(id).get();
        } catch (IllegalArgumentException e) {
            throw new BussinessException("606", "Employe is Null ,please give Employe Id " + e.getMessage());
        } catch (NoSuchElementException e) {
            throw new BussinessException("607", "The give Employe id is Not present in Db " + e.getMessage());
        }

    }

    @Override
    public void deleteEmpById(Long id) {
        try {
            emplRepo.deleteById(id);
        } catch (IllegalArgumentException e) {
            throw new BussinessException("609", "Employe is Null ,please give Employe Id " + e.getMessage());
        } catch (NoSuchElementException e) {
            throw new BussinessException("610", "The give Employe id is Not present in Db " + e.getMessage());
        }

    }
}
