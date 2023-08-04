package com.project2.repo;



import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
//import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project2.entity.Recipient;

@Repository
public class RecipientRepo {

	@Autowired
	Recipient r;
	
	Configuration cfg = new Configuration().configure().addAnnotatedClass(Recipient.class);
	SessionFactory sf = cfg.buildSessionFactory();

	public String sendAmount(int id, String name, int amt) {
		
		r.setId(id);
		r.setName(name);
		r.setAmount(amt);
		
        Session session = sf.openSession();
        Transaction tran = session.beginTransaction();
        session.save(r);
        tran.commit();
        session.close();
        
		return "Amount credited Succesfully";
	}

	public String deleteData(int id) {
		Session session = sf.openSession();
        Transaction tran = session.beginTransaction();
        Recipient find = session.find(Recipient.class, id);
        if(find!=null) {
        	session.remove(find);
        	tran.commit();
        	session.close();
        	return "Data with id " + id + " deleted succesfully";
        }
		return "Data with id " + id + " not found";
	}

	public String updateRecipient(int id, int amt) {
		Session session = sf.openSession();
        Transaction tran = session.beginTransaction();
        Recipient find = session.find(Recipient.class, id);
        if(find!=null) {
        	find.setAmount(find.getAmount()+amt);
        	session.merge(find);
        	tran.commit();
        	session.close();
        	return "Amount succesfully updated for id " + id;
        }
		
		return "Match not found for id " +  id;
	}

	public String fetchAll() {
//		Session session = sf.openSession();
//        Transaction tran = session.beginTransaction();
//        Query q = session.createQuery("from Recipient");
//        List list = q.list();
//        System.out.println(list.toString());
//		return list.toString();
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("vikas");
		EntityManager em = emf.createEntityManager();
		EntityTransaction trans = em.getTransaction();
		Query query = em.createQuery("from Recipient");
		List<Recipient> list = query.getResultList();
		
		for(Recipient r : list) {
			System.out.println(r);
		}
		
		return list.toString();
	}

}
