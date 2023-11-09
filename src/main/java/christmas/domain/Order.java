package christmas.domain;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class Order {

    private Map<MenuList, Integer> menus;
    private List<Discount> discounts;

    public Order(Map<MenuList, Integer> menus, List<Discount> discounts) {
        this.menus = menus;
        this.discounts = discounts;
    }

    public int calcTotalAmountBeforeDiscount(){
        int totalAmountBeforeDiscount = 0;
        Set<Map.Entry<MenuList, Integer>> entries = menus.entrySet();

        for(Map.Entry<MenuList, Integer> entry : entries){
            int price = entry.getKey().getPrice();
            Integer quantity = entry.getValue();

            totalAmountBeforeDiscount += price * quantity;
        }
        return totalAmountBeforeDiscount;
    }

    

    public int calcTotalDiscountAmount(){
        return discounts.stream()
                .mapToInt(discount -> discount.getDiscountPrice())
                .sum();
    }


}
