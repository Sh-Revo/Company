package ToW;

public class FreelanceWork extends Worker{

    private double hours;
    private double rate;
    private double salary;

    public FreelanceWork(String name, String surName, double hours, double rate) {
        super(name, surName);
        this.hours = hours;
        this.rate = rate;
        this.salary = rate*hours;
    }

    public double getHours() {
        return hours;
    }

    public double getRate() {
        return rate;
    }

    @Override
    public double paySalary() {
        return salary;
    }

    @Override
    public String toString(){
        return "Работник Фрилансер: "+
                "\nИмя: " + name +
                "\nФамилия: " + surName +
                "\nВремя: " + hours +
                "\nЗарплата: " + salary;
    }
}
