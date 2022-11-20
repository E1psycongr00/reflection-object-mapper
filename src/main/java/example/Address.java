package example;

public class Address {
    private final String street;
    private final String area;

    public Address(String street, String area) {
        this.street = street;
        this.area = area;
    }

    public String getStreet() {
        return street;
    }

    public String getArea() {
        return area;
    }
}
