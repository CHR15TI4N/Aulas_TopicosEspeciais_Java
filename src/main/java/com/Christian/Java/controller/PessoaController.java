package com.Christian.Java.controller;

import com.Christian.Java.model.Pessoa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.Christian.Java.service.PessoaService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {
    @Autowired
    private PessoaService service;

    //cria um item que você deseja no banco
    @PostMapping
    public ResponseEntity<Object> gravarPessoa(@RequestBody Pessoa pessoa){
        return ResponseEntity.status(HttpStatus.OK).body(service.gravaPessoa(pessoa));
    }

    //busca de forma mais geral
    @GetMapping
    public ResponseEntity<List<Pessoa>> buscarPessoas(){
        return ResponseEntity.status(HttpStatus.OK).body(service.buscaPessoa());
    }

    //faz a busca pelo id do que foi criado
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Pessoa>> buscarIndividual(@PathVariable (value = "id") Long id){
        return ResponseEntity.status(HttpStatus.OK).body(service.buscaIndividual(id));
    }

    //é usado para atualizar o que foi criado
    @PutMapping("/{id}")
    public ResponseEntity<Object> alteraPessoa(@PathVariable (value = "id") Long id, @RequestBody Pessoa pessoa){
        Optional<Pessoa> pessoaExist = service.buscaIndividual(id);
        if (pessoaExist.isEmpty()){
            return ResponseEntity.status(HttpStatus.OK).body("Dado não encontrado!");
        }
        Pessoa newPessoa = pessoaExist.get();
        newPessoa.setNome(pessoa.getNome());
        newPessoa.setCpf(pessoa.getCpf());

        return ResponseEntity.status(HttpStatus.OK).body(service.gravaPessoa(newPessoa));
    }


    //faz o delete do item que foi criado
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> detelaPessoa(@PathVariable (value = "id") Long id){

        Optional<Pessoa> pessoaExist = service.buscaIndividual(id);
        if (pessoaExist.isEmpty()){
            return ResponseEntity.status(HttpStatus.OK).body("Dado não encontrado!");
        }

        service.deletePessoa(pessoaExist);
        return ResponseEntity.status(HttpStatus.OK).body("Deletado com sucesso!");
    }
}
