package dev.lcastrooliveira.datamanipulation.model.timeline;

import lombok.Data;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.Set;

@Data
public class Purchase {
    private ZonedDateTime timestamp;
    private BigDecimal revenue;
    private String transactionId;
    private String storeName;
    private Set<Products> products;
}
