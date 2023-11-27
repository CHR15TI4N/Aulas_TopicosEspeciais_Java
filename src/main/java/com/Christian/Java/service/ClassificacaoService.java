package com.Christian.Java.service;

import com.Christian.Java.model.Classificacao;
import com.Christian.Java.repository.ClassificacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassificacaoService {
    @Autowired
    private ClassificacaoRepository repository;

    public List<Classificacao> buscaTudo(){
        return repository.findAll();
    }
}
