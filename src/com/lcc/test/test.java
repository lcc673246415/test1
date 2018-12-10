package com.lcc.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import com.lcc.bean.Customer;
import com.lcc.bean.Linkman;

public class test {

	
	@Test
	public void test1(){
		//加载主配置文件
			Configuration configure = new Configuration().configure();
			SessionFactory sessionFactory = configure.buildSessionFactory();
			Session session = sessionFactory.openSession();
			Transaction beginTransaction = session.beginTransaction();
			Customer customer1 = new Customer();
			Customer customer2 = new Customer();
			customer1.setCust_name("客户1");
			customer2.setCust_name("客户2");
			
			Linkman linkman1 = new Linkman();
			Linkman linkman2 = new Linkman();
			Linkman linkman3= new Linkman();
			linkman1.setLkm_name("联系人1");
			linkman2.setLkm_name("联系人2");
			linkman3.setLkm_name("联系人3");
			
			linkman1.setCustomer(customer1);
			linkman2.setCustomer(customer1);
			linkman3.setCustomer(customer2);
			customer1.getLinkmans().add(linkman1);
			customer1.getLinkmans().add(linkman2);
			customer2.getLinkmans().add(linkman3);
			session.save(customer1);
			session.save(customer2);
		
			
			
			
			
			beginTransaction.commit();
			session.close();
			sessionFactory.close();
	}
	
	
}
