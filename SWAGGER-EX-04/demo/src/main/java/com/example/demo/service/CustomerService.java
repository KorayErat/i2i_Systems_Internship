package com.example.demo.service;

import com.example.demo.dto.CustomerDTO;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CustomerService {

    private final Map<Long, CustomerDTO> customers = new HashMap<>();
    private long idCounter = 1;

    public CustomerDTO createCustomer(CustomerDTO dto) {
        dto.setId(idCounter++);
        customers.put(dto.getId(), dto);
        return dto;
    }

    public CustomerDTO getCustomerById(Long id) {
        return customers.get(id);
    }

    public List<CustomerDTO> getAllCustomers() {
        return new ArrayList<>(customers.values());
    }

    public CustomerDTO updateCustomer(Long id, CustomerDTO dto) {
        if (customers.containsKey(id)) {
            dto.setId(id);
            customers.put(id, dto);
            return dto;
        }
        return null;
    }

    public boolean deleteCustomer(Long id) {
        return customers.remove(id) != null;
    }
}
