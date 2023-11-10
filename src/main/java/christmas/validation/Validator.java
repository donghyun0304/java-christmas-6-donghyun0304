package christmas.validation;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Validator {

    public static void validateOnlyNumber(String str) {
        if (!str.matches("[0-9]+")) {
            throw new IllegalArgumentException("숫자로만 이루어진 문자가 아닙니다.");
        }
    }

    public static void validate1To45Number(int number) {
        if (!(number >= 1 && number <= 31)) {
            throw new IllegalArgumentException("1~31사이의 숫자가 아닙니다.");
        }
    }

    public static void validateOrderForm(String str){
        String regex = "([가-힣]+-\\d+)(,[가-힣]+-\\d+)*";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);

        if(!matcher.matches()){
            throw new IllegalArgumentException("주문 형식에 맞지 않습니다.");
        }
    }

    public static void validateDuplicate(String str) {
        String[] menus = str.split(",");
        HashSet<String> set = new HashSet<>();

        for(String menu : menus){
            String menuName = menu.split("-")[0];
            if(set.contains(menuName)){
                throw new IllegalArgumentException("중복 메뉴가 존재합니다.");
            }
            set.add(menuName);
        }
    }


}
