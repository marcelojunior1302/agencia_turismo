module br.edu.univasf.agencia_turismo {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;
    requires java.sql;

    opens br.edu.univasf.agencia_turismo to javafx.fxml;
    exports br.edu.univasf.agencia_turismo;

    opens br.edu.univasf.agencia_turismo.controller to javafx.fxml;
    exports br.edu.univasf.agencia_turismo.controller;

    opens br.edu.univasf.agencia_turismo.model;

}