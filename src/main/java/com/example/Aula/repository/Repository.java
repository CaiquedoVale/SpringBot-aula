package com.example.Aula.repository;

import com.example.Aula.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Repository extends JpaRepository<Cliente, Long> {
}
