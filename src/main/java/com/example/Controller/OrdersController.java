package com.example.Controller;

import com.example.Model.DishItem;
import com.example.Model.Order;
import com.example.Service.OrderService;
import com.example.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


/**
 * Created by ThinkPad on 2019/1/27.
 */

@Controller
@RequestMapping("/order")
public class OrdersController {

    @Autowired
    OrderService orderService;




    @RequestMapping("/add")
    @ResponseBody
    public Object addOrder(Order order){
        this.orderService.OrderInsert(order);
        return Result.success();
    }

//    @RequestMapping("/post")
//    @ResponseBody
//    public Object OrderInsert(HttpServletRequest request){
//        System.out.println(request);
//       // this.orderService.OrderInsert(order);
//        return Result.success();
//    }



    @RequestMapping("/delete")
    @ResponseBody
    public Object deleteOrder(Order order){
        this.orderService.OrderDelete(order);
        return Result.success();
    }

    @RequestMapping("/list")
    @ResponseBody
    public List<Order> listOrder(){

        return this.orderService.OrderList();
    }

    @RequestMapping("/update")
    @ResponseBody
    public Object updateOrder(Order order){
        this.orderService.OrderUpdate(order);
        return Result.success();
    }

    @RequestMapping("foreSearch")
    @ResponseBody
    public Object search(String keyword){
        return null;
    }
}
