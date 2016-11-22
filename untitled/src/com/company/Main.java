package com.company;

public class Main {

    public static void main(String args[]) throws CloneNotSupportedException {
        // write your code here

        Squad Volsung = new Squad("Volsung butchers", 10);
        Volsung.addSquadMember(new Viking("Eyjolf Vikarsson"));
        Volsung.addSquadMember(new Viking("Nærfi Gudmundsson"));
        Volsung.addSquadMember(new Viking("Reinn Lodmundsson"));
        Volsung.addSquadMember(new Archer("Vebjorn Audbjornsson"));
        Volsung.addSquadMember(new Archer("Aron Vesteinsson"));
        Volsung.addSquadMember(new Archer("Hallvard Yngvarsson"));
        Volsung.addSquadMember(new Archer("Hrossketil Hriflasson"));
        Volsung.addSquadMember(new Archer("Rognvald Unnsson"));
        Volsung.addSquadMember(new Archer("Hrossketil Eiriksson"));
        Volsung.addSquadMember(new Archer("Arn Borgarsson"));

        Squad Ylfing = Volsung.clone();
        Ylfing.setName("Ylfing blood brothers");
        /*Squad Ylfing = new Squad("Ylfing blood brothers", 10);
        Ylfing.addSquadMember(new Viking("Eyjolf Vikarsson"));
        Ylfing.addSquadMember(new Viking("Nærfi Gudmundsson"));
        Ylfing.addSquadMember(new Viking("Reinn Lodmundsson"));
        Ylfing.addSquadMember(new Archer("Vebjorn Audbjornsson"));
        Ylfing.addSquadMember(new Archer("Aron Vesteinsson"));
        Ylfing.addSquadMember(new Archer("Hallvard Yngvarsson"));
        Ylfing.addSquadMember(new Archer("Hrossketil Hriflasson"));
        Ylfing.addSquadMember(new Archer("Rognvald Unnsson"));
        Ylfing.addSquadMember(new Archer("Hrossketil Eiriksson"));
        Ylfing.addSquadMember(new Archer("Arn Borgarsson"));*/

        Battle asgardChallenge = new Battle(Volsung, Ylfing);
        asgardChallenge.Run();
    }
    // end Main
}
