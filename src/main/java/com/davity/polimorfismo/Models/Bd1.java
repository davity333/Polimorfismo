package com.davity.polimorfismo.Models;

import javafx.collections.ObservableList;

import java.util.ArrayList;

public class Bd1 implements interfaceStudent{
    ArrayList<Student> baseDato1 = new ArrayList<>();

    @Override
    public void save(Student student) {
        baseDato1.add(student);
        System.out.println(student);
    }
    @Override
    public void update(Student student) {
        for(Student s: baseDato1){
            if(s.getMatricula() == s.getMatricula()){
                s.setName(student.getName());
                s.setEdad(student.getEdad());
            }
        }
    }
}

