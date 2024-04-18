module com.davity.polimorfismo {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;
    requires java.sql;

    opens com.davity.polimorfismo to javafx.fxml;
    opens com.davity.polimorfismo.Models;   //PA IMPRIMIR LOS DATOS EN LA TABLA
    exports com.davity.polimorfismo;
    exports com.davity.polimorfismo.Controllers;
    opens com.davity.polimorfismo.Controllers to javafx.fxml;
}