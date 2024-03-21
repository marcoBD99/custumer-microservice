package com.paymentchain.custumer.controller;

import org.springframework.web.bind.annotation.RestController;

import com.paymentchain.custumer.entities.Custumer;
import com.paymentchain.custumer.repository.CustumerRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;






@RestController
@RequestMapping("/custumer")
public class CustumerRestController {

    @Autowired
    CustumerRepository custumerRepository;

    @GetMapping()
    public List<Custumer> findAll(){
        return custumerRepository.findAll();
    }


    @GetMapping("/{id}")
    public ResponseEntity<?> get(@PathVariable long id) {
        Optional<Custumer> custumer = custumerRepository.findById(id);
        if (custumer.isPresent()){
            return new ResponseEntity<>(custumer.get(),HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<?> putMethodName(@PathVariable long id, @RequestBody Custumer entity) {
        Optional<Custumer> custumer = custumerRepository.findById(id);
        if (custumer.isPresent()){
            Custumer newCustemer = custumer.get();
            newCustemer.setName(entity.getName());
            newCustemer.setPhone(entity.getPhone());
            Custumer save = custumerRepository.save(newCustemer);
            return new ResponseEntity<>(save,HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCustomer(@PathVariable long id){
        Optional<Custumer> custumer = custumerRepository.findById(id);
        if (custumer.isPresent()){
            custumerRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody Custumer entity) {
        Custumer save = custumerRepository.save(entity);
        return ResponseEntity.ok(save);
    }
    




}
