package com.microventas.ventas.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ItemTest {

    @Test
    void testGettersAndSetters() {
        Item item = new Item();
        item.setNombre("Producto");
        item.setPrecio(50.0);
        item.setQuantity(3);

        Assertions.assertEquals("Producto", item.getNombre());
        Assertions.assertEquals(50.0, item.getPrecio());
        Assertions.assertEquals(3, item.getQuantity());
    }
}
