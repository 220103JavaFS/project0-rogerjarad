package com.revature;

import com.revature.controllers.*;
//import com.revature.controllers.BankAccountController;
//import com.revature.controllers.LoginController;
import com.revature.models.View;
import io.javalin.Javalin;

public class Driver {

    private static Javalin driver;

    public static void main(String[] args) {
        driver = Javalin.create();

//        driver.get("/hello", ((ctx) -> {
//            String url = ctx.url();
//            System.out.println(url);
//            ctx.html("<h1> Hello Javalin </h1>");
//            ctx.status(200);
//        }));
        configure(new BankAccountController());
        configure(new LoginController());
        configure(new CustomerController());
        configure(new ViewController());
        driver.start();
    }

    public static void configure(Controller... controllers){

        for (Controller c: controllers){
            c.addRoutes(driver);
        }
    }
}
