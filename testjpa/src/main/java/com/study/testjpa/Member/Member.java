package com.study.testjpa.Member;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.study.testjpa.team.Team;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Entity
@Getter
@Setter
@ToString
@Table(name="member")
public class Member {
	
	@Id
	@Column(name="member_id")
	private String id;
	
	
	private String user_name;
	
	@ManyToOne
	@JoinColumn(name="team_id")
	private Team team;
	
	public Member() {
		
	}
	public Member(String id,String user_name) {
		this.id = id;
		this.user_name = user_name;
	}
	
}
