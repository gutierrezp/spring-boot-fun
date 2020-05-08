package com.pedro.primer.multiplication;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

/**
 * This class represents a Multiplication in our application.
 */
@RequiredArgsConstructor
@Getter
@ToString
@EqualsAndHashCode
@Entity
public final class Multiplication {

	// Both factors
	private final int factorA;
	private final int factorB;
	
	@Id
	@GeneratedValue
	@Column(name = "MULTIPLICATION_ID")
	private Long id;
	
	// Empty constructor for JSON (de)serialization
	public Multiplication() {
		this(0, 0);
	}

}
