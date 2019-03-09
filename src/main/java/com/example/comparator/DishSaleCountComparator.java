package com.example.comparator;

import com.example.Model.Dish;

import java.util.Comparator;

/**
 * Created by ThinkPad on 2019/3/9.
 */
public class DishSaleCountComparator implements Comparator<Dish> {
    @Override
    public int compare(Dish o1, Dish o2) {
        return o1.getSaleCount()-o2.getSaleCount();
    }
}
