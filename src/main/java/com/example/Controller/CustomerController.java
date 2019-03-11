package com.example.Controller;


import com.example.Model.Customer;
import com.example.Service.CustomerService;
import com.example.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("")
public class CustomerController {

    @Autowired
    private CustomerService customserService;

    @ResponseBody
    @RequestMapping("/select")
    public String selectCustomer(Customer customer) {
        List<Customer> customerList = customserService.selectCustomer(customer);
        for (Customer customer1 : customerList) {
            System.out.println(customer1.getName());
        }
        return "login";
    }


    @RequestMapping(value="/registerSuccess")
    public String registerSuccess(){
        return "registerSuccess";
    }

    @ResponseBody
    @RequestMapping("/insert")
    public void insertCustomer(Customer customer) {
        System.out.println("good");
        System.out.println(customer.getName());
        this.customserService.insertCustomer(customer);
    }


    @RequestMapping("/update")
    public  void updateCustomer(Customer customer){

    }

    @RequestMapping("/delete")
    public  void deleteCustomer(){

    }

    @RequestMapping(value =  "/login")
    public String login(){
        return "login";
    }


   // @RequestMapping(value = "/login")
    public String login(@RequestParam("name") String name, @RequestParam("password") String password, Model model, HttpSession session) {
        Customer customer = customserService.get(name);
        if(customer==null){
            model.addAttribute("msg","账号密码错误");
            return "login";
        }
        session.setAttribute("customer",customer);
        return "redirect:index";
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
    public String register(Model model,Customer customer)
    {

        return "register";
    }

    @RequestMapping(value = "/test")
    public String test(){
        return "test";
    }


    @RequestMapping(value = "/resturants")
    public String resturants() {
        return "resturants";
    }

    @RequestMapping(value = "/userInfo")
    public String userInfo() {
        return "Userinformation";
    }

    @RequestMapping(value = "/customerList")
    public String customerList(){ return  "CustomerList";}
}
