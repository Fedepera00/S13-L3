package it.epicode.esercizi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory; // LOGGING
import java.time.LocalDate; // LOCALDATE PER GESTIRE LE DATE
import java.util.List; // LIST PER RAPPRESENTARE I PRODOTTI

public class Order {
    private static final Logger logger = LoggerFactory.getLogger(Order.class);

    private Long id;
    private String status; // STATO DELL'ORDINE (es. "Shipped", "Pending")
    private LocalDate orderDate;
    private LocalDate deliveryDate;
    private List<Product> products;
    private Customer customer;

    // MI CREO IL COSTRUTTORE
    public Order(Long id, String status, LocalDate orderDate, LocalDate deliveryDate, List<Product> products, Customer customer) {
        this.id = id;
        this.status = status;
        this.orderDate = orderDate;
        this.deliveryDate = deliveryDate;
        this.products = products;
        this.customer = customer;

        logger.info("Creato ordine: {}", this);
    }

    //GETTER

    public Long getId() { return id; }

    public String getStatus() { return status; }

    public LocalDate getOrderDate() { return orderDate; }

    public LocalDate getDeliveryDate() { return deliveryDate; }

    public List<Product> getProducts() { return products; }

    public Customer getCustomer() { return customer; }

    // ORDINE COME STRINGA
    @Override
    public String toString() {
        return "Order{id=" + id + ", status='" + status + "', orderDate=" + orderDate +
                ", deliveryDate=" + deliveryDate + ", products=" + products + ", customer=" + customer + "}";
    }
}