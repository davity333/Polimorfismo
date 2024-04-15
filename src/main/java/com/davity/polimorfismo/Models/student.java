package com.davity.polimorfismo.Models;

public class student implements interfaceStudent{

    private String name;
    private int edad;
    private String matricula;

    public student(String name, int edad, String matricula) {
        this.name = name;
        this.edad = edad;
        this.matricula = matricula;
    }
    public student() {
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
    public void initialize() {

    }

    @Override
    public void save() {

    }

    @Override
    public void update() {

    }
}
