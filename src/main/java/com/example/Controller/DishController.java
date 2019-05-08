package com.example.Controller;

import com.example.Model.Customer;
import com.example.Model.CustomerDishItem;
import com.example.Model.Dish;
import com.example.Service.CustomerDishItemService;
import com.example.Service.DishService;
import com.example.util.ObjectUtil;
import com.example.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * Created by ThinkPad on 2019/3/8.
 */

@Controller
@RequestMapping("/dish")
public class DishController {

    @Autowired
    private DishService dishService;

    @Autowired
    private CustomerDishItemService customerDishItemService;



    @RequestMapping("/add")
    @ResponseBody
    public Object addDish(@RequestBody Dish dish){
        String message;
        this.dishService.DishInsert(dish);
        return Result.success();
    }

    @RequestMapping("/list/{mid}")
    @ResponseBody
    public List<Dish> listDish(@PathVariable("mid") int mid){
        return this.dishService.DishList(mid);
    }

    @RequestMapping("/update")
    @ResponseBody
    public Object updateDish(@RequestBody Dish dish){
        this.dishService.DishUpdate(dish);
        return Result.success();
    }

//    @RequestMapping("/get/{id}")
//    public String getDish(@PathVariable("id") String id){
//        int mid = Integer.parseInt(id);
//       List<Dish> DishList = this.dishService.DishList(mid);
//        return "dishes";
//       //return Result.success(DishList);
//    }

    @RequestMapping("/get/{id}")
    public ModelAndView getDish(@PathVariable("id") String id ){
        ModelAndView mav = new ModelAndView("dishes");
        int mid = Integer.parseInt(id);
        List<Dish> DishList = this.dishService.DishList(mid);
        mav.addObject("DishList",DishList);
        return mav;
    }


    /**
     * 获取现在时间
     *
     * @return返回长时间格式 yyyy-MM-dd HH:mm:ss
     */
    public static Date getNowDate() {
        Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = formatter.format(currentTime);
        ParsePosition pos = new ParsePosition(8);
        Date currentTime_2 = formatter.parse(dateString, pos);
        return currentTime_2;
    }

    @RequestMapping("post/{id}/{mid}")
    @ResponseBody
    public Object addDish(@PathVariable("id") int id, @PathVariable("mid")int mid, HttpServletRequest request){
        Customer customer = (Customer) request.getSession().getAttribute("customer");
        CustomerDishItem customerDishItem = new CustomerDishItem();
        if(ObjectUtil.isNotEmpty(customer)){
            customerDishItem.setCid(customer.getId());
        }else {
            customerDishItem.setCid(0);
        }
        int cid = customerDishItem.getCid();
        /************search for the same order item,if exist, the amount will pluse one********/
        CustomerDishItem dbCustomerDishItem = this.customerDishItemService.select(mid,cid,id);
        if(ObjectUtil.isEmpty(dbCustomerDishItem)){
            customerDishItem.setDid(id);
            customerDishItem.setMid(mid);
            customerDishItem.setAmount(1);
            customerDishItem.setCreateDate(new Date());
            this.customerDishItemService.insert(customerDishItem);
        }
        else{
            dbCustomerDishItem.setAmount(dbCustomerDishItem.getAmount()+1);
            dbCustomerDishItem.setModifiedDate(this.getNowDate());
            this.customerDishItemService.update(dbCustomerDishItem);
        }
        return Result.success();

    }
}