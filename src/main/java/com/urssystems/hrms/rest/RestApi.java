package com.urssystems.hrms.rest;



import java.util.List;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.urssystems.hrms.pojos.Employee;
import com.urssystems.hrms.pojos.Session;
import com.urssystems.hrms.services.EmployeeServiceImpl;
import com.urssystems.hrms.services.SessionServiceImpl;

@RestController
@RequestMapping("/rest")
public class RestApi {
	
	@Autowired
	private RedisTemplate<String, Object> redisTemplate;
	
	@Autowired
	private EmployeeServiceImpl employeeServiceImpl;
	
	@Autowired
	private SessionServiceImpl sessionServiceImpl;
	
	
	@RequestMapping("/test")
	public String test(){
		String s ="";
		try {	
			ValueOperations<String, Object> values = redisTemplate.opsForValue();
			values.set("joe", new Employee("02", "Joe", 20));
			
			System.out.println("Employee added: " + values.get("joe"));
			s = values.get("joe").toString();
		} finally {
			
		}
		
		return s;
	}
	
	@RequestMapping(value="/store", method=RequestMethod.POST,consumes = MediaType.APPLICATION_JSON)
	public String storeEmp(@RequestBody Employee emp){
		employeeServiceImpl.saveEmp(emp);
		redisCache(emp);
		return emp.toString();
	}

	@RequestMapping("/emp")
	@Produces(MediaType.APPLICATION_JSON)
	public Employee createEmployee(){
		Employee e = new Employee("1", "URS", 20);
		employeeServiceImpl.saveEmp(e);
		return e;
	}
	
	@RequestMapping("/sessions")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Session> getAllSessions(){
		
		List<Session> l = sessionServiceImpl.getAllSessions();
		redisSessionCache(l);
		return l;
	}
	
	public void redisSessionCache(List<Session> list){
		
		try {	
			for(Session s:list){
			ValueOperations<String, Object> values = redisTemplate.opsForValue();
			values.set(s.getId(),s);
			
			System.out.println("Session added: " + values.get(s.getId()));
			}
		} finally {
			
		}
	}
	
	
	
	public void redisCache(Employee e){
		
		try {	
			ValueOperations<String, Object> values = redisTemplate.opsForValue();
			values.set(e.getName(), e);
			
			System.out.println("Employee added: " + values.get(e.getName()));
			
		} finally {
			
		}
		
	}
	
}
