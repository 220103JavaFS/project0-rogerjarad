package com.revature.controllers;

import com.revature.services.BankAccountService;
import io.javalin.Javalin;
import io.javalin.http.Handler;


public class BankAccountController implements Controller{

    private BankAccountService bankAccountService = new BankAccountService();
    Handler getBankAccounts = (ctx) ->{
        if(ctx.req.getSession(false) != null) {
            ctx.json(bankAccountService.findAllAccounts());
            ctx.status(200);
        }else {
            ctx.status(401);
        }
    };

    @Override
    public void addRoutes(Javalin app) {
        app.get("/Accounts", getBankAccounts);
    }
}
