package com.urssystems.hrms.pojos;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="session")
public class Session implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id")
	private String id;
	
	@Column(name="session")
	private String session;

	public Session(){
		
	}
	
	public Session(String id, String session) {
		super();
		this.id = id;
		this.session = session;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSession() {
		return session;
	}

	public void setSession(String session) {
		this.session = session;
	}
	
	public String toString() {
		return "Session [" + getId() + ", "  + getSession() + "]";
	}
	
}
