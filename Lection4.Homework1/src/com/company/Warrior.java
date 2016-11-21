package com.company;

/**
 * Created by NecroS on 11/19/2016.
 */
public abstract class Warrior implements IWarrior {
    private String name;
    private int health;
    private int damage;
    private String squadName;

    @Override
    public String toString() {
        return String.format("%s(%s - %s)", getName(), this.getClass(), getSquadName());
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public String getSquadName() {
        return squadName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int attack() {
        return getDamage();
    }

    @Override
    public void takeDamage(int damage) {
        setHealth(getHealth() - damage);
    }

    @Override
    public boolean isAlive(){
        return getHealth()>0;
    }

    @Override
    public void setSquadName(String name){
        this.squadName = name;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        // TODO: 11/19/2016  
        return super.clone();
    }

    @Override
    public boolean equals(Object obj) {
        // TODO: 11/19/2016
        return super.equals(obj);
    }
}
