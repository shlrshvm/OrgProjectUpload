package com.OrganizationSystem.repository;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.OrganizationSystem.entity.Country;
import com.OrganizationSystem.entity.Employee;

@Repository
public class MainDao {
	@Autowired
	SessionFactory factory;
	
	public String addCountry(Country c) {
		Session session= null;
		Transaction tx= null;
		String msg= null;
		try {
		session= factory.openSession();
		tx= session.beginTransaction();
		
		session.persist(c);
		tx.commit();
		msg= "Country is added..";
		}catch(Exception e) {
			
			if(tx!= null) {
				tx.rollback();
			}
			e.printStackTrace();
			
		}finally {
			
			if(session!= null) {
				session.close();
			}
		}
		return msg;
	}

	public String updateCountry(int id, Country c) {
		Session session= null;
		Transaction tx= null;
		String msg= null;
		
		try {
			session= factory.openSession();
			tx= session.beginTransaction();
			
			Country country = session.get(Country.class,id);
			country.setCname(c.getCname());
			session.merge(country);
			tx.commit();
			msg= "Country is updated..";
		}catch(Exception e) {
			if(tx!= null) {
				tx.rollback();
			}
			e.printStackTrace();
		}
		finally {
			if(session!= null) {
				session.close();
			}
		}
		return msg;
	}

	public String deleteCountry(int id) {
		Session session= null;
		Transaction tx= null;
		String msg= null;
		try {
			session= factory.openSession();
			tx= session.beginTransaction();
			
			Country country= session.get(Country.class, id);
			session.remove(country);
			tx.commit();
			msg= "Country is deleted";
		}catch(Exception e) {
			if(tx!= null) {
				tx.rollback();
			}
			e.printStackTrace();
		}finally {
			if(session!=null) {
				session.close();
			}
		}
		return msg;
	}

	public Country getParticularCountry(int id) {
		Session session= null;
		Transaction tx= null;
		Country country= null;
	
		try {
			session= factory.openSession();
			tx= session.beginTransaction();
			
			country= session.get(Country.class, id);
			country.getCid();
			country.getCname();
			tx.commit();
			
			
		}catch(Exception e) {
			if(tx!= null) {
				tx.rollback();
			}
			e.printStackTrace();
		}finally {
			if(session!= null) {
				session.close();
			}
		}
		return country;
	}
	public List<Country> getAllRecord() {
		Session session= null;
		Transaction tx= null;
		List<Country> list= null;
		try {
			session= factory.openSession();
			tx= session.beginTransaction();
			String hqlQuery="from Country";
			Query<Country> query= session.createQuery(hqlQuery);
			
			list= query.list();
			tx.commit();
			
		}catch(Exception e) {
			if(tx!= null) {
				tx.rollback();
			}
			e.printStackTrace();
		}finally {
			if(session!= null) {
				session.close();
			}
		}
		return list;
	}
	public String addEmployee(Employee emp) {
		Session session= null;
		Transaction tx= null;
		String msg= null;
		try {
			session= factory.openSession();
			tx= session.beginTransaction();
			session.persist(emp);
			tx.commit();
			msg= "Employee Added Successfully";
		}catch(Exception e) {
			if(tx!= null) {
				tx.rollback();
			}
			e.printStackTrace();
		}finally {
			if(session!= null) {
				session.close();
			}
		}
		return msg;
	}

	public String updateEmployee(Employee emp) {
		Session session= null;
		Transaction tx= null;
		String msg= null;
		try {
			session= factory.openSession();
			tx= session.beginTransaction();
			Employee employee= session.get(Employee.class, emp.getId());
			employee.setName(emp.getName());
			employee.setCountry(emp.getCountry());
			employee.setCreatedby(emp.getCreatedby());
			employee.setCreateddtm(emp.getCreateddtm());
			employee.setDepartment(emp.getDepartment());
			employee.setEmailid(emp.getEmailid());
			employee.setPhoneno(emp.getPhoneno());
			employee.setSalary(emp.getSalary());
			employee.setStatus(emp.getStatus());
			employee.setUpdatedby(emp.getUpdatedby());
			employee.setUpdateddtm(emp.getUpdateddtm());
			
			session.merge(employee);
			tx.commit();
			msg="Employee updated successfully";
			
		}catch(Exception e) {
			if(tx!= null) {
				tx.rollback();
			}
			e.printStackTrace();
		}finally {
			if(session!= null) {
				session.close();
			}
		}
		return msg;
	}

	public String deleteEmployee(int id) {
		Session session= null;
		Transaction tx= null;
		String msg= null;
		try {
			session= factory.openSession();
			tx= session.beginTransaction();
			Employee employee= session.get(Employee.class, id);
			session.remove(employee);
			msg= "Employee deleted Successfully";
		}
		catch(Exception e) {
			if(tx!=null) {
				tx.rollback();
			}
			e.printStackTrace();
		}finally {
			if(session!= null) {
				session.close();
			}
		}
		return msg;
		
	}

	public List<Employee> getAllEmp() {
		Session session= null;
		Transaction tx= null;
		List<Employee> list= null;
		String hqlQuery= "from Employee";
		try {
			session= factory.openSession();
			tx= session.beginTransaction();
			Query<Employee> query= session.createQuery(hqlQuery, Employee.class);
			list= query.list();
			tx.commit();
			
		}catch(Exception e) {
			if(tx!=null) {
				tx.rollback();
			}
			e.printStackTrace();
			
		}finally {
			if(session!=null) {
				session.close();
			}
			
		}
		return list;
	}

	public Employee getAllEmpbyId(int id) {
		Session session= null;
		Transaction tx= null;
		Employee emp= null;
		try {
			session= factory.openSession();
			tx= session.beginTransaction();
			emp= session.get(Employee.class, id);
			tx.commit();
			
		}catch(Exception e) {
			if(tx!=null) {
				tx.rollback();
			}
			e.printStackTrace();
			
		}finally {
			if(session!=null) {
				session.close();
			}
		}
		return emp;	
		}

	public Employee login(Employee emp) {
		Session session= null;
		Transaction tx= null;
		Employee employee= null;
		
		String hqlQuery= "from Employee where emailid=:myemailid and phoneno=:phoneno";
		try {
			session= factory.openSession();
			tx= session.beginTransaction();
			Query<Employee> query= session.createQuery(hqlQuery, Employee.class);
			query.setParameter("myemailid", emp.getEmailid());
			query.setParameter("phoneno", emp.getPhoneno());
			employee= query.uniqueResult();
			tx.commit();
			
		}catch(Exception e) {
			if(tx!=null) {
				tx.rollback();
			}
			e.printStackTrace();
			
		}finally {
			if(session!=null) {
				session.close();
			}
		}
		return employee;
	}

	public List<Employee> getEmpbyStatus(String status) {
		Session session= null;
		Transaction tx= null;
		List<Employee> list= null;
		String hqlQuery= "from Employee where status=:status";
		try {
			session= factory.openSession();
			tx= session.beginTransaction();
			Query<Employee> query= session.createQuery(hqlQuery, Employee.class);
			
			query.setParameter("status", status);
			list= query.list();
			tx.commit();
			
		}catch(Exception e) {
			if(tx!=null) {
				tx.rollback();
			}
			e.printStackTrace();
			
		}finally {
			if(session!=null) {
				session.close();
			}
		}
		return list;
	}
	

}
