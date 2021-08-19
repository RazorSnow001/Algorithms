package String.KeyIndexedCounting;

import lombok.Data;

@Data
public class Person {
    private String name;
    private Integer group;
    private Integer index;

    public Person(String name, Integer group, Integer index) {
        this.name = name;
        this.group = group;
        this.index = index;
    }

    public Person(String name, Integer group) {
        this.name = name;
        this.group = group;
    }


}
