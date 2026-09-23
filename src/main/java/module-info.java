module com.tuempresa.evaluacion2 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.tuempresa.evaluacion2 to javafx.fxml;
    exports com.tuempresa.evaluacion2;
}