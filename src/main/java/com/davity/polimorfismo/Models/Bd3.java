package com.davity.polimorfismo.Models;

import java.util.ArrayList;

public class Bd3 implements interfaceStudent{

    ArrayList<Student> baseDato3 = new ArrayList<>();
    @Override
    public void save(Student student) {
        baseDato3.add(student);
        System.out.println(student);
    }
    @Override
    public void update(Student student) {
        for(Student s: baseDato3){
            if(s.getMatricula() == s.getMatricula()){
                s.setName(student.getName());
                s.setEdad(student.getEdad());
            }
        }
    }
}
