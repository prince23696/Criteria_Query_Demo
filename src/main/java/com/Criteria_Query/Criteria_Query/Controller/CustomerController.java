package com.Criteria_Query.Criteria_Query.Controller;

import com.Criteria_Query.Criteria_Query.Entity.Customer;
import com.Criteria_Query.Criteria_Query.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @PostMapping("/saveCustomer")
    public Customer addCustomer(@RequestBody Customer customer) {
        return customerService.addCustomer(customer);
    }

    @GetMapping("/getCustomers")
    public List<Customer> getCustomers() {
        return customerService.getCustomers();
    }

    @GetMapping("/getCustomer/{id}")
    public Customer getCustomer(@PathVariable int id) {
        return customerService.getCustomer(id);
    }

    @GetMapping("/getCustomerNotEqual/{id}")
    public List<Customer> getCustomerNotEqual(@PathVariable int id) {
        return customerService.getCustomerNotEqual(id);
    }

    @GetMapping("/getCustomerLessThan/{id}")
    public List<Customer> getCustomerLessThan(@PathVariable int id) {
        return customerService.getCustomerLessThan(id);
    }

    @GetMapping("/getCustomerGreaterThan/{id}")
    public List<Customer> getCustomerGreaterThan(@PathVariable int id) {
        return customerService.getCustomerGreaterThan(id);
    }

    @GetMapping("/getCustomerLessThanEqual/{id}")
    public List<Customer> getCustomerLessThanEqual(@PathVariable int id) {
        return customerService.getCustomerLessThanEqual(id);
    }

    @GetMapping("/getCustomerGreaterThanEqual/{id}")
    public List<Customer> getCustomerGreaterThanEqual(@PathVariable int id) {
        return customerService.getCustomerGreaterThanEqual(id);
    }

    @GetMapping("/getCustomerBetween/{id}/{id1}")
    public List<Customer> getCustomerBetween(@PathVariable int id, @PathVariable int id1) {
        return customerService.getCustomerBetween(id, id1);
    }

    @GetMapping("/getCustomerLike/{name}")
    public List<Customer> getCustomerLike(@PathVariable String name) {
        return customerService.getCustomerLike(name);
    }

    @GetMapping("/getCustomerNameAndAddress/{name}/{address}")
    public List<Customer> getCustomerNameAndAddress(@PathVariable String name, @PathVariable String address) {
        return customerService.getCustomerNameAndAddress(name, address);
    }

    @GetMapping("/getCustomerNameOrAddress/{name}/{address}")
    public List<Customer> getCustomerNameOrAddress(@PathVariable String name, @PathVariable String address) {
        return customerService.getCustomerNameOrAddress(name, address);
    }

    @PutMapping("/updateCustomer/{id}")
    public Customer updateCustomer(@PathVariable int id, @RequestBody Customer customer) {
        return customerService.updateCustomer(id, customer);
    }

    @DeleteMapping("/deleteCustomer/{id}")
    public String updateCustomer(@PathVariable int id) {
        return customerService.deleteCustomer(id);
    }

}
