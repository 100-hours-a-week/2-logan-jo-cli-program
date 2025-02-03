import enums.Gender;

public class Puppy extends Dog{
    private Person person;

    public Person getPerson() {
        return person;
    }

    public Puppy(Dog dog, Person person) {
        super(dog.getDogType(), dog.getName(), dog.getAge(), dog.getGender(), dog.getPrice(), dog.getHealth(), dog.getTraining());
        this.person = person;
    }
    public void write() {
        super.write();
        System.out.println("소유자: " + person.getName());
    }
}
