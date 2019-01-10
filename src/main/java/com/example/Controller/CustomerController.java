package com.example.Controller;


import com.example.Model.Customer;
import com.example.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/user")
public class CustomerController {

    @Autowired
    private CustomerService customserService;

    @ResponseBody
    @RequestMapping("/select")
    public String selectCustomer(Customer customer) {
        List<Customer> customerList = customserService.selectCustomer(customer);
        for (Customer customer1 : customerList
                ) {
            System.out.println(customer1.getName());

        }
        return "login";
    }

    @ResponseBody
    @PostMapping("/insert")
    public void insertCustomer(Customer customer) {
        this.customserService.insertCustomer(customer);
    }


    @RequestMapping(value = "/login")
    public String Customer() {
        return "login";
    }

    @RequestMapping(value = "/index")
    public String index() {
        return "index";
    }

    @RequestMapping(value = "/checkout")
    public String checkout() {
        return "checkout";
    }


    @RequestMapping(value = "/contact")
    public String contact() {
        return "contact";
    }

    @RequestMapping(value = "/m_register")
    public String Mregister() {
        return "Merchant register";
    }

    @RequestMapping(value = "/orders")
    public String orders() {
        return "orders";
    }

    @RequestMapping(value = "/register")
    public String register() {
        return "register";
    }

    @RequestMapping(value = "/resturants")
    public String resturants() {
        return "resturants";
    }

    @RequestMapping(value = "/userInfo")
    public String userInfo() {
        return "Userinformation";
    }
}
