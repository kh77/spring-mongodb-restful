package com.sm.persistence;

import static org.springframework.data.mongodb.core.aggregation.Aggregation.newAggregation;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.project;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.ProjectionOperation;
import org.springframework.stereotype.Service;

import com.sm.model.CompanyPaymentHistoryDTO;
import com.sm.model.Employer;

@Service
public class ReportService {

	@Autowired
	private MongoTemplate mongoTemplate;

	/**
	 * Used Projection strategy to query
	 * 
	 * @return
	 */
	public List<CompanyPaymentHistoryDTO> getAvgRatingReport() {
		ProjectionOperation projectToMatchModel = project().andExpression("companyName").as("name")
				.andExpression("monthlyPayroll.totalAmount").as("avgAmount");

		Aggregation aggregation = newAggregation(Employer.class, projectToMatchModel);

		return this.mongoTemplate.aggregate(aggregation, Employer.class, CompanyPaymentHistoryDTO.class)
				.getMappedResults();
	}
}
