package com.testClasses.springmvc.dao.impl;

import org.springframework.stereotype.Repository;

import com.testClasses.springmvc.entity.Client;



@Repository("claimDao") 
public class ClaimDaoImpl implements IClaimDao {

	
//	@Autowired 
//	private SessionFactory sessionFactory;
//	
//	private Session session;
//	
//	@Override
//	public Client getClientById(int id) {
//		session=sessionFactory.getCurrentSession();
//		Client person=(Client) session.createQuery("from Client p where p.policyPersonId=:id")
//		.setParameter("id", id).uniqueResult();
//		return person;
//	}


	public Client getClientById(int id) {
		return new Client(1000);
	}
	
	
}
