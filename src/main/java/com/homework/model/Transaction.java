package com.homework.model;

import java.util.Objects;

public class Transaction {
    long id;
    User user;

    long amount;

    public Transaction(long id, User user, long amount) {
        this.id = id;
        this.user = user;
        this.amount = amount;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
        Transaction that = (Transaction) o;
        return id == that.id && amount == that.amount && Objects.equals(user, that.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, user, amount);
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", user=" + user +
                ", amount=" + amount +
                '}';
    }
}
