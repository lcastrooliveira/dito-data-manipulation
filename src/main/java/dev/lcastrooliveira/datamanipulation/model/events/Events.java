package dev.lcastrooliveira.datamanipulation.model.events;

import lombok.Data;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.Set;


@Data
public class Events {
    private String event;
    private BigDecimal revenue;
    private ZonedDateTime timestamp;
    private Set<CustomData> customData;
}
