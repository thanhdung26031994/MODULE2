package ss13_search.utils;

import ss13_search.model.Job;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CsvFile {
    private static final String PATH = "src/ss13_search/data/job.csv";

    public static void writeToFile(List<Job> jobs){
        File file = new File(PATH);
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;
        try {
            fileWriter = new FileWriter(file);
            bufferedWriter = new BufferedWriter(fileWriter);
            for (Job job: jobs){
                bufferedWriter.write(job.getCode() +
                        "," + job.getName() +
                        "," + job.getData() +
                        "," + job.getMoney() +
                        "," + job.getDescribe());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                assert fileWriter != null;
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static List<Job> readToFile(){
        List<Job> jobList = new ArrayList<>();
        File file = new File(PATH);
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        Job job;
        try {
            fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);
            String temp;
            String[] tempStr;
            while ((temp = bufferedReader.readLine()) != null){
                tempStr = temp.split(",");
                job = new Job(tempStr[0], tempStr[1], tempStr[2], Long.parseLong(tempStr[3]), tempStr[4]);
                jobList.add(job);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                assert fileReader != null;
                fileReader.close();
                assert bufferedReader != null;
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return jobList;
    }
}
