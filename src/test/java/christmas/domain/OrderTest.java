package christmas.domain;

import christmas.service.EventService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.*;

class OrderTest {

    private Order order;
    private Map<MenuList, Integer> menus = new HashMap<>();
    private List<Discount> discounts = new ArrayList<>();

    @BeforeEach
    void init(){
        menus.clear();
        discounts.clear();

        menus.put(MenuList.CAESAR_SALAD, 1);
        menus.put(MenuList.T_BONE_STEAK, 2);
        menus.put(MenuList.CHAMPAGNE, 1);
        order = new Order(menus, discounts);
    }

    @Test
    void 음식가격들과_할인전_총주문금액은_일치한다() {
        //when
        Set<Map.Entry<MenuList, Integer>> menusEntry = menus.entrySet();
        int menusPrice = menusEntry.stream()
                .mapToInt(menuEntry -> menuEntry.getKey().getPrice() * menuEntry.getValue())
                .sum();
        int totalAmountBeforeDiscount = order.calcTotalAmountBeforeDiscount();
        //then
        Assertions.assertThat(menusPrice).isEqualTo(totalAmountBeforeDiscount);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1","3","6","25","27","29"})
    void 날짜에_따라_할인금액이_달라진다(String day){
        //given
        EventService eventService = new EventService();
        List<Event_12_Calendar> events = Event_12_Calendar.findEvent(day);
        discounts = eventService.getDiscounts(events, day, menus);
        order = new Order(menus, discounts);
        //when
        int totalDiscountAmount = order.calcTotalDiscountAmount();
        int sum = discounts.stream()
                .mapToInt(discount -> discount.getDiscountPrice())
                .sum();
        //then
        Assertions.assertThat(totalDiscountAmount).isEqualTo(sum);
    }

    @Test
    void 할인전_총주문금액이_12만원이상이면_증정메뉴가격이_총혜택금액에_포함된다(){
        //given
        EventService eventService = new EventService();
        List<Event_12_Calendar> events = Event_12_Calendar.findEvent("1");
        discounts = eventService.getDiscounts(events, "1", menus);
        order = new Order(menus, discounts);
        //when
        int benefitAmount = order.calcTotalBenefitAmount();
        int sum = 1000 + 4046 + 25000;
        //then
        Assertions.assertThat(benefitAmount).isEqualTo(sum);
    }

    @Test
    void 할인전_총주문금액이_12만원미만이면_증정메뉴가격이_총혜택금액에_포함되지_않는다(){
        //given
        EventService eventService = new EventService();
        menus.clear();
        menus.put(MenuList.CAESAR_SALAD, 1);
        menus.put(MenuList.T_BONE_STEAK, 1);
        menus.put(MenuList.CHAMPAGNE, 1);
        List<Event_12_Calendar> events = Event_12_Calendar.findEvent("1");
        discounts = eventService.getDiscounts(events, "1", menus);
        order = new Order(menus, discounts);
        //when
        int benefitAmount = order.calcTotalBenefitAmount();
        int sum = 1000 + 2023;
        //then
        Assertions.assertThat(benefitAmount).isEqualTo(sum);
    }

}