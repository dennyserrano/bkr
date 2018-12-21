package org.bkr.web.rest;

import java.util.List;

import org.bkr.services.factories.DHeaderFactory;
import org.bkr.services.repo.ReportRepository;
import org.bkr.web.DHeader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reports")
public class ReportController {

	@Autowired
	private ReportRepository reportRepo;
	
	@RequestMapping("/year")
	public List<DHeader> byYear(@RequestParam("year") int year)
	{
		return DHeaderFactory.generateHead(reportRepo.headerByYear(year));
	}
	
	@RequestMapping("/allyear")
	public List<Integer> getAllYear()
	{
		return reportRepo.allYear();
	}
}
