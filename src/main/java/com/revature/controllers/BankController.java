package com.revature.controllers;

import com.revature.services.BankService;
import io.javalin.Javalin;
import io.javalin.http.Handler;
import com.revature.models.Bank;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BankController implements Controller{
    private final Logger log = LoggerFactory.getLogger(BankController.class);

    private BankService bankService = new BankService();

//    private final Handler changeBank = ctx -> {
//        if(ctx.req.getSession(false)!=null){
//            Bank bank = ctx.bodyAsClass(Bank.class);
//            if(bankService.changeBank(bank)){
//                ctx.status(200);
//            }else {
//                ctx.status(400);
//            }
//
//
//        }else {
//            ctx.status(401);
//        }
//
//    };

    private final Handler callId = ctx -> {
        if (ctx.req.getSession(false) != null) {
            String idString = ctx.pathParam("account_number");
            int id = Integer.parseInt(idString);
            Bank bank = bankService.callId(id);
            ctx.json(bank);
            ctx.status(200);

        }else{
            ctx.status(400);
        }

    };
    private final Handler addBank = ctx -> {
        if (ctx.req.getSession(false) != null) {
            Bank bank = ctx.bodyAsClass(Bank.class);
            if(bankService.addBank(bank)){
                ctx.status(201);

            }else {
                ctx.status(400);

            }

        }else {
            ctx.status(401);
        }
    };
    private final Handler bankDeposit = ctx -> {
//        if (ctx.req.getSession(false) != null) {
//            String depositString = ctx.pathParam("account_balance");
//            int account_balance = Integer.parseInt(depositString);
//            Bank bank = bankService.bankDeposit(account_balance);
//            ctx.json(bank);
//            ctx.status(200);
//
//        }else{
//            ctx.status(400);
//        }

    };




    @Override
    public void addRoutes(Javalin app) {
      //  app.put("/bank", changeBank);
        app.get("/bank/{account_number}", callId);
        app.post("/create", addBank);
        app.put("/deposit", bankDeposit);

    }
}
