package co.istad.mvcapp.controller;

import co.istad.mvcapp.view.WelcomeView;

public class IndexController {
    public void handleIndex() {
        new WelcomeView().render();
    }
}
