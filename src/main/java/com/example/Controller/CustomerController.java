package com.example.Controller;


import com.example.Model.Customer;
import com.example.Model.Merchant;
import com.example.Service.CustomerService;
import com.example.Service.MerchantService;
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

    @Autowired
    private MerchantService merchantService;

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



    @RequestMapping(value = "/orderItem")
    public String orderItem() {
        return "orderItem";
    }


    @RequestMapping(value = "/contact")
    public String contact() {
        return "contact";
    }

    @RequestMapping(value = "/m_register")
    public String Mregister() {
        return "Merchant register";
    }

    @RequestMapping(value = "/adminLogin")
    public String AdminLogin() {
        return "AdminLogin";
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

    @RequestMapping(value = "/CustomerList")
    public String customerList(){ return  "CustomerList";}

    @RequestMapping(value = "/merchantList")
    public String merchantList(){ return  "MerchantList";}

    @RequestMapping("ListCustomer")
    @ResponseBody
    public List<Customer> customersList(){
        return this.customserService.CustomerList();
    }

    @RequestMapping("ListMerchant")
    @ResponseBody
    public List<Merchant> merchantsList(){
        return this.merchantService.MerchantList();
    }

    @RequestMapping(value = "/dishs/{id}")
    @ResponseBody
    public String dishGet(@PathVariable("id") String mid){
        System.out.println(mid);
        return "dishes";
    }

    @RequestMapping("/CustomerDelete/{id}")
    @ResponseBody
    public Object CustomerDelete(@PathVariable("id") int id){
        this.customserService.delete(id);
        return Result.success();
    }

    @RequestMapping("/DynamicDish")
    public String DynamicDish(){
        return "DynamicDish";
    }
}
