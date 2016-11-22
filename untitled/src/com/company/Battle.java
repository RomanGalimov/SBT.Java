package com.company;

/**
 * Created by NecroS on 11/19/2016.
 */
public class Battle {
    int stepCounter = 1;
    DateHelper dh;
    Squad sq1, sq2;

    public void Run() {
        do {
            Step();
        } while ((sq1.hasAliveWarriors()) && (sq2.hasAliveWarriors()));
    }

    private void Step() {
        if (stepCounter % 2 == 0) {
            Fight(sq1, sq2);
        } else {
            Fight(sq2, sq1);
        }
        stepCounter++;
    }

    private void Fight(Squad firstSquad, Squad secondSquad) {
        Warrior firstSquadWarrior = firstSquad.getRandomWarrior();
        Warrior secondSquadWarrior = secondSquad.getRandomWarrior();

        if (firstSquadWarrior.rollToHit()) {
            secondSquadWarrior.takeDamage(firstSquadWarrior.attack());
            System.out.println(firstSquadWarrior.getSquadName() + ": " + firstSquadWarrior.getName() + " hit enemy!");
            System.out.println(secondSquadWarrior.isAlive() ? secondSquadWarrior.getSquadName() + ": " + secondSquadWarrior.getName() + " is alive!" : secondSquadWarrior.getSquadName() + ": " + secondSquadWarrior.getName() + " dead");
        }

        dh.skipTime();

        System.out.println(!secondSquad.hasAliveWarriors() ? String.format("Squad win: %s \nbattle time: %s minutes", firstSquad.toString(), dh.getFormattedDiff()) : "");

    }

    public Battle(Squad sq1, Squad sq2) {
        dh = new DateHelper();
        this.sq1 = sq1;
        this.sq2 = sq2;
        System.out.println("Начало битвы:" + dh.getFormattedStartDate());
    }
}
