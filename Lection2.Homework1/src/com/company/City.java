package com.company;

import java.lang.reflect.Array;
import java.util.Date;
import java.util.Random;

/**
 * Класс отвечающий за все строения и жителей города
 * Created by NecroS on 11/5/2016.
 */
public class City {

    public Citizen[][][][] street;

    Random rnd = new Random();
    private final int MAXBUILDINGCOUNT = 10;
    private final int MAXFLATCOUNT = 20;
    private final int MAXRUMMATESCOUNT = 6;
    Date CurrentDate = new Date();
    private long Born;


    public void PrintStreet() {
        for (int i = 0; i < this.street.length; i++) {
            System.out.println(String.format("Дом %d:", i));
            for (int j = 0; j < this.street[i].length; j++) {
                System.out.println(String.format("   Квартира %d:", j));
                if (this.street[i][j] == null) {
                    System.out.println("     Квартира пустует");
                } else {
                    for (int k = 0; k < this.street[i][j].length; k++) {
                        System.out.println(String.format("     Житель %d: %s", k, street[i][j][k][0].toString()));
                    }
                }

            }
        }
    }

    public void GenerateStreet() {
        int random = rnd.nextInt(MAXBUILDINGCOUNT);
        random = random == 0 ? 1 : random;
        // Строим дома
        this.street = new Citizen[random][][][];

        // Наполняем дома квартирами
        for (int i = 0; i < street.length; i++) {
            random = rnd.nextInt(MAXFLATCOUNT);
            random = random == 0 ? 1 : random;
            this.street[i] = new Citizen[random][][];

            // Наполнение квартир жильцами
            for (int j = 0; j < street[i].length; j++) {
                random = rnd.nextInt(MAXRUMMATESCOUNT);
                random = random == 0 ? 1 : random;
                this.street[i][j] = new Citizen[random][1];

                // Наполнение жильцов профилями
                for (int k = 0; k < street[i][j].length; k++) {
                    this.street[i][j][k][0] = new Citizen();
                }

            }
        }
    }

    public int CalculateFlatBalance(int BuildingNumber, int FlatNumber) {
        int balance = 0;
        if (!isFlatEmpty(BuildingNumber, FlatNumber)) {
            for (Citizen[] cit : street[BuildingNumber][FlatNumber]
                    ) {
                balance += cit[0].getBalance();
            }
        }

        return balance;
    }

    public boolean isThereAnybodyHome(int BuildingNumber, int FlatNumber) throws Exception {
        boolean anybodyHome = false;
        int i = 0;
        if (isFlatEmpty(BuildingNumber, FlatNumber)) return false;
        for (Citizen[] cit : street[BuildingNumber][FlatNumber]
                ) {
                anybodyHome = anybodyHome | cit[0].isHome();
        }
        return anybodyHome;
    }

    public boolean isFlatEmpty(int BuildingNumber, int FlatNumber) {
        if (street[BuildingNumber][FlatNumber] == null) return true;
        return false;
    }

    public void NewCitizenBorn() {
        if (rnd.nextGaussian() > 0.8d) {
            int building = getRandomBuilding();
            int flat = getRandomFlat(building);
            if(isFlatEmpty(building,flat)) return;
            int OldRoommatesCount = street[building][flat].length;
            Citizen[][] newArray = new Citizen[OldRoommatesCount + 1][1];
            System.arraycopy(street[building][flat], 0, newArray, 0, OldRoommatesCount);

            newArray[OldRoommatesCount][0] = new Citizen(newArray[0][0].getName());

            street[building][flat] = newArray;

            System.out.println(String.format("%s Building %d, flat %d: %s", newArray[0][0].getAge() > 60 ? "[Усыновлен новый ребенок]" : "[Рождение ребенка]", building, flat, street[building][flat][OldRoommatesCount][0].toString()));
            for (Citizen[] cit : street[building][flat]
                    ) {
                System.out.println(cit[0].toString());
            }
        }
    }

    // случайная смерть
    public void Death() {
        int building = getRandomBuilding();
        int flat = getRandomFlat(building);
        int citizen = getRandomCitizen(building, flat);
        if(citizen==-1)return;
        System.out.println("[Смерть] в доме " + building + " квартире " + flat + " житель " + citizen);
        int roommatesCount = getCitizenInFlatCount(building, flat);
        if (roommatesCount == 1 || roommatesCount == -1) {
            street[building][flat] = null;
        } else {
            street[building][flat][citizen][0] = street[building][flat][roommatesCount - 1][0];
            Citizen[][] newArray = new Citizen[roommatesCount - 1][1];
            System.arraycopy(street[building][flat], 0 , newArray, 0 , roommatesCount-1);
            street[building][flat] = newArray;
        }
    }

    // TODO: 11/15/2016 Выселение
    public void Eviction(int building, int flat) {
        street[building][flat] = null;
        System.out.println(String.format("[Выселение]Жители дома %d квартиры %d ВЫСЕЛЕНЫ!", building, flat));
    }

