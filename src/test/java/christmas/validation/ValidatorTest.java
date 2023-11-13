package christmas.validation;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class ValidatorTest {

    @Test
    void 숫자로만_이루어진_문자라면_예외가_터지지_않는다() {
        assertDoesNotThrow(() -> Validator.validateOnlyNumber("45"));
    }

    @Test
    void 숫자로만_이루어진_문자가_아니라면_예외가_터진다() {
        assertThatThrownBy(() -> Validator.validateOnlyNumber(""))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> Validator.validateOnlyNumber("1a"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 일에서31사이의_숫자라면_예외가_터지지_않는다() {
        assertDoesNotThrow(() -> Validator.validate1To31Number(31));
    }

    @Test
    void 일에서31사이의_숫자가_아니라면_예외가_터진다() {
        assertThatThrownBy(() -> Validator.validate1To31Number(0))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> Validator.validate1To31Number(32))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 주문형식에_맞으면_예외가_터지지_않는다() {
        assertDoesNotThrow(() -> Validator.validateOrderForm("양송이스프-1,티본스테이크-1"));
    }

    @Test
    void 주문형식에_맞지_않으면_예외가_터진다() {
        assertThatThrownBy(() -> Validator.validateOrderForm("양송이스프-1, 티본스테이크-1"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> Validator.validateOrderForm(" "))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> Validator.validateOrderForm("양송이스프1,티본스테이크-1"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> Validator.validateOrderForm(" 양송이스프-1,티본스테이크-1"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 중복메뉴가_존재하면_예외가_터진다() {
        assertThatThrownBy(() -> Validator.validateDuplicate("티본스테이크-1,티본스테이크-1"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 메뉴개수가_20개이하면_예외가_터지지_않는다() {
        assertDoesNotThrow(() -> Validator.validateLessThan20Menus("티본스테이크-19,제로콜라-1"));
    }

    @Test
    void 메뉴개수가_20개초과면_예외가_터진다() {
        assertThatThrownBy(() -> Validator.validateLessThan20Menus("티본스테이크-19,제로콜라-2"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 메뉴개수에_0이_들어가면_예외가_터진다() {
        assertThatThrownBy(() -> Validator.validateZeroNumber("티본스테이크-0"))
                .isInstanceOf(IllegalArgumentException.class);
    }

}