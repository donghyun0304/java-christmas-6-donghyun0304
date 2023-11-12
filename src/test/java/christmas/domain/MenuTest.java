package christmas.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import static org.junit.jupiter.api.Assertions.*;

class MenuTest {

    @ParameterizedTest
    @EnumSource(value = MenuList.class, names = {"CHOCOLATE_CAKE", "ICE_CREAM"})
    void 디저트메뉴가_주어지면_true를_반환한다(MenuList menu) {
        //given
        boolean hasDessert = Menu.hasMenuListInDessert(menu);
        //then
        Assertions.assertThat(hasDessert).isTrue();
    }

    @ParameterizedTest
    @EnumSource(value = MenuList.class, names = {"BARBECUE_RIBS", "CHAMPAGNE"})
    void 디저트메뉴가_아닌_메뉴가_주어지면_false를_반환한다(MenuList menu) {
        //given
        boolean hasDessert = Menu.hasMenuListInDessert(menu);
        //then
        Assertions.assertThat(hasDessert).isFalse();
    }

    @ParameterizedTest
    @EnumSource(value = MenuList.class, names = {"CHRISTMAS_PASTA", "SEAFOOD_PASTA"})
    void 메인메뉴가_주어지면_true를_반환한다(MenuList menu) {
        //given
        boolean hasMain = Menu.hasMenuListInMain(menu);
        //then
        Assertions.assertThat(hasMain).isTrue();
    }

    @ParameterizedTest
    @EnumSource(value = MenuList.class, names = {"ICE_CREAM", "RED_WINE"})
    void 메인메뉴가_아닌_메뉴가_주어지면_false를_반환한다(MenuList menu) {
        //given
        boolean hasDessert = Menu.hasMenuListInMain(menu);
        //then
        Assertions.assertThat(hasDessert).isFalse();
    }

    @Test
    void 음료만_존재하면_예외가_터진다() {
        Assertions.assertThatThrownBy(() -> Menu.validateOnlyDrinks("제로콜라-1,레드와인-1,샴페인-1"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 음료와_다른음식이_같이_존재하면_예외가_터지지_않는다() {
        assertDoesNotThrow(() -> Menu.validateOnlyDrinks("제로콜라-1,바비큐립-1,샴페인-1"));
    }

}