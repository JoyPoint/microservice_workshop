package com.metamagic.ms.repo.read;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.metamagic.ms.bean.Product;

@Repository
public class ProductReadRepository {

	@Autowired
	PersistenceManagerFactory pmf;

	private PersistenceManager pm() {
		return pmf.getPersistenceManager();
	}

	@SuppressWarnings("unchecked")
	public List<Product> findAll() {
		
		List<Product> working_greeting = null;
		PersistenceManager pm = pm();
		try
		{
		    Query query = pm.newQuery(Product.class);
			List<Product> list = (List<Product>) query.execute();
			working_greeting = (List<Product> )pm.detachCopyAll(list);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
		}
		
		return working_greeting;
	}	
	
	
}