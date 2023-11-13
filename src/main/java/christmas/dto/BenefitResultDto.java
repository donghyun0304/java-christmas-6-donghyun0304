package christmas.dto;

import christmas.domain.Discount;
import christmas.domain.MenuList;
import christmas.domain.Order;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BenefitResultDto {

    private Map<String, Integer> nonDuplicateDiscounts;
    private MenuList present;

    private BenefitResultDto(Map<String, Integer> nonDuplicateDiscounts, MenuList present) {
        this.nonDuplicateDiscounts = nonDuplicateDiscounts;
        this.present = present;
    }

    public static BenefitResultDto from(Order order) {
        return new BenefitResultDto(getDiscountsMap(order.getDiscounts()), order.getPresent());
    }

    private static Map<String, Integer> getDiscountsMap(List<Discount> discounts) {
        Map<String, Integer> nonDuplicateDiscounts = new HashMap<>();

        for (int i = 0; i < discounts.size(); i++) {
            Discount discount = discounts.get(i);
            String discountTitle = discount.getDiscountTitle();
            Integer sum = nonDuplicateDiscounts.getOrDefault(discountTitle, 0) + discount.getDiscountPrice();
            nonDuplicateDiscounts.put(discountTitle, sum);
        }
        return nonDuplicateDiscounts;
    }

    public Map<String, Integer> getNonDuplicateDiscounts() {
        return nonDuplicateDiscounts;
    }

    public MenuList getPresent() {
        return present;
    }
}
