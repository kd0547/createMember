package com.study.testjpa.team;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Team {
	@Id
	@Column(name="team_id")
	private String id;
	private String name;
	
	public Team() {
		
	}
	public Team(String id, String name) {
		this.id = id;
		this.name = name;
	}
}
