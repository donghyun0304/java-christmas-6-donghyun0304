package christmas.domain;

import java.util.List;

public class Order {

    private List<MenuList> menus;

    public Order(List<MenuList> menus) {
        this.menus = menus;
    }

    public int calcTotalAmountBeforeDiscount(){
        return menus.stream()
                .mapToInt(menu -> menu.getPrice())
                .sum();
    }

}
