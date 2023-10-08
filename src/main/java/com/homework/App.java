package com.homework;

import com.homework.model.Account;
import com.homework.model.Transaction;
import com.homework.model.User;

import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Optional;
import java.util.Scanner;
import java.util.Set;

public class App {

    public static void main(String[] args) {
        User currentUser = null;
        Set<User> userList = new HashSet<>();
        Set<Account> accountSet = new HashSet<>();
        Set<Transaction> transactionSet = new HashSet<>();
        Account currentAccount = null;
        Scanner sc = new Scanner(System.in);


        //Блок пользователь
        if (currentUser == null) {
            //авторизация игрока
            System.out.println("Введите логин:");
            String login = sc.next();

           try {
               currentUser = userList.stream()
                       .filter(s -> s.getLogin().equals(login))
                       .findAny()
                       .get();
           }
           catch (Exception e){

           }

            if (currentUser == null) {
                //регистрация игрока
                System.out.println("Пользователь не найден. Введите пароль для регистрации");
                String password = sc.next();
                User newUser = new User(login, password);
                userList.add(newUser);
                currentUser = newUser;
                Account newAccount = new Account(newUser, 0);
                accountSet.add(newAccount);
                currentAccount = newAccount;
            } else if (currentUser != null) {
                //авторизация пользователя
                System.out.println("Введите пароль для авторизации");
                String password = sc.next();
                if (currentUser.getLogin().equals(password)) {
                    //авторизация прошла успешно
                } else {
                    //авторизация не прошла
                    System.out.println("Введен неверный пароль");
                }
            }
        }

        //Блок счетов
        final User finalCurrentUser = currentUser;
        if (currentAccount == null) {
            try{
            currentAccount = accountSet.stream()
                    .filter(x -> x.getUser().equals(finalCurrentUser))
                    .findFirst()
                    .get();}
            catch (Exception e){

            }
        }
        if (currentAccount == null) {
            currentAccount = new Account(currentUser, 0);
        }

        //Блок транзакций
        workingWithCommands(currentUser, currentAccount, transactionSet);
    }

    public static void workingWithCommands(User currentUser, Account currentAccount, Set<Transaction> transactionSet){
        boolean exit = false;
        while (!exit) {
        System.out.println("список операций: 1-дебет, 2-кредит, 3- текущий баланс, 4-выход");
        Scanner sc = new Scanner(System.in);
        int operation = sc.nextInt();

            switch (operation) {
                case 1: //дебет
                    System.out.println("Введите идентификатор транзации");
                    Long id = sc.nextLong();
                    //проверка на уникальность id
                    try {
                        Transaction tr = transactionSet.stream()
                                .filter(x -> x.getId() == id)
                                .findFirst()
                                .get();

                        if (tr != null) {
                            //ошибка!!!
                            System.out.println("Не уникальный идентификатор транзакции");
                            break;
                        }
                    } catch (Exception e){

                    }

                        System.out.println("Введите сумму");
                        int sum = sc.nextInt();
                        if (currentAccount.getAmount() < sum) {
                            System.out.println("Не достаточно средств на счете");
                        } else {
                            Transaction transaction = new Transaction(id, currentUser, sum);
                            transactionSet.add(transaction);
                            currentAccount.setAmount(currentAccount.getAmount() - sum);
                        }

                    break;
                case 2://кредит
                    System.out.println("Введите идентификатор транзации");
                    Long idCredit = sc.nextLong();
                    //проверка на уникальность id
                    try {
                        Transaction trCredit = transactionSet.stream()
                                .filter(x -> x.getId() == idCredit)
                                .findFirst()
                                .get();
                        if (trCredit != null) {
                            //ошибка!!!
                            System.out.println("Не уникальный идентификатор транзакции");
                            break;
                        }
                    }
                    catch (Exception e){

                    }

                        System.out.println("Введите сумму");
                        int sumCredit = sc.nextInt();

                        Transaction transaction = new Transaction(idCredit, currentUser, sumCredit);
                        transactionSet.add(transaction);
                        currentAccount.setAmount(currentAccount.getAmount() + sumCredit);

                    break;
                case 3://текущий баланс
                    System.out.println("Текущий баланс - " + currentAccount.getAmount());
                    break;
                case 4://выход
                    exit = true;
                    break;
            }
        }
    }
}
