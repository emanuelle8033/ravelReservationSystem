package com.biblioteca.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.biblioteca.model.Destino;
import com.biblioteca.repository.DestinoRepository;

@Service
public class DestinoService {

    @Autowired
    private DestinoRepository destinoRepository;

    public List<Destino> findAll() {
        return destinoRepository.findAll();
    }

    public Optional<Destino> findById(Long id) {
        return destinoRepository.findById(id);
    }

    public Destino save(Destino destino) {
        return destinoRepository.save(destino);
    }

    public Destino update(Long id, Destino destino) {
        Optional<Destino> existing = destinoRepository.findById(id);
        if (existing.isPresent()) {
            destino.setId(id);
            return destinoRepository.save(destino);
        }
        return null;
    }

    public void delete(Long id) {
        destinoRepository.deleteById(id);
    }
}