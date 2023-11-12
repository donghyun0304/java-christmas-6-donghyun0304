package christmas.domain;

import java.util.Arrays;

public enum MenuList {

    MUSHROOM_SOUP("양송이수프", 6000),
    TAPAS("타파스", 5500),
    CAESAR_SALAD("시저샐러드", 8000),
    T_BONE_STEAK("티본스테이크", 55_000),
    BARBECUE_RIBS("바비큐립", 54_000),
    SEAFOOD_PASTA("해산물파스타", 35_000),
    CHRISTMAS_PASTA("크리스마스파스타", 25_000),
    CHOCOLATE_CAKE("초코케이크", 15_000),
    ICE_CREAM("아이스크림", 5_000),
    ZERO_COKE("제로콜라", 3_000),
    RED_WINE("레드와인", 60_000),
    CHAMPAGNE("샴페인", 25_000);

    private String title;
    private int price;

    MenuList(String title, int price) {
        this.title = title;
        this.price = price;
    }

    public static MenuList findMenu(String menuName){
        return Arrays.stream(MenuList.values())
                .filter(m -> m.getTitle().equals(menuName))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("메뉴가 존재하지 않습니다."));
    }

    public static void validateValidMenus(String inputMenus){
        String[] menus = inputMenus.split(",");

        for(String menu : menus){
            String menuName = menu.split("-")[0];
            boolean hasMenu = Arrays.stream(MenuList.values())
                    .anyMatch(m -> m.getTitle().equals(menuName));
            if(!hasMenu){
                throw new IllegalArgumentException("메뉴가 존재하지 않습니다.");
            }
        }
    }

    public String getTitle() {
        return title;
    }

    public int getPrice() {
        return price;
    }
}
