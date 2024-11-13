import java.util.Objects;

public class Person {
    private String lName;
    private String fName;

    public Person(String lName, String fName, int age, String city) {
        this.lName = lName;
        this.fName = fName;
        this.age = age;
        this.city = city;
    }

    public String getlName() {
        return lName;
    }

    public String getfName() {
        return fName;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "lName='" + lName + '\'' +
                ", fName='" + fName + '\'' +
                ", age=" + age +
                ", city='" + city + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;
        return age == person.age && Objects.equals(lName, person.lName) && Objects.equals(fName, person.fName) && Objects.equals(city, person.city);
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(lName);
        result = 31 * result + Objects.hashCode(fName);
        result = 31 * result + age;
        result = 31 * result + Objects.hashCode(city);
        return result;
    }

    public String getCity() {
        return city;
    }

    private int age;
    private String city;
}
