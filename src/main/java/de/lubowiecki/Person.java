package de.lubowiecki;

import java.time.LocalDate;

public class Person implements Entity {

    private String vorname;
    private String nachname;
    private LocalDate geburtsDatum;

    public Person() {
    }

    public String getVorname() {
        return vorname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public String getNachname() {
        return nachname;
    }

    public void setNachname(String nachname) {
        this.nachname = nachname;
    }

    public LocalDate getGeburtsDatum() {
        return geburtsDatum;
    }

    public void setGeburtsDatum(LocalDate geburtsDatum) {
        this.geburtsDatum = geburtsDatum;
    }

    @Override
    public String toString() {
        return new StringBuilder(vorname).append(" ")
                        .append(nachname).append(", ")
                        .append(geburtsDatum.format(FormatHelper.DATE_FMT)).append("\n")
                        .toString();
    }
}
