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

    public static MenuList findMenu(String menuName){
        return Arrays.stream(Menu.values())
                .filter(m -> m.hasMenuName(MenuList.valueOf(menuName)))
                .findAny()
                .map(m -> MenuList.valueOf(menuName))
                .orElseThrow(() -> new IllegalArgumentException("메뉴를 찾을 수 없습니다."));
    }

    public boolean hasMenuName(MenuList menu){
        return menus.stream()
                .anyMatch(m -> m == menu);
    }

    public boolean hasMenuListInDessert(MenuList menu){
        return Arrays.stream(Menu.values())
                .anyMatch(m -> menus.contains(menu));
    }









}
