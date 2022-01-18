package com.revature;

import com.revature.controllers.*;
import com.revature.controllers.RegisterController;
import io.javalin.Javalin;

public class Driver {

    private static Javalin driver;

    public static void main(String[] args) {
        driver = Javalin.create();


        configure(new RegisterController(), (new LoginController()
        ));


        driver.start();
    }

    public static void configure(RegisterController registerController, Controller... controllers) {

        for (Controller c: controllers){
            c.addRoutes(driver);
        }
    }
}
