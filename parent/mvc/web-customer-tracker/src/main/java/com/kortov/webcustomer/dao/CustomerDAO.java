package com.kortov.webcustomer.dao;

import com.kortov.webcustomer.entity.Customer;

import java.util.List;

public interface CustomerDAO {
    List<Customer> getAll();
}