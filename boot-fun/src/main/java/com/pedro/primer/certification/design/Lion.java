package com.pedro.primer.certification.design;

public class Lion extends Animal {
	public boolean equals(Lion lion){
		boolean result = false;
		System.out.println("Lion");
		if (lion instanceof Lion){
			result = this.getId().equals(lion.getId());
		}
		return result;
	}

}
