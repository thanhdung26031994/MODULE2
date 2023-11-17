package ss13_search.repository.impl;

import ss13_search.model.Job;
import ss13_search.repository.IJobRepository;

import java.util.ArrayList;
import java.util.List;

public class JobRepository implements IJobRepository {
    private static  final List<Job> jobList = new ArrayList<>();
    static {
        jobList.add(new Job("CV-001", "Mua máy tính", "12/12/2023", 30000000L, "Việc học lập trình"));
        jobList.add(new Job("CV-002", "Mua sách", "26/02/2023", 25000L, "Việc học"));
        jobList.add(new Job("CV-003", "Mua quần áo", "12/12/2023", 1500000L, "Hết đồ"));
    }

    @Override
    public List<Job> getAll() {
        return jobList;
    }

    @Override
    public boolean checkCode(String code) {
        for (Job job: jobList){
            if (job.getCode().equals(code)){
                return true;
            }
        }
        return false;
    }

    @Override
    public void addJob(Job job) {
        jobList.add(job);
    }

    @Override
    public void removeJob(String code) {
        for (Job job: jobList){
            if (job.getCode().equals(code)){
                jobList.remove(job);
                break;
            }
        }
    }

    @Override
    public void editJob(String code, Job job) {
        for (Job job1: jobList){
            if (job1.getCode().equals(code)){
                job1.setName(job.getName());
                job1.setData(job.getData());
                job1.setMoney(job.getMoney());
                job1.setDescribe(job.getDescribe());
                break;
            }
        }
    }

    @Override
    public Job findByCode(String code) {
        for (Job job: jobList){
            if (job.getCode().equalsIgnoreCase(code)){
                return job;
            }
        }
        return null;
    }

    @Override
    public List<Job> findByName(String name) {
        List<Job> jobs = new ArrayList<>();
        for (Job job: jobList){
            if (job.getName().toLowerCase().contains(name.toLowerCase())){
                jobs.add(job);
            }
        }
        return jobs;
    }
}
