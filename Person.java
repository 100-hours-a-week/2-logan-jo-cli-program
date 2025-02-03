import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private String phone;
    private String address;
    private int property;
    private List<Dog> dogs = new ArrayList<>();

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
    public void write(){
        System.out.println("이름: " + name);
        System.out.println("전화번호: " + phone);
        System.out.println("주소: " + address);
        System.out.println("재산: " + property + "만원");
        System.out.println("소유한 강아지 수: " + dogs.size());
    }
}
