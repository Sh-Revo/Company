import ToW.*;

public class Company {
    public static Company company;
    FixedWork [] fixedWorks;
    HourWork [] hourWorks;
    FreelanceWork[] freelanceWorks;

     static Company company(){
        if (company == null){
            company = new Company();
        }

        return company;
    }


    public FixedWork[] getFixedWorks() {
        return fixedWorks;
    }

    public void setFixedWorks(FixedWork[] fixedWorks) {
        if (fixedWorks != null) {
            this.fixedWorks = fixedWorks;
        } else this.fixedWorks = new FixedWork[0];
    }



    public HourWork[] getHourWorks() {
         return hourWorks;
    }

    public void setHourWorks(HourWork[] hourWorks) {
        if (hourWorks != null) {
            this.hourWorks = hourWorks;
        } else this.hourWorks = new HourWork[0];
    }

    public FreelanceWork[] getFreelanceWorks() {
        return freelanceWorks;
    }

    public void setFreelanceWorks(FreelanceWork[] freelanceWorks) {
        if (freelanceWorks != null) {
            this.freelanceWorks = freelanceWorks;
        } else this.freelanceWorks = new FreelanceWork[0];
    }

}
