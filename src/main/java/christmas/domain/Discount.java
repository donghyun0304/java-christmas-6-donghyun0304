package christmas.domain;


public class Discount {

    public static final int WEEKDAYS_DISCOUNT_PRICE = 2023;
    public static final int WEEKENDS_DISCOUNT_PRICE = 2023;
    public static final int START_DAYS_DISCOUNT_PRICE = 1000;


    private String discountTitle;
    private int discountPrice;

    private Discount(String discountTitle, int discountPrice) {
        this.discountTitle = discountTitle;
        this.discountPrice = discountPrice;
    }

    public static Discount christmasFrom(String day){
        if(Event_12_Calendar.hasDayInChristMasEventDays(day)){
            return new Discount(Event_12_Calendar.CHRISTMAS_EVENT_DAYS.getTitle(), (Integer.parseInt(day) - 1) * 100 + 1000);
        }
        return null;
    }

    public static Discount weekdaysOf(String day, MenuList menu){
        if(Event_12_Calendar.hasWeekdayInWeekdays(day)){
            if(Menu.hasMenuListInDessert(menu)){
                return new Discount(Event_12_Calendar.WEEKDAYS.getTitle(), WEEKDAYS_DISCOUNT_PRICE);
            }
        }
        return null;
    }

    public static Discount weekendsOf(String day, MenuList menu){
        if(Event_12_Calendar.hasWeekendInWeekends(day)){
            if(Menu.hasMenuListInMain(menu)){
                return new Discount(Event_12_Calendar.WEEKENDS.getTitle(), WEEKENDS_DISCOUNT_PRICE);
            }
        }
        return null;
    }

    public static Discount starFrom(String day){
        if(Event_12_Calendar.hasStarDayInStarDays(day)){
            return new Discount(Event_12_Calendar.STAR_DAYS.getTitle(), START_DAYS_DISCOUNT_PRICE);
        }
        return null;
    }

    public int getDiscountPrice() {
        return discountPrice;
    }

    public String getDiscountTitle() {
        return discountTitle;
    }

}
