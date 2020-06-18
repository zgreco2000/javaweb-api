package ar.com.educacionit.dao.hibernate.impl;

import java.util.Optional;

import org.hibernate.Session;
import org.hibernate.query.Query;

import ar.com.educacionit.app.domain.User;
import ar.com.educacionit.dao.exceptions.GenericException;
import ar.com.educacionit.dao.hibernate.HibernateBaseRepository;
import ar.com.educacionit.dao.user.UserRepository;

public class UserHibernateRepositoryImpl extends HibernateBaseRepository implements UserRepository {

	public UserHibernateRepositoryImpl() {
		super();
	}
	
	@Override
	public User getUser(String userName) throws GenericException{
		User User = null;
		
		Session session= super.factory.getCurrentSession();
		
		try {
			
			session.getTransaction().begin();
			
			String sql = "Select e from " + User.class.getName() + " e where e.username=:username ";
			
			Query<User> query = session.createQuery(sql);
			
			query.setParameter("username", userName);
			
			Optional<User> employees = query.uniqueResultOptional();
			
			if (employees.isPresent()) {
				
				User = employees.get();
			}
			session.getTransaction().commit();
			
		}catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
			throw new GenericException(e.getMessage(),e);
		}
		return User;
}
}