package ss13_search.repository.impl;

import ss13_search.model.Job;
import ss13_search.repository.IJobRepository;
import ss13_search.utils.CsvFile;
import ss13_search.utils.IdNotFoundException;
import ss13_search.utils.UniqueIDException;

import java.util.ArrayList;
import java.util.List;

public class JobRepository implements IJobRepository {
//    private static  final List<Job> jobList = CsvFile.readToFile();
//    static {
//        jobList.add(new Job("CV-001", "Mua máy tính", "12/12/2023", 30000000L, "Việc học lập trình"));
//        jobList.add(new Job("CV-002", "Mua sách", "26/02/2023", 25000L, "Việc học"));
//        jobList.add(new Job("CV-003", "Mua quần áo", "12/12/2023", 1500000L, "Hết đồ"));
//    }

    @Override
    public List<Job> getAll() {
        List<Job> jobList = CsvFile.readToFile();
        return jobList;
    }

    @Override
    public boolean checkCode(String code) throws UniqueIDException{
        List<Job> jobList = CsvFile.readToFile();
        for (Job job: jobList){
            if (job.getCode().equals(code)){
                return true;
            }
        }
        return false;
    }

    @Override
    public void addJob(Job job) {
        List<Job> jobList = CsvFile.readToFile();
        jobList.add(job);
        CsvFile.writeToFile(jobList);
    }

    @Override
    public void removeJob(String code) throws IdNotFoundException {
        List<Job> jobList = CsvFile.readToFile();
        for (Job job: jobList){
            if (job.getCode().equals(code)){
                jobList.remove(job);
                CsvFile.writeToFile(jobList);
            }
        }
    }

    @Override
    public void editJob(String code, Job job) {
        List<Job> jobList = CsvFile.readToFile();
        for (Job job1: jobList){
            if (job1.getCode().equals(code)){
                job1.setName(job.getName());
                job1.setData(job.getData());
                job1.setMoney(job.getMoney());
                job1.setDescribe(job.getDescribe());
                CsvFile.writeToFile(jobList);
            }
        }
    }

    @Override
    public Job findByCode(String code) {
        List<Job> jobList = CsvFile.readToFile();
        for (Job job: jobList){
            if (job.getCode().equalsIgnoreCase(code)){
                return job;
            }
        }
        return null;
    }

    @Override
    public List<Job> findByName(String name) {
        List<Job> jobList = CsvFile.readToFile();
        List<Job> jobs = new ArrayList<>();
        for (Job job: jobList){
            if (job.getName().toLowerCase().contains(name.toLowerCase())){
                jobs.add(job);
            }
        }
        return jobs;
    }
}
