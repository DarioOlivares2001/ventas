package com.microventas.ventas.service;

import com.microventas.ventas.repository.*;
import com.microventas.ventas.model.*;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class InvoiceService {

    @Autowired
    private InvoiceRepository invoiceRepository;

    public List<Invoice> getAllInvoices() {
        return invoiceRepository.findAll();
    }

    public Invoice getInvoiceById(Long id) {
        return invoiceRepository.findById(id).orElseThrow(() -> new RuntimeException("Invoice not found"));
    }

    public Invoice createInvoice(Invoice invoice) {
        return invoiceRepository.save(invoice);
    }

    public Invoice updateInvoice(Long id, Invoice invoiceDetails) {
        Invoice invoice = getInvoiceById(id);
        invoice.setOrderNumber(invoiceDetails.getOrderNumber());
        invoice.setInvoiceNumber(invoiceDetails.getInvoiceNumber());
        invoice.setItems(invoiceDetails.getItems());
        invoice.setTotal(invoiceDetails.getTotal());
        invoice.setUserInfo(invoiceDetails.getUserInfo());
        invoice.setFecha(invoiceDetails.getFecha());
        return invoiceRepository.save(invoice);
    }

    public void deleteInvoice(Long id) {
        invoiceRepository.deleteById(id);
    }
}
