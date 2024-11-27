package it.epicode.esercizi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory; // LOGGING


public class Product {
    private static final Logger logger = LoggerFactory.getLogger(Product.class);

    private Long id;
    private String name;
    private String category; // (es. "Books", "Baby")
    private Double price;

    // MI CREO IL COSTRUTTORE
    public Product(Long id, String name, String category, Double price) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.price = price;

        logger.info("Creato prodotto: {}", this);
    }

    //GETTER

    public Long getId() { return id; }

    public String getName() { return name; }

    public String getCategory() { return category; }

    public Double getPrice() { return price; }

    // RAPPRESENTO PRODOTTO COME STRINGA
    @Override
    public String toString() {
        return "Product{id=" + id + ", name='" + name + "', category='" + category + "', price=" + price + "}";
    }
}