package com.example.Service;

import com.example.Dao.CustomerDao;
import com.example.Model.Customer;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by ThinkPad on 2019/1/7.
 */
@Service("CustomerDao")
public class CustomerService implements CustomerDao{

    @Autowired
    private CustomerDao customerDao;

    @Override
    public void insertCustomer(Customer customer){
        customerDao.insertCustomer(customer);
    }

    @Override
    public void delete(int id){ customerDao.delete(id);}


    @Override
    public void update(Customer customer){
        customerDao.update(customer);
    }

    @Override
    public Customer get(int id){
       return customerDao.get(id);
    }

    @Override
    public boolean isExist(String name ){
        Customer customer=customerDao.get(name);
        if(customer==null){
            return false;
        }
        return true;
    }


    @Override
    public List<Customer> selectCustomer(Customer customer) {
        return customerDao.selectCustomer(customer);
    }


    public Customer get(String name){
        return customerDao.get(name);
    }
}
