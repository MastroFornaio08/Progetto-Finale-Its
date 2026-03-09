package com.progettofinale.its.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Utente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Il nome non può essere vuoto!")
    private String nome;

    @NotBlank(message = "Il cognome non può essere vuoto!")
    private String cognome;

    @NotBlank(message = "L'email è obbligatoria!")
    @Email(message = "Inserisci un indirizzo email valido (es. nome@dominio.com)")
    private String email;

    public Utente(String nome, String cognome, String email) {
        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
    }
}