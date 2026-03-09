package com.progettofinale.its.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.progettofinale.its.model.Utente;
import com.progettofinale.its.repository.UtenteRepository;

import java.util.List;

@RestController
@RequestMapping("/api/utenti")
public class UtenteController {

    @Autowired
    private UtenteRepository utenteRepository;

    //LEGGI TUTTI 
    @GetMapping
    public List<Utente> getTuttiGliUtenti() {
        return utenteRepository.findAll();
    }

    //CREA UN NUOVO UTENTE
    @PostMapping
    public Utente creaUtente(@RequestBody Utente nuovoUtente) {
        
        return utenteRepository.save(nuovoUtente);
    }

    //CANCELLA UN UTENTE TRAMITE ID
    @DeleteMapping("/{id}")
    public String cancellaUtente(@PathVariable Long id) {
        
        if (utenteRepository.existsById(id)) {
            utenteRepository.deleteById(id);
            return "Utente con ID " + id + " eliminato con successo!";
        } else {
            return "Errore: Utente con ID " + id + " non trovato.";
        }
    }
 // 4. AGGIORNA UN UTENTE ESISTENTE (PUT)
    @PutMapping("/{id}")
    public Utente aggiornaUtente(@PathVariable Long id, @RequestBody Utente utenteAggiornato) {
        // Cerchiamo l'utente nel database tramite l'ID fornito
        return utenteRepository.findById(id)
            .map(utenteEsistente -> {
                // Se lo trova, aggiorniamo i suoi campi con i nuovi dati
                utenteEsistente.setNome(utenteAggiornato.getNome());
                utenteEsistente.setCognome(utenteAggiornato.getCognome());
                utenteEsistente.setEmail(utenteAggiornato.getEmail());
                
                // Salviamo le modifiche nel database
                return utenteRepository.save(utenteEsistente);
            })
            .orElseThrow(() -> new RuntimeException("Errore: Utente con ID " + id + " non trovato."));
    }
}