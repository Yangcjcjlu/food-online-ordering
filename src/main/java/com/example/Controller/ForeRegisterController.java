package com.example.Controller;

import com.example.Dao.AdministratorDao;
import com.example.Dao.MerchantDao;
import com.example.Model.Administrator;
import com.example.Model.Customer;
import com.example.Model.Dish;
import com.example.Model.Merchant;
import com.example.Service.AdministratorService;
import com.example.Service.CustomerService;
import com.example.Service.DishService;
import com.example.Service.MerchantService;
import com.example.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by ThinkPad on 2019/2/27.
 */
@Controller
@RequestMapping("/fore")
public class ForeRegisterController {
    @Autowired
    CustomerService customerService;

    @Autowired
    MerchantService merchantService;

    @Autowired
    DishService dishService;

    @Autowired
    AdministratorService administratorService;

    @RequestMapping("/AdministratorRegister")
    @ResponseBody
    public Object register(@RequestParam("name") String name,@RequestParam("password") String password,
    @RequestParam("tel") String tel,HttpServletRequest request){
       Administrator administrator = new Administrator();
       administrator.setTel(tel);
       administrator.setName(name);
       administrator.setPassword(password);
        boolean isExist =administratorService.isExist(name);

        if(isExist){
            String message = "UserName Is already existed, you need to create another account!!";
            return Result.fail(message);
        }
        administratorService.insert(administrator);
        request.getSession().setAttribute("administrator",administrator);
        return Result.success();
    }

    @RequestMapping("/foreRegister")
    @ResponseBody
    public Object register(@RequestParam("name") String name,@RequestParam("email") String email,@RequestParam("password") String password,
                           @RequestParam("telephone") String telephone,HttpServletRequest request){
        Customer customer = new Customer();
        customer.setTelephone(telephone);
        customer.setName(name);
        customer.setPassword(password);
        customer.setAddress(email);
        boolean isExist = customerService.isExist(name);

        if(isExist){
            String message = "UserName Is already existed, you need to create another account!!";
            return Result.fail(message);
        }
        customerService.insertCustomer(customer);
        customer = customerService.get(customer.getName());
        request.getSession().setAttribute("customer",customer);
        return Result.success();
    }

    @RequestMapping("/foreLogin")
    @ResponseBody
    public Object login(@RequestParam("name") String name, @RequestParam("password") String password, HttpServletRequest request){
        Customer customer = new Customer();
        customer.setName(name);
        customer.setPassword(password);
        Customer customer1 ;
        customer1=customerService.get(name);
        if(customer1==null)
        {
            String message = "There is no such people!";
            return Result.fail(message);
        }
        else if(!customer1.getPassword().toString().equals(password)){
            String message ="The password is incorrect,please check it out!";
            return Result.fail(message);
        }
        else{
            String message = "Welcome!";
            request.getSession().setAttribute("customer",customer1);
            return Result.success(message,customer1);
        }
    }


    @RequestMapping("/MerchantRegister1")
    @ResponseBody
    public Object MerchantRegister1(@RequestParam("name") String name,@RequestParam("password") String password,@RequestParam("tel") String tel,
                                    @RequestParam("address") String address){
        String message;
        if(this.merchantService.MerchantIsExist(name)){
            message = "The Merchant has already existed! Please change another name";
            return Result.fail(message);
        }
        Merchant merchant = new Merchant();
        merchant.setAddress(address);
        merchant.setName(name);
        merchant.setPassword(password);
        merchant.setStatus(1);
        merchant.setTel(tel);
        merchantService.MerchantInsert(merchant);
        return Result.success();

    }

    @RequestMapping("/MerchantRegister")
    @ResponseBody
    public Object MerchantRegister(@RequestBody Merchant merchant){
        String message;
        if(this.merchantService.MerchantIsExist(merchant.getName())){
            message = "The Merchant has already existed! Please change another name";
            return Result.fail(message);
        }

        merchantService.MerchantInsert(merchant);
        return Result.success();

    }

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ResponseBody
    public Object MerchantLogin(@RequestBody Merchant merchant,HttpSession session){
        String message;
        Merchant merchant1 = this.merchantService.MerchantGet(merchant.getName());
        if(merchant1==null){
            message = "There is no such people";
            return Result.fail(message);
        }
        if(merchant1.getPassword()!=merchant.getPassword()){
            message = "Password is InCorrect,please try again";
            return Result.fail(message);
        }
        session.setAttribute("user",merchant);
        return Result.success();

    }

    @GetMapping("forechecklogin ")
    public Object checkLogin(HttpSession session){
        String message;
        Customer customer = (Customer) session.getAttribute("name");
        if(null!=customer){
            message="success!";
            return Result.success(message);
        }
        message="please login in !";
        return Result.fail(message);
    }

    @GetMapping("foreLoginOut")
    public String logout(HttpSession session){
        session.removeAttribute("customer");
        return "redirect:index";
    }

    @GetMapping("foreBuyOne")
    public Object buyone(int did,int num,HttpSession session){
        return buyoneAndAddCart(did,num,session);
    }

    private int buyoneAndAddCart(int did,int num,HttpSession session){
        Dish dish = this.dishService.DishGet(did);
        int ooid=0;
        Customer customer = (Customer) session.getAttribute("customer");
        boolean found = false;
        return ooid;
    }
}