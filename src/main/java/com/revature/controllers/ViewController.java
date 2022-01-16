package com.revature.controllers;

import com.revature.models.View;
import com.revature.services.ViewService;
import io.javalin.Javalin;
import io.javalin.http.Handler;

import java.util.List;

public class ViewController implements Controller {

    private ViewService viewService = new ViewService();

    private Handler showChecking = (ctx) ->{
        List<View> list = viewService.listCheckingAccount();

        ctx.json(list);
        ctx.status(200);
    };


    @Override
    public void addRoutes(Javalin app) {
        app.get("/view", showChecking);
    }
}

