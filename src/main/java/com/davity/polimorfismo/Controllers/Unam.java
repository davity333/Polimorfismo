package com.davity.polimorfismo.Controllers;

import com.davity.polimorfismo.App;
import com.davity.polimorfismo.Models.Universidad;
import com.davity.polimorfismo.Models.interfaceStudent;
import com.davity.polimorfismo.Models.Student;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

public class Unam  {

    @FXML
    private Button btnPolitecnica;

    @FXML
    private Button btnUnach;

    @FXML
    private Button btnUnam;

    @FXML
    private TableColumn<Student, String> columnaEdad;

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

        //tablaEstudiantes.getItems().add(student);
        actualizartable();
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Advertencia");
        alert.setHeaderText(null);
        alert.setContentText("Estudiante agregado");
        alert.showAndWait();
    }

    public void actualizartable(){
        tablaEstudiantes.getItems().setAll(Universidad.ListaLectura(0));
    }

    @FXML
    void onClickPolitecnica(MouseEvent event) {
        App.newStage("Alumnos","TABLA POLITECNICA");
    }

    @FXML
    void onClickTablaEstudiantes(MouseEvent event) {
        Student seleccionar = this.tablaEstudiantes.getSelectionModel().getSelectedItem();
        if(seleccionar != null){
            this.txtNombre.setText(seleccionar.getName());
            this.txtEdad.setText(String.valueOf(seleccionar.getEdad()));
            this.txtMatricula.setText(seleccionar.getMatricula());
        }
    }

    public void initialize(){
        System.out.println("mira ese wey");

        columnaNombre.setCellValueFactory(new PropertyValueFactory<>("name"));
        columnaEdad.setCellValueFactory(new PropertyValueFactory<>("edad"));
        columnaMatricula.setCellValueFactory(new PropertyValueFactory<>("matricula"));

        tablaEstudiantes.getItems().setAll(Universidad.ListaLectura(2));
    }

    @FXML
    void onClickUnach(MouseEvent event) {
            App.newStage("Unach","TABLA ESTUDIANTES UNACH");
    }

    @FXML
    void onClickUnam(MouseEvent event) {

    }




}

