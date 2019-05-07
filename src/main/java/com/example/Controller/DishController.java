package com.example.Controller;

import com.example.Model.Dish;
import com.example.Service.DishService;
import com.example.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by ThinkPad on 2019/3/8.
 */

@Controller
@RequestMapping("/dish")
public class DishController {

    @Autowired
    private DishService dishService;




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
}