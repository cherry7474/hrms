package com.urssystems.hrms.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.urssystems.hrms.pojos.Session;
import com.urssystems.hrms.reposorities.SessionRepository;

@Service
@Transactional
public class SessionServiceImpl implements SessionService {
	
	@Autowired
	private SessionRepository sessionRepository;
	

	@Override
	public List<Session> getAllSessions() {
		List<Session> sessions = new ArrayList<>();
		//Iterator<Session> i = (sessionRepository.findAll()).iterator();
		Iterable<Session> it = sessionRepository.findAll();
		for(Session s:it)
		{
			sessions.add(s);
		}
		return sessions;
	}

}
