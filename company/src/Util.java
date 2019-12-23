import ToW.*;

import java.util.Arrays;
import java.util.Scanner;


public class Util implements FoundSalary{

    Scanner scan = new Scanner(System.in);
    void doSmth(){
        System.out.print("\n1 - Добавление сотрудников" +
                "\n2 - Информация о сотрудниках" +
                "\n3 - Затраты на сотрудников" +
                "\n4 - Сортировка" +
                "\n5 - Обратная сортировка");

        System.out.println("Ввод: ");

        int y = scan.nextInt();
        switch (y) {
            case 1:
                addPerson();
                break;
            case 2:
                showInfo();
                repeet();
                break;
            case 3:
                System.out.println(payment());
                repeet();
                break;
            case 4:
               // sorting(true);
                repeet();
                break;
            case 5:
               // sorting(false);
                repeet();
                break;
            default: {
                System.out.println("Вы ввели не верное значение");
                break;
            }
        }

    }

    private void addPerson(){
        System.out.println("\n 1 - Рабочий с фиксированой З/П" +
                "\n 2 - Рабочий с почасовой З/П" +
                "\n 3 - Фрилансер");


        int x = scan.nextInt();
        switch (x) {
            case 1: {
                //addFixedWorker();
                repeet();
                break;
            }
            case 2: {
                addHoursWorker();
                repeet();
                break;
            }
            case 3: {
                //addFreelance();
                repeet();
                break;
            }
            default: {
                System.out.println("Повторите попытку");
                break;
            }
        }
    }

    private void addHoursWorker() {
        scan.nextLine();
        System.out.println("Введите имя сотрудника: ");
        String firstName = scan.nextLine();
        System.out.println("Введите фамилию: ");
        String secondName = scan.nextLine();
        System.out.println("Введите количество рабочих дней: ");
        double day = scan.nextDouble();
        System.out.println("Введите количество часов: ");
        double time = scan.nextDouble();
        System.out.println("Введите цену часа: ");
        double rate = scan.nextDouble();
        HourWork[] tmp = Arrays.copyOf(Company.getInstance().getHourWorks(), Company.getInstance().getHourWorks().length + 1);
        tmp[tmp.length - 1] = new HourWork(firstName, secondName, time, day, rate);
        Company.getInstance().setHourWorks(tmp);
    }

   /* private void addFixedWorker() {
        FixWorker[] tmp = Arrays.copyOf(Company.getInstance().getFixedWorker(), Company.getInstance().getFixedWorker().length + 1);
        scan.nextLine();
        System.out.println("Введите имя сотрудника: ");
        String firstName = scan.nextLine();
        System.out.println("Введите фамилию: ");
        String secondName = scan.nextLine();
        System.out.println("Введите ЗП: ");
        float pay = scan.nextFloat();
        tmp[tmp.length - 1] = new FixWorker(firstName, secondName, pay);
        Company.getInstance().setFixedWorker(tmp);
    }*/


    private String payment() {
        double payment = calcSalary(Company.getInstance().getFixedWorks()) +
               calcSalary(Company.getInstance().getHourWorks());
        return "Затраты на зарплаты " + payment + " $";
    }


    private void showInfo() {
        System.out.println( infoWorkers(Company.getInstance().getFixedWorks()));
        System.out.println(infoWorkers(Company.getInstance().getHourWorks()));
       // System.out.println(infoWorkers(Company.getInstance().getFreelanceWorker()));

    }

    private void repeet(){
        String yes = "y";
        String no = "n";
        System.out.println("\nПродолжить?" +
                "\n(y)YES или (n)NO");
        String question = scan.next();
        if (question.equals(yes)) {
            doSmth();
        } else if (question.equals(no)) {
            System.out.println("Сохраняю компанию");
            //saveCompanyInFile();
            System.out.println("Спасибо");

        } else {
            System.out.println("Введите другую букву: ");
            repeet();
        }
    }
}
