import ToW.*;

import java.util.Arrays;
import java.util.Scanner;


public class Util implements FoundSalary, ReadFile, SaveFile {
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
                sorting(true);
                repeet();
                break;
            case 5:
                sorting(false);
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
                addFreelanceWorker();
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



    private void addFreelanceWorker() {
        scan.nextLine();
        System.out.println("Введите имя сотрудника: ");
        String firstName = scan.nextLine();
        System.out.println("Введите фамилию: ");
        String secondName = scan.nextLine();
        System.out.println("Введите количество часов: ");
        double hours = scan.nextFloat();
        System.out.println("Введите ставку: ");
        double rate = scan.nextFloat();
        FreelanceWork[] tmp = Arrays.copyOf(Company.company().getFreelanceWorks(), Company.company().getFreelanceWorks().length + 1);
        tmp[tmp.length - 1] = new FreelanceWork(firstName, secondName, hours, rate);
        Company.company().setFreelanceWorks(tmp);
    }

    //сортировка
    private void sorting(boolean flag){
        int numbOfPeople = Company.company().fixedWorks.length +
                Company.company().hourWorks.length +
                Company.company().freelanceWorks.length;
        Worker[] workers = new Worker[numbOfPeople];
        for (int i = 0, j = 0, k = 0, l = 0; i < workers.length; i++) {
            if (i < Company.company().fixedWorks.length) {
                workers[i] = Company.company().fixedWorks[j];
                j++;
            } else if (i < Company.company().fixedWorks.length + Company.company().hourWorks.length) {
                workers[i] = Company.company().hourWorks[k];
                k++;
            } else {
                workers[i] = Company.company().freelanceWorks[l];
                l++;
            }

        }
        int size = workers.length;
        int x = size - 1;
        boolean swap = true;
        Worker temp;

        while (swap) {
            swap = false;

            for (int i = x; i > size - 1 - x; i--) {
                if (workers[i].paySalary() < workers[i - 1].paySalary()) {
                    temp = workers[i];
                    workers[i] = workers[i - 1];
                    workers[i - 1] = temp;
                    swap = true;
                }
            }
            for (int i = size - x; i < x; i++) {
                if (workers[i].paySalary() > workers[i + 1].paySalary()) {
                    temp = workers[i];
                    workers[i] = workers[i + 1];
                    workers[i + 1] = temp;
                    swap = true;
                }
            }
            if (!swap) {
                break;
            }
        }
        if (flag) {
            for (Worker w : workers) {
                System.out.println(w.toString());
            }
        } else {
            for (int i = workers.length - 1; i >= 0; i--) {
                System.out.println(workers[i].toString());
            }
        }
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
        System.out.println(infoWorkers(Company.company().getFreelanceWorks()));

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
