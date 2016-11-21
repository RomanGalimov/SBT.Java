package com.company;

/**
 * Created by NecroS on 11/19/2016.
 */
public class Archer extends Warrior implements IWarrior, Cloneable {
    int BallisticSkill = 4;

    @Override
    public int attack() {
        return getDamage();
    }

    @Override
    public void takeDamage(int damage) {
        setHealth(getHealth() - damage);
    }

    @Override
    public boolean isAlive() {
        return getHealth() > 0;
    }

    @Override
    public void setSquadName(String name) {
        super.setSquadName(name);
    }

    public boolean rollToHit() {
        return DiceHelper.roll6d() >= BallisticSkill;
    }

    @Override
    public Archer clone() throws CloneNotSupportedException {
        return (Archer)super.clone();
    }

    Archer() {
        setHealth(80);
        setDamage(80);
        setName("A1");
    }

    public Archer(String name) {
        setHealth(80);
        setDamage(80);
        setName(name);
    }
}
