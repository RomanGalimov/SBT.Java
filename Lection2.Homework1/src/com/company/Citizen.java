package com.company;

import java.util.Random;

/**
 * Created by NecroS on 11/5/2016.
 */
public class Citizen {
    private final int BALANCELIMITH = 150000;
    private final int AGELIMITH = 100;
    private final int NAMECOUNT = 10;

    private String Name;
    private int age = 0;
    private boolean HasWork = false;
    private int balance = 0;
    private boolean home = true;

    private Random rnd = new Random();

    private String getRandomName() {
        String Name, Surname;
        switch (rnd.nextInt(NAMECOUNT)) {
            case 0:
                Name = "Amanda";
                break;
            case 1:
                Name = "Anastasia";
                break;
            case 2:
                Name = "Andrea";
                break;
            case 3:
                Name = "Beatrice";
                break;
            case 4:
                Name = "Becky";
                break;
            case 5:
                Name = "Baldwin";
                break;
            case 6:
                Name = "Abner";
                break;
            case 7:
                Name = "Eastone";
                break;
            case 8:
                Name = "Eric";
                break;
            case 9:
                Name = "Fairman";
                break;
            default:
                return "Jhon Doe";
        }

        switch (rnd.nextInt(NAMECOUNT)) {
            case 0:
                Surname = "Abrams";
                break;
            case 1:
                Surname = "Archer";
                break;
            case 2:
                Surname = "Armstrong";
                break;
            case 3:
                Surname = "Barlow";
                break;
            case 4:
                Surname = "Bishop";
                break;
            case 5:
                Surname = "Boone";
                break;
            case 6:
                Surname = "Carter";
                break;
            case 7:
                Surname = "Clayton";
                break;
            case 8:
                Surname = "Davis";
                break;
            case 9:
                Surname = "Edwards";
                break;
            default:
                return "";
        }
        return Name + " " + Surname;
    }

    public void GenerateRandomCitisen() {
        setName(getRandomName());
        setAge(rnd.nextInt(AGELIMITH));
        setBalance(rnd.nextInt(BALANCELIMITH));
        setHasWork(rnd.nextGaussian() <= 0.1 ? false : true);
        setHome(true);
    }

    @Override
    public String toString() {
        return String.format("%s возраст %d, %s %s", getName(), getAge(), isHasWork() ? "работает" : "безработынй", getBalance() != 0 ? ", баланс - " + String.valueOf(getBalance()) : "");
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        this.Name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age >= 0 && age <= AGELIMITH) {
            this.age = age;
        } else
            this.age = 0;

    }

    public boolean isHasWork() {
        return HasWork;
    }

    public void setHasWork(boolean hasWork) {
        if ((getAge() <= 10) || (getAge() > 80)) {
            this.HasWork = false;
        } else
            this.HasWork = hasWork;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {

        if (getAge() <= 10) {
            this.balance = 0;
        } else
            this.balance = balance;
    }

    public boolean isHome() {
        return home;
    }

    public void setHome(boolean home) {
        this.home = home;
    }

    Citizen() {
        GenerateRandomCitisen();
    }

    //NewBorn
    Citizen(String Name) {
        setName(Name + " Junior");
        setAge(0);
        setHasWork(false);
        setBalance(0);
        setHome(true);
    }

    Citizen(String Name, int Age, boolean HasWork, int balance) {
        setName(Name);
        setAge(Age);
        setHasWork(HasWork);
        setBalance(balance);
        setHome(true);
    }


}
