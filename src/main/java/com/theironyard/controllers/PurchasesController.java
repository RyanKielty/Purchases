package com.theironyard.controllers;

import com.theironyard.entities.Customer;
import com.theironyard.entities.Purchase;
import com.theironyard.services.CustomerRepository;
import com.theironyard.services.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.PostConstruct;
import java.io.File;
import java.util.List;
import java.util.Scanner;

/**
 * Created by ryankielty on 1/21/17.
 */
@Controller
public class PurchasesController {
    @Autowired
    CustomerRepository customers;

    @Autowired
    PurchaseRepository purchases;

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String home(Model model, String category) {
        List<Purchase> purchaseList;
        if (category != null) {
            purchaseList = purchases.findByCategory(category);
        } else {
            purchaseList = (List<Purchase>) purchases.findAll();
        }
        model.addAttribute("purchases", purchaseList);
        return "home";
    }

    @PostConstruct
    public void init() throws Exception {
        if (customers.count() == 0) {
            File customersFile = new File("customers.csv");
            Scanner customersScanner = new Scanner(customersFile);
            while (customersScanner.hasNext()) {
                String line = customersScanner.nextLine();
                String[] customersColumns = line.split(",");
                Customer customer = new Customer(customersColumns[0], customersColumns[1]);
                customers.save(customer);
            }
        }
        if (purchases.count() == 0) {
            File purchasesFile = new File("purchases.csv");
            Scanner purchasesScanner = new Scanner(purchasesFile);
            while (purchasesScanner.hasNext()) {
                String line = purchasesScanner.nextLine();
                String[] purchasesColumns = line.split(",");
                Purchase purchase = new Purchase(purchasesColumns[1], purchasesColumns[2], purchasesColumns[3], purchasesColumns[4]);
                purchase.setCustomer(customers.findOne(Integer.parseInt(purchasesColumns[0])));
                purchases.save(purchase);
            }
        }

    }
}
