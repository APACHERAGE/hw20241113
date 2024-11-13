import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

import static java.util.Arrays.stream;

/*
Дан список строк вида “параметр:значение” (например, “length:8”, “name:Jack”  и т.д). Используя стримы получить  map, где параметр – это ключ, его значение – значение. При этом, если в списке дважды встретился один и тот же параметр, то значения должны быть указаны через запятую
Например дано::  “name:Nick”,“length:8”, “name:Jack”
Вывод:  [ name - Nick,Jack ;  length -> 8]
2.

Дан список Person (lName, fName, age, city) необходимо реализовать метод
который вернет средний возраст всех людей проживающих в Берлине
который вернет map, где ключ - возраст, значение количество людей, соответствующего возраста





 */
public class Main {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("length:8", "name:Jack", "age:25");
        System.out.println(keyValue(list));
        List<Person>personList=List.of(
                new Person("Jack","Jackson",20,"Berlin"),
                new Person("John","Johnson",21,"Washington"),
                new Person("Nick","Nickson",20,"Leipzig"),
                new Person("Jimmy","Neutron",23,"Paris"),
                new Person("Ann","Marrie",20,"Berlin"),
                new Person("Luis","Anderson",25,"Berlin")
        );
        System.out.println(getAverageAge(personList,"Berlin"));
        System.out.println(mapAgeToQuantity(personList));
    }
public static Map<String,String>keyValue(List<String>list){
   return  list.stream()
            .map(s -> s.split(":", 2))
            .collect(Collectors.toMap(
                    s -> s[0],
                    s -> s[1],
                    (key, value) -> key + "," + value
            ));
}


    public static OptionalDouble getAverageAge(List<Person>personList, String city) {
   return personList.stream()
           .filter(person -> person.getCity().equals(city))
           .mapToInt(Person::getAge).average();
    }

    public static Map<Integer, Integer> mapAgeToQuantity(List<Person> personList) {
        return personList.stream()
                .collect(Collectors.groupingBy(
                        Person::getAge,
                        Collectors.collectingAndThen(
                                Collectors.counting(),
                                Long::intValue
                        )
                ));
    }

}