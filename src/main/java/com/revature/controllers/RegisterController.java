package com.revature.controllers;
import com.revature.services.RegisterService;
import com.revature.models.People;
import io.javalin.Javalin;
import io.javalin.http.Handler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RegisterController {
    private final Logger log = LoggerFactory.getLogger(RegisterController.class);

    private RegisterService registerService = new RegisterService();
    public RegisterController(){}

    private Handler register = (ctx) -> {
        People people = ctx.bodyAsClass(People.class);
        if(registerService.register(people)) {
            ctx.status(200);

        }else{
            ctx.status(400);
        }
    };
    public void addRoutes(Javalin app) {
        app.post("/register", register, Role.Manager, Role.Employee); //Role.MANAGER, Role.EMPLOYEE
    }
}
