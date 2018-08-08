package model;

/**
 * Das Model ist komplett unabhängig von den anderen
 * Klassen und weiß nicht, was um es herum geschieht.
 * Es ist völlig egal ob man dieses Model aus einem
 * Fenster oder einer Konsolen Eingabe verwendet -
 * beides würde funktionieren.
 */
public class MainModel {

    private String text = "Hallo Welt!";

    public void reset() {
        this.text = "";
    }

    public String getText() {
        return this.text;
    }
}