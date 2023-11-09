package christmas.domain;

import java.util.Arrays;
import java.util.List;

public enum Event_12_Calendar {

    CHRISTMAS_EVENT_DAYS("크리스마스 디데이",Arrays.asList("1","2","3","4","5","6","7","8","9","10","11",
            "12","13","14","15","16","17","18","19","2O","21","22","23","24","25")),
    WEEKDAYS("평일", Arrays.asList("4","5","6","7","11","12","13","14","18","19","20","21","25","26","27","28")),

    WEEKENDS("주말", Arrays.asList("1","2","8","9","15","16","22","23","29","30")),
    STAR_DAYS("별 데이", Arrays.asList("3","10","17","24","25","31"));

    private String title;
    private List<String> days;

    Event_12_Calendar(String title, List<String> days) {
        this.title = title;
        this.days = days;
    }

}
