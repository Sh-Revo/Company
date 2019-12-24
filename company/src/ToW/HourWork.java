package ToW;

public class HourWork extends Worker{
    private double salary;
    private double hours;
    private double rate;
    private double days;

    public HourWork(String name, String surName, double hours, double days, double rate, double salary) {
        super(name, surName);
        this.hours = hours;
        this.days = days;
        this.rate = rate;
        this.salary = salary;
    }

    public HourWork(String name, String surName, double hours, double days, double rate) {
        super(name, surName);
        this.hours = hours;
        this.days = days;
        this.rate = rate;
        this.salary = days * hours * rate;
    }

    public double getHours() {
        return hours;
    }

    public double getRate() {
        return rate;
    }

    public double getDays() {
        return days;
    }

    @Override
    public double paySalary() {
        return salary;
    }

    @Override
    public String toString(){
        return "Работник с почасовой зарплатой: "+
                "\nИмя: " + name +
                "\nФамилия: " + surName +
                "\nВремя: " + hours +
                "\nДни: " + days +
                "\nОклад: " + rate +
                "\nЗарплата: " + salary;
    }
}
