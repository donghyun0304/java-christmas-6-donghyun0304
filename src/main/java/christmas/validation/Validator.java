package christmas.validation;

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

}
