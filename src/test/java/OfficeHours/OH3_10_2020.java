package OfficeHours;

import java.util.*;

public class OH3_10_2020 {
    public static void main(String[] args) {


        HashSet<String> hasSet = new HashSet<>();
        TreeSet<String> treeSet = new TreeSet<>();
        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>();

        for (String each : Arrays.asList("value1", "value1", "value2", "value5")){

            hasSet.add(each);
            treeSet.add(each);
            linkedHashSet.add(each);

        }
        System.out.println("hashSet: " + hasSet);
        System.out.println("treeSet: " + treeSet);
        System.out.println("LinkedSet: " + linkedHashSet);



        }
}
