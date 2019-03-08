package com.example.Dao;

import com.example.Model.Merchant;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by ThinkPad on 2019/3/8.
 */
public interface MerchantDao {

    Merchant MerchantGet(int id);

    Merchant MerchantGet(@Param("name") String name);

    List<Merchant> MerchantList();

    boolean MerchantIsExist(String name);

    void MerchantDelete(Merchant merchant);

    void MerchantInsert(Merchant merchant);

    void MerchantUpdate(Merchant merchant);
}
