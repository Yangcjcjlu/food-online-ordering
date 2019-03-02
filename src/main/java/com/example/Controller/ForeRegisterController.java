package com.example.Controller;

import com.example.Model.Customer;
import com.example.Service.CustomerService;
import com.example.util.Result;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * Created by ThinkPad on 2019/2/27.
 */
@Controller
@RequestMapping("/fore")
public class ForeRegisterController {
    @Autowired
    CustomerService customerService;

    @RequestMapping("/foreRegister")
    @ResponseBody
    public Object register(@RequestParam("name") String name,@RequestParam("email") String email,@RequestParam("password") String password,
    @RequestParam("telephone") String telephone){
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
        return Result.success();
    }

    public Object login(@RequestParam("name") String name,@RequestParam("password") String password){
        Customer customer = new Customer();
        customer.setName(name);
        customer.setPassword(password);
        return null;
    }
}
