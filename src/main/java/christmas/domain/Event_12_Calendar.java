package christmas.domain;

import christmas.constant.Constant;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum Event_12_Calendar {

    CHRISTMAS_EVENT_DAYS(Constant.CHRISTMAS_DISCOUNT, Arrays.asList("1","2","3","4","5","6","7","8","9","10","11",
            "12","13","14","15","16","17","18","19","2O","21","22","23","24","25")),
    WEEKDAYS(Constant.WEEKDAYS_DISCOUNT, Arrays.asList("3","4","5","6","7","10","11","12","13","14","17","18","19","20","21","24","25","26","27","28","31")),

    WEEKENDS(Constant.WEEKENDS_DISCOUNT, Arrays.asList("1","2","8","9","15","16","22","23","29","30")),
    STAR_DAYS(Constant.STAR_DAYS_DISCOUNT, Arrays.asList("3","10","17","24","25","31"));

    private String title;
    private List<String> days;

    public String getTitle() {
        return title;
    }

    Event_12_Calendar(String title, List<String> days) {
        this.title = title;
        this.days = days;
    }

    public static List<Event_12_Calendar> findEvent(String day){
        return Arrays.stream(Event_12_Calendar.values())
                .filter(event -> event.hasDay(day))
                .collect(Collectors.toList());
    }

    public boolean hasDay(String day){
        return days.contains(day);
    }

    public static boolean hasDayInChristMasEventDays(String day){
        return Arrays.stream(Event_12_Calendar.values())
                .anyMatch(d -> d==CHRISTMAS_EVENT_DAYS && d.hasDay(day));
    }

    public static boolean hasWeekdayInWeekdays(String day){
        return Arrays.stream(Event_12_Calendar.values())
                .anyMatch(d -> d==WEEKDAYS && d.hasDay(day));
    }

    public static boolean hasWeekendInWeekends(String day){
        return Arrays.stream(Event_12_Calendar.values())
                .anyMatch(d -> d==WEEKENDS && d.hasDay(day));
    }

    public static boolean hasStarDayInStarDays(String day){
        return Arrays.stream(Event_12_Calendar.values())
                .anyMatch(d -> d==STAR_DAYS && d.hasDay(day));
    }

}
