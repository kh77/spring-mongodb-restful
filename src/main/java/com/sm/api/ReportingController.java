package com.sm.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sm.model.CompanyPaymentHistoryDTO;
import com.sm.persistence.ReportService;

@RestController
@RequestMapping("/api/reports")
public class ReportingController {
    
	@Autowired
	private ReportService reportService;

    
    @GetMapping
    public List<CompanyPaymentHistoryDTO> avgRatingReport(){
        return this.reportService.getAvgRatingReport();
    }
}
