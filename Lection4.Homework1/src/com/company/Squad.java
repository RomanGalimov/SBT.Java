package com.company;

import java.util.Random;

/**
 * Created by NecroS on 11/19/2016.
 */
public class Squad implements Cloneable {
    private String name;
    private Warrior[] squadArray;

    Random rnd = new Random();

    public Warrior getRandomWarrior() {

        Warrior aliveWarrior = null;
        do {
            aliveWarrior = squadArray[rnd.nextInt(squadArray.length)];
            if(aliveWarrior.isAlive()) break;
        } while (hasAliveWarriors());
        return aliveWarrior;
    }

    public boolean hasAliveWarriors() {
        boolean alive = false;
        for (Warrior warrior : squadArray
                ) { //что тут произошло? почему скобки раскиданы?
            alive = alive | warrior.isAlive(); //зачем проходить весь отряд в поисках хотя бы одного живого? при нахождении сразу return true;
        }
        return alive;
    }



    @Override
    public String toString() {
        return this.getName();
    }

    @Override
    public Squad clone() throws CloneNotSupportedException {
        Squad clonedSquad;
        try{
            clonedSquad = (Squad)super.clone();
            clonedSquad.squadArray = new Warrior[this.squadArray.length];
            int i = 0;
            for (Warrior warrior: this.squadArray
                    ) { //опять...
                clonedSquad.squadArray[i] =(Warrior)warrior.clone(); //медод мог бы вернуть сразу Warrior, тогда бы не пришлось приводить тип
                i++; //для цикла с внутренним счетчиком есть форма for(int i = x; i < y; i++). в данном случае счетчик вообще не нужен
            }
        } catch(CloneNotSupportedException e){
            throw new UnsupportedOperationException(e);
        }

//что это за пустые строки?
        return clonedSquad;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj); //это неверная реализация
    }

    public void addSquadMember(Warrior squadNewMember) {
        for (int i = 0; i < squadArray.length; i++){
            if(squadArray[i] == null){ //можно было передавать в конструктор готовый массив бойцов. без извращений
                squadArray[i] = squadNewMember;
                squadArray[i].setSquadName(getName());
                break;
            }
        }
    }

    public Squad(String name, int size){
        setName(name);
        this.squadArray = new Warrior[size];
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        if(squadArray != null && squadArray.length >0){
            for (Warrior warrior: squadArray
                 ) { //в следующей лабе за такое форматирование буду ставить 0
               warrior.setSquadName(name);
            }
        }
    }
}
