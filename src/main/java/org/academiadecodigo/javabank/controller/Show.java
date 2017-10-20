package org.academiadecodigo.javabank.controller;

import org.academiadecodigo.javabank.model.Customer;
import org.academiadecodigo.javabank.model.account.Account;
import org.academiadecodigo.javabank.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class Show {

    @Autowired
    private CustomerService customerService;

    @RequestMapping(method = RequestMethod.GET, path ="customer/{id}")
    public String showCustomer(@PathVariable Integer id, Model model){

        Customer customer = customerService.findById(id);

        model.addAttribute("customer", customer);

        List<Account> accounts = customerService.getAccounts(id);

        model.addAttribute("accounts", accounts);

        return "idcostumer-view";

    }

    @RequestMapping(method = RequestMethod.GET, path ="customer/delete/{id}")
    public String deleteCustomer(@PathVariable Integer id, Model model){

        customerService.delete(id);

        return "redirect:/customer";

    }
}