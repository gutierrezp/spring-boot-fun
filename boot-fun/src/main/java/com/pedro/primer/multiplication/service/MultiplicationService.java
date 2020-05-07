package com.pedro.primer.multiplication.service;

import java.util.List;

import com.pedro.primer.multiplication.Multiplication;
import com.pedro.primer.multiplication.MultiplicationResultAttempt;

public interface MultiplicationService {
	/**
	 * Creates a Multiplication object with two randomly-generated
	factors
	 * between 11 and 99.
	 *
	 * @return a Multiplication object with random factors
	 */
	Multiplication createRandomMultiplication();
	
	/**
	* @return true if the attempt matches the result of the
	* multiplication, false otherwise.
	*/
	boolean checkAttempt(final MultiplicationResultAttempt resultAttempt);

	List<MultiplicationResultAttempt> getStatsForUser(String userAlias);

}
