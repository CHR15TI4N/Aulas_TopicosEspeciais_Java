package com.Christian.Java.service;

import com.Christian.Java.model.Livro;
import com.Christian.Java.model.Veiculo;
import com.Christian.Java.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LivroService {
    @Autowired
    private LivroRepository repository;

    public Livro gravaLivro(Livro livro){
        return repository.save(livro);
    }

    public List<Livro> buscaTodos(){
        return repository.findAll();
    }

    public Optional<Livro> buscaId(Long id){
        return repository.findById(id);
    }

    public void deleteLivro(Optional<Livro> livro){
        repository.delete(livro.get());
    }
}
