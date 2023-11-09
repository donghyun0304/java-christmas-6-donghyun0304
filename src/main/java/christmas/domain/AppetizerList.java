package christmas.domain;

public enum AppetizerList {

    MUSHROOM_SOUP("양송이수프", 6000),
    TAPAS("타파스", 5500),
    CAESAR_SALAD("시저샐러드", 8000);

    private String title;
    private int price;

    AppetizerList(String title, int price) {
        this.title = title;
        this.price = price;
    }
}
