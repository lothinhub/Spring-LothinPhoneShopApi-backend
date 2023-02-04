package com.lothin.phoneshp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.time.LocalDate;
import java.util.List;
import com.lothin.phoneshp.model.SaleDetail;
import com.lothin.phoneshp.projections.SaleByDate;

public interface SaleDetailRepository extends JpaRepository<SaleDetail, Long> {

    @Query(value = "select date(sold_date) soldDate,product_id productId,p.name productName,sum(sd.unit) totalUnit, sum(p.sale_price * sd.unit) amount\r\n"
        + "from sales s inner join sale_details sd on s.id = sd.sale_id\r\n"
        + "inner join products p on p.id = sd.product_id\r\n"
        + "where date(sold_date) = :soldDate\r\n"
        + "group by date(sold_date), product_id, p.name",nativeQuery=true)
    List<SaleByDate> findByProduct(@Param("soldeDate") LocalDate soldDate);

    // @Query(value = "select date(sold_date) soldDate,product_id productId,p.name productName,sum(sd.unit) totalUnit, sum(p.sale_price * sd.unit) amount\r\n"
	// 		+ "from sales s inner join sale_details sd on s.id = sd.sale_id\r\n"
	// 		+ "inner join products p on p.id = sd.product_id\r\n"
	// 		+ "where date(sold_date) = :soldDate\r\n"
	// 		+ "group by date(sold_date), product_id, p.name", nativeQuery = true)
	// List<SaleByDate> findByProduct(@Param("soldDate") LocalDate soldDate);

}
