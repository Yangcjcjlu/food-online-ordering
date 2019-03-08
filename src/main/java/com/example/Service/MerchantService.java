package com.example.Service;

import com.example.Dao.MerchantDao;
import com.example.Model.Merchant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by ThinkPad on 2019/3/8.
 */

@Service("MerchantService")
public class MerchantService implements MerchantDao {

    @Autowired
    private MerchantDao merchantDao;

    @Override
    public Merchant MerchantGet(int id){ return this.merchantDao.MerchantGet(id);}

    @Override
    public List<Merchant> MerchantList(){ return this.merchantDao.MerchantList();}

    @Override
    public void MerchantDelete(Merchant merchant){ this.merchantDao.MerchantDelete(merchant);}

    @Override
    public void MerchantInsert(Merchant merchant){ this.merchantDao.MerchantInsert(merchant);}

    @Override
    public void MerchantUpdate(Merchant merchant){this.merchantDao.MerchantUpdate(merchant);}

    @Override
    public Merchant MerchantGet(String name) {return this.merchantDao.MerchantGet(name);}

    @Override
    public boolean MerchantIsExist(String name){
        Merchant merchant = merchantDao.MerchantGet(name);
        if(merchant==null){
            return false;
        }
        return true;
    }
}
