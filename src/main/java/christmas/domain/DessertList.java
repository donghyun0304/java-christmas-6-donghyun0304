package christmas.domain;

public enum DessertList {

    CHOCOLATE_CAKE("초코케이크", 15000),
    ICE_CREAM("아이스크림", 5000);

    private String title;
    private int price;

    DessertList(String title, int price) {
        this.title = title;
        this.price = price;
    }
}
