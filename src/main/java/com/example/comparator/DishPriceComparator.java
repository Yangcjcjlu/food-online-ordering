package com.example.comparator;

import com.example.Model.Dish;

import java.util.Comparator;

/**
 * Created by ThinkPad on 2019/3/9.
 */
public class DishPriceComparator implements Comparator<Dish> {
    @Override
    public int compare(Dish o1, Dish o2) {
        return (int)(o1.getPrice()-o2.getPrice());
    }
}
