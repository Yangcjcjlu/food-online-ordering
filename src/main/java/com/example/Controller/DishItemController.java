package com.example.Controller;

import com.example.Model.Customer;
import com.example.Model.CustomerDishItem;
import com.example.Model.Dish;
import com.example.Model.DishItem;
import com.example.Service.CustomerDishItemService;
import com.example.Service.DishService;
import com.example.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * Created by ThinkPad on 2019/3/8.
 */

@Controller
@RequestMapping("/dishItem")
public class DishItemController {

    @Autowired
    private CustomerDishItemService customerDishItemService;



    @RequestMapping("/list")
    @ResponseBody
    public List<DishItem> getDishList(HttpServletRequest request){
        Customer customer=(Customer) request.getSession().getAttribute("customer");
        int cid;
        if(!customer.equals(null)){
             cid = customer.getId();
        }else{
            cid =0;
        }
        List<DishItem> dishItemList = this.customerDishItemService.list(cid);

        return dishItemList;
    }






    @RequestMapping("post/{id}")
    public Object addDish(@PathVariable("id") int id, HttpServletRequest request){
        Customer customer = (Customer) request.getSession().getAttribute("customer");
        CustomerDishItem customerDishItem = new CustomerDishItem();
        customerDishItem.setCid(customer.getId());
        customerDishItem.setDid(id);
        customerDishItem.setAmount(1);
        customerDishItem.setCreateDate(new Date());


        this.customerDishItemService.insert(customerDishItem);
        return Result.success();

    }
}