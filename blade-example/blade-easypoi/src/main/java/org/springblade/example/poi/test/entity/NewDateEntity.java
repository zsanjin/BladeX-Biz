package org.springblade.example.poi.test.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Data;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;

/**
 * import java.time.Instant;
 * import java.time.LocalDate;
 * import java.time.LocalDateTime;
 * import java.time.ZoneId;
 *
 * @author by jueyue on 19-6-23.
 */
@Data
public class NewDateEntity {

	@Excel(name = "instant", format = "yyyy-MM-dd")
	private Instant instant;
	@Excel(name = "localdate", format = "yyyy-MM-dd")
	private LocalDate localDate;
	@Excel(name = "localdatetime", format = "yyyy-MM-dd")
	private LocalDateTime localDateTime;
	@Excel(name = "ZoneId", format = "yyyy-MM-dd")
	private ZoneId zoneId;
}
