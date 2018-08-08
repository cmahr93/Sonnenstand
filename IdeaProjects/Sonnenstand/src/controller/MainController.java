package controller;

import model.MainModel;
import view.View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Der Controller muss die View und das Model kennen da dieser für die Kommunikation zwischen beiden sorgt
 */
public class MainController implements ActionListener {

    private View view;
    private MainModel mainModel;

    public MainController(View view){
        this.view = view;
        this.mainModel = new MainModel();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        view.setText(mainModel.getText());
    }
}