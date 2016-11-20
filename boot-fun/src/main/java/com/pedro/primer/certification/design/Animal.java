package com.pedro.primer.certification.design;

public abstract class Animal {
	private String id;
	private String name;
	private float weight;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getWeight() {
		return weight;
	}
	public void setWeight(float weight) {
		this.weight = weight;
	}
	
	@Override
	public boolean equals (Object obj){
		boolean result = false;
		System.out.println("Animal");
		if(obj instanceof Animal){
			result = this.getId().equals(((Animal)obj).getId());
		}
		return result;
	}

}
