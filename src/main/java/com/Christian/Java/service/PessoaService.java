package com.Christian.Java.service;

import com.Christian.Java.model.Pessoa;
import com.Christian.Java.model.Veiculo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.Christian.Java.repository.PessoaRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PessoaService {
    @Autowired
    private PessoaRepository repository;
//    public Pessoa gravaPessoa(Pessoa pessoa){
//        return repository.save(pessoa);
//    }
    public Pessoa gravaPessoa(Pessoa pessoa){
        if (!pessoa.getVeiculo().isEmpty()){
            for (Veiculo v : pessoa.getVeiculo()){
                v.setPessoa(pessoa);
            }
        }
        return repository.save(pessoa);
    }
    public List<Pessoa> buscaPessoa(){
        return repository.findAll();
    }
    public Optional<Pessoa> buscaIndividual(Long id){
        return repository.findById(id);
    }
    public void deletePessoa(Optional<Pessoa> pessoa){
        repository.delete(pessoa.get());
    }
}
