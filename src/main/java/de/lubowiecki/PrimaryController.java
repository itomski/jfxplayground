package de.lubowiecki;

import java.util.ArrayList;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class PrimaryController {

    private final Repository<Person> repo = new PersonRepository();

    @FXML // Element wird sichtbar für FXML
    TextField vorname;

    @FXML
    TextField nachname;

    @FXML
    DatePicker geburtsDatum;

    @FXML
    TextArea ausgabe;

    @FXML
    TextField testFeld;

    @FXML
    private void checkSpace(KeyEvent event) {
        System.out.println(event.getCode());
        if(event.getCode() == KeyCode.SPACE) {
            String text = testFeld.getText().toUpperCase();
            testFeld.setText(text);
        }
    }

    @FXML
    private void speichern() {

        // FXCollections.observableList(list)

        Person person = new Person();
        person.setVorname(vorname.getText());
        person.setNachname(nachname.getText());
        person.setGeburtsDatum(geburtsDatum.getValue());
        repo.add(person);

        // TODO: Eingabe Validieren
        updateAusgabe();
        formularLeeren();
    }

    private void formularLeeren() {
        vorname.clear();
        nachname.clear();
        geburtsDatum.getEditor().clear();
        geburtsDatum.setValue(null);
    }

    private void updateAusgabe() {
        StringBuilder sb = new StringBuilder();
        for(Person p : repo.getAll()) {
            sb.append(p);
        }
        ausgabe.setText(sb.toString());
    }
}
