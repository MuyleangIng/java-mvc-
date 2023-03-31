package co.istad.mvcapp;

import co.istad.mvcapp.controller.IndexController;

public class MainApplication {

    public static void main(String[] args) {

        // Create reference or object or dependency
        IndexController indexController = new IndexController();

        // Invoke handle index to render the welcome view
        indexController.handleIndex();

    }
}
