`@**RequestBody`

- 객체를 받을 수 없고, 단일 값으로 받을 수 있다.
- **Spring MVC**에서는 쿼리데이터와 form-data형식을 받을 수 있다.
- **Spring WebFlux**에서 요청 매개변수는 쿼리데이터만 받을 수 있다.

`@ModelAttribute`

- form data로 받은 데이터를 커멘더 객체에 주입할 때 사용한다.

`@RequsetParam`

- JSON 형식의 요청 데이터를 자바 객체로 변환해 받을 수 있도록 한다.