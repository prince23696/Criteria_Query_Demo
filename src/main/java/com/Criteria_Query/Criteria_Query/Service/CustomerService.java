package com.Criteria_Query.Criteria_Query.Service;

import com.Criteria_Query.Criteria_Query.Entity.Customer;
import java.util.List;

public interface CustomerService {

    public Customer addCustomer(Customer customer);


    public List<Customer> getCustomers();

    public List<Customer> getCustomer(int id);

    public List<Customer> getCustomerNotEqual(int id);

    public List<Customer> getCustomerLessThan(int id);

    public List<Customer> getCustomerGreaterThan(int id);

    public List<Customer> getCustomerLessThanEqual(int id);

    public List<Customer> getCustomerGreaterThanEqual(int id);

    public List<Customer> getCustomerBetween(int id, int id1);

    public List<Customer> getCustomerLike(String name);

    public List<Customer> getCustomerNameAndAddress(String name, String address);

    public List<Customer> getCustomerNameOrAddress(String name, String address);


}
