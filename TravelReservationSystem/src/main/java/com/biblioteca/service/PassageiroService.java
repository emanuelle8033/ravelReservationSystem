package com.biblioteca.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.biblioteca.model.Passageiro;
import com.biblioteca.repository.PassageiroRepository;

@Service
public class PassageiroService {

    @Autowired
    private PassageiroRepository passageiroRepository;

    public List<Passageiro> findAll() {
        return passageiroRepository.findAll();
    }

    public Optional<Passageiro> findById(Long id) {
        return passageiroRepository.findById(id);
    }

    public Passageiro save(Passageiro passageiro) {
        return passageiroRepository.save(passageiro);
    }

    public Passageiro update(Long id, Passageiro passageiro) {
        Optional<Passageiro> existing = passageiroRepository.findById(id);
        if (existing.isPresent()) {
            passageiro.setId(id);
            return passageiroRepository.save(passageiro);
        }
        return null;
    }

    public void delete(Long id) {
        passageiroRepository.deleteById(id);
    }
}
