package ToW;

public class FixedWork extends Worker {
    private double salary;


    public FixedWork(String name, String surName, double salary) {
        super(name, surName);
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public double paySalary() {
        return salary;
    }
}
