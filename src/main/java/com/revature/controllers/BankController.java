package com.revature.controllers;
import com.revature.models.TradeDTO;
import com.revature.services.BankService;
import io.javalin.Javalin;
import io.javalin.http.Handler;
import com.revature.models.Bank;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BankController implements Controller{
    private final Logger log = LoggerFactory.getLogger(BankController.class);

    private BankService bankService = new BankService();



    Handler update = (ctx) ->{
        Bank bank = new Bank();

        bank = ctx.bodyAsClass(Bank.class);
        System.out.println(bank);

        if(ctx.req.getSession(false) != null) {
            ctx.json(bankService.update(bank));
            ctx.status(200);
        }else {
            ctx.status(401);
            ctx.html("<h1> UPDATED </h1>");
        }
    };

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
                ctx.html("<h1> ACCOUNT_ADDED </h1>");
                ctx.status(201);

            }else {
                ctx.status(400);
                ctx.html("<h1> BANK_ACCOUNT_ADDED </h1>");

            }

        }else {
            ctx.status(401);
        }
    };
    Handler withdrawBank = (ctx) -> {
        int accountnumber = 0;
        try{
            accountnumber = (Integer) ctx.req.getSession(false).getAttribute("account_number");

        }catch (ClassCastException e){
            e.printStackTrace();
            ctx.status(401);
            return;
        }
        TradeDTO tradeDTO = ctx.bodyAsClass(TradeDTO.class);
        tradeDTO.setSend(accountnumber);

        if (bankService.withdraw(tradeDTO)){
            ctx.html("<h1> WITHDRAW_COMPLETE </h1>");
            ctx.status(200);
        }else {
            ctx.status(400);
            ctx.html("<h1> WITHDRAW_COMPLETE </h1>");
        }


//        Bank bank = new Bank();
//        bank = ctx.bodyAsClass(Bank.class);
//
//        if(ctx.req.getSession(false) != null) {
//            double total = bankService.callId(bank.getAccountNumber()).getAccountBalance();
//            if(total >= bank.getAccountBalance()){
//                bank.setAccountBalance(total - bank.getAccountBalance());;
//                ctx.json(bankService.update(bank));
//                ctx.status(200);
//            }
//            else{
//                ctx.status(401);
//            }
//
//        }else{
//            ctx.status(402);
//        }

    };

    Handler depositBank = (ctx) -> {
        int accountnumber = 0;
        try{
            accountnumber = (Integer) ctx.req.getSession(false).getAttribute("account_number");

        }catch (ClassCastException e){
            e.printStackTrace();
            ctx.status(401);
            return;
        }
        TradeDTO tradeDTO = ctx.bodyAsClass(TradeDTO.class);
        tradeDTO.setSend(accountnumber);

        if (bankService.deposit(tradeDTO)){
            ctx.html("<h1> DEPOSIT_COMPLETE </h1>");
            ctx.status(200);
        }else {
            ctx.status(400);
            ctx.html("<h1> DEPOSIT_COMPLETE </h1>");
        }

    };
    private final Handler trade = (ctx) ->{

        TradeDTO tradeDTO = new TradeDTO();
        tradeDTO = ctx.bodyAsClass(TradeDTO.class);
        if(bankService.trade(tradeDTO)){
            ctx.status(200);
            ctx.html("<h1> TRADE_COMPLETE </h1>");
        }else{
            ctx.status(401);
            ctx.html("<h1> TRADE_COMPLETE </h1>");
        }

    };





    @Override
    public void addRoutes(Javalin app) {



        app.get("/bank/{account_number}", callId);
        app.post("/create", addBank);
        app.put("/update", update);
        app.post("/deposit", depositBank);
        app.put("/withdraw", withdrawBank);
        app.put("/trade", trade);

    }
}
