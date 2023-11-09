package christmas.domain;

public enum MainList {

    T_BONE_STEAK("티본스테이크", 55000),
    BARBECUE_RIBS("바비큐립", 54000),
    SEAFOOD_PASTA("해산물파스타", 35000),
    CHRISTMAS_PASTA("크리스마스파스타", 25000);

    private String title;
    private int price;

    MainList(String title, int price) {
        this.title = title;
        this.price = price;
    }
}
