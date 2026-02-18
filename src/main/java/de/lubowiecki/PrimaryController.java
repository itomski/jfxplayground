package de.lubowiecki;

import java.util.ArrayList;
import java.util.List;

import javafx.fxml.FXML;
import javafx.scene.control.*;

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
    private void speichern() {
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
