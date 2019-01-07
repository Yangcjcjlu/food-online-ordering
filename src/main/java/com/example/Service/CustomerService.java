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
@Service(value = "CustomerDao")
public class CustomerService implements CustomerDao{

    @Autowired
    private CustomerDao customerDao;

    public void insertCustomer(Customer customer){
        customerDao.insertCustomer(customer);
    }

    @Override
    public List<Customer> selectCustomer(Customer customer) {
        return customerDao.selectCustomer(customer);
    }

}
