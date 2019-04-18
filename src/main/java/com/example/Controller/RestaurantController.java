package com.example.Controller;

import com.example.Service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by ThinkPad on 2019/3/19.
 */

@Controller
@RequestMapping("/restaurant")
public class RestaurantController {

    @Autowired
    private RestaurantService restaurantService;

    @RequestMapping("/list")
    @ResponseBody
    public List ListRestaurant(){
        return this.restaurantService.RestaurantList();
    }

}
