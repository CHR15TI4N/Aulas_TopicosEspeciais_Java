package com.Christian.Java.repository;

import com.Christian.Java.model.Venda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RestController;

@RestController
public interface VendaRepository extends JpaRepository<Venda, Integer> {
}
