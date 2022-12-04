import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Person implements Comparable<Person> {
    private String name;
    private int age;
    private int height;
    private int weight;

    public Person(String name, int age, int height, int weight) {
        this.name = name;
        this.age = age;
        this.height = height;
        this.weight = weight;
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    public int getHeight() {
        return this.height;
    }

    public int getWeight() {
        return this.weight;
    }

    @Override
    public int compareTo(Person otherPerson) {
        // add your code here!
        int result = getName().compareTo(otherPerson.getName());
        return result == 0 ? Integer.compare(getAge(), otherPerson.getAge()) : result;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", height=" + height +
                ", weight=" + weight +
                '}';
    }

    public static void main(String[] args) {
        Person one = new Person("Zom", 22, 185, 65);
        Person two = new Person("Xris", 30, 185, 65);
        Person thr = new Person("Xob", 22, 185, 65);

        List<Person> people = new ArrayList<>(List.of(one, two, thr));

        Collections.sort(people);

        people.forEach(System.out::println);

    }
}