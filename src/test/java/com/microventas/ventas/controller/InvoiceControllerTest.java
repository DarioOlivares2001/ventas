package com.microventas.ventas.controller;

import com.microventas.ventas.model.Invoice;

import com.microventas.ventas.model.Item;
import com.microventas.ventas.model.UserInfo;
import com.microventas.ventas.service.InvoiceService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;


import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class InvoiceControllerTest {

    @Mock
    private InvoiceService invoiceService;

    @InjectMocks
    private InvoiceController invoiceController;

    private MockMvc mockMvc;
    private Invoice invoice;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(invoiceController).build();

        // Creación de un objeto de prueba
        invoice = new Invoice(123, 456, List.of(new Item("Item1", 1, 100.0)), 100.0, new UserInfo("User1", "Address1", "user1@example.com"), "2024-12-13");
    }

    @Test
    void testGetAllInvoices() throws Exception {
        List<Invoice> invoiceList = List.of(invoice);

        // Simulación del servicio
        when(invoiceService.getAllInvoices()).thenReturn(invoiceList);

        // Realizar la petición GET
        mockMvc.perform(get("/api/invoices"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$[0].orderNumber").value(invoice.getOrderNumber()))
            .andExpect(jsonPath("$[0].invoiceNumber").value(invoice.getInvoiceNumber()))
            .andExpect(jsonPath("$[0].total").value(invoice.getTotal()));

        // Verificación de interacción con el servicio
        verify(invoiceService, times(1)).getAllInvoices();
    }

    @Test
    void testGetInvoiceById() throws Exception {
        // Simulación del servicio
        when(invoiceService.getInvoiceById(123L)).thenReturn(invoice);

        // Realizar la petición GET
        mockMvc.perform(get("/api/invoices/{id}", 123L))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.orderNumber").value(invoice.getOrderNumber()))
            .andExpect(jsonPath("$.invoiceNumber").value(invoice.getInvoiceNumber()))
            .andExpect(jsonPath("$.total").value(invoice.getTotal()));

        // Verificación de interacción con el servicio
        verify(invoiceService, times(1)).getInvoiceById(123L);
    }

    @Test
    void testCreateInvoice() throws Exception {
        // Simulación del servicio
        when(invoiceService.createInvoice(Mockito.any(Invoice.class))).thenReturn(invoice);

        // Realizar la petición POST
        mockMvc.perform(post("/api/invoices")
                .contentType("application/json")
                .content("{\"orderNumber\":123, \"invoiceNumber\":456, \"total\":100.0, \"items\":[{\"name\":\"Item1\", \"quantity\":1, \"price\":100.0}], \"userInfo\":{\"name\":\"User1\", \"address\":\"Address1\", \"email\":\"user1@example.com\"}, \"fecha\":\"2024-12-13\"}"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.orderNumber").value(invoice.getOrderNumber()))
            .andExpect(jsonPath("$.invoiceNumber").value(invoice.getInvoiceNumber()))
            .andExpect(jsonPath("$.total").value(invoice.getTotal()));

        // Verificación de interacción con el servicio
        verify(invoiceService, times(1)).createInvoice(Mockito.any(Invoice.class));
    }

   

    @Test
    void testDeleteInvoice() throws Exception {
        // Realizar la petición DELETE
        mockMvc.perform(delete("/api/invoices/{id}", 123L))
            .andExpect(status().isNoContent());

        // Verificación de interacción con el servicio
        verify(invoiceService, times(1)).deleteInvoice(123L);
    }
}
