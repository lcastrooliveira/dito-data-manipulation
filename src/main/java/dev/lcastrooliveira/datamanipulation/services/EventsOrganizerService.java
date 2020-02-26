package dev.lcastrooliveira.datamanipulation.services;

import dev.lcastrooliveira.datamanipulation.model.events.CustomData;
import dev.lcastrooliveira.datamanipulation.model.events.EventWrapper;
import dev.lcastrooliveira.datamanipulation.model.events.Events;
import dev.lcastrooliveira.datamanipulation.model.timeline.Products;
import dev.lcastrooliveira.datamanipulation.model.timeline.Purchase;
import dev.lcastrooliveira.datamanipulation.model.timeline.PurchaseWrapper;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class EventsOrganizerService {
    public PurchaseWrapper organizeEvents(EventWrapper allEvents) {
        final Map<String, List<Events>> eventsGroupedByTransaction = allEvents.getEvents()
                .stream()
                .collect(Collectors.groupingBy(event -> fromSetToMap(event.getCustomData()).getOrDefault("transaction_id", "non_provided")));
        final List<Purchase> purchases = eventsGroupedByTransaction.values()
                .stream()
                .map(this::convertEventsToPurchase)
                .sorted(Comparator.comparing(Purchase::getTimestamp).reversed())
                .collect(Collectors.toList());
        return new PurchaseWrapper(purchases);
    }

    private Purchase convertEventsToPurchase(List<Events> sameTransactionEvents) {
        final Purchase purchase = new Purchase();
        final Events purchaseEvent = sameTransactionEvents.stream()
                                     .filter(event -> event.getEvent().equals("comprou")).findFirst()
                                     .orElseThrow(RuntimeException::new);
        final Set<Events> productEvents = sameTransactionEvents.stream()
                                          .filter(event -> event.getEvent().equals("comprou-produto"))
                                          .collect(Collectors.toSet());
        purchase.setTimestamp(purchaseEvent.getTimestamp());
        purchase.setRevenue(purchaseEvent.getRevenue());

        final Map<String, String> customDataMap = fromSetToMap(purchaseEvent.getCustomData());
        purchase.setStoreName(customDataMap.get("store_name"));
        purchase.setTransactionId(customDataMap.get("transaction_id"));

        final Set<Products> organizedProducts = productEvents.stream().map(event -> {
            final Map<String, String> customProductMap = fromSetToMap(event.getCustomData());
            return new Products(customProductMap.get("product_name"), new BigDecimal(customProductMap.get("product_price")));
        }).collect(Collectors.toSet());
        purchase.setProducts(organizedProducts);
        return purchase;
    }

    private Map<String, String> fromSetToMap(Set<CustomData> customData) {
        return customData.stream()
                .collect(Collectors.toMap(CustomData::getKey, CustomData::getValue));
    }


}
