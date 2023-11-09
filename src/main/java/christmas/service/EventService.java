package christmas.service;

import christmas.domain.Discount;
import christmas.domain.Event_12_Calendar;
import christmas.domain.MenuList;

import java.util.*;

public class EventService {

    public List<Discount> getDiscounts(List<Event_12_Calendar> events, String day, Map<MenuList, Integer> menus){
        List<Discount> discounts = new ArrayList<>();

        if(events.contains(Event_12_Calendar.CHRISTMAS_EVENT_DAYS)){
            Discount christmasDiscount = Discount.createChristmasDiscount(day);
            System.out.println(christmasDiscount.toString());
            discounts.add(christmasDiscount);
        }

        if(events.contains(Event_12_Calendar.WEEKDAYS)){
            Set<MenuList> menuLists = menus.keySet();
            for(MenuList m : menuLists){
                for(int i=0; i<menus.get(m); i++){
                    Discount weekdaysDiscount = Discount.createWeekdaysDiscount(day, m);
                    if(weekdaysDiscount != null){
                        System.out.println(weekdaysDiscount.toString());
                        discounts.add(weekdaysDiscount);
                    }
                }
            }
        }
        return null;
    }
}
