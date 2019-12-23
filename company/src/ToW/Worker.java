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

    public void setName(String name) {
        this.name = name;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }


}
