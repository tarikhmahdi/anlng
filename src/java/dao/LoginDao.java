/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.User;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import util.HibernateUtil;

/**
 *
 * @author B14
 */
public class LoginDao {
    public boolean login(User user) {
        try {
            SessionFactory factory = HibernateUtil.getSessionFactory();
            Session session = factory.openSession();
            session.beginTransaction();
            
            Query query = session.createQuery("SELECT u FROM User u WHERE u.name=:uname AND u.pass =:pass");
            query.setString("uname", user.getName());
            query.setString("pass", user.getPass());
            
            List<User> cList= query.list();
            cList.toString();
            session.getTransaction().commit();
            session.close();
            return true;
        } catch (Exception e) {
            //e.printStackTrace();
            return false;
        }
    }
}
