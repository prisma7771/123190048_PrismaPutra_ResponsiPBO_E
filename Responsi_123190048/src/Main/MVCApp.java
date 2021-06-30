package Main;

import View.ViewApp;
import Model.ModelApp;
import Controller.ControllerApp;

public class MVCApp {
    ViewApp va = new ViewApp();
    ModelApp model = new ModelApp();
    ControllerApp control = new ControllerApp(va,model,"",0.0,0.0,0.0,0.0);
}
