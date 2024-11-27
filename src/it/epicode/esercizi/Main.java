package it.epicode.esercizi;

import it.epicode.esercizi.esercizio1.Esercizio1;
import it.epicode.esercizi.esercizio2.Esercizio2;
import it.epicode.esercizi.esercizio3.Esercizio3;
import it.epicode.esercizi.esercizio4.Esercizio4;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory; // LOGGING

import java.time.LocalDate; // LOCALDATE PER GESTIRE LE DATE
import java.util.ArrayList;
import java.util.List; // LIST PER ELENCHI DI OGGETTI
import java.util.Scanner;

public class Main {
    private static final Logger logger = LoggerFactory.getLogger(Main.class);


    public static void main(String[] args) {
        logger.info("Applicazione avviata");


        // LISTA PER I PRODOTTI DI TEST
        List<Product> products = new ArrayList<>();
        products.add(new Product(1L, "Book A", "Books", 150.0)); // "Books"
        products.add(new Product(2L, "Toy A", "Baby", 50.0)); // "Baby"
        products.add(new Product(3L, "Game B", "Boys", 120.0)); // "Boys"
        products.add(new Product(4L, "Book B", "Books", 120.0)); // "Books"
        products.add(new Product(5L, "Toy B", "Baby", 120.0)); // "Baby"

        // LISTA CLIENTI PER I TEST
        Customer customer1 = new Customer(1L, "Federico Peralta", 2); // CLIENTE LV 2
        Customer customer2 = new Customer(2L, "Andrea La Ventura", 1); // CLIENTE LV 1

        // LISTA ORDINI PER I TEST
        List<Order> orders = new ArrayList<>();
        orders.add(new Order(1L, "Shipped", LocalDate.of(2021, 2, 1), LocalDate.of(2021, 2, 10), products, customer1));
        // ORDINE SPEDITO
        orders.add(new Order(2L, "Pending", LocalDate.of(2021, 3, 1), LocalDate.of(2021, 3, 10), products, customer2));
        // ORDINE EFFETTUATO

        Scanner scanner = new Scanner(System.in);


        boolean running = true;


        while (running) {
            // MENU'
            System.out.println("\n=== MENU INTERATTIVO ===");
            System.out.println("1. Esercizio 1: Prodotti categoria 'Books' con prezzo > 100");
            System.out.println("2. Esercizio 2: Ordini con prodotti nella categoria 'Baby'");
            System.out.println("3. Esercizio 3: Applica sconto 10% a prodotti categoria 'Boys'");
            System.out.println("4. Esercizio 4: Prodotti di clienti livello 2 tra date specifiche");
            System.out.println("5. Esci");
            System.out.print("Scegli un'opzione: ");

            int scelta = scanner.nextInt();


            switch (scelta) {
                case 1:
                    logger.info("Esercizio 1 selezionato");

                    List<Product> booksOver100 = Esercizio1.getBooksOverPrice(products);
                    // PRODOTTI > DI 100
                    System.out.println("Prodotti trovati: " + booksOver100);
                    break;

                case 2:
                    logger.info("Esercizio 2 selezionato");

                    List<Order> babyOrders = Esercizio2.getOrdersWithBabyProducts(orders);
                    // PRODOTTI BABY
                    System.out.println("Ordini trovati: " + babyOrders);
                    break;

                case 3:
                    logger.info("Esercizio 3 selezionato");

                    List<Product> discountedBoysProducts = Esercizio3.applyDiscountToBoysProducts(products);
                    // APPLICARE SCONTO AI PRODOTTI BOYS
                    System.out.println("Prodotti scontati: " + discountedBoysProducts);
                    break;

                case 4:
                    logger.info("Esercizio 4 selezionato");

                    List<Product> tier2Products = Esercizio4.getProductsByTierAndDateRange(orders);
                    // PRODOTTI ORDINATI DAI CLIENTI DI LIVELLO 2
                    System.out.println("Prodotti trovati: " + tier2Products);
                    break;

                case 5:
                    logger.info("Uscita");
                    System.out.println("Ciao!");
                    running = false;
                    break;

                default:
                    logger.warn("Opzione non valida");
                    System.out.println("Opzione non valida. Riprova.");
            }
        }

        scanner.close();
        logger.info("Applicazione chiusa");
    }
}