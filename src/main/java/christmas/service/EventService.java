package christmas.service;

import christmas.domain.Discount;
import christmas.domain.Event_12_Calendar;
import christmas.domain.MenuList;

import java.util.*;
import java.util.function.BiFunction;

public class EventService {

    public List<Discount> getDiscounts(List<Event_12_Calendar> events, String day, Map<MenuList, Integer> menus) {
        List<Discount> discounts = new ArrayList<>();
        if (events.contains(Event_12_Calendar.CHRISTMAS_EVENT_DAYS)) {
            addDiscountIfNotNull(Discount.christmasFrom(day), discounts);
        }
        if (events.contains(Event_12_Calendar.WEEKDAYS)) {
            addDiscountsForMenus(day, menus, discounts, Discount::weekdaysOf);
        }
        if (events.contains(Event_12_Calendar.WEEKENDS)) {
            addDiscountsForMenus(day, menus, discounts, Discount::weekendsOf);
        }
        if (events.contains(Event_12_Calendar.STAR_DAYS)) {
            addDiscountIfNotNull(Discount.starFrom(day), discounts);
        }
        return discounts;
    }

    private void addDiscountIfNotNull(Discount discount, List<Discount> discounts) {
        if (discount != null) {
            discounts.add(discount);
        }
    }

    private void addDiscountsForMenus(String day, Map<MenuList, Integer> menus, List<Discount> discounts,
                                      BiFunction<String, MenuList, Discount> discountCreator) {
        for (Map.Entry<MenuList, Integer> entry : menus.entrySet()) {
            MenuList menu = entry.getKey();
            int quantity = entry.getValue();
            for (int i = 0; i < quantity; i++) {
                addDiscountIfNotNull(discountCreator.apply(day, menu), discounts);
            }
        }
    }
}
