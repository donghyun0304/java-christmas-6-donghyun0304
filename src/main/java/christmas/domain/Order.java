package christmas.domain;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Order {

    private static final int MIN_PRICE_FOR_PRESENT = 120000;
    private Map<MenuList, Integer> menus;
    private List<Discount> discounts;
    private MenuList present;

    public Order(Map<MenuList, Integer> menus, List<Discount> discounts) {
        this.menus = menus;
        this.discounts = discounts;
        if(calcTotalAmountBeforeDiscount() >= MIN_PRICE_FOR_PRESENT){
            this.present = MenuList.CHAMPAGNE;
        }
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

    public int calcTotalAmountAfterDiscount(){
        return calcTotalAmountBeforeDiscount() - calcTotalDiscountAmount();
    }


    public int calcTotalDiscountAmount(){
        return discounts.stream()
                .mapToInt(discount -> discount.getDiscountPrice())
                .sum();
    }

    public int calcTotalBenefitAmount(){
        return calcTotalDiscountAmount() + present.getPrice();
    }

    public Map<MenuList, Integer> getMenus() {
        return Collections.unmodifiableMap(menus);
    }

    public String getPresentName() {
        if(present == null){
            return "없음";
        }
        return present.getTitle();
    }
}
