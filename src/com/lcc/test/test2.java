package com.lcc.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import com.lcc.bean.Customer;
import com.lcc.bean.Linkman;
import com.lcc.bean.Role;
import com.lcc.bean.User;

public class test2 {

	@Test
	public void demo1(){
		//�����������ļ�
		Configuration configure = new Configuration().configure();
		SessionFactory sessionFactory = configure.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction beginTransaction = session.beginTransaction();
	
		//����2���û�
		User user1 = new User();
		User user2 = new User();
		user1.setUser_name("�û�1");
		user2.setUser_name("�û�2");
		
		//����3������
		Role role1 = new Role();
		Role role2 = new Role();
		Role role3 = new Role();
		role1.setRole_name("����1");
		role2.setRole_name("����2");
		role3.setRole_name("����3");
		user1.getRoles().add(role1);
		user1.getRoles().add(role2);
		user2.getRoles().add(role3);
		
		session.save(user1);
		session.save(user2);
		
		
		
		
		beginTransaction.commit();
		session.close();
		sessionFactory.close();
	}
	@Test
	public void demo2(){
		//�����������ļ�
		Configuration configure = new Configuration().configure();
		SessionFactory sessionFactory = configure.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction beginTransaction = session.beginTransaction();
		
		User user = session.get(User.class,1L);
		Role role = session.get(Role.class, 3L);
		user.getRoles().add(role);
		session.save(user);
		
		beginTransaction.commit();
		session.close();
		sessionFactory.close();
	}
	@Test
	public void demo3(){
		//�����������ļ�
		Configuration configure = new Configuration().configure();
		SessionFactory sessionFactory = configure.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction beginTransaction = session.beginTransaction();
		
		User user = session.get(User.class,1L);
		Role role = session.get(Role.class, 2L);
		user.getRoles().remove(role);
		session.save(user);
		
		beginTransaction.commit();
		session.close();
		sessionFactory.close();
	}
}
