package org.bkr.services.repo;

import java.math.BigDecimal;
import java.util.List;

import org.bkr.models.DailyHeader;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReportRepository extends CrudRepository<DailyHeader, Long>{

	@Query("select distinct YEAR(d.date) from DailyHeader d")
	public List<Integer> allYear();
	
	@Query("select distinct MONTH(d.date) from DailyHeader d where YEAR(d.date)=?1")
	public List<DailyHeader> monthsByYear(int year);
	
	@Query("select "
			+ "new DailyHeader("
			+ "TIMESTAMP(CONCAT(YEAR(d.date) , '-' , MONTH(d.date) , '-' , 1)), "
			+ "SUM(d.total), "
			+ "SUM(d.expenses), "
			+ "SUM(d.grandTotal), "
			+ "SUM(d.remittance), "
			+ "SUM(d.difference), "
			+ "SUM(d.amExpenses), "
			+ "SUM(d.pmExpenses), "
			+ "SUM(d.amRemittance), "
			+ "SUM(d.pmRemittance) "
			+ ") "
			+ "from DailyHeader d "
			+ "where YEAR(d.date)=?1 "
			+ "GROUP BY TIMESTAMP(CONCAT(YEAR(d.date) , '-' , MONTH(d.date) , '-' , 1)) ")
	public List<DailyHeader> headerByYear(int year);
	
	
//	@Query("select "
//			+ "new DailyHeader("
//			+ "SUM(d.total), "
//			+ "SUM(d.expenses), "
//			+ "SUM(d.grandTotal), "
//			+ "SUM(d.remittance), "
//			+ "SUM(d.difference), "
//			+ "SUM(d.amExpenses), "
//			+ "SUM(d.pmExpenses), "
//			+ "SUM(d.amRemittance), "
//			+ "SUM(d.pmRemittance) "
//			+ ") "
//			+ "from DailyHeader d "
//			+ "where YEAR(d.date)=?1 and "
//			+ "MONTH(d.date)=?2")
//	public List<DailyHeader> m(int year, int month);
	
}
