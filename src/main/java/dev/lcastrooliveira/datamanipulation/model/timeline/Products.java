package dev.lcastrooliveira.datamanipulation.model.timeline;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Products {
    private String name;
    private BigDecimal price;
}
