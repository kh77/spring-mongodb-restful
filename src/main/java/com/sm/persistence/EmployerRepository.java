package com.sm.persistence;

import java.util.Collection;

import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.query.TextCriteria;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

import com.sm.model.Employer;
import com.sm.model.NationalityE;

@Repository
public interface EmployerRepository extends MongoRepository<Employer, String>, QuerydslPredicateExecutor<Employer> {
	Collection<Employer> findAllByEmailContains(String email, Sort sort);

	Collection<Employer> findAllByNationality(NationalityE nationality);

	Collection<Employer> findAllBy(TextCriteria textCriteria);

	/**
	 * Mongo Style Query
	 * 
	 * @param nationality
	 * @return
	 */
	@Query("{'nationality' : {$eq : ?0}}")
	Collection<Employer> getAllByNationality(NationalityE nationality);

	/**
	 * Mongo Style Query
	 * 
	 * @return
	 */
	@Query("{'paymentTransactionHistory.paymentAmount' : {$lt : '5000'}}")
	Collection<Employer> getAllPaymentHistoryAmountLessThanSpecifiedAmount();
	
	
	/**
	 * Mongo Style Query
	 * 
	 * @return
	 */
	@Query("{'monthlyPayroll.totalAmount' : {$lt : '5000'}}")
	Collection<Employer> getAllMonthlyPayrollTotalAmount();


	/**
	 * Mongo Style Query
	 * 
	 * @return
	 */
	@Query("{ 'address.id' : ?0 }")
	Collection<Employer> getAllByAddressId(String id);
}
