package dev.lcastrooliveira.datamanipulation.controlllers;

import dev.lcastrooliveira.datamanipulation.model.events.EventWrapper;
import dev.lcastrooliveira.datamanipulation.model.events.Events;
import dev.lcastrooliveira.datamanipulation.model.timeline.Purchase;
import dev.lcastrooliveira.datamanipulation.model.timeline.PurchaseWrapper;
import dev.lcastrooliveira.datamanipulation.services.EventsOrganizerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/timeline")
public class EventsOrganizerController {

    private final EventsOrganizerService eventsOrganizerService;

    @Autowired
    public EventsOrganizerController(EventsOrganizerService eventsOrganizerService) {
        this.eventsOrganizerService = eventsOrganizerService;
    }

    @PostMapping
    ResponseEntity<PurchaseWrapper> organizeTimeline(@RequestBody EventWrapper allEvents) {
        final PurchaseWrapper purchaseWrapper = eventsOrganizerService.organizeEvents(allEvents);
        return ResponseEntity.ok(purchaseWrapper);
    }



}
