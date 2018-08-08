package controller;

import model.MainModel;
import view.View;


/**
 * Der Controller muss die View und das Model kennen da dieser für die Kommunikation zwischen beiden sorgt
 */
public class MainController {

    private View view;
    private MainModel mainModel;

    public MainController(View view){
        this.view = view;
        this.mainModel = new MainModel();
    }
}