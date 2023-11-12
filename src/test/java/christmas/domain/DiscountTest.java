package christmas.domain;

import christmas.constant.Constant;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import java.util.stream.Stream;
import static org.assertj.core.api.Assertions.assertThat;

class DiscountTest {

    @ValueSource(strings = {"1","15","25"})
    @ParameterizedTest
    void 크리스마스_디데이_할인_날짜라면_크리스마스_할인_이름을_가진_객체가_생성된다(String day){
        //given
        Discount discount = Discount.christmasFrom(day);
        //then
        assertThat(discount.getDiscountTitle()).isEqualTo(Constant.CHRISTMAS_DISCOUNT);
    }

    @ValueSource(strings = {"26","30","31"})
    @ParameterizedTest
    void 크리스마스_디데이_할인_날짜가_아니라면_Null을_반환한다(String day){
        //given
        Discount discount = Discount.christmasFrom(day);
        //then
        assertThat(discount).isNull();
    }

    @MethodSource("generateData1")
    @ParameterizedTest
    void 평일_날짜와_디저트_메뉴가_주어지면_평일할인_이름을_가진_객체가_생성된다(String day, MenuList menu){
        //given
        Discount discount = Discount.weekdaysOf(day, menu);
        //then
        assertThat(discount.getDiscountTitle()).isEqualTo(Constant.WEEKDAYS_DISCOUNT);
    }

    static Stream<Arguments> generateData1(){
        return Stream.of(
                Arguments.of("4", MenuList.CHOCOLATE_CAKE),
                Arguments.of("10", MenuList.CHOCOLATE_CAKE),
                Arguments.of("25", MenuList.ICE_CREAM)
        );
    }
    
    @MethodSource("generateData2")
    @ParameterizedTest
    void 디저트_메뉴와_평일날짜가_아닌_날짜가_주어지면_Null이_생성된다(String day, MenuList menu){
        //given
        Discount discount = Discount.weekdaysOf(day, menu);
        //then
        assertThat(discount).isNull();
    }

    static Stream<Arguments> generateData2(){
        return Stream.of(
                Arguments.of("1", MenuList.CHOCOLATE_CAKE),
                Arguments.of("9", MenuList.CHOCOLATE_CAKE),
                Arguments.of("29", MenuList.ICE_CREAM)
        );
    }

    @MethodSource("generateData3")
    @ParameterizedTest
    void 평일날짜와_디저트메뉴가_아닌_다른메뉴가_주어지면_Null을_반환한다(String day, MenuList menu){
        //given
        Discount discount = Discount.weekdaysOf(day, menu);
        //then
        assertThat(discount).isNull();
    }

    static Stream<Arguments> generateData3(){
        return Stream.of(
                Arguments.of("4", MenuList.MUSHROOM_SOUP),
                Arguments.of("10", MenuList.T_BONE_STEAK),
                Arguments.of("25", MenuList.ZERO_COKE)
        );
    }

    @MethodSource("generateData4")
    @ParameterizedTest
    void 주말_날짜와_메인_메뉴가_주어지면_주말할인_이름을_가진_객체가_생성된다(String day, MenuList menu){
        //given
        Discount discount = Discount.weekendsOf(day, menu);
        //then
        assertThat(discount.getDiscountTitle()).isEqualTo(Constant.WEEKENDS_DISCOUNT);
    }

    static Stream<Arguments> generateData4(){
        return Stream.of(
                Arguments.of("1", MenuList.T_BONE_STEAK),
                Arguments.of("23", MenuList.BARBECUE_RIBS),
                Arguments.of("30", MenuList.CHRISTMAS_PASTA)
        );
    }

    @MethodSource("generateData5")
    @ParameterizedTest
    void 메인_메뉴와_주말날짜가_아닌_날짜가_주어지면_Null을_반환한다(String day, MenuList menu){
        //given
        Discount discount = Discount.weekendsOf(day, menu);
        //then
        assertThat(discount).isNull();
    }

    static Stream<Arguments> generateData5(){
        return Stream.of(
                Arguments.of("3", MenuList.T_BONE_STEAK),
                Arguments.of("25", MenuList.BARBECUE_RIBS),
                Arguments.of("27", MenuList.CHRISTMAS_PASTA)
        );
    }

    @MethodSource("generateData6")
    @ParameterizedTest
    void 주말날짜와_메인메뉴가_아닌_다른메뉴가_주어지면_Null을_반환한다(String day, MenuList menu){
        //given
        Discount discount = Discount.weekendsOf(day, menu);
        //then
        assertThat(discount).isNull();
    }

    static Stream<Arguments> generateData6(){
        return Stream.of(
                Arguments.of("1", MenuList.MUSHROOM_SOUP),
                Arguments.of("23", MenuList.CHOCOLATE_CAKE),
                Arguments.of("30", MenuList.CHAMPAGNE)
        );
    }

    @ValueSource(strings = {"3","10","17","24","25","31"})
    @ParameterizedTest
    void 스타_날짜가_주어지면_스타할인_이름을_가진_객체가_생성된다(String day){
        //given
        Discount discount = Discount.starFrom(day);
        //then
        assertThat(discount.getDiscountTitle()).isEqualTo(Constant.STAR_DAYS_DISCOUNT);
    }

    @ValueSource(strings = {"1","22","23"})
    @ParameterizedTest
    void 스타_날짜가_아닌_날짜가_주어지면_Null을_반환한다(String day){
        //given
        Discount discount = Discount.starFrom(day);
        //then
        assertThat(discount).isNull();
    }

}