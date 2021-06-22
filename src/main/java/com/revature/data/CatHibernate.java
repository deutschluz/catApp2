package com.revature.data;

import java.util.List;

import org.hibernate.Session;

import com.revature.beans.Cat;
import com.revature.utils.HibernateUtil;

public class CatHibernate implements GenericDAO<Cat> {
	@Override
	public Cat add(Cat t) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Cat getById(Integer id) {
		// get a sesh from sesh fact
		Session s= HibernateUtil.getSession();
		
		Cat c= s.get(Cat.class, id);
		s.close();
		return c;
	}

	@Override
	public List<Cat> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Cat t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Cat t) {
		// TODO Auto-generated method stub
		
	}
	
}
