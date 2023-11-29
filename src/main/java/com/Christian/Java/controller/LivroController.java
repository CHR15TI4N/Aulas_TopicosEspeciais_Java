package com.Christian.Java.controller;

import com.Christian.Java.model.Livro;
import com.Christian.Java.model.Veiculo;
import com.Christian.Java.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/livro")
public class LivroController {
    @Autowired
    private LivroService service;

    @PostMapping
    public ResponseEntity<Livro> gravaLivro(@RequestBody Livro livro){
        return ResponseEntity.status(HttpStatus.OK).body(service.gravaLivro(livro));
    }

    @GetMapping
    public ResponseEntity<List<Livro>> buscaTodos(){
        return ResponseEntity.status(HttpStatus.OK).body(service.buscaTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> buscaId(@PathVariable(value = "id") Long id){
        Optional<Livro> livroExist = service.buscaId(id);

        if (livroExist.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK).body("Livro não encontrado");
        }
        return ResponseEntity.status(HttpStatus.OK).body(service.buscaId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> alteraLivro(@PathVariable(value = "id") Long id, @RequestBody Livro livro){

        Optional<Livro> livroExist = service.buscaId(id);
        if (livroExist.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK).body("Livro não encontrado");
        }

        Livro newLivro = livroExist.get();
        newLivro.setTitulo(livro.getTitulo());
        newLivro.setGenero(livro.getGenero());
        newLivro.setAutor(livro.getAutor());


        return ResponseEntity.status(HttpStatus.OK).body(service.gravaLivro(newLivro));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletaLivro(@PathVariable(value = "id") Long id){

        Optional<Livro> livroExist = service.buscaId(id);
        if (livroExist.isEmpty()){
            return ResponseEntity.status(HttpStatus.OK).body("Livro não encontrado");
        }

        service.deleteLivro(livroExist);
        return ResponseEntity.status(HttpStatus.OK).body("Livro deletado!");
    }
}
