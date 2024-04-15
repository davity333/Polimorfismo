package com.davity.polimorfismo;

import com.davity.polimorfismo.Controllers.Politecnia;
import com.davity.polimorfismo.Models.student;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.kordamp.bootstrapfx.BootstrapFX;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class App extends Application {
    private static Stage stageView;
    private static Stage stageRoot;

    private ObservableList<student> EstudiantesUnam = FXCollections.observableArrayList();
    private  ObservableList<student> EstudiantesPolitecnica = FXCollections.observableArrayList();
    public ObservableList<student> getEstudiantesPolitecnica() {
        return EstudiantesPolitecnica;
    }

    public void addEstudiantePolitecnica(student studiante){
        EstudiantesPolitecnica.add(studiante);
    }

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("Alumnos.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
        stage.setResizable(false);

    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void newStage(String fxml, String title) {
        stageView = new Stage();
        Scene scene = null;

        try {
            scene = new Scene(loadFXML(fxml));
            scene.getStylesheets().add(BootstrapFX.bootstrapFXStylesheet());
            stageView.setTitle(title);
            stageView.setScene(scene);
            stageView.centerOnScreen();
            stageView.initOwner(stageRoot);
            stageView.initModality(Modality.APPLICATION_MODAL);
            stageView.showAndWait();
        } catch (IOException ex) {
            //throw new RuntimeException(e);
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void main(String[] args) {
        launch();
        System.out.println("hola mundo");
    }
}