package com.microventas.ventas.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "invoices")
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "order_number", nullable = false)
    private Integer orderNumber;

    @Column(name = "invoice_number", nullable = false)
    private Integer invoiceNumber;

    @ElementCollection
    @CollectionTable(name = "invoice_items", joinColumns = @JoinColumn(name = "invoice_id"))
    private List<Item> items;

   
    @Column(name = "total")
    private Double total;

    @Embedded
    private UserInfo userInfo;

    @Column(name = "fecha")
    private String fecha;



    // Constructor por defecto
    public Invoice() {
    }

    // Constructor con todos los campos
    public Invoice(Long id, Integer orderNumber, Integer invoiceNumber, List<Item> items, Double total, UserInfo userInfo, String fecha) {
        this.id = id;
        this.orderNumber = orderNumber;
        this.invoiceNumber = invoiceNumber;
        this.items = items;
        this.total = total;
        this.userInfo = userInfo;
        this.fecha = fecha;
    }

    // Constructor sin ID (para creación de nuevas facturas)
    public Invoice(Integer orderNumber, Integer invoiceNumber, List<Item> items, Double total, UserInfo userInfo, String fecha) {
        this.orderNumber = orderNumber;
        this.invoiceNumber = invoiceNumber;
        this.items = items;
        this.total = total;
        this.userInfo = userInfo;
        this.fecha = fecha;
    }

    // Constructor básico (mínimos campos)
    public Invoice(Long id, Double total) {
        this.id = id;
        this.total = total;
    }

   

        

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(Integer orderNumber) {
        this.orderNumber = orderNumber;
    }

    public Integer getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(Integer invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

}
