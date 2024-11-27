package it.epicode.esercizi.esercizio4;

import it.epicode.esercizi.Order; // ORDER
import it.epicode.esercizi.Product; // PRODUCT
import org.slf4j.Logger;
import org.slf4j.LoggerFactory; // LOGGING
import java.time.LocalDate; // LOCALDATE FRAMEWORK GESTIONE DATE
import java.util.List;
import java.util.stream.Collectors; // COLLECTORS PER RACCOGLIERE GLI STREAMS

// ES.4 FILTRA I PRODOTTI ORDINATI DA CLIENTI DI LIVELLO 2
public class Esercizio4 {
    private static final Logger logger = LoggerFactory.getLogger(Esercizio4.class);

    // METODO PER FILTRARE I PRODOTTI
    public static List<Product> getProductsByTierAndDateRange(List<Order> orders) {
        logger.info("Esercizio 4 partito con {} ordini", orders.size());

        // FFILTRA GLI ORDINI E LI RACCOGLIE IN UNO STREAMS
        List<Product> result = orders.stream()
                .filter(order -> order.getCustomer().getTier() == 2) // FILTER LIVELLO 2 CLIENTI
                .filter(order -> order.getOrderDate().isAfter(LocalDate.of(2021, 1, 31))) // DOPO DATA 31 GENNAIO 2021
                .filter(order -> order.getOrderDate().isBefore(LocalDate.of(2021, 4, 2))) // PRIMA DI 1 APRILE 2021
                .flatMap(order -> order.getProducts().stream())
                .collect(Collectors.toList());

        logger.info("Esercizio 4 terminato, prodotti trovati: {}", result.size());
        return result;
    }
}