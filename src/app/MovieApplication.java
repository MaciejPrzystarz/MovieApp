package app;


import controller.ApplicationController;

public class MovieApplication {
    public static void main(String[] args) {

        ApplicationController applicationController = new ApplicationController();
        applicationController.mainLoop();

    }
}