package it.epicode.esercizi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory; // LOGGING

public class Customer {
    private static final Logger logger = LoggerFactory.getLogger(Customer.class);

    private Long id;
    private String name;
    private Integer tier; // LIVELLO DEL CLIENTE (es. 1, 2)

    // MI CREO IL COSTRUTTORE
    public Customer(Long id, String name, Integer tier) {
        this.id = id;
        this.name = name;
        this.tier = tier;

        logger.info("Creato cliente: {}", this);
    }

    //GETTER

    public Long getId() { return id; }

    public String getName() { return name; }

    public Integer getTier() { return tier; }

    // METODO PER RAPP CLIENTE COME STRINGA
    @Override
    public String toString() {
        return "Customer{id=" + id + ", name='" + name + "', tier=" + tier + "}";
    }
}