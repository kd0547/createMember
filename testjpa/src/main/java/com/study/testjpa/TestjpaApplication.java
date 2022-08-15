package com.study.testjpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.study.testjpa.Member.Member;
import com.study.testjpa.team.Team;



@SpringBootApplication
public class TestjpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestjpaApplication.class, args);
		
		//[엔티티 매니저 팩토리] - 생성
				EntityManagerFactory emf = 
						//persistence.xml 설정 정보 조회
						Persistence.createEntityManagerFactory("JPAstudy");
				
				//[엔티티 메니저] - 생성
				EntityManager em = emf.createEntityManager();
				
				//[트랜잭션] 획득 
				EntityTransaction tx = em.getTransaction();
				
				try {
					tx.begin(); //[트랜잭션] - 시작
					
					queryLogicJoin(em);//비지니스 로직;
					//System.out.println("TEST");
					tx.commit(); //[트랜잭션] - commit
					
					
				} catch(Exception e) {
					
					
					e.printStackTrace();
					tx.rollback();
					
				} finally {
					em.close();
				}
				emf.close();
	}
	public static void logic(EntityManager em) {
		
		Member member = em.find(Member.class, "member1");
		
		Team team = member.getTeam();
		
		System.out.println("팀 이름 = "+team.getName());
	}
	private static void queryLogicJoin(EntityManager em) {
		String jpql = "select m from Member m join m.team t where t.name= :teamName";
		
		List<Member> Resultlist = em.createQuery(jpql,Member.class)
				.setParameter("teamName", "팀1")
				.getResultList();
		
		for(Member member :Resultlist) {
			System.out.println("[query] member.username= "+member.getUser_name());
		}
		
	}
}
