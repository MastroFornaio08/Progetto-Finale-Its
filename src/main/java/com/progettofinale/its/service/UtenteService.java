package com.progettofinale.its.service;

import com.progettofinale.its.model.Utente;
import com.progettofinale.its.repository.UtenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service // Indica a Spring che questa classe contiene la "logica di business"
public class UtenteService {

    @Autowired
    private UtenteRepository utenteRepository;

    public List<Utente> ottieniTuttiGliUtenti() {
        return utenteRepository.findAll();
    }

    public Utente salvaUtente(Utente utente) {
    	return utenteRepository.save(utente);
    }

    public Optional<Utente> ottieniUtentePerId(Long id) {
        return utenteRepository.findById(id);
    }

    public boolean eliminaUtente(Long id) {
        if (utenteRepository.existsById(id)) {
            utenteRepository.deleteById(id);
            return true;
        }
        return false;
    }
}