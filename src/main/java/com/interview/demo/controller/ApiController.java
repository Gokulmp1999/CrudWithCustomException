package com.interview.demo.controller;

import com.interview.demo.customexception.BussinessException;
import com.interview.demo.customexception.ControllerException;
import com.interview.demo.entity.Employe;
import com.interview.demo.service.EmplServiceInterface;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api")
public class ApiController {

    Logger logger= LoggerFactory.getLogger(ApiController.class);
    @Autowired
    EmplServiceInterface emplServiceInterface;


    @RequestMapping(value = "save", method = RequestMethod.POST)
    public ResponseEntity<?> getFindById(@RequestBody Employe employe) {
        try {
            Employe employeList = emplServiceInterface.saveEmploye(employe);
            return new ResponseEntity<>(employeList, HttpStatus.CREATED);
        } catch (BussinessException b) {
            ControllerException ce = new ControllerException(b.getErrorCode(), b.getErrorMessage());
            return new ResponseEntity<>(ce, HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            ControllerException ce = new ControllerException("611", e.getMessage());
            return new ResponseEntity<>(ce, HttpStatus.BAD_REQUEST);
        }

    }

    @RequestMapping(value = "getAllemp", method = RequestMethod.GET)
    public ResponseEntity<?> getAllEmp() {
        try {
            logger.trace("Starting gett all employ method with info trace");
            logger.info("Starting gett all employ method with info level");
            List<Employe> employeList = emplServiceInterface.getAllEmploy();
            return new ResponseEntity<>(employeList, HttpStatus.OK);
        }catch (BussinessException b){
            ControllerException ce = new ControllerException(b.getErrorCode(), b.getErrorMessage());
            return new ResponseEntity<>(ce, HttpStatus.BAD_REQUEST);
        }catch (Exception e) {
            ControllerException ce = new ControllerException("614", e.getMessage());
            return new ResponseEntity<>(ce, HttpStatus.BAD_REQUEST);
        }

    }

    @RequestMapping(value = "update", method = RequestMethod.PUT)
    public ResponseEntity<?> udateEmpById(@RequestBody Employe employe) {
        try {
            Employe employeList = emplServiceInterface.saveEmploye(employe);
            return new ResponseEntity<>(employeList, HttpStatus.CREATED);
        }catch (BussinessException b){
            ControllerException ce = new ControllerException(b.getErrorCode(), b.getErrorMessage());
            return new ResponseEntity<>(ce, HttpStatus.BAD_REQUEST);
        }catch (Exception e) {
            ControllerException ce = new ControllerException("615", e.getMessage());
            return new ResponseEntity<>(ce, HttpStatus.BAD_REQUEST);
        }
    }


    @RequestMapping(value = "delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteEmpById(@PathVariable Long id) {
        try {
            emplServiceInterface.deleteEmpById(id);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        } catch (BussinessException b) {
            ControllerException ce = new ControllerException(b.getErrorCode(), b.getErrorMessage());
            return new ResponseEntity<>(ce, HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            ControllerException ce = new ControllerException("612", e.getMessage());
            return new ResponseEntity<>(ce, HttpStatus.BAD_REQUEST);
        }

    }

    @RequestMapping(value = "findById/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getFindById(@PathVariable Long id) {
        try {
            Employe employeList = emplServiceInterface.findEmplById(id);
            return new ResponseEntity<>(employeList, HttpStatus.OK);
        } catch (BussinessException b) {
            ControllerException ce = new ControllerException(b.getErrorCode(), b.getErrorMessage());
            return new ResponseEntity<>(ce, HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            ControllerException ce = new ControllerException("613", e.getMessage());
            return new ResponseEntity<>(ce, HttpStatus.BAD_REQUEST);
        }


    }
}
