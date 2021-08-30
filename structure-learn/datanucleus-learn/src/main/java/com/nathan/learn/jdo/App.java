package com.nathan.learn.jdo;


import com.nathan.learn.jdo.model.Book;
import com.nathan.learn.jdo.model.Inventory;
import com.nathan.learn.jdo.model.Product;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;
import javax.jdo.Transaction;
import java.util.List;
import java.util.Properties;

public class App {
    PersistenceManager pm = getPF().getPersistenceManager();

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
        Transaction tx = pm.currentTransaction();
        try {
            tx.begin();
            Inventory inv = new Inventory("My Inventory2");
            Product product = new Product("Sony Discman2", "A standard discman from Sony", 49.99);
            inv.getProducts().add(product);
            pm.makePersistent(product);
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (tx.isActive()) {
                tx.rollback();
            }
        }
    }

    public void insertBook() {
        Book book = new Book("test", "test", "test");
        pm.makePersistent(book);
        pm.flush();
        Query<Book> bookQuery = pm.newQuery(Book.class);
        List<Book> books = bookQuery.executeList();
        System.out.println(books);
    }

    public void select() {
        Query<Inventory> q = getPF().getPersistenceManager().newQuery(Inventory.class, "NAME == name");
        q.declareParameters("java.lang.String name");
        List<Inventory> inventories = (List<Inventory>) q.execute("Sony Discman2");
        for (Inventory p : inventories) {
            System.out.println(p);
        }
    }

    public static void main(String[] args) {
        App app = new App();
        app.insertBook();
    }
}
