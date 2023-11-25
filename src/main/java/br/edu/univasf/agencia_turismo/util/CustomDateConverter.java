package br.edu.univasf.agencia_turismo.util;

import javafx.util.StringConverter;
import java.text.SimpleDateFormat;
import java.sql.Date;

public class CustomDateConverter extends StringConverter<Date> {
    private final SimpleDateFormat dateFormatter = new SimpleDateFormat("dd-MM-yyyy");

    @Override
    public String toString(Date date) {
        if (date != null) {
            return dateFormatter.format(date);
        } else {
            return "";
        }
    }

    @Override
    public Date fromString(String string) {
        try {
            if (string != null && !string.isEmpty()) {
                java.util.Date utilDate = dateFormatter.parse(string);
                return new Date(utilDate.getTime());
            }
        } catch (Exception e) {
            e.printStackTrace(); // Tratar exceções, se necessário
        }
        return null;
    }
}
