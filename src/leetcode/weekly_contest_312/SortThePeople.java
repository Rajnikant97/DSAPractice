package leetcode.weekly_contest_312;

import java.util.Arrays;
import java.util.Comparator;

public class SortThePeople {
    public static void main(String[] args) {

    }

    public String[] sortPeople(String[] names, int[] heights) {
        Person[] people = new Person[names.length];
        for (int i = 0; i < people.length; i++) {
            people[i] = new Person(names[i], heights[i]);
        }

        Arrays.sort(people, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return Integer.compare(o2.height, o1.height);

            }
        });
        for (int i = 0; i < people.length; i++) {
            names[i] = people[i].name;
        }
        return names;
    }

    class Person {
        String name;
        int height;
        public Person(String n, int h) {
            name = n;
            height = h;
        }
    }


}
