package com.biblioteca.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.biblioteca.model.Viagem;
import com.biblioteca.repository.ViagemRepository;

@Service
public class ViagemService {

    @Autowired
    private ViagemRepository viagemRepository;

    public List<Viagem> findAll() {
        return viagemRepository.findAll();
    }

    public Optional<Viagem> findById(Long id) {
        return viagemRepository.findById(id);
    }

    public Viagem save(Viagem viagem) {
        // Calcula valor total baseado no destino
        if (viagem.getDestino() != null && viagem.getDestino().getPrecoEstimado() != null) {
            viagem.setValorTotal(viagem.getDestino().getPrecoEstimado());
        }
        return viagemRepository.save(viagem);
    }

    public Viagem update(Long id, Viagem viagem) {
        Optional<Viagem> existing = viagemRepository.findById(id);
        if (existing.isPresent()) {
            viagem.setId(id);
            return viagemRepository.save(viagem);
        }
        return null;
    }

    public void delete(Long id) {
        viagemRepository.deleteById(id);
    }
}