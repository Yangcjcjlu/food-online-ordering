package com.example.Service;

import com.example.Dao.RestaurantDao;
import com.example.Model.Restaurant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by ThinkPad on 2019/3/19.
 */
@Service("RestaurantService")
public class RestaurantService implements RestaurantDao {

    @Autowired
    private RestaurantDao restaurantDao;

    @Override
    public List<Restaurant> RestaurantList() {
        return this.restaurantDao.RestaurantList();
    }
}
