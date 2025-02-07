package lk.ijse.gdse72;

import config.FactoryConfiguration;
import entity.Customer;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Customer customer = new Customer(3,"Lithira","ll@gmail.com","0772696876");

        //saveCustomer(customer);
        //Customer customerById = getCustomerById(3);
        //System.out.println(customerById);
//        deleteCustomerById(1);
//        updateCustomer(3, new Customer(3,"Lithira","lithira@gmail.com","0772696876"));
        List<Customer> allCustomers = new Main().getAllCustomers();
        for (Customer allCustomer : allCustomers) {
            System.out.println(allCustomer);
        }

    }
       public static  boolean saveCustomer(Customer customer) {
           Session session = FactoryConfiguration.getInstance().getSession();
           try {
               Transaction transaction = session.beginTransaction();
               session.save(customer);
               transaction.commit();
               System.out.println("Customer Saved");
               return true;
           } catch (Exception e) {
               System.out.println("Customer Not Saved");
               e.printStackTrace();
                return false;

           }finally {
                session.close();
           }


       }

       public static Customer getCustomerById(int id){
           Session session = FactoryConfiguration.getInstance().getSession();
           Customer customer = session.get(Customer.class, id);
           session.close();
              return customer;
       }

       public static boolean deleteCustomerById(int id){
              Session session = FactoryConfiguration.getInstance().getSession();
              try {
                Transaction transaction = session.beginTransaction();
                Customer customer = session.get(Customer.class, id);
                session.delete(customer);
                transaction.commit();
                System.out.println("Customer Deleted");
                return true;
              } catch (Exception e) {
                System.out.println("Customer Not Deleted");
                e.printStackTrace();
                return false;
              }finally {
                session.close();
              }

       }
       public static boolean updateCustomer(int id, Customer newCustomer){
           Session session = FactoryConfiguration.getInstance().getSession();
           try {
               Customer customer = session.get(Customer.class, id);
               Transaction transaction = session.beginTransaction();
               customer.setName(newCustomer.getName());
                customer.setEmail(newCustomer.getEmail());
                customer.setContact(newCustomer.getContact());
                transaction.commit();
               return true;
           } catch (Exception e) {
               System.out.println("Customer Not Updated");
               e.printStackTrace();
               return false;
           }finally {
               session.close();
           }
       }
//xml to property
       public List<Customer> getAllCustomers(){
           Session session = FactoryConfiguration.getInstance().getSession();
           List<Customer> customers = (ArrayList<Customer>) session.createQuery("from entity.Customer").list();
           session.close();
           return customers;
       }
}