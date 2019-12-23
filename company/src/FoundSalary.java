import ToW.Worker;

public interface FoundSalary  {
    default String infoWorkers(Worker[] workers) {
        String temp = "";
        for (Worker i : workers) {
            temp += i.toString() + "\n";
        }
        return temp;
    }

    default double calcSalary(Worker[] workers){
        double temp=0;
        for (Worker i: workers) {
            temp += i.paySalary();
        }
        return temp;
    }
}
