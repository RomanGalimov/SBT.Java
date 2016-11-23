package com.company;

/**
 * Created by NecroS on 11/19/2016.
 */

public class Viking extends Warrior implements IWarrior,Cloneable {

    private int WeaponSkill = 2;

    @Override
    public int attack() {
        return getDamage();
    } //зачем переписывать унаследованные методы с такой же реализацией??
//    тебе явно стоит перечитать лекцию о наследовании

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
        super.setSquadName(name);
    }

    @Override
    public boolean rollToHit(){
        return DiceHelper.roll6d() >= WeaponSkill;
    }

    @Override
    public Viking clone() throws CloneNotSupportedException {
      return (Viking)super.clone();
    }


    Viking() {  //конструкторы принято писать перед остальными методами
        setHealth(100);
        setDamage(50);
        setName("V1");
    }

    public Viking(String name){
        setHealth(100);
        setDamage(50);
        setName(name);
    }
}
