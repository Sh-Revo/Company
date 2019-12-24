import ToW.*;

import java.util.Arrays;
import java.util.Scanner;


public class Util implements FoundSalary, Files, ReadFile, SaveFile {
    {
        loadCompany();
    }

    Scanner scan = new Scanner(System.in);
    private Company company;
    void doSmth(){
        company = Company.company();
        System.out.print("\n1 - Добавление сотрудников" +
                "\n2 - Информация о сотрудниках" +
                "\n3 - Затраты на сотрудников" +
                "\n4 - Сортировка" +
                "\n5 - Обратная сортировка");
        System.out.println("\nВведите цифру: ");
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
                addFixedWorker();
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
    //добавление рабочих
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
        System.out.println("Введите ставку: ");
        double rate = scan.nextDouble();
        HourWork[] tmp = Arrays.copyOf(Company.company.getHourWorks(), Company.company.getHourWorks().length + 1);
        tmp[tmp.length-1] = new HourWork(firstName, secondName, time, day, rate);
        Company.company().setHourWorks(tmp);
    }

    private void addFixedWorker() {
        scan.nextLine();
        System.out.println("Введите имя сотрудника: ");
        String firstName = scan.nextLine();
        System.out.println("Введите фамилию: ");
        String secondName = scan.nextLine();
        System.out.println("Введите Зарплату: ");
        double salary = scan.nextFloat();
        FixedWork[] tmp = Arrays.copyOf(Company.company().getFixedWorks(), Company.company().getFixedWorks().length + 1);
        tmp[tmp.length - 1] = new FixedWork(firstName, secondName, salary);
        Company.company().setFixedWorks(tmp);
    }

    //затраты
    private String payment() {
        double payment = calcSalary(Company.company().getFixedWorks()) +
               calcSalary(Company.company().getHourWorks());
        return "Затраты на зарплаты " + payment + " $";
    }

    //инфо
    private void showInfo() {
        System.out.println( infoWorkers(Company.company().getFixedWorks()));
        System.out.println(infoWorkers(Company.company().getHourWorks()));
       // System.out.println(infoWorkers(Company.getInstance().getFreelanceWorker()));

    }
    
    //повтор
    private void repeet(){
        String yes = "y";
        String no = "n";
        System.out.println("\nПродолжить?" +
                "\n(y)YES или (n)NO");
        String question = scan.next();
        if (question.equals(yes)) {
            doSmth();
        } else if (question.equals(no)) {
            System.out.println("Сохранение");
            saveCompanyFile();
            System.out.println("Выход из программы");

        } else {
            System.out.println("Введите другую букву: ");
            repeet();
        }
    }
}
