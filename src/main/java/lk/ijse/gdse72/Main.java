package lk.ijse.gdse72;

import config.FactoryConfiguration;
import entity.Customer;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class Main {
    public static void main(String[] args) {
        Customer customer = new Customer(3,"Lithira","ll@gmail.com","0772696876");

        saveCustomer(customer);
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
}