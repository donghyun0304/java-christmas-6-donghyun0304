기능목록

날짜입력

- 날짜를 입력 받는다.
   + 숫자가 아니라면 예외
   + 1~31의 숫자가 아니라면 예외

- 메뉴와 개수를 입력받는다.
    + 메뉴의 개수가 1이상의 숫자가 아니라면 예외
    + 주문 형식에 맞지 않으면 예외
    + 중복메뉴가 존재하면 예외
    + 존재하지 않은 메뉴라면 예외
    + 음료만 존재하면 예외
    + 주문 개수가 20개 초과하면 예외

12월 이벤트 달력
- 날짜에 맞는 이벤트들을 반환한다.
- 입력받은 날짜가 크리스마스 이벤트에 존재하지는 확인한다.
- 입력받은 날짜가 평일 이벤트에 존재하는지 확인한다. 
- 입력받은 날짜가 주말 이벤트에 존재하는지 확인한다.
- 입력받은 날짜가 스타 이벤트에 존재하는지 확인한다.

메뉴
- 입력받은 메뉴가 존재하는지 확인한다.
- 입력받은 메뉴가 디저트에 존재하는지 확인한다.
- 입력받은 메뉴가 메인에 존재하는지 확인한다.
- 입력받은 메뉴들에 음료만 존재하는지 확인한다.

메뉴리스트
- 메뉴이름과 동일한 메뉴리스트를 반환한다.
- 입력받은 메뉴들이 존재하는 메뉴인지 확인한다.

할인
- 크리스마스 할인을 반환한다.
- 평일 할인을 반환한다.
- 주말 할인을 반환한다.
- 스타 할인을 반환한다.

주문
- 할인 전 총 주문 금액을 반환한다.
- 할인 후 예상 결제 금액을 반환한다.
- 총 할인 금액을 반환한다.
- 총 혜택 금액을 반환한다.

주문 서비스 레이어
- 할인들을 반환한다.

출력
- 시작문구를 출력한다.
- 주문메뉴들을 출력한다.
- 할인 전 총 주문금액을 출력한다.
- 증정메뉴를 출력한다.
- 혜택내역을 출력한다.
- 총 혜택금액을 출력한다.
- 할인 후 예상 결제 금액을 출력한다.
- 12월 이벤트 배지를 출력한다.

검증
- 숫자로만 이루어져 있는 문자열인지 검증한다.
- 1~31의 숫자인지 검증한다.
- 주문입력형식이 맞는지 검증한다.
- 중복메뉴가 존재하는지 검증한다.
- 주문 개수가 20개 이하인지 검증한다.
- 0인지 검증한다.


