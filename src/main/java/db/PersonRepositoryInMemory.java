package db;

import domain.Person;

import java.util.ArrayList;

public class PersonRepositoryInMemory {
    private ArrayList<Person> persons;

    public PersonRepositoryInMemory() {
        this.persons = new ArrayList<>();
        persons.add(new Person("Rune", "r0662214", "github.com/..."));
    }

    public ArrayList<Person> getPersons() {
        return persons;
    }
}
