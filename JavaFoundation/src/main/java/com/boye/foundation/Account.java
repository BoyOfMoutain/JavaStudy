package com.boye.foundation;

import java.io.Serializable;

public class Account implements Serializable {
    private static final long serialVersionUID = -5359078591563986851L;
    private int acct;

    public Account() {
    }

    public Account(int acct) {
        this.acct = acct;
    }

    public int getAcct() {
        return acct;
    }

    public void setAcct(int acct) {
        this.acct = acct;
    }

    @Override
    public String toString() {
        return "Account{" +
                "acct=" + acct +
                '}';
    }
}
