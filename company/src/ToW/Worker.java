package ToW;

public abstract class Worker {
    String name;
    String surName;

    public Worker(String name, String surName) {
        this.name = name;
        this.surName = surName;
    }

    public abstract double paySalary();

    public String getName() {
        return name;
    }

    public String getSurName() {
        return surName;
    }


}
