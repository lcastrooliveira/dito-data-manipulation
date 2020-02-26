package dev.lcastrooliveira.datamanipulation.model.events;

import lombok.Data;

import java.util.List;

@Data
public class EventWrapper {
    private List<Events> events;
}
