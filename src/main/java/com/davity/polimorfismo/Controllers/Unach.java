package com.davity.polimorfismo.Controllers;

import com.davity.polimorfismo.App;
import com.davity.polimorfismo.Models.Universidad;
import com.davity.polimorfismo.Models.interfaceStudent;
import com.davity.polimorfismo.Models.student;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

public class Unach implements interfaceStudent {

    @FXML
    private Button btnPolitecnica;

    @FXML
    private Button btnUnach;

    @FXML
    private Button btnUnam;

    @FXML
    private Button buttonRegresar;

    @FXML
    private TableColumn<student, String> columnaEdad;

    @FXML
    private TableColumn<student, String> columnaMatricula;

    @FXML
    private TableColumn<student, String> columnaNombre;

    @FXML
    private TableView<student> tablaEstudiantes;

    @FXML
    private TextField txtEdad;

    @FXML
    private TextField txtMatricula;

    @FXML
    private TextField txtNombre;

    @Override
    public void initialize() {
        tablaEstudiantes.setItems(Universidad.getEstudiantes());
        columnaNombre.setCellValueFactory(new PropertyValueFactory<>("name"));
        columnaEdad.setCellValueFactory(new PropertyValueFactory<>("edad"));
        columnaMatricula.setCellValueFactory(new PropertyValueFactory<>("matricula"));

        txtEdad.textProperty().addListener((observable, oldValue, newValue) -> {

            if (!newValue.matches("\\d*")|| "0".equals(newValue)) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText(null);
                alert.setHeaderText("Texto invalido");
                alert.setContentText("Solo puedes ingresar números en la cantidad\n intente nuevamente");
                alert.showAndWait();
                txtEdad.setText(oldValue);
            }
        });
    }

    @FXML
    void onClickAgregar(MouseEvent event) {
        save();
    }

    @FXML
    void onClickActualizar(MouseEvent event) {
        update();
    }

    @FXML
    void onClickRegresar(MouseEvent event) {

    }

    @FXML
    void onClickTablaEstudiantes(MouseEvent event) {
        student seleccionar = this.tablaEstudiantes.getSelectionModel().getSelectedItem();
        if(seleccionar != null){
            this.txtNombre.setText(seleccionar.getName());
            this.txtEdad.setText(String.valueOf(seleccionar.getEdad()));
            this.txtMatricula.setText(seleccionar.getMatricula());
        }
    }
    //FUNCION SAVE
    public void save(){
        student estudiante = new student(txtNombre.getText(), Integer.parseInt(txtEdad.getText()), txtMatricula.getText());
        Universidad.addEstudiante(estudiante);
        tablaEstudiantes.refresh();
        txtNombre.clear();
        txtEdad.clear();
        txtMatricula.clear();
    }


    //FUNCION UPDATE
    public void update(){
        student seleccionar = this.tablaEstudiantes.getSelectionModel().getSelectedItem();

        if(seleccionar == null){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Advertencia");
            alert.setHeaderText(null);
            alert.setContentText("Por favor seleccione a un estudiante");
            alert.showAndWait();
        }else {
            seleccionar.setName(txtNombre.getText());
            seleccionar.setEdad(Integer.parseInt(txtEdad.getText()));
            seleccionar.setMatricula(txtMatricula.getText());
            tablaEstudiantes.refresh();
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Advertencia");
            alert.setHeaderText(null);
            alert.setContentText("Estudiante actualizado");
            alert.showAndWait();
        }
    }

    @FXML
    void onClickPolitecnica(MouseEvent event) {
        App.newStage("Alumnos","TABLA POLITECNICA");
    }

    @FXML
    void onClickUnach(MouseEvent event) {

    }

    @FXML
    void onClickUnam(MouseEvent event) {

    }

}
