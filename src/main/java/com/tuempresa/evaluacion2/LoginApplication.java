package com.tuempresa.evaluacion2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(com.tuempresa.evaluacion2.HelloApplication.class.getResource("inicio-sesion.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 570, 400);
        stage.setTitle("Inicio de Sesión");
        stage.setScene(scene);
        stage.show();
    }
}
