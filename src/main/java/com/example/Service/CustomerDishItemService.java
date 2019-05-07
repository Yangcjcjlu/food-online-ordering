package com.example.Service;

import com.example.Dao.CustomerDishItemDao;
import com.example.Model.DishItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by ThinkPad on 2019/4/29.
 */
@Service("CustomerDishItemDao")
public class CustomerDishItemService implements CustomerDishItemDao {

    @Autowired
    private CustomerDishItemDao customerDishItemDao;


    @Override
    public void insert(DishItem dishItem) {
        customerDishItemDao.insert(dishItem);
    }

    @Override
    public void update(DishItem dishItem) {
        customerDishItemDao.update(dishItem);
    }
}
