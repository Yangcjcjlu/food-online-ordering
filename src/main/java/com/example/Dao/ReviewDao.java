package com.example.Dao;

import com.example.Model.Review;

import java.util.List;

/**
 * Created by ThinkPad on 2019/3/8.
 */
public interface ReviewDao {

    List<Review> ReviewList();

    Review ReviewGet(int id);

    void ReviewUpdate(Review review);

    void ReviewDelete(int id);

    void ReviewInsert(Review review);


}
