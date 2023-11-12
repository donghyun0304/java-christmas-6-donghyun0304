package christmas.domain;

import java.util.*;

public class Order {

    private static final int MIN_PRICE_FOR_PRESENT = 120_000;
    private static final int MIN_PRICE_FOR_EVENT = 10_000;
    private Map<MenuList, Integer> menus;
    private List<Discount> discounts;
    private MenuList present;

    public Order(Map<MenuList, Integer> menus, List<Discount> discounts) {
        this.menus = menus;
        if(calcTotalAmountBeforeDiscount() >= MIN_PRICE_FOR_EVENT){
            this.discounts = discounts;
        }
        if(calcTotalAmountBeforeDiscount() < MIN_PRICE_FOR_EVENT){
            this.discounts = Collections.EMPTY_LIST;
        }
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
        if(present != null){
            return calcTotalDiscountAmount() + present.getPrice();
        }
        return calcTotalDiscountAmount();
    }

    public Map<MenuList, Integer> getMenus() {
        return Collections.unmodifiableMap(menus);
    }

    public MenuList getPresent() {
        return present;
    }

    public List<Discount> getDiscounts() {
        return Collections.unmodifiableList(discounts);
    }

}
