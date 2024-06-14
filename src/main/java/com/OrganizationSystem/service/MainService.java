package com.OrganizationSystem.service;

import java.util.HashMap;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.OrganizationSystem.entity.Country;
import com.OrganizationSystem.entity.Employee;
import com.OrganizationSystem.repository.MainDao;

@Service
public class MainService {
	
	@Autowired
	MainDao dao;
	@PostMapping("addcountry")
	public String addCountry(Country c) {
		String msg= dao.addCountry(c);
		if(Objects.isNull(msg)) {
			msg="Country is not added";
		}
		return msg;
	}
	
	public String updateCountry(int id, Country c) {
		String msg= dao.updateCountry(id,c);
		return msg;
	}
	public String deleteCountry(int id) {
		String msg= dao.deleteCountry(id);
		return msg;
	}

	public Country getParticularCountry(int id) {
		Country country= dao.getParticularCountry(id);
		return country;
	}
	public List<Country> getAllRecord() {
		List<Country> list= dao.getAllRecord();
		return list;
	}
	public String addEmployee(Employee emp) {
		String msg= dao.addEmployee(emp);
		if(Objects.isNull(msg)) {
			msg="Record is not added";
		}
		return msg;
	}

	public String updateEmployee(Employee emp) {
		String msg= dao.updateEmployee(emp);
		if(Objects.isNull(emp)) {
			msg= "Record is not updated";
		}
		return msg;
	}

	public String deleteEmployee(int id) {
		String msg= dao.deleteEmployee(id);
		if(Objects.isNull(id)) {
			msg= "Record is not deleted";
		}
		return msg;
	}

	public List<Employee> getAllEmp() {
		List<Employee> list= dao.getAllEmp();
		if(Objects.isNull(list)) {
			list=null;
		}
		return list;
	}

	public Employee getAllEmpbyId(int id) {
		Employee emp= dao.getAllEmpbyId(id);
		if(Objects.isNull(emp)) {
			emp=null;
		}
		return emp;
	}

	public HashMap login(Employee emp) {
		Employee e= dao.login(emp);
		HashMap map= new HashMap();
		if(Objects.isNull(e)) {
			map.put("msg", "Invalid User");
			map.put("user", e);
		}else {
			map.put("msg", "Valid User");
			map.put("user", e);
		}
		return map;
		
		
	}

	public List<Employee> getEmpbyStatus(String status) {
		List<Employee> list= dao.getEmpbyStatus(status);
		if(Objects.isNull(list)) {
			list=null;
		}
		return list;
	}

	

}
