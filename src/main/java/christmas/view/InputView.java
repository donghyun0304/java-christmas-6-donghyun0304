package christmas.view;

import christmas.domain.Menu;
import christmas.domain.MenuList;
import christmas.validation.Validator;


import static camp.nextstep.edu.missionutils.Console.*;

public class InputView {

    public String inputDay() {
        System.out.println("12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)");
        String day = readLine().trim();
        try {
            Validator.validateOnlyNumber(day);
            Validator.validate1To31Number(Integer.parseInt(day));
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
            return inputDay();
        }
        return day;
    }

    public String inputMenus() {
        System.out.println("주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)");
        String order = readLine().trim();
        try {
            Validator.validateOrderForm(order);
            Validator.validateDuplicate(order);
            MenuList.validateValidMenus(order);
            Menu.validateOnlyDrinks(order);
            Validator.validateLessThan20Menus(order);
            Validator.validateZeroNumber(order);
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
            return inputMenus();
        }
        return order;
    }


}
