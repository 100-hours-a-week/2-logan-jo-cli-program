import enums.Gender;

public class Dog extends Animal{
    private String DogType;

    private double price;
    private String health;
    private int training;
    public String getDogType() {
        return DogType;
    }

    public void setDogType(String dogType) {
        DogType = dogType;
    }

    public Dog(String dogType, String name, int age, Gender gender, double price, String health, int training) {
        super(name, age, gender);
        this.DogType = dogType;
        this.price = price;
        this.health = health;
        this.training = training;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getHealth() {
        return health;
    }

    public void setHealth(String health) {
        this.health = health;
    }

    public int getTraining() {
        return training;
    }

    public void setTraining(int training) {
        this.training = training;
    }
    public void write() {
        super.write();
        System.out.println("품종: " + DogType);
        System.out.println("가격: " + price + "만원");
        System.out.println("건강 상태(좋음, 돈 조금듬, 돈 많이듬, 많이 아파요...): " + health);
        System.out.println("훈련도: " + training + "%");
    }
}

