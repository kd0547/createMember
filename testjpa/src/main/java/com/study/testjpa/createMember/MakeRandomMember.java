package com.study.testjpa.createMember;

import java.util.Random;

public class MakeRandomMember {
	
	int leftLimit = 48; // numeral '0'
	int rightLimit = 122; // letter 'z'
	int defaultStringLength = 10;
	
	private static MakeRandomMember instance = new MakeRandomMember();
	

	Random random = new Random();
	
	private MakeRandomMember () {
		
	}
	public static MakeRandomMember getInstance() {
		return instance;
	}
	
	
	public String createRandomString(int length) {
		int StringLength = (length == 0) ? defaultStringLength : length;
		
		return random.ints(leftLimit,rightLimit + 1)
				  .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
				  .limit(StringLength)
				  .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
				  .toString();
	}
	
	
	
	
}
