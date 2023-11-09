package christmas.domain;

public enum DrinkList {

    ZERO_COKE("제로콜라", 30000),
    RED_WINE("레드와인", 60000),
    CHAMPAGNE("샴페인", 25000);

    private String title;
    private int price;

    DrinkList(String title, int price) {
        this.title = title;
        this.price = price;
    }
}
