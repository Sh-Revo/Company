import ToW.FixedWork;
import ToW.FreelanceWork;
import ToW.HourWork;

import java.io.*;
import java.util.Scanner;

public interface ReadFile extends LoadFile {

    default void loadCompany() {
        Company.company().setFixedWorks(readFixedWorkFile(new File(FIXED_WORKER)));
        Company.company().setHourWorks(readHourWorkFile(new File(HOUR_WORKER)));
        Company.company().setFreelanceWorks(readFreelanceWorkFile(new File(FREELANCE_WORKER)));
    }

    //чтение с файла
    default FixedWork[] readFixedWorkFile(File path) {
        int lines = 0;
        FixedWork[] fromFile = null;
        if (path.exists()) {
            try {
                Scanner scan = new Scanner(path);
                FileReader reader = new FileReader(path);
                LineNumberReader numLines = new LineNumberReader(reader);
                while (numLines.readLine() != null) {
                    lines++;
                }
                String[] worker;
                if (lines != 0) {
                    fromFile = new FixedWork[lines];
                    for (int i = 0; i < lines; i++) {
                        worker = scan.next().split(",");
                        fromFile[i] = new FixedWork(worker[0], worker[1], Double.parseDouble(worker[2]));
                    }
                }
            } catch (FileNotFoundException | NumberFormatException e) {
                System.out.println("Файл не найден. " + e.fillInStackTrace());
                return new FixedWork[0];
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return fromFile;
    }

    default HourWork[] readHourWorkFile(File path) {
        int lines = 0;
        HourWork[] fromFile = null;
        if (path.exists()) {
            try {
                Scanner scan = new Scanner(path);
                FileReader reader = new FileReader(path);
                LineNumberReader numLines = new LineNumberReader(reader);
                while (numLines.readLine() != null) {
                    lines++;
                }
                String[] worker;
                if (lines != 0) {
                    fromFile = new HourWork[lines];
                    for (int i = 0; i < lines; i++) {
                        worker = scan.next().split(",");
                        fromFile[i] = new HourWork(worker[0], worker[1], Double.parseDouble(worker[2]), Double.parseDouble(worker[3]), Double.parseDouble(worker[4]));
                    }
                } else Company.company.setHourWorks(fromFile);
            } catch (FileNotFoundException | NumberFormatException e) {
                System.out.println("Файл не найден. " + e.fillInStackTrace());
                return new HourWork[0];
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return fromFile;
    }

    default FreelanceWork[] readFreelanceWorkFile(File path) {
        int lines = 0;
        FreelanceWork[] fromFile = null;
        if (path.exists()) {
            try {
                Scanner scan = new Scanner(path);
                FileReader reader = new FileReader(path);
                LineNumberReader numLines = new LineNumberReader(reader);
                while (numLines.readLine() != null) {
                    lines++;
                }
                String[] worker;
                if (lines != 0) {
                    fromFile = new FreelanceWork[lines];
                    for (int i = 0; i < lines; i++) {
                        worker = scan.next().split(",");
                        fromFile[i] = new FreelanceWork(worker[0], worker[1], Double.parseDouble(worker[2]), Double.parseDouble(worker[3]));
                    }
                }
            } catch (FileNotFoundException | NumberFormatException e) {
                System.out.println("Файл не найден. " + e.fillInStackTrace());
                return new FreelanceWork[0];
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return fromFile;
    }




}
