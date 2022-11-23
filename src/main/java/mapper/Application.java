package mapper;

import example.Address;
import example.Person;

public class Application {

    public static void main(String[] args) throws IllegalAccessException {
        Address address = new Address("뇽뇽로", "서울시");
        Person person = new Person("Ace", 10, address, new String[] {"programmer", "teacher"});
        String s = ObjectMapper.writeToString(person);
        System.out.println(s);
    }
}
