package christmas.domain;

import christmas.constant.Constant;

public class Discount {

    private String discountTitle;
    private int discountPrice;

    private Discount(String discountTitle, int discountPrice) {
        this.discountTitle = discountTitle;
        this.discountPrice = discountPrice;
    }

    public static Discount createChristmasDiscount(Event_12_Calendar calendar, String day){
        if(Event_12_Calendar.hasDayInChristMasEventDays(day)){
            return new Discount(calendar.getTitle(), (Integer.parseInt(day) - 1) * 100 + 1000);
        }
        throw new IllegalArgumentException("크리스마스 디데이 할인이 아닙니다.");
    }

//    public static Discount createWeekdaysDiscount(Event_12_Calendar calendar, String day, ){
//        if(calendar.getTitle().equals(Constant.CHRISTMAS_DISCOUNT) && calendar.hasDay(day)){
//            return new Discount(calendar.getTitle(), (Integer.parseInt(day) - 1) * 100 + 1000);
//        }
//        throw new IllegalArgumentException("크리스마스 디데이 할인이 아닙니다.");
//    }



}
