package christmas.domain;

import net.bytebuddy.asm.Advice;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class Event_12_CalendarTest {

    @ParameterizedTest
    @MethodSource("generateData")
    void 날짜에_맞는_이벤트_달력객체_리스트가_생성된다(String day, int index){
        //given
        List<Event_12_Calendar> event = Event_12_Calendar.findEvent(day);
        //when
        List<List<Event_12_Calendar>> result = Arrays.asList(
                Arrays.asList(
                        Event_12_Calendar.WEEKENDS,
                        Event_12_Calendar.CHRISTMAS_EVENT_DAYS
                ),
                Arrays.asList(
                        Event_12_Calendar.WEEKDAYS,
                        Event_12_Calendar.STAR_DAYS,
                        Event_12_Calendar.CHRISTMAS_EVENT_DAYS
                ),
                Arrays.asList(
                        Event_12_Calendar.WEEKDAYS,
                        Event_12_Calendar.CHRISTMAS_EVENT_DAYS
                ),
                Arrays.asList(
                        Event_12_Calendar.WEEKDAYS,
                        Event_12_Calendar.STAR_DAYS,
                        Event_12_Calendar.CHRISTMAS_EVENT_DAYS)
                ,
                Arrays.asList(
                        Event_12_Calendar.WEEKDAYS
                )
                );
        //then
        Assertions.assertThat(event).containsAll(result.get(index));
    }

    static Stream<Arguments> generateData(){
        return Stream.of(
                Arguments.of("1", 0),
                Arguments.of("3", 1),
                Arguments.of("12", 2),
                Arguments.of("25", 3),
                Arguments.of("26", 4)
        );
    }

}