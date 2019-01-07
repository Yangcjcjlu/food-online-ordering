package com.example.Controller;


import com.example.Model.Customer;
import com.example.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/user")
public class CustomerController {

    @Autowired
    private CustomerService customserService;

    @ResponseBody
    @GetMapping("/select")
    public Customer selectCustomer(Customer customer){
        List<Customer> customerList= customserService.selectCustomer(customer);
        for (Customer customer1:customerList
             ) {
            System.out.print(customer1);
            return customer1;
        }
        return null;
    }

    @ResponseBody
    @PostMapping("/insert")
    public void insertCustomer(Customer customer){
         this.customserService.insertCustomer(customer);
    }
}

