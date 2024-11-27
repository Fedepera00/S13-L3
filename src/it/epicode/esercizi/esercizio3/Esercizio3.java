package it.epicode.esercizi.esercizio3;

import it.epicode.esercizi.Product; // PRODUCT
import org.slf4j.Logger;
import org.slf4j.LoggerFactory; // LOGGING
import java.util.List;
import java.util.stream.Collectors; // COLLECTORS PER RISULTATI STREAMS

// ES. 3 SCONTO 10% A CATEGORIA BABY
public class Esercizio3 {
    private static final Logger logger = LoggerFactory.getLogger(Esercizio3.class);

    // METODO PER APPLICATORE LO SCONTO 10%
    public static List<Product> applyDiscountToBoysProducts(List<Product> products) {
        logger.info("Esercizio 3 partito con {} prodotti", products.size());

        // APPLICO SCONTO 10% AI PRODOTTI BOYS
        List<Product> result = products.stream()
                .filter(product -> "Boys".equals(product.getCategory())) // FILTRA CATEGORIA BOYS
                .map(product -> new Product(
                        product.getId(),
                        product.getName(),
                        product.getCategory(),
                        product.getPrice() * 0.9)) // 10% SCONTO
                .collect(Collectors.toList());

        logger.info("Esercizio 3 terminato, prodotti con sconto: {}", result.size());
        return result;
    }
}