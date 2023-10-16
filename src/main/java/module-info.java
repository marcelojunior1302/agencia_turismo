module br.edu.univasf.agencia_turismo {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;

    opens br.edu.univasf.agencia_turismo to javafx.fxml;
    exports br.edu.univasf.agencia_turismo;
}