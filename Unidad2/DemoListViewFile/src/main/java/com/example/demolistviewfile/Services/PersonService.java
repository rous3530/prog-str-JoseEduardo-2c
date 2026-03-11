package com.example.demolistviewfile.Services;

import com.example.demolistviewfile.Repositories.PersonFileRepository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PersonService {

    PersonFileRepository repo = new PersonFileRepository();

    public List<String> loadForListView() throws IOException {
        List<String> lines = repo.readAllLines();
        List<String> result= new ArrayList<>();
        for(String line : lines){
            if(line==null || line.isBlank()) continue;

            String[] parts= line.split(",");
            String name=parts[0];
            String email=parts[1];
            result.add(name+"-"+email);
        }
        return result;
    }

    public void addPerson(String name, String email,Integer age) throws IOException {
        validate(name,email);
        repo.addNewLine(name+","+email+","+age);
    }


    private void validate(String name, String email){
        if (name== null || name.isBlank() || name.length()<3){
            throw new IllegalArgumentException("el nombre es incorrecto");
        }
        String em =(email==null) ? "" : email.trim();
        if (em.isBlank() || !em.contains("@") || !em.contains(".")){
            throw new IllegalArgumentException("el email es invalido");
        }


    }
}