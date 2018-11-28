package db;

import domain.Person;

import java.util.ArrayList;
import java.util.List;

public class Service {
    private ImageRepositoryInMemory imageRepo;
    private PersonRepositoryInMemory personRepo;

    public Service() {
        imageRepo = new ImageRepositoryInMemory();
        personRepo = new PersonRepositoryInMemory();
    }

    public void addImage(String key){
        imageRepo.addImage(key);
    }

    public List<String> getAllImages(){
        return imageRepo.getAllKeys();
    }

    public ArrayList<Person> getAllPersons(){
        return personRepo.getPersons();
    }
}
