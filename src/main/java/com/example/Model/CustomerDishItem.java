package com.example.Model;

import java.util.Date;

/**
 * Created by ThinkPad on 2019/4/29.
 */
public class CustomerDishItem {

    private int id;

    private int cid;

    private int did;

    private int mid;

    private int amount;

    private Merchant merchantVO;

    private Customer customerVO;

    private Dish dishVO;

    private Date createDate;

    private Date modifiedDate;

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public Merchant getMerchantVO() {
        return merchantVO;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public void setMerchantVO(Merchant merchantVO) {
        this.merchantVO = merchantVO;
    }

    public Customer getCustomerVO() {
        return customerVO;
    }

    public void setCustomerVO(Customer customerVO) {
        this.customerVO = customerVO;
    }

    public Dish getDishVO() {
        return dishVO;
    }

    public void setDishVO(Dish dishVO) {
        this.dishVO = dishVO;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public int getDid() {
        return did;
    }

    public void setDid(int did) {
        this.did = did;
    }

    public int getMid() {
        return mid;
    }

    public void setMid(int mid) {
        this.mid = mid;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
