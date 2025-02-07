package lk.ijse.gdse72;

import config.FactoryConfiguration;
import entity.Customer;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class Main {
    public static void main(String[] args) {
        Customer customer = new Customer(
                1,
                "Saman",
                "saman@gmail.com"
        );
        Session session = FactoryConfiguration.getInstance().getSession();

        Transaction transaction = session.beginTransaction();

        session.save(customer);

        transaction.commit();
        session.close();

    }
}