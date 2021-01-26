package com.nathan.learn.jdo;


import com.nathan.learn.jdo.model.Inventory;
import com.nathan.learn.jdo.model.Product;

import javax.jdo.*;
import java.util.List;
import java.util.Properties;

public class App {
    public PersistenceManagerFactory getPF() {
        Properties properties = new Properties();
        properties.setProperty("javax.jdo.PersistenceManagerFactoryClass", "org.datanucleus.api.jdo.JDOPersistenceManagerFactory");
        properties.setProperty("datanucleus.schema.autoCreateAll", "true");
        properties.setProperty("javax.jdo.option.ConnectionDriverName", "com.mysql.jdbc.Driver");
        properties.setProperty("javax.jdo.option.ConnectionURL", "jdbc:mysql://localhost:3306/jdotest?useSSL=false");
        properties.setProperty("javax.jdo.option.ConnectionUserName", "root");
        properties.setProperty("javax.jdo.option.ConnectionPassword", "root");
        return JDOHelper.getPersistenceManagerFactory(properties);
    }

    public PersistenceManagerFactory getPFFromXML() {
        return JDOHelper.getPersistenceManagerFactory("Tutorial");
    }

    public void insert() {
        try (PersistenceManager pm = getPF().getPersistenceManager()) {
            Transaction tx = pm.currentTransaction();
            try {
                tx.begin();
                Inventory inv = new Inventory("My Inventory2");
                Product product = new Product("Sony Discman2", "A standard discman from Sony", 49.99);
                inv.getProducts().add(product);
                pm.makePersistent(inv);
                tx.commit();
            } finally {
                if (tx.isActive()) {
                    tx.rollback();
                }
            }
        }
    }

    public void select() {
        Query q = getPF().getPersistenceManager().newQuery(
                "SELECT FROM " + Inventory.class.getName());
        List<Inventory> inventories = (List<Inventory>) q.execute();
        for (Inventory p : inventories) {
            System.out.println(p);
        }
    }

    public static void main(String[] args) {
        App app = new App();
        app.select();
    }
}
