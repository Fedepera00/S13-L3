package it.epicode.esercizi.esercizio1;

import it.epicode.esercizi.Product; // PRODUCT
import org.slf4j.Logger;
import org.slf4j.LoggerFactory; // LOGGING
import java.util.List;
import java.util.stream.Collectors; // COLLECTORS X DATI STREAMS

// ES. 1 FILTRA I PRODOTTI CON PREZZO 1 - 100
public class Esercizio1 {
    private static final Logger logger = LoggerFactory.getLogger(Esercizio1.class);

    // FILTRO PRODOTTI
    public static List<Product> getBooksOverPrice(List<Product> products) {
        logger.info("Esercizio 1 partito con {} prodotti", products.size());

        // FILTRO USO STREAM
        List<Product> result = products.stream()
                .filter(p -> "Books".equals(p.getCategory()) && p.getPrice() > 100) // CATEGORIA E PREZZO
                .collect(Collectors.toList()); // METTO IN UNA LISTA

        logger.info("Esercizio 1 terminato, prodotti trovati: {}", result.size());
        return result;
    }
}