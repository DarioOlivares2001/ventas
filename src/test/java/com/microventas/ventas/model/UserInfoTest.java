package com.microventas.ventas.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UserInfoTest {

    @Test
    void testGettersAndSetters() {
        UserInfo userInfo = new UserInfo();
        userInfo.setNombre("Luisa");
        userInfo.setEmail("luisa@mail.com");
        userInfo.setDireccion("Boulevard 123");

        Assertions.assertEquals("Luisa", userInfo.getNombre());
        Assertions.assertEquals("luisa@mail.com", userInfo.getEmail());
        Assertions.assertEquals("Boulevard 123", userInfo.getDireccion());
    }
}
