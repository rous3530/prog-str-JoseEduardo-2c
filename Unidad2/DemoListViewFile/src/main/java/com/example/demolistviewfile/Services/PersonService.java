package com.example.demolistviewfile.services;

import com.example.demolistviewfile.repositories.PersonFileRepository;

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
          String edad=parts[2];
          result.add(name+"-"+email+"-"+edad);
        }
        return result;
    }
    public void updatePerson(int index, String name, String email, String edad) throws IOException {
       validate(name, email, edad);
        List<String> listoriginal=repo.readAllLines();
        List<String> clearlines=new ArrayList<>();///RECORRE LA LISTAS Y CORRE LAS QUE ESTEN OCUPADA
        for (String line: listoriginal){
            if(line!=null && !line.isBlank()){
clearlines.add(line);///la linea esta buena, no es null ni esta en blanco
            }
        }
        /// cambiar el registro:
        clearlines.set(index,name+","+email+","+edad );
        /// para guardar:
        repo.saveFile(clearlines);///sustituye la info del archivo dejandolo actualizado
    }///para actualizar id para saber cual se substitute

    public void addPerson(String name, String email, String edad) throws IOException {
        repo.addNewLine(name+","+email+","+edad);
    }
    private void validate(String name, String email, String edad){


    }


    public void delatePerson(int index) throws IOException {
        List<String> listoriginal=repo.readAllLines();
        List<String> clearlines=new ArrayList<>();
        for (String line: listoriginal){
            if(line!=null && !line.isBlank()){
                clearlines.add(line);
            }
        }
        /// cambiar el registro:
        clearlines.remove(index);
        /// para guardar:
        repo.saveFile(clearlines);///sustituye la info del archivo dejandolo actualizado
    }


}
