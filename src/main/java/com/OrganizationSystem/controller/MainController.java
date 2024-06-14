package com.OrganizationSystem.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.OrganizationSystem.entity.Country;
import com.OrganizationSystem.entity.Employee;
import com.OrganizationSystem.service.MainService;

@CrossOrigin
@RestController
@RequestMapping("api")
public class MainController {
	@Autowired
	MainService service;
	@PostMapping("addcountry")
	public String addCountry(@RequestBody Country c) {
		//System.out.println(c);
		
		String msg= service.addCountry(c);
		return msg;
	}
	@PutMapping("updatecountry/{id}")
	public String updateCountry(@PathVariable int id, @RequestBody Country c) {
		
		String msg= service.updateCountry(id, c);
		return msg;
	}
	@DeleteMapping("deletecountry/{id}")
	public String deleteCountry(@PathVariable int id) {
		String msg= service.deleteCountry(id);
		return msg;
	}
	@GetMapping("getparticularrecord/{id}")
	public Country getParticularcountry(@PathVariable int id) {
		Country country= service.getParticularCountry(id);
		return country;
	}
	@GetMapping("getallrecord")
	public List<Country> getAllRecord() {
		List<Country> list= service.getAllRecord();
		return list;
	}
	@PostMapping("addemp")
	public String addEmployee(@RequestBody Employee emp) {
		String msg= service.addEmployee(emp);
		return msg;
	}
	@PutMapping("updateemp")
	public String updateEmployee(@RequestBody Employee emp ) {
		
		String msg= service.updateEmployee(emp);
		return msg;
	}
	@DeleteMapping("deleteemp/{id}")
	public String deleteEmployee (@PathVariable int id) {
		String msg= service.deleteEmployee(id);
		return msg;
	}
	@GetMapping("getallemp")
	public List<Employee> getAllEmp(){
	List<Employee> list= service.getAllEmp();
	return list;
	}
	@GetMapping("getallempbyid/{id}")
	public Employee getAllEmpbyId(@PathVariable int id){
		
		Employee emp= service.getAllEmpbyId(id);
		return emp;
		}
	@GetMapping("getempbystatus/{status}")
	public List<Employee> getEmpbyStatus(@PathVariable String status){
		List<Employee> list= service.getEmpbyStatus(status);
		return list;
	}
	@PostMapping("login")
	public HashMap login(@RequestBody Employee emp) {
		HashMap map= service.login(emp);
		return map;
	}

}
