package com.theironyard.controllers;

import com.theironyard.entities.Purchase;
import com.theironyard.services.CustomerRepository;
import com.theironyard.services.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.PostConstruct;
import java.util.List;

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
    public String home(Model model, String category, String creditCard) {
        List<Purchase> purchaseList;
        if()

        model.addAttribute("customers", customers);
        model.addAttribute("purchases", purchases);
        return "home";
    }

    @PostConstruct
    public void init() {

    }
}
