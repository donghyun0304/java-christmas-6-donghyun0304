package christmas.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

class MenuListTest {

    @ParameterizedTest
    @MethodSource("generateData")
    void 메뉴이름이_존재하면_메뉴를_반환한다(String menuName, int index) {
        //given
        MenuList menu = MenuList.findMenu(menuName);
        //when
        List<MenuList> result = Arrays.asList(MenuList.MUSHROOM_SOUP, MenuList.SEAFOOD_PASTA, MenuList.ZERO_COKE);
        //then
        assertThat(menu).isEqualTo(result.get(index));
    }

    static Stream<Arguments> generateData() {
        return Stream.of(
                Arguments.of("양송이수프", 0),
                Arguments.of("해산물파스타", 1),
                Arguments.of("제로콜라", 2)
        );
    }

    @Test
    void 메뉴이름이_존재하지_않으면_예외가_터진다() {
        assertThatThrownBy(() -> MenuList.findMenu("aa"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 메뉴들이_존재하면_예외가_터지지_않는다() {
        Assertions.assertDoesNotThrow(() -> MenuList.validateValidMenus("제로콜라-1,레드와인-1,샴페인-1"));
    }

    @Test
    void 메뉴들이_존재하지_않으면_예외가_터진다() {
        assertThatThrownBy(() -> MenuList.validateValidMenus("제로콜라-1,바비큐립-1,치킨-1"))
                .isInstanceOf(IllegalArgumentException.class);
    }


}