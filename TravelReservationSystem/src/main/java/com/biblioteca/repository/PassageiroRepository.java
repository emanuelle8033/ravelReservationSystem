package com.biblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.biblioteca.model.Passageiro;

@Repository
public interface PassageiroRepository extends JpaRepository<Passageiro, Long> {
}