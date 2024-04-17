package com.davity.polimorfismo.Models;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.List;

public class Universidad {
    public static List<interfaceStudent> BasedeDatos;
    public static void addStudent(Student student){
        for(interfaceStudent BD: BasedeDatos){
            BD.save(student);
        }
    }

    public static void updateStudent(Student student){
        for(interfaceStudent BD: BasedeDatos){
            BD.update(student);
        }
    }

    public static ArrayList<Student> ListaLectura(int index){
        interfaceStudent interfaze = BasedeDatos.get(index);
        if(interfaze instanceof Bd1){ //SI INTERFAZ ES UNA INSTANCIA DE Bd1
            Bd1 db1 = (Bd1) interfaze;  //LA INTERFAZ SE CONVIERTE EN UN TIPO Bd1
            return db1.baseDato1;

        }else if(interfaze instanceof Bd2) { //SI INTERFAZ ES UNA INSTANCIA DE Bd1
            Bd2 db2 = (Bd2) interfaze;
            return db2.baseDato2;

        }else{                               //SI INTERFAZ ES UNA INSTANCIA DE Bd1
            Bd3 db3 = (Bd3) interfaze;
            return db3.baseDato3;
        }
        //Esta técnica se conoce como "casting", y se utiliza cuando
        // se necesita acceder a los métodos o propiedades específicas
        // de una clase que implementa una interfaz genérica.
    }

    public static void inizialite(){ //CREA LAS BASES DE DATOS
        BasedeDatos = new ArrayList<>();

        Bd1 base1 = new Bd1();
        Bd2 base2 = new Bd2();
        Bd3 base3 = new Bd3();

        BasedeDatos.add(base1); //AGREGA EL OBJETO A LA LISTA
        BasedeDatos.add(base2);
        BasedeDatos.add(base3);
    }


}

