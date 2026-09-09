module com.example.aula3exercicio4 {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.example.aula3exercicio4.Controller to javafx.fxml;

    exports com.example.aula3exercicio4.Controller;
    exports com.example.aula3exercicio4.Model;
}