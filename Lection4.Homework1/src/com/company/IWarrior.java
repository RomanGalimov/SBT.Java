package com.company;

/**
 * Created by NecroS on 11/19/2016.
 */
public interface IWarrior {
    int attack();
    void takeDamage(int damage);
    boolean isAlive();
    void setSquadName(String name);
    boolean rollToHit();
}
