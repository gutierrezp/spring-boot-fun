package com.pedro.primer.multiplication.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.pedro.primer.multiplication.Multiplication;
import com.pedro.primer.multiplication.MultiplicationResultAttempt;
import com.pedro.primer.multiplication.User;
import com.pedro.primer.multiplication.repository.MultiplicationResultAttemptRepository;
import com.pedro.primer.multiplication.repository.UserRepository;

@Service
public class MultiplicationServiceImpl implements MultiplicationService{
	
	private RandomGeneratorService randomGeneratorService;
	private MultiplicationResultAttemptRepository attemptRepository;
	private UserRepository userRepository;	
	
	@Autowired
	public MultiplicationServiceImpl(RandomGeneratorService randomGeneratorService2,
			MultiplicationResultAttemptRepository attemptRepository, UserRepository userRepository) {
		this.randomGeneratorService = randomGeneratorService2;
		this.attemptRepository = attemptRepository;
		this.userRepository = userRepository;
	}

	@Override
	public Multiplication createRandomMultiplication() {
		int factorA = randomGeneratorService.generateRandomFactor();
		int factorB = randomGeneratorService.generateRandomFactor();
		return new Multiplication(factorA, factorB);
	}
	
	@Transactional
	@Override
	public boolean checkAttempt(final MultiplicationResultAttempt attempt) {
		// Check if the user already exists for that alias
		Optional<User> user = userRepository.findByAlias(attempt.getUser().getAlias());
		
		// Checks if it's correct
		boolean correct = attempt.getResultAttempt() ==
				attempt.getMultiplication().
				getFactorA() *
				attempt.getMultiplication().
				getFactorB();

		// Avoids 'hack' attempts
		Assert.isTrue(!attempt.isCorrect(), "You can't send an attempt marked as correct!!");

		// Creates a copy, now setting the 'correct' field accordingly
		MultiplicationResultAttempt checkedAttempt =
				new MultiplicationResultAttempt(attempt.getUser(),
						attempt.getMultiplication(),
						attempt.getResultAttempt(),
						correct);
		
		// Stores the attempt
		attemptRepository.save(checkedAttempt);
		
		// Returns the result
		return correct;		
	}
	
	@Override
	public List<MultiplicationResultAttempt> getStatsForUser(String userAlias) {
		return attemptRepository.findTop5ByUserAliasOrderByIdDesc(userAlias);
	}

}
