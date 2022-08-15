package com.study.testjpa;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.intThat;

import java.util.HashSet;
import java.util.Iterator;

import org.junit.jupiter.api.Test;


import com.study.testjpa.createMember.MakeRandomMember;

class CreateMemberTest {
	
	@Test
	void test() {
		int count = 0;
		HashSet<String> set = new HashSet<String>();
		MakeRandomMember makeRandomMember = MakeRandomMember.getInstance();
		long beforeTime = System.currentTimeMillis();
		for(int i = 0; i < 1000000;i++) {
			set.add(makeRandomMember.createRandomString(10));
			
		}
		long afterTime = System.currentTimeMillis(); 
		
		System.out.println(set.size());
		/*
		Iterator<String> item = set.iterator();
		while(item.hasNext()) {
			System.out.println(item.next());
			
			if(count == 100) {
				return ;
			}
			count++;
		}
		*/
		long secDiffTime = (afterTime - beforeTime)/1000;
		
		System.out.println("시간차이(s) : "+secDiffTime);
	}
	
	
	
	
	/*
	 * 경과시간 - 55s 
	  @Test
	void test() {
		Member member = new Member();
		MakeRandomMember makeRandomMember = MakeRandomMember.getInstance();
		long beforeTime = System.currentTimeMillis();
		for(int i = 0; i < 1000000;i++) {
			member.setId(makeRandomMember.createRandomString(10));
			member.setUser_name(makeRandomMember.createRandomString(5));
			
			System.out.println(member.toString());
		}
		long afterTime = System.currentTimeMillis(); 
		
		long secDiffTime = (afterTime - beforeTime)/1000;
		
		System.out.println("시간차이(s) : "+secDiffTime);
	}
	 */
}
