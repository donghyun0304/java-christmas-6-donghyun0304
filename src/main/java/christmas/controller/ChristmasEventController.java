package christmas.controller;

import christmas.domain.Discount;
import christmas.domain.Event_12_Calendar;
import christmas.domain.MenuList;
import christmas.domain.Order;
import christmas.dto.BenefitResultDto;
import christmas.service.EventService;
import christmas.view.InputView;
import christmas.view.OutputView;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ChristmasEventController {

    private final InputView inputView;
    private final OutputView outputView;
    private final EventService eventService;

    public ChristmasEventController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.eventService = new EventService();
    }

    public void run() {
        outputView.printStart();
        String day = inputView.inputDay();
        String inputMenus = inputView.inputMenus();

        Map<MenuList, Integer> menus = parseMenus(inputMenus);
        List<Event_12_Calendar> events = Event_12_Calendar.findEvent(day);
        List<Discount> discounts = eventService.getDiscounts(events, day, menus);
        Order order = createOrder(menus, discounts);

        printOrderSummary(order);
    }

    private Map<MenuList, Integer> parseMenus(String menus) {
        return Arrays.stream(menus.split(","))
                .map(menuEntry -> menuEntry.split("-"))
                .collect(Collectors.toMap(
                        menuInfo -> MenuList.findMenu(menuInfo[0]),
                        menuInfo -> Integer.parseInt(menuInfo[1])
                ));
    }

    private Order createOrder(Map<MenuList, Integer> menus, List<Discount> discounts) {
        return new Order(menus, discounts);
    }

    private void printOrderSummary(Order order) {
        outputView.printMenus(order.getMenus());
        outputView.printTotalAmountBeforeDiscount(order.calcTotalAmountBeforeDiscount());
        outputView.printPresent(order.getPresent());
        outputView.printBenefitResult(BenefitResultDto.from(order));
        outputView.printTotalBenefitAmount(order.calcTotalBenefitAmount());
        outputView.printTotalAmountAfterDiscount(order.calcTotalAmountAfterDiscount());
        outputView.printBadge(order.calcTotalBenefitAmount());
    }
}
