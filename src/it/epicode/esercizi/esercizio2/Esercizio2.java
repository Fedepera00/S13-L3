package it.epicode.esercizi.esercizio2;

import it.epicode.esercizi.Order; // ORDER
import org.slf4j.Logger;
import org.slf4j.LoggerFactory; // LOGGING
import java.util.List; // LISTA ORDINI
import java.util.stream.Collectors; // COLLECTORS PER STREAM

// ES. 2 FILTRO ORDINI CATEGORIA BABY
public class Esercizio2 {
    private static final Logger logger = LoggerFactory.getLogger(Esercizio2.class);

    // FILTRO GLI ORDINI
    public static List<Order> getOrdersWithBabyProducts(List<Order> orders) {
        logger.info("Esercizio 2 partito con {} ordini", orders.size());

        // FILTRO USANDO LO STREAM
        List<Order> result = orders.stream()
                .filter(order -> order.getProducts().stream()
                        .anyMatch(product -> "Baby".equals(product.getCategory()))) // VERIFICA BABY
                .collect(Collectors.toList());

        logger.info("Esercizio 2 terminato, ordini trovati: {}", result.size());
        return result;
    }
}