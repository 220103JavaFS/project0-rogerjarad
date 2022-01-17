package com.revature.controllers;

import io.javalin.Javalin;
import io.javalin.http.Handler;
import com.revature.models.Login;
import com.revature.services.RegisterService;


public class RegisterController extends Controller{

    private RegisterService service = new RegisterService();

    public RegisterController(){};

    private Handler register = (ctx) -> {
        Login login = ctx.bodyAsClass(Login.class);
        if(service.register(login)) {
            ctx.status(200);

        }else {
            ctx.status(400)
        }
    };
    @Override
    public void addRoutes(Javalin app) {
        app.post("/register", register, Role.MANAGER, Role.EMPLYEE);
    }
}
