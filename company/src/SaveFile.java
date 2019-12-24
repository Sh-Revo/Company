import ToW.FixedWork;
import ToW.HourWork;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public interface SaveFile extends LoadFile{

    //Создание файла
    default void creatFile(File path) {
        try {
            path.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //сохранение
    default void fixWorkerSave(FixedWork[] fixWorkers, File path) {
        creatFile(path);
        try {
            FileWriter writer = new FileWriter(path);
            writer.flush();
            //writer.write(fixWorkers.length + "\n");
            for (FixedWork w : fixWorkers) {
                writer.write(w.getName() + "," + w.getSurName() + "," + w.getSalary() + "\n");
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("Ошибка записи файла!" + e.toString());
        }
    }

    default void hoursWorkerSave(HourWork[] hoursWorkers, File path) {
        creatFile(path);
        try {
            FileWriter writer = new FileWriter(path);
            writer.flush();
            //writer.write(hoursWorkers.length + "\n");
            for (HourWork h : hoursWorkers) {
                writer.write(h.getName() + "," + h.getSurName() + "," + h.getHours() + ","
                        + h.getDays() + "," + h.getRate() + "\n");
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("Файл не записан!" + e.toString());
        }
    }

    default void saveCompanyFile() {
        fixWorkerSave(Company.company().getFixedWorks(), new File(FIXED_WORKER));
        hoursWorkerSave(Company.company().getHourWorks(), new File(HOUR_WORKER));
        //freelanceSave(Company.getInstance().getFreelanceWorker(), new File(FREELANCE_WORKER));
    }
}
