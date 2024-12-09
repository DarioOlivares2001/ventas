package com.microventas.ventas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.microventas.ventas.service.*;
import com.microventas.ventas.model.*;

import java.util.List;

@RestController
@RequestMapping("/api/invoices")
@CrossOrigin(origins = "http://localhost:4200") // Permite solicitudes desde el frontend
public class InvoiceController {

    @Autowired
    private InvoiceService invoiceService;

    @GetMapping
    public List<Invoice> getAllInvoices() {
        return invoiceService.getAllInvoices();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Invoice> getInvoiceById(@PathVariable Long id) {
        return ResponseEntity.ok(invoiceService.getInvoiceById(id));
    }

    @PostMapping
    public ResponseEntity<Invoice> createInvoice(@RequestBody Invoice invoice) {
        return ResponseEntity.ok(invoiceService.createInvoice(invoice));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Invoice> updateInvoice(@PathVariable Long id, @RequestBody Invoice invoiceDetails) {
        return ResponseEntity.ok(invoiceService.updateInvoice(id, invoiceDetails));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteInvoice(@PathVariable Long id) {
        invoiceService.deleteInvoice(id);
        return ResponseEntity.noContent().build();
    }
}
