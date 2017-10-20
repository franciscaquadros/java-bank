package org.academiadecodigo.javabank.model;

import org.academiadecodigo.javabank.model.account.Account;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Customer extends AbstractModel {

    private String name;
    private String email;
    private String phone;

    @OneToMany(
            // propagate changes on customer entity to account entities
            cascade = {CascadeType.ALL},

            // make sure to remove accounts if unlinked from customer
            orphanRemoval = true,

            // user customer foreign key on account table to establish
            // the many-to-one relationship instead of a join table
            mappedBy = "customer",

            // fetch accounts from database together with user
            fetch = FetchType.EAGER
    )
    private List<Account> accounts = new ArrayList<>();

    @ModelAttribute
    public String getName() {
        return name;
    }
    @ModelAttribute
    public void setName(String name) {
        this.name = name;
    }
    @ModelAttribute
    public String getEmail() {
        return email;
    }
    @ModelAttribute
    public String getPhone() {
        return phone;
    }
    @ModelAttribute
    public void setEmail(String email) {
        this.email = email;
    }
    @ModelAttribute
    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void addAccount(Account account) {
        accounts.add(account);
        account.setCustomer(this);
    }

    public void removeAccount(Account account) {
        accounts.remove(account);
        account.setCustomer(null);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", accounts=" + accounts +
                "} " + super.toString();
    }
}


