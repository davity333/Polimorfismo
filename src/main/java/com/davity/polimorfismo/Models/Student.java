package com.davity.polimorfismo.Models;

public class Student{

    private String name;
    private int edad;
    private String matricula;

    public Student(String name, int edad, String matricula) {
        this.name = name;
        this.edad = edad;
        this.matricula = matricula;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    @Override
    public String toString() {
        return "name='" + name + '\'' +
                ", edad='" + edad + '\''+
                ", matricula='" + matricula + '\'';
    }
}
