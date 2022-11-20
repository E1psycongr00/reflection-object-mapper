package example;

public class Person {
    private static final long serialId = 1231217;
    private final String name;
    private final int age;
    private final Address address;
    private final String[] jobs;

    public Person(String name, int age, Address address, String[] jobs) {
        this.name = name;
        this.age = age;
        this.address = address;
        this.jobs = jobs;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Address getAddress() {
        return address;
    }

    public String[] getJobs() {
        return jobs;
    }
}
