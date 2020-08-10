package com.sm.api;

import java.math.BigDecimal;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.sm.model.Employer;
import com.sm.model.NationalityE;
import com.sm.model.QEmployer;
import com.sm.persistence.AddressRepository;
import com.sm.persistence.EmployerRepository;

@RestController
@RequestMapping("api/employer")
public class EmployerController {

	@Autowired
	private EmployerRepository employerRepository;

	@Autowired
	private AddressRepository addressRepository;

	
	/**
	 * Add Employer
	 * 
	 * @param employer
	 */
	@PostMapping
	public void insert(@RequestBody Employer employer) {
		if(employer.getAddress() != null) {
			addressRepository.insert(employer.getAddress());
		}
		this.employerRepository.insert(employer);
	}

	/**
	 * Update Employer
	 * 
	 * @param employer
	 */
	@PutMapping
	public void update(@RequestBody Employer employer) {
		if(employer.getAddress() != null) {
			addressRepository.save(employer.getAddress());
		}
		this.employerRepository.save(employer);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable String id) {
		this.employerRepository.deleteById(id);
	}

	/**
	 * find All employer and sory by email
	 * 
	 * @return
	 */
	@GetMapping("/all")
	public Collection<Employer> all() {
		Sort sortByThemeAsc = Sort.by("email").ascending();
		Collection<Employer> Employers = this.employerRepository.findAll(sortByThemeAsc);
		return Employers;
	}

	/**
	 * find by employer id
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping("/{id}")
	public Employer byId(@PathVariable String id) {
		return this.employerRepository.findById(id).orElse(null);
	}

	/**
	 * find by email address
	 * 
	 * @param data
	 * @return
	 */
	@GetMapping("/email/{data}")
	public Collection<Employer> getEmployerbyEmail(@PathVariable String data) {
		Sort sort = Sort.by("email").ascending();
		return this.employerRepository.findAllByEmailContains(data, sort);
	}

	/**
	 * Mongo DB Query , Spring Data Mongo Query
	 * 
	 * @return
	 */
	@GetMapping("/nationality")
	public Collection<Employer> multipleQueries() {
		// Mongo Query
		this.employerRepository.getAllByNationality(NationalityE.PAKISTAN);
		
		// Mongo Query on collection field
		this.employerRepository.getAllPaymentHistoryAmountLessThanSpecifiedAmount();
		
		// Mongo Query on object
		this.employerRepository.getAllMonthlyPayrollTotalAmount();
		
		// mongo Query on DBRef and query will be done by only id of DBRef
		this.employerRepository.getAllByAddressId("5f15549894643a6f00de4627");
		
		// Spring Data Mongo Query
		return this.employerRepository.findAllByNationality(NationalityE.PAKISTAN);
	}
	
	/**
	 * Using Query DSL on embedded and many java collection document
	 * @return
	 */
    @GetMapping("/amount")
    public Collection<Employer> bestBuys(){
        // build query
        QEmployer query = new QEmployer("query");
        
        // Embedded document 
        BooleanExpression totalAmountFilter =  query.monthlyPayroll.totalAmount.gt(50);
        
        // collection query
        Predicate paymentAmountFilter =  query.paymentTransactionHistory.any().paymentAmount.eq(BigDecimal.valueOf(10));

        Predicate predicateQuery = totalAmountFilter.and(paymentAmountFilter);

        // pass the query to findAll()
        return (Collection<Employer>) this.employerRepository.findAll(predicateQuery);
    }


}
