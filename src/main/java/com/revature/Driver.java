package com.revature;

import com.revature.controllers.*;
import io.javalin.Javalin;

public class Driver {

    private static Javalin driver;

    public static void main(String[] args) {
        driver = Javalin.create();


        configure(new LoginController(), new AccountController(), new BankController());


        driver.start();
    }

    public static void configure(Controller... controllers) {

        for (Controller c: controllers){
            c.addRoutes(driver);
        }
    }
}