    // TODO: 11/15/2016 Случайное заселение
    public boolean Settlement() {
        int building = getRandomBuilding();
        int flat = getRandomFlat(building);

        if (isFlatEmpty(building, flat)) {
            int random = rnd.nextInt(MAXRUMMATESCOUNT);
            random = random == 0 ? 1 : random;
            Citizen[][] settlers = new Citizen[random][1];

            // Наполнение жильцов профилями
            for (int k = 0; k < settlers.length; k++) {
                settlers[k][0] = new Citizen();
            }
            street[building][flat] = settlers;
            System.out.println(String.format("[Заселение]В дом %d квартира %d заселилась новая семья", building, flat));
        } else {
            System.out.println(String.format("В дом %d квартира %d не смогла заселиться семья так как квартира занята", building, flat));
        }
        return false;
    }


    public void CallToDuty() {
        int WorkersCount = 0;
        for (Citizen[][][] build : street
                ) {
            for (Citizen[][] flat : build
                    ) {
                if (flat == null) continue;
                for (Citizen[] cit : flat
                        ) {
                    if (cit[0] == null) {
                        System.out.println("Мертвая душа!");
                        continue;
                    }
                    if (cit[0].isHasWork() && cit[0].isHome()) {
                        cit[0].setHome(false);
                        WorkersCount++;
                    }
                }
            }
        }
        System.out.println(String.format("%d человек ушло на работу", WorkersCount));
    }

    public void CallHome() throws Exception {
        int WorkersCount = 0;
        for (Citizen[][][] build : street
                ) {
            for (Citizen[][] flat : build
                    ) {
                if (flat == null) continue;
                for (Citizen[] cit : flat
                        ) {
                    if (cit[0] == null) {
                        System.out.println("Мертвая душа!");
                        continue;
                    }
                    if (cit[0].isHasWork() && !cit[0].isHome()) {
                        cit[0].setHome(true);
                        WorkersCount++;
                    }
                }
            }
        }
        System.out.println(String.format("%d человек пришло с работы", WorkersCount));
    }

    public void Pay(int sum) {
        int balance = 0;
        for (int i = 0; i < street.length; i++) {
            for (int j = 0; j < street[i].length; j++) {
                if (isFlatEmpty(i, j)) {
                    System.out.println("Квартира пустует, квартплата не снимается!");
                    continue;
                }
                balance = CalculateFlatBalance(i, j);
                if (balance < sum) {
                    // TODO: 11/13/2016 Выселить
                    System.out.println(String.format("[Квартплата]У жителей дома %d квартиры %d недостаточно денег для оплаты квартплаты(%d). Выселение.", i, j, balance));
                    Eviction(i, j);
                } else {
                    int k = 0;
                    do {
                        if (street[i][j][k][0].getBalance() >= sum) {
                            street[i][j][k][0].setBalance(street[i][j][k][0].getBalance() - sum);
                            break;
                        } else {
                            sum -= street[i][j][k][0].getBalance();
                            street[i][j][k][0].setBalance(0);
                        }
                        k++;
                    } while (sum != 0 || k < street[i][j].length);
                }
            }
        }
    }

    public void Pay(int building, int flat, int sum, String payTarget, String ifCantPay) throws Exception {
        if (isFlatEmpty(building, flat)) {
            System.out.println("Квартира пустует, доставка отменена!");
            return;
        }
        if (!isThereAnybodyHome(building, flat)) {
            System.out.println(String.format("Квартира пуста. Отменяем \"%s\" ", payTarget));
        } else {
            int balance = CalculateFlatBalance(building, flat);
            if (balance < sum) {
                System.out.println(String.format("У жителей дома %d квартиры %d недостаточно денег(%d) для %s. %s", building, flat, balance, payTarget, ifCantPay));
            } else {
                int k = 0;
                do {
                    if (street[building][flat][k][0].getBalance() >= sum) {
                        street[building][flat][k][0].setBalance(street[building][flat][k][0].getBalance() - sum);
                        break;
                    } else {
                        sum -= street[building][flat][k][0].getBalance();
                        street[building][flat][k][0].setBalance(0);
                    }
                    k++;
                } while (sum != 0 || k < street[building][flat].length);

            }
        }

    }

    public void PayRent() {
        System.out.println("Наступил день оплаты квартплаты!");
        Pay(1000);
    }

    public void GetSalary() {
        int payments = 0;
        final int SALARY = 6000;
        for (Citizen[][][] build : street
                ) {
            for (Citizen[][] flat : build
                    ) {
                if (flat == null) continue;
                for (Citizen[] member : flat
                        ) {
                    if (member[0].isHasWork()) {
                        member[0].setBalance(member[0].getBalance() + SALARY);
                        payments++;
                    }
                }
            }
        }
        System.out.println(String.format("В день зарплаты выплачено %d ", payments * SALARY));
    }

    public int getBuildingCount() {
        return street.length;
    }

    public int getRandomBuilding() {
        return getBuildingCount() == 1 ? 0 : rnd.nextInt(getBuildingCount() - 1);
    }

    public int getFlatCount(int building) {
        return street[building].length;
    }

    public int getCitizenInFlatCount(int building, int flat) {
        if (isFlatEmpty(building, flat)) return -1;
        return street[building][flat].length;
    }

    public int getRandomFlat(int house) {
        return getFlatCount(house) == 1 ? 0 : rnd.nextInt(getFlatCount(house) - 1);
    }

    public int getRandomCitizen(int building, int flat) {
        if (isFlatEmpty(building, flat)) return -1;
        return getCitizenInFlatCount(building, flat) == 1 ? 0 : rnd.nextInt(getCitizenInFlatCount(building, flat) - 1);
    }

    City() {
        Born = CurrentDate.getTime();
        GenerateStreet();
    }

}
