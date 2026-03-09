package com.progettofinale.its.config;


import com.progettofinale.its.model.Utente;
import com.progettofinale.its.repository.UtenteRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataInitializer {

    @Bean
    public CommandLineRunner caricaDati(UtenteRepository repository) {
        return args -> {
            // Se il database è vuoto inserisco questi dati qui
            if (repository.count() == 0) {
                repository.save(new Utente("Mario", "Rossi", "mario.rossi@example.com"));
                repository.save(new Utente("Giulia", "Bianchi", "giulia.b@example.com"));
                repository.save(new Utente("Luca", "Verdi", "luca.verdi@example.com"));
                
                System.out.println("Dati di prova inseriti con successo nel database H2!");
            }
        };
    }
}