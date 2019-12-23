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
        this.salary = days * hours * salary;
    }



    @Override
    public double paySalary() {
        return salary;
    }
}
