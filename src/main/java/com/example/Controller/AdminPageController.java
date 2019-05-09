package com.example.Controller;

import com.example.Model.Administrator;
import com.example.Model.Merchant;
import com.example.Service.AdministratorService;
import com.example.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

/**
 * Created by ThinkPad on 2019/3/11.
 */

@Controller
@RequestMapping("admin")
public class AdminPageController {

    @Autowired
    public AdministratorService administratorService;


    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ResponseBody
    public Object MerchantLogin(@RequestParam("name") String name,@RequestParam("password") String password, HttpSession session){
        String message;
        Administrator administrator = new Administrator();
        administrator.setName(name);
        administrator.setPassword(password);
        Administrator dbadministrator = this.administratorService.get(administrator.getName());
        if(dbadministrator==null){
            message = "There is no such people";
            return Result.fail(message);
        }
        if(!dbadministrator.getPassword().equals(administrator.getPassword())){
            message = "Password is InCorrect,please try again";
            return Result.fail(message);
        }
        session.setAttribute("admin",administrator);
        return Result.success();

    }

    @GetMapping(value = "/admin")
    public String admin(){
       return "redirect:admin_category_list";
    }

    @GetMapping(value = "/admin_category_list")
    public String listCategory(){
        return "admin/listCategory";
    }
}
