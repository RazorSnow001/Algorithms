package String.KeyIndexedCounting;

import java.util.*;


/*
!that is not very complicated problem
!
!1 that is just a problem we faced every day
!  sort the item with the
!  one attribute
!  that is very simple
!
!  so the solution will include
!  1 use the mysql order by
!  2 use the stream in java 8 c
!
!studentList.stream().sorted(Comparator.comparing(StudentInfo::getAge)).collect(Collectors.toList());
!
!  3 use the brute no encapsulated algorithm
!    we use the array to do the record

     ok first
    1 we need an array to record the number of each group of the elements
    2 we need to add some items by the order to get the first index of the first element of each group
    3 we need to use the executed record array to execute the actual index of each item

    the implementation of this record array is pretty impressive my bro
    it actually records the index of the eventual result .
    but it uses the relationship between the first index of each group and the group numbers and orders
    so that is a very elegant solution .
*/
public class KeyIndexedCounting {
    public List<Person> sortByGroupId(List<Person> personList) {
        Optional<Integer> result = personList.stream().map(Person::getGroup).max(Comparator.comparingInt(a -> a));
        Comparator<Person> personComparator = Comparator.comparingInt(Person::getGroup);
        PriorityQueue<Person> priorityQueue = new PriorityQueue(personComparator);
        List<Person> sortedPersonList = new ArrayList<>();
        if (result.isPresent()) {
            int[] record = new int[result.get() + 2];
            for (Person person : personList) {
                record[person.getGroup() + 1]++;
            }
            for (int i = 0; i < record.length - 1; i++) {
                record[i + 1] = record[i] + record[i + 1];
            }
            for (Person person : personList) {
                record[person.getGroup()]++;
                int resultIndex = record[person.getGroup()];
                person.setIndex(resultIndex);
                priorityQueue.offer(person);
            }
            while(!priorityQueue.isEmpty()){
                sortedPersonList.add(priorityQueue.poll());
            }
        }
        return sortedPersonList;
    }


    public static void main(String[] args) {
        List<Person> personList = Arrays.asList(new Person("TOM", 2), new Person("LUCY", 2),
                new Person("JOSH", 1), new Person("BOSH", 3),new Person("CURRY",1),new Person("CURRY",2));
        KeyIndexedCounting sortByGroupId = new KeyIndexedCounting();
        List<Person> sortedPersonList = sortByGroupId.sortByGroupId(personList);
        Comparator<Person> personComparator = Comparator.comparingInt(Person::getGroup);
        personList.stream().sorted(personComparator).forEach(p -> System.out.println(p.getName() + "..." + p.getGroup()));
        System.out.println();
        sortedPersonList.forEach(p -> System.out.println(p.getName() + "..." + p.getGroup()));
    }
}
