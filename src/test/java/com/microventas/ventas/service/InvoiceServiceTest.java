package com.microventas.ventas.service;

import com.microventas.ventas.model.Invoice;
import com.microventas.ventas.model.Item;
import com.microventas.ventas.model.UserInfo;
import com.microventas.ventas.repository.InvoiceRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import java.util.Optional;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class InvoiceServiceTest {

    @Mock
    private InvoiceRepository invoiceRepository;

    @InjectMocks
    private InvoiceService invoiceService;

    private Invoice invoice;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);  // Inicializa los mocks
        
        // Creación de un objeto UserInfo (puedes ajustar los valores a lo que necesites)
        UserInfo userInfo = new UserInfo("User1", "Address1", "user1@example.com");
        
        // Creación de un objeto Item (puedes ajustarlo a lo que necesites)
        Item item = new Item("Item1", 1, 100.0);
        
        // Creación de una lista de Items
        List<Item> items = List.of(item);
        
        // Creación de una factura con el constructor adecuado
        invoice = new Invoice(123, 456, items, 100.0, userInfo, "2024-12-13");
    }

    @Test
    void testGetAllInvoices() {
        List<Invoice> invoiceList = List.of(invoice);

        // Simula el comportamiento del repositorio
        when(invoiceRepository.findAll()).thenReturn(invoiceList);

        // Llamada al servicio
        List<Invoice> result = invoiceService.getAllInvoices();

        // Verificación
        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals(invoice, result.get(0));

        // Verificación de interacción con el repositorio
        verify(invoiceRepository, times(1)).findAll();
    }

    @Test
    void testGetInvoiceById() {
        when(invoiceRepository.findById(1L)).thenReturn(Optional.of(invoice));

        // Llamada al servicio
        Invoice result = invoiceService.getInvoiceById(1L);

        // Verificación
        assertNotNull(result);
        assertEquals(invoice, result);

        verify(invoiceRepository, times(1)).findById(1L);
    }

    @Test
    void testCreateInvoice() {
        when(invoiceRepository.save(invoice)).thenReturn(invoice);

        Invoice result = invoiceService.createInvoice(invoice);

        assertNotNull(result);
        assertEquals(invoice, result);

        verify(invoiceRepository, times(1)).save(invoice);
    }

    

    @Test
    void testDeleteInvoice() {
        invoiceService.deleteInvoice(1L);

        verify(invoiceRepository, times(1)).deleteById(1L);
    }

    @Test
    void testGetInvoiceById_throwsException() {
        when(invoiceRepository.findById(1L)).thenReturn(Optional.empty());

        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            invoiceService.getInvoiceById(1L);
        });

        assertEquals("Invoice not found", exception.getMessage());

        verify(invoiceRepository, times(1)).findById(1L);
    }
}
