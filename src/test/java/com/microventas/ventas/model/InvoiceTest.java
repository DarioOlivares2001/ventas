package com.microventas.ventas.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class InvoiceTest {

    @Test
    void testSettersAndGetters() {
        UserInfo userInfo = new UserInfo("Pepe", "pepe@mail.com", "Calle 456");
        Item item = new Item();
        item.setNombre("Producto");
        item.setPrecio(100.0);
        item.setQuantity(2);

        Invoice invoice = new Invoice();
        invoice.setId(1L);
        invoice.setOrderNumber(123);
        invoice.setInvoiceNumber(456);
        invoice.setItems(List.of(item));
        invoice.setTotal(200.0);
        invoice.setUserInfo(userInfo);
        invoice.setFecha("2024-12-13");

        Assertions.assertEquals(1L, invoice.getId());
        Assertions.assertEquals(123, invoice.getOrderNumber());
        Assertions.assertEquals(456, invoice.getInvoiceNumber());
        Assertions.assertEquals(1, invoice.getItems().size());
        Assertions.assertEquals(200.0, invoice.getTotal());
        Assertions.assertEquals("Pepe", invoice.getUserInfo().getNombre());
        Assertions.assertEquals("2024-12-13", invoice.getFecha());
    }
}
