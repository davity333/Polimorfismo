package com.davity.polimorfismo.Controllers;

import com.davity.polimorfismo.App;
import com.davity.polimorfismo.Models.Bd1;
import com.davity.polimorfismo.Models.Bd2;
import com.davity.polimorfismo.Models.Student;
import com.davity.polimorfismo.Models.Universidad;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

public class Politecnia {
    @FXML
    private Button btnActualizar;

    @FXML
    private Button btnAgregar;

    @FXML
    private Button btnUnach;

    @FXML
    private Button btnUnam;
    @FXML
    private TableColumn<Student, Integer> columnaEdad;

    @FXML
    private TableColumn<Student, String> columnaMatricula;

    @FXML
    private TableColumn<Student, String> columnaNombre;

    @FXML
    private TableView<Student> tablaEstudiantes;

    @FXML
    private TextField txtEdad;

    @FXML
    private TextField txtMatricula;

    @FXML
    private TextField txtNombre;

    @FXML
    void onClickActualizar(MouseEvent event) {
        String name = txtNombre.getText();
        int edad = Integer.parseInt(txtEdad.getText());
        String matricula = txtMatricula.getText();

        Student student = new Student(name,edad,matricula);
        Universidad.updateStudent(student);

        //tablaEstudiantes.getItems().add(student);
        actualizartable();
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Advertencia");
        alert.setHeaderText(null);
        alert.setContentText("Estudiante actualizado");
        alert.showAndWait();
    }

    @FXML
    void onClickAgregar(MouseEvent event) {
        String name = txtNombre.getText();
        int edad = Integer.parseInt(txtEdad.getText());
        String matricula = txtMatricula.getText();

        Student student = new Student(name,edad,matricula);
        Universidad.addStudent(student);

        actualizartable();
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Advertencia");
        alert.setHeaderText(null);
        alert.setContentText("Estudiante agregado");
        alert.showAndWait();
    }

        public void actualizartable(){ //HACER BOTON PARA ACTUALIZAR CUANDO AGREUE DATOS DESDE OTRA VENTANA


            tablaEstudiantes.getItems().setAll(Universidad.ListaLectura(0));
        }

    @FXML
    void onClickTablaEstudiantes(MouseEvent event) {
    }

    public void initialize(){
       // System.out.println("mira ese wey");

        columnaNombre.setCellValueFactory(new PropertyValueFactory<>("name"));
        columnaEdad.setCellValueFactory(new PropertyValueFactory<>("edad"));
        columnaMatricula.setCellValueFactory(new PropertyValueFactory<>("matricula"));

        tablaEstudiantes.getItems().setAll(Universidad.ListaLectura(0));
    }

    @FXML
    void onClickUnach(MouseEvent event) {
        App.newStage("Unach","ALUMNOS DE LA UNCHA");
    }


    @FXML
    void onClickUnam(MouseEvent event) {
        App.newStage("Unam","ESTUDIANTES UNAM");
    }

    public void onClickPolitecnica(MouseEvent mouseEvent) {
    }
}

