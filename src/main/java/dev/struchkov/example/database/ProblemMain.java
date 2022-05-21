package dev.struchkov.example.database;

import dev.struchkov.example.database.domain.entity.Epic;

import java.util.HashSet;
import java.util.Set;

public class ProblemMain {

    public static void main(String[] args) {
        final Epic epic1 = new Epic();
        epic1.setName("Test 1");

        final Epic epic2 = new Epic();
        epic2.setName("Test 2");

        final Set<Epic> epics = new HashSet<>();
        epics.add(epic1);
        epics.add(epic2);
//        final Set<Epic> epics = Set.of(epic1, epic2);

        System.out.println();
        System.out.println(epics);
        System.out.println();
    }

}
