import ToW.FixedWork;
import ToW.FreelanceWork;
import ToW.HourWork;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public interface SaveFile extends LoadFile{

    //Создание файла
    default void createFile(File path) {
        try {
            path.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //сохранение
    default void fixWorkerSave(FixedWork[] fixWorkers, File path) {
        createFile(path);
        try {
            FileWriter writer = new FileWriter(path);
            writer.flush();
            for (FixedWork w : fixWorkers) {
                writer.write(w.getName() + "," + w.getSurName() + "," + w.getSalary() + "\n");
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("Ошибка записи файла!" + e.toString());
        }
    }

    default void hoursWorkerSave(HourWork[] hoursWorkers, File path) {
        createFile(path);
        try {
            FileWriter writer = new FileWriter(path);
            writer.flush();
            for (HourWork h : hoursWorkers) {
                writer.write(h.getName() + "," + h.getSurName() + "," + h.getHours() + ","
                        + h.getDays() + "," + h.getRate() + "\n");
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("Файл не записан!" + e.toString());
        }
    }

    default void freelanceWorkerSave(FreelanceWork[] freelanceWorks, File path){
        createFile(path);
        try {
            FileWriter writer = new FileWriter(path);
            writer.flush();
            for (FreelanceWork w : freelanceWorks) {
                writer.write(w.getName() + "," + w.getSurName() + "," + w.getHours()+ "," + w.getRate() + "\n");
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("Файл не записан!" + e.toString());
        }
    }

    default void saveCompanyFile() {
        fixWorkerSave(Company.company().getFixedWorks(), new File(FIXED_WORKER));
        hoursWorkerSave(Company.company().getHourWorks(), new File(HOUR_WORKER));
        freelanceWorkerSave(Company.company().getFreelanceWorks(), new File(FREELANCE_WORKER));
    }
}
