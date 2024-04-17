package com.davity.polimorfismo.Models;

import java.util.ArrayList;

public class Bd2 implements interfaceStudent{

    ArrayList<Student> baseDato2 = new ArrayList<>();
    @Override
    public void save(Student student) {
        baseDato2.add(student);
        System.out.println(student);
    }
    @Override
    public void update(Student student) {
        for(Student s: baseDato2){
            if(s.getMatricula() == s.getMatricula()){
                s.setName(student.getName());
                s.setEdad(student.getEdad());
            }
        }
    }
}
