package com.company;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.*;

public class Main {


    public static void main(String[] args) throws ParseException {
        List<UserPage> userPages = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        boolean PageDisplayed;
        int DisplayedPageNumber;
        // write your code here
        do {
            PageDisplayed = false;
            DisplayedPageNumber = 0;

            if (userPages.isEmpty()) {
                System.out.println("Архив страниц пользователя пуст. Нажмите 1 для добавления новой страницы, либо exit для выхода.");
                UserPage up = new UserPage();
                up.AddPage();
                userPages.add(up);
            } else {
                do {
                    System.out.println("Введите имя учетной записи, либо exit для выхода");

                    if (sc.hasNext("exit")) {
                        System.out.println("До новых встреч!");
                        break;
                    }

                    String userId = sc.nextLine();
                    for (int i = 0; i < userPages.size(); i++) {
                        if (userPages.get(i).getIdent().equals(userId)) {
                            userPages.get(i).ShowPage();
                            PageDisplayed = true;
                            DisplayedPageNumber = i;
                        }
                    }
                    System.out.println("Страница не найдена, измените условия поиска либо ввведите exit для выхода");
                } while (PageDisplayed);

            }
            if (PageDisplayed) {
                System.out.println("Для редактирования страницы нажмите 1, для удаления 2, для выхода exit");

                switch (sc.nextInt()) {
                    case 1:
                        break;
                    case 2:
                        userPages.remove(userPages.get(DisplayedPageNumber));
                        break;
                    default:
                        System.out.println("Неизвестная комманда");

                }
            }
            if (sc.hasNext("exit")) {
                System.out.println("До новых встреч!");
                break;
            }
            if (sc.nextInt() == 1) {
                for (UserPage ar : userPages
                        ) {
                    if (ar == null) {
                        ar = new UserPage();
                        ar.AddPage();
                    }
                }

                //ДОбавляем карту
            }

        } while (true);
    }
}

class UserPage {
    private String ident;
    private String FullName;
    private String email;
    private Date birthDate;
    private String address;
    private String pasport;
    private String mobilephone;
    private String siteAddress;
    private String jobNPosition;
    private String about;
    private int avaterId;

    public String getIdent() {
        return ident;
    }

    public boolean setIdent(String ident) {
        Pattern p = Pattern.compile("[\\w]+");
        Matcher m = p.matcher(ident);
        if (m.matches()) {
            this.ident = ident;
            return true;
        }
        return false;
    }

    public String getFullName() {

        return FullName;
    }

    public boolean setFullName(String fullName) {
        Pattern p = Pattern.compile("([A-Z])([a-z]*)\\s([A-Z])([a-z]*)\\s([A-Z])([a-z]*)");
        Matcher m = p.matcher(fullName);
        if (m.matches()) {
            FullName = fullName;
            return true;
        }
        return false;
    }

    public String getEmail() {
        return email;
    }

    public boolean setEmail(String email) {
        Pattern p = Pattern.compile("([A-Za-z0-9]*)@([A-Za-z0-9]*).([A-Za-z0-9]{2,3})");
        Matcher m = p.matcher(email);
        if (m.matches()) {
            this.email = email;
            return true;
        }
        return false;
    }

    public String getBirthDate() {
        return birthDate.toString();
    }

    public boolean setBirthDate(String birthDate) throws ParseException {
        Pattern p = Pattern.compile("([0-3]{2}).([0-3]{2}).([1-2](9|0)(5-9|0|1)[0-9])");
        Matcher m = p.matcher(birthDate);
        if (m.matches()) {
            /*Calendar cal = Calendar.getInstance();
            char[] day = new char[2];
            char[] month = new char[2];
            char[] year = new char[4];
            birthDate.getChars(0, 2, day, 0);
            birthDate.getChars(3, 5, month, 0);
            birthDate.getChars(0, 2, year, 0);

            cal.set(Integer.getInteger(year.toString()), Integer.getInteger(month.toString()), Integer.getInteger(day.toString()));
            Date date = cal.getTime();
            */
            DateFormat df = new SimpleDateFormat("dd.MM.yyyy");
            this.birthDate = df.parse(birthDate);
            return true;
        }
        return false;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }


    public String getAddress() {
        return address;
    }

    public boolean setAddress(String address) {
        Pattern p = Pattern.compile("(\\D){8,30}, д.([\\d]{1,3}, кв.([\\d]){1,3})");
        Matcher m = p.matcher(address);
        if (m.matches()) {
            this.address = address;
            return true;
        }
        return false;
    }

    public String getPasport() {
        return pasport;
    }

    public boolean setPasport(String pasport) {
        Pattern p = Pattern.compile("([0-9]{4}) ([0-9]{6}), ([A-Za-z\\n]{10,300}) ((\\d){1,2}.(\\d){1,2}.(\\d){4})]");
        Matcher m = p.matcher(pasport);
        if (m.matches()) {
            this.pasport = pasport;
            return true;
        }
        return false;
    }

    public String getMobilephone() {
        return mobilephone;
    }

