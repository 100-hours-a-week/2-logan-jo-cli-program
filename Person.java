import java.util.List;

public class Person {
    private String name;
    private String phone;
    private String address;
    private int property;
    private List<Dog> dogs;

    public Person(String name, String phone, String address, int property) {
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.property = property;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getProperty() {
        return property;
    }

    public void setProperty(int property) {
        this.property = property;
    }

    public void addDog(Dog dog) {
        dogs.add(dog);
    }
}
