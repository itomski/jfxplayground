package de.lubowiecki;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PersonRepository implements Repository<Person> {

    private List<Person> personen = new ArrayList<>();

    public void add(Person p) {
        personen.add(p);
    }

    public List<Person> getAll() {
        return Collections.unmodifiableList(personen);
    }
}