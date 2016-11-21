package com.company;

import java.util.Random;
import java.util.Calendar;

/**
 * Created by NecroS on 11/5/2016.
 */
public class TimeLine {
    Random rnd = new Random();
    Calendar StartDate = Calendar.getInstance();
    Calendar CurrentDate = StartDate;
    private City city;
    int DayCount = 0;
    private int LastDay;

    public void Step() throws Exception {
        if (CurrentDate.get(Calendar.HOUR_OF_DAY) == 7) {
            city.CallToDuty();
        }
        if (CurrentDate.get(Calendar.HOUR_OF_DAY) == 19) {
            city.CallHome();
        }
        if ((CurrentDate.get(Calendar.DAY_OF_MONTH) == 1) && (CurrentDate.get(Calendar.HOUR_OF_DAY) == 10)) {
            System.out.println("День оплаты квартплат");
            city.PayRent();
        }

        if ((CurrentDate.get(Calendar.DAY_OF_MONTH) == 15) && (CurrentDate.get(Calendar.HOUR_OF_DAY) == 8)) {
            System.out.println("День зарплаты");
            city.GetSalary();
        }

        //Отправка почты
        if (rnd.nextGaussian() > 0.8) {
            for (int i = 0; i < rnd.nextInt(10); i++) {
                int house = city.getRandomBuilding();
                int flat = city.getRandomFlat(house);
                city.Pay(house, flat, 2, "оплата посылки", "Посылка уничтожена.");
            }
        }

        if (rnd.nextGaussian() > 0.5) {
            city.NewCitizenBorn();
        }

        //
        if (rnd.nextGaussian() > 0.7) {
            for (int i = 0; i < rnd.nextInt(30); i++) {
                int house = city.getRandomBuilding();
                int flat = city.getRandomFlat(house);
                int payment = rnd.nextInt(50) + 1;
                System.out.println(String.format("В дом %d квартиру %d отправлена еда стоимостью %d", house, flat, payment));
                city.Pay(house, flat, payment, "оплата доставки еды", "Еду вернули в магазин.");
            }
        }

        if (CurrentDate.get(Calendar.DAY_OF_MONTH) ==rnd.nextInt( CurrentDate.getMaximum(Calendar.DAY_OF_MONTH))&&(rnd.nextGaussian() > 0.8)) {
            city.Death();
        }

        if((CurrentDate.get(Calendar.DAY_OF_MONTH) == CurrentDate.getMaximum(Calendar.DAY_OF_MONTH)) &&(rnd.nextGaussian() > 0.5)){
            city.Settlement();
        }

    }

    public void Run() throws Exception {
        for (DayCount = 0; DayCount < LastDay; DayCount++) {

            for (int i = CurrentDate.get(Calendar.HOUR); i < 24; i++) {
                System.out.println(CurrentDate.getTime());
                CurrentDate.add(Calendar.HOUR, 1);
                Step();
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }
    }

    private int getLastDay() {
        return LastDay;
    }

    public void setLastDay(int lastDay) {
        LastDay = lastDay;
    }

    public void setCity(City city) {
        this.city = city;
    }

    TimeLine(City city, int lastDay) {
        setLastDay(lastDay);
        setCity(city);
    }


}
