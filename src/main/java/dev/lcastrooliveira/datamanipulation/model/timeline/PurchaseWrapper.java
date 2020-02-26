package dev.lcastrooliveira.datamanipulation.model.timeline;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PurchaseWrapper {
    private List<Purchase> timeline;
}
