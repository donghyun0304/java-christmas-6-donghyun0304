package christmas.domain;

import christmas.constant.Constant;

public class Discount {

    public static final int WEEKDAYS_DISCOUNT_PRICE = 2023;

    private String discountTitle;
    private int discountPrice;

    private Discount(String discountTitle, int discountPrice) {
        this.discountTitle = discountTitle;
        this.discountPrice = discountPrice;
    }

    public static Discount createChristmasDiscount(String day){
        if(Event_12_Calendar.hasDayInChristMasEventDays(day)){
            return new Discount(Event_12_Calendar.CHRISTMAS_EVENT_DAYS.getTitle(), (Integer.parseInt(day) - 1) * 100 + 1000);
        }
        throw new IllegalArgumentException("크리스마스 디데이 할인이 아닙니다.");
    }

    public static Discount createWeekdaysDiscount(String day, MenuList menu){
        if(Event_12_Calendar.hasWeekdayInWeekdays(day)){
            if(Menu.hasMenuListInDessert(menu)){
                return new Discount(Event_12_Calendar.WEEKENDS.getTitle(), WEEKDAYS_DISCOUNT_PRICE);
            }
        }
        throw new IllegalArgumentException("평일할인이 아닙니다.");
    }


    @Override
    public String toString() {
        return "Discount{" +
                "discountTitle='" + discountTitle + '\'' +
                ", discountPrice=" + discountPrice +
                '}';
    }
}
