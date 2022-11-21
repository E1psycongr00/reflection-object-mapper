# Object mapper 설계하기

##  기능 요구사항

### 직렬화
object mapper의 기능을 구현한다. 클래스의 필드를 리플렉션을 통해 json 형식으로 변환해야 한다.
- 인스턴스 변수의 이름과 값을 json key, value로 활용한다.
- 배열과 nested class 모두 변환해야 한다.
- transient, static이 붙은 필드는 변환하지 않는다.

## 예시
```java 
class Person {
    private static final long serialId = 1231217;
    private String name;
    private int age;
    private Address address;
    private String[] job;
    // 생성자.... ....
    
class Address {
    private String street;
    private String area
    
    // 생성자 .......
}
```

## 출력 예시
```json
{
  "name": "hello",
  "age": 10,
  "address": {
    "street": "뇽뇽로",
    "area": "서울"
  },
  "job": ["programmer", "trainer"]
}
```


### 역직렬화
String json을 class로 역직렬화 한다.
- 역직렬화 함수 인자는 objectMapper.read(String json, Class<?> clazz).
- 해당 class 타입의 인스턴스를 생성해서 반환한다.


