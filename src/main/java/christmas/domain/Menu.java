package christmas.domain;

import java.util.Arrays;
import java.util.List;

public enum Menu {

    APPETIZER("애피타이저",
            Arrays.asList(AppetizerList.MUSHROOM_SOUP, AppetizerList.TAPAS, AppetizerList.CAESAR_SALAD)),
    MAIN("메인",
            Arrays.asList(MainList.T_BONE_STEAK, MainList.BARBECUE_RIBS, MainList.SEAFOOD_PASTA, MainList.CHRISTMAS_PASTA)),
    DESSERT("디저트", Arrays.asList(DessertList.CHOCOLATE_CAKE, DessertList.ICE_CREAM)),
    DRINK("음료", Arrays.asList(DrinkList.ZERO_COKE, DrinkList.RED_WINE, DrinkList.CHAMPAGNE));

    private String title;
    private List<Object> menuList;

    Menu(String title, List<Object> menuList) {
        this.title = title;
        this.menuList = menuList;
    }
}
