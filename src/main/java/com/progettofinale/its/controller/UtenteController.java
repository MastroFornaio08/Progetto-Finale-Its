package com.progettofinale.its.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.progettofinale.its.model.Utente;
//import com.progettofinale.its.repository.UtenteRepository;
import jakarta.validation.Valid;
import com.progettofinale.its.service.UtenteService;

import java.util.List;

@RestController
@RequestMapping("/api/utenti")
public class UtenteController {

    @Autowired
    private UtenteService utenteService; // Usiamo il Service invece del Repository!

    @GetMapping
    public List<Utente> getTuttiGliUtenti() {
        return utenteService.ottieniTuttiGliUtenti();
    }

    @PostMapping
    public Utente creaUtente(@Valid @RequestBody Utente nuovoUtente) {
        return utenteService.salvaUtente(nuovoUtente);
    }

    @DeleteMapping("/{id}")
    public String cancellaUtente(@PathVariable Long id) {
        boolean eliminato = utenteService.eliminaUtente(id);
        if (eliminato) {
            return "Utente con ID " + id + " eliminato con successo!";
        } else {
            return "Errore: Utente con ID " + id + " non trovato.";
        }
    }

    @PutMapping("/{id}")
    public Utente aggiornaUtente(@PathVariable Long id, @Valid @RequestBody Utente utenteAggiornato) {
        return utenteService.ottieniUtentePerId(id)
            .map(utenteEsistente -> {
                utenteEsistente.setNome(utenteAggiornato.getNome());
                utenteEsistente.setCognome(utenteAggiornato.getCognome());
                utenteEsistente.setEmail(utenteAggiornato.getEmail());
                return utenteService.salvaUtente(utenteEsistente);
            })
            .orElseThrow(() -> new RuntimeException("Errore: Utente con ID " + id + " non trovato."));
    }
}