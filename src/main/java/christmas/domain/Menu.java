package christmas.domain;

import java.util.Arrays;
import java.util.List;

public enum Menu {

    APPETIZER("애피타이저",
            Arrays.asList(MenuList.MUSHROOM_SOUP, MenuList.TAPAS, MenuList.CAESAR_SALAD)),
    MAIN("메인",
            Arrays.asList(MenuList.T_BONE_STEAK, MenuList.BARBECUE_RIBS, MenuList.SEAFOOD_PASTA, MenuList.CHRISTMAS_PASTA)),
    DESSERT("디저트", Arrays.asList(MenuList.CHOCOLATE_CAKE, MenuList.ICE_CREAM)),
    DRINK("음료", Arrays.asList(MenuList.ZERO_COKE, MenuList.RED_WINE, MenuList.CHAMPAGNE));

    private String title;
    private List<MenuList> menus;

    Menu(String title, List<MenuList> menus) {
        this.title = title;
        this.menus = menus;
    }

    public boolean hasMenuName(MenuList menu) {
        return menus.stream()
                .anyMatch(m -> m == menu);
    }

    public static boolean hasMenuListInDessert(MenuList menu) {
        return DESSERT.hasMenuName(menu);
    }

    public static boolean hasMenuListInMain(MenuList menu) {
        return MAIN.hasMenuName(menu);
    }

    public static void validateOnlyDrinks(String inputMenus) {
        boolean hasOnlyDrinks = Arrays.stream(inputMenus.split(","))
                .map(menu -> menu.substring(0, menu.indexOf("-")))
                .map(menu -> MenuList.findMenu(menu))
                .allMatch(menu -> DRINK.menus.contains(menu));
        if (hasOnlyDrinks) {
            throw new IllegalArgumentException("음료만 주문할 수 없습니다.");
        }
    }

}
