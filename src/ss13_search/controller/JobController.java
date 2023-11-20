package ss13_search.controller;

import ss12_map_set.service.IFruitService;
import ss13_search.model.Job;
import ss13_search.service.IJobService;
import ss13_search.service.impl.JobService;

import java.util.List;

public class JobController {
    private static IJobService jobService = new JobService();

    public List<Job> getAll() {
        return jobService.getAll();
    }

    public boolean checkCode(String code) {
        return jobService.checkCode(code);
    }

    public void addJob(Job job) {
        jobService.addJob(job);
    }

    public void removeJob(String code) {
        jobService.removeJob(code);
    }

    public void editJob(String code,Job job) {
        jobService.editJob(code, job);
    }

    public Job findByCode(String code) {
        return jobService.findByCode(code);
    }

    public List<Job> findByName(String name) {
        return jobService.findByName(name);
    }

    public List<Job> sortByName() {
        return jobService.sortByName();
    }

    public List<Job> sortByMoney() {
        return jobService.sortByMoney();
    }
}
