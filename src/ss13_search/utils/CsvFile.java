package ss13_search.utils;

import ss13_search.model.Job;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CsvFile {
    //    private static final String PATH = "src/ss13_search/data/job.csv";
    private static final String PATH = "src/ss13_search/data/job1.txt";

    //    public static void writeToFile(List<Job> jobs) throws IOException {
//        File file = new File(PATH);
//        FileWriter fileWriter = null;
//        BufferedWriter bufferedWriter = null;
//        try {
//            fileWriter = new FileWriter(file);
//            bufferedWriter = new BufferedWriter(fileWriter);
//            for (Job job: jobs){
//                bufferedWriter.write(job.getCode() +
//                        "," + job.getName() +
//                        "," + job.getData() +
//                        "," + job.getMoney() +
//                        "," + job.getDescribe());
//                bufferedWriter.newLine();
//            }
//            bufferedWriter.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }finally {
//            try {
//                assert fileWriter != null;
//                fileWriter.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//    }
    public static void writeToFile(List<Job> jobs) {
        FileOutputStream fileOutputStream = null;
        ObjectOutputStream objectOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(PATH);
            objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(jobs);
            System.out.println("Ghi file thành công");

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                assert objectOutputStream != null;
                objectOutputStream.close();
                fileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    //    public static List<Job> readToFile() throws IOException, ClassNotFoundException {
//        List<Job> jobList = new ArrayList<>();
//        File file = new File(PATH);
//        FileReader fileReader = null;
//        BufferedReader bufferedReader = null;
//        Job job;
//        try {
//            fileReader = new FileReader(file);
//            bufferedReader = new BufferedReader(fileReader);
//            String temp;
//            String[] tempStr;
//            while ((temp = bufferedReader.readLine()) != null){
//                tempStr = temp.split(",");
//                job = new Job(tempStr[0], tempStr[1], tempStr[2], Long.parseLong(tempStr[3]), tempStr[4]);
//                jobList.add(job);
//            }
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }finally {
//            try {
//                assert fileReader != null;
//                fileReader.close();
//                assert bufferedReader != null;
//                bufferedReader.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//
//    }
//}
    public static List<Job> readToFile() {
        List<Job> jobList = new ArrayList<>();
        ObjectInputStream objectInputStream = null;
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(PATH);
            objectInputStream = new ObjectInputStream(fileInputStream);
            jobList = (List<Job>) objectInputStream.readObject();
            objectInputStream.close();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Không có dữ liệu trong file");
        } finally {
            try {
                if(objectInputStream != null) {
                    objectInputStream.close();
                    fileInputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return jobList;
    }
}