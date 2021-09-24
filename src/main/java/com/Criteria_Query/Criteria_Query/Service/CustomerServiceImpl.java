package com.Criteria_Query.Criteria_Query.Service;

import com.Criteria_Query.Criteria_Query.Entity.Customer;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public Customer addCustomer(Customer customer) {
        entityManager.persist(customer);
        return customer;
    }

    @Transactional
    public List<Customer> getCustomers() {

        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Customer> cq = criteriaBuilder.createQuery(Customer.class);
        Root<Customer> customerRoot = cq.from(Customer.class);
        cq.orderBy(criteriaBuilder.desc(customerRoot.get("fname")));
        List<Customer> customers = entityManager.createQuery(cq).getResultList();
        return customers;
    }

    @Transactional
    public List<Customer> getCustomer(int id) {

        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Customer> criteriaQuery = criteriaBuilder.createQuery(Customer.class);
        Root<Customer> customerRoot = criteriaQuery.from(Customer.class);
        criteriaQuery.select(customerRoot);
        Predicate predicate = criteriaBuilder.equal(customerRoot.get("c_id"), id);
        criteriaQuery.where(predicate);
        TypedQuery<Customer> typedQuery = entityManager.createQuery(criteriaQuery);
        List<Customer> customerList = typedQuery.getResultList();
        return customerList;
    }

    @Transactional
    public List<Customer> getCustomerNotEqual(int id) {

        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Customer> criteriaQuery = criteriaBuilder.createQuery(Customer.class);
        Root<Customer> customerRoot = criteriaQuery.from(Customer.class);
        criteriaQuery.select(customerRoot);
        Predicate predicate = criteriaBuilder.notEqual(customerRoot.get("c_id"), id);
        criteriaQuery.where(predicate);
        TypedQuery<Customer> typedQuery = entityManager.createQuery(criteriaQuery);
        List<Customer> customerList = typedQuery.getResultList();
        return customerList;
    }

    @Transactional
    public List<Customer> getCustomerLessThan(int id) {

        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Customer> criteriaQuery = criteriaBuilder.createQuery(Customer.class);
        Root<Customer> customerRoot = criteriaQuery.from(Customer.class);
        criteriaQuery.select(customerRoot);
        Predicate lastPredicate = criteriaBuilder.lt(customerRoot.get("c_id"), id);
        criteriaQuery.where(lastPredicate);
        TypedQuery<Customer> typedQuery = entityManager.createQuery(criteriaQuery);
        List<Customer> customerList = typedQuery.getResultList();
        return customerList;
    }

    @Transactional
    public List<Customer> getCustomerGreaterThan(int id) {


        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Customer> criteriaQuery = criteriaBuilder.createQuery(Customer.class);
        Root<Customer> customerRoot = criteriaQuery.from(Customer.class);
        criteriaQuery.select(customerRoot);
        Predicate lastPredicate = criteriaBuilder.gt(customerRoot.get("c_id"), id);
        criteriaQuery.where(lastPredicate);
        TypedQuery<Customer> typedQuery = entityManager.createQuery(criteriaQuery);
        List<Customer> customerList = typedQuery.getResultList();
        return customerList;
    }

    @Transactional
    public List<Customer> getCustomerLessThanEqual(int id) {


        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Customer> criteriaQuery = criteriaBuilder.createQuery(Customer.class);
        Root<Customer> customerRoot = criteriaQuery.from(Customer.class);
        criteriaQuery.select(customerRoot);
        Predicate lastPredicate = criteriaBuilder.le(customerRoot.get("c_id"), id);
        criteriaQuery.where(lastPredicate);
        TypedQuery<Customer> typedQuery = entityManager.createQuery(criteriaQuery);
        List<Customer> customerList = typedQuery.getResultList();
        return customerList;
    }

    @Transactional
    public List<Customer> getCustomerGreaterThanEqual(int id) {


        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Customer> criteriaQuery = criteriaBuilder.createQuery(Customer.class);
        Root<Customer> customerRoot = criteriaQuery.from(Customer.class);
        criteriaQuery.select(customerRoot);
        Predicate lastPredicate = criteriaBuilder.ge(customerRoot.get("c_id"), id);
        criteriaQuery.where(lastPredicate);
        TypedQuery<Customer> typedQuery = entityManager.createQuery(criteriaQuery);
        List<Customer> customerList = typedQuery.getResultList();
        return customerList;
    }

    @Transactional
    public List<Customer> getCustomerBetween(int id, int id1) {

        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Customer> criteriaQuery = criteriaBuilder.createQuery(Customer.class);
        Root<Customer> customerRoot = criteriaQuery.from(Customer.class);
        criteriaQuery.select(customerRoot);
        Predicate lastPredicate = criteriaBuilder.between(customerRoot.get("c_id"), id, id1);
        criteriaQuery.where(lastPredicate);
        TypedQuery<Customer> typedQuery = entityManager.createQuery(criteriaQuery);
        List<Customer> customerList = typedQuery.getResultList();
        return customerList;
    }

    @Transactional
    public List<Customer> getCustomerLike(String name) {

        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Customer> criteriaQuery = criteriaBuilder.createQuery(Customer.class);
        Root<Customer> customerRoot = criteriaQuery.from(Customer.class);
        criteriaQuery.select(customerRoot);
        Predicate predicate = criteriaBuilder.like(customerRoot.get("fname"), "%a%");
        criteriaQuery.where(predicate);
        TypedQuery<Customer> typedQuery = entityManager.createQuery(criteriaQuery);
        List<Customer> customerList = typedQuery.getResultList();

        return customerList;
    }

    @Override
    public List<Customer> getCustomerNameAndAddress(String name, String address) {

        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Customer> criteriaQuery = criteriaBuilder.createQuery(Customer.class);
        Root<Customer> customerRoot = criteriaQuery.from(Customer.class);
        criteriaQuery.select(customerRoot);
        Predicate predicateName = criteriaBuilder.equal(customerRoot.get("fname"), name);
        Predicate predicateAddress = criteriaBuilder.equal(customerRoot.get("address"), address);
        Predicate nameAndAddressPredicate = criteriaBuilder.and(predicateName, predicateAddress);
        criteriaQuery.where(nameAndAddressPredicate);
        TypedQuery<Customer> typedQuery = entityManager.createQuery(criteriaQuery);
        List<Customer> customerList = typedQuery.getResultList();
        return customerList;

    }

    @Override
    public List<Customer> getCustomerNameOrAddress(String name, String address) {

        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Customer> criteriaQuery = criteriaBuilder.createQuery(Customer.class);
        Root<Customer> customerRoot = criteriaQuery.from(Customer.class);
        criteriaQuery.select(customerRoot);
        Predicate predicateName = criteriaBuilder.equal(customerRoot.get("fname"), name);
        Predicate predicateAddress = criteriaBuilder.equal(customerRoot.get("address"), address);
        Predicate nameAndAddressPredicate = criteriaBuilder.or(predicateName, predicateAddress);
        criteriaQuery.where(nameAndAddressPredicate);
        TypedQuery<Customer> typedQuery = entityManager.createQuery(criteriaQuery);
        List<Customer> customerList = typedQuery.getResultList();
        return customerList;
    }
}
