package com.homework.model;

import java.util.Objects;

public class Account {
    User user;
    long amount;

    public Account(User user, long amount) {
        this.user = user;
        this.amount = amount;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return amount == account.amount && Objects.equals(user, account.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user, amount);
    }

    @Override
    public String toString() {
        return "Account{" +
                "user=" + user +
                ", amount=" + amount +
                '}';
    }
}
