package com.davity.polimorfismo.Models;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Universidad {
    private static ObservableList<student> EstudiantesPolitecnica = FXCollections.observableArrayList();
   //POLITECNICA
   public static ObservableList<student> getEstudiantes() {
        return EstudiantesPolitecnica;
    }

    public static void addEstudiante(student studiante){
        EstudiantesPolitecnica.add(studiante);
    }


}
