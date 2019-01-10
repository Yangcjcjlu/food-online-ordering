package com.example.Controller;


import com.example.Model.Customer;
import com.example.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class CustomerController {

    @Autowired
    private CustomerService customserService;

    @ResponseBody
    @GetMapping("/select")
    public void selectCustomer(Customer customer){
        List<Customer> customerList= customserService.selectCustomer(customer);
        for (Customer customer1:customerList
             ) {
            System.out.println(customer1.getName());

        }

    }

    @ResponseBody
    @PostMapping("/insert")
    public void insertCustomer(Customer customer){
         this.customserService.insertCustomer(customer);
    }


    @RequestMapping("/login")
    public String Customer(){
            return "login";
        }
    }

