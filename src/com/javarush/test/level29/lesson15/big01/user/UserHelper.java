package com.javarush.test.level29.lesson15.big01.user;

public class UserHelper {
    private User userAnya = new User("Аня", "Смирнова", 10);
    private User userRoma = new User("Рома", "Виноградов", 30);



    public void printUsers() {
        userAnya.printInfo();
        userRoma.printInfo();
    }

    public void printAdditionalInfo(User user) {
        if (user.getAge() < 16)
            System.out.println("Пользователь моложе 16 лет");
        else
            System.out.println("Пользователь старше 16 лет");
    }


    public int calculateAvarageAge() {

        User userUra = new User("Юра", "Карп", 28);

       return  (userAnya.getAge() + userRoma.getAge() + userUra.getAge()) / 3;


    }

    public double calculateRate(double base, int age, boolean hasWork, boolean hasHouse) {
        double b1 = base;
        b1 += age / 100;
        b1 *= hasWork ? 1.1 : 0.9;
        b1 *= hasHouse ? 1.1 : 0.9;
        return b1;
    }

    public String getBoosName(User user) {
       return user.getBoss();

    }
}
