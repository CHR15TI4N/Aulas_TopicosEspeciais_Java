package com.Christian.Java.service;

import com.Christian.Java.model.Venda;
import com.Christian.Java.repository.VendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VendaService {
    @Autowired
    private VendaRepository repository;

    public List<Venda> listaVenda(){
        return repository.findAll();
    }

}
