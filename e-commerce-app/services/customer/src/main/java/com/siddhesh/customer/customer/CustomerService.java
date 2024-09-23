package com.siddhesh.customer.customer;


import com.siddhesh.customer.exception.CustomerNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private CustomerRepository customerRepository;

    private CustomerMapper mapper;
    public String createCustomer(CustomerRequest request) {
        var customer = customerRepository.save(mapper.toCustomer(request));
        return customer.getId();
    }

    public void updateCustomer(CustomerRequest request) {
        var customer = customerRepository.findById(request.id())
                .orElseThrow(() -> new CustomerNotFoundException("Customer Not Found with this ID"));
        customerRepository.save(customer);
    }

    public List<Customer> getCustomer() {
        return customerRepository.findAll();

    }
}
