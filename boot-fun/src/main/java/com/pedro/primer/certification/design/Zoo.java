package com.pedro.primer.certification.design;

public class Zoo {
	public static void main (String...args){
		Animal a = new Lion();
		a.setId("LOLA");
		Lion l = new Lion();
		l.setId("LOLA");
		Simba s = new Simba();
		s.setId("LOLA");
		
		System.out.println(a.equals(l));
		System.out.println(l.equals(a));
		System.out.println(l.equals(l));
		System.out.println(l.equals(s));
	}

}
