package christmas.view;

import christmas.domain.MenuList;

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
    }


}
