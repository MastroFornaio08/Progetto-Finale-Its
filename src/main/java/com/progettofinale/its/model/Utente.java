package com.progettofinale.its.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity 
@Data //Genera in automatico Getter, Setter, toString, ecc.
@NoArgsConstructor //Genera il costruttore vuoto richiesto da JPA
public class Utente {

    @Id // Indica che questa è la Chiave Primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Long id;

    private String nome;
    private String cognome;
    private String email;

    
    public Utente(String nome, String cognome, String email) {
        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
    }
}