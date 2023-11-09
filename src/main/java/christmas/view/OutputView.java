package christmas.view;

import christmas.domain.Discount;
import christmas.domain.MenuList;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class OutputView {

    public void printStart(){
        System.out.println("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.");
    }

    public void printMenus(Map<MenuList, Integer> menus){
        System.out.println("<주문 메뉴>");
        Set<Map.Entry<MenuList, Integer>> entries = menus.entrySet();
        for (Map.Entry<MenuList, Integer> entry : entries) {
            System.out.println(entry.getKey().getTitle() + " " + entry.getValue() + "개");
        }
        System.out.println();
    }

    public void printTotalAmountBeforeDiscount(int amount){
        System.out.println("<할인 전 총주문 금액>");
        System.out.printf("%,d\n", amount);
        System.out.println();
    }

    public void printPresent(MenuList menu){
        System.out.println("<증정 메뉴>");
        if(menu == null){
            System.out.println("없음");
        }
        if(menu != null){
            System.out.println(menu.getTitle() + " 1개");
        }
        System.out.println();
    }

    public void printBenefitResult(Map<String, Integer> discounts, MenuList present){
        System.out.println("<혜택 내역>");
        Set<Map.Entry<String, Integer>> entries = discounts.entrySet();
        for(Map.Entry<String, Integer> entry : entries){
            System.out.printf("%s: -%,d원\n", entry.getKey(), entry.getValue());
        }
        System.out.printf("%s: -%,d원\n", present.getTitle(), present.getPrice());
        System.out.println();
    }

    public void printTotalBenefitAmount(int amount){
        System.out.println("<총혜택 금액>");
        System.out.printf("-%,d원\n", amount);
    }

    public void printTotalAmountAfterDiscount(int amount){
        System.out.println("<할인 후 예상 결제 금액>");
        System.out.printf("%,d원\n", amount);
    }






}
