package com.Christian.Java.service;

import com.Christian.Java.model.Produto;
import com.Christian.Java.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {
    @Autowired
    private ProdutoRepository repository;

    public List<Produto> buscaTudo(){
        return repository.findAll();
    }
}