    public boolean setMobilephone(String mobilephone) {
        Pattern p = Pattern.compile("(8|\\+7)([0-9]{10})");
        Matcher m = p.matcher(mobilephone);
        if (m.matches()) {
            this.mobilephone = mobilephone;
            return true;
        }
        return false;
    }

    public String getSiteAddress() {
        return siteAddress;
    }

    public boolean setSiteAddress(String siteAddress) {
        Pattern p = Pattern.compile("(https://|http://)([A-Za-z0-9\\s]{1,100}).([a-z\\s]{2,3})");
        Matcher m = p.matcher(siteAddress);
        if (m.matches()) {
            this.siteAddress = siteAddress;
            return true;
        }
        return false;
    }

    public String getJobNPosition() {
        return jobNPosition;
    }

    public boolean setJobNPosition(String jobNPosition) {
        Pattern p = Pattern.compile("([A-Za-z0-9\\s]{3,100}), ([A-Za-z\\s]{3,30})");
        Matcher m = p.matcher(jobNPosition);
        if (m.matches()) {
            this.jobNPosition = jobNPosition;
            return true;
        }
        return false;
    }

    public String getAbout() {
        return about;
    }

    public boolean setAbout(String about) {
        Pattern p = Pattern.compile("([A-Za-z0-9\\s]{1000})");
        Matcher m = p.matcher(about);
        if (m.matches()) {
            this.about = about;
            return true;
        }
        return false;
    }

    public int getAvaterId() {
        return avaterId;
    }

    public void setAvaterId(int avaterId) {
        this.avaterId = avaterId;
    }

    public void AddPage() throws ParseException {
        Scanner scan = new Scanner(System.in);

        System.out.println("Введите идентификатор ");
        do {

            if (setIdent(scan.nextLine())) {
                break;
            } else System.out.println("Введите корректный идентификатор, минимум один символ без спецсимволов");
        } while (true);

        System.out.println("Введите ФИО ");
        do {

            if (setFullName(scan.nextLine())) {
                break;
            } else System.out.println("Введите корректное ФИО");
        } while (true);

        System.out.println("Введите email ");
        do {

            if (setEmail(scan.nextLine())) {
                break;
            } else System.out.println("Введите корректный email");
        } while (true);
        System.out.println("Введите дату рождения в формате дд.мм.гггг ");
        do {
            if (setBirthDate(scan.nextLine())) {
                break;
            } else System.out.println("Введите корректную дату рождения");
        } while (true);
        System.out.println("Введите место жительства ");
        do {
            if (setAddress(scan.nextLine())) {
                break;
            } else System.out.println("Введите корректное место жительства");
        } while (true);
        System.out.println("Введите паспортные данные  ");
        do {
            if (setPasport(scan.nextLine())) {
                break;
            } else System.out.println("Введите корректные паспортные данные");
        } while (true);
        System.out.println("Введите номер мобильного телефона ");
        do {
            if (setMobilephone(scan.nextLine())) {
                break;
            } else System.out.println("Введите корректный номер мобильного телефона");
        } while (true);
        System.out.println("Введите адресс сайта ");
        do {
            if (setSiteAddress(scan.nextLine())) {
                break;
            } else System.out.println("Введите корректный адресс сайта");
        } while (true);
        System.out.println("Введите место работы и должность ");
        do {
            if (setJobNPosition(scan.nextLine())) {
                break;
            } else System.out.println("Введите место работы и должность");
        } while (true);
        System.out.println("Введите О себе ");
        do {
            if (setAbout(scan.nextLine())) {
                break;
            } else System.out.println("Введите текст < 1000 символов");
        } while (true);
        System.out.println("Страница добавлена!");
    }

    public void ShowPage() {
        StringBuffer sb = new StringBuffer();
        sb.append(String.format("Идентификатор: %S", getIdent()));
        sb.append(String.format("ФИО: %S", getFullName()));
    }

    public void EditPageElement(String elementName, String value) throws ParseException {
        switch (elementName) {
            case "ident":
                setIdent(value);
                break;
            case "FullName":
                setFullName(value);
                break;
            case "email":
                setEmail(value);
                break;
            case "birthDate":
                DateFormat df = new SimpleDateFormat("MM dd yyyy");
                Date updatedDate = df.parse(value);
                setBirthDate(updatedDate);
                break;
            case "address":
                setAddress(value);
                break;
            case "pasport":
                setPasport(value);
                break;
            case "mobilephone":
                setMobilephone(value);
                break;
            case "siteAddress":
                setSiteAddress(value);
                break;
            case "jobNPosition":
                setJobNPosition(value);
                break;
            case "about":
                setAbout(value);
                break;
            case "avaterId":
                setAvaterId(Integer.getInteger(value));
                break;
            default:
                System.out.println("Неизвестный элемент, карточка не отредактирована.");
        }
    }
}


class Avatars {
    String[] avatar = new String[10];

    Avatars() {
        avatar[0] = "";
        avatar[1] = "";
        avatar[2] = "";
        avatar[3] = "";
        avatar[4] = "";
    }

    public String getAvatar(int id) {
        return avatar[id];
    }

}