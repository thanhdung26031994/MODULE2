package ss13_search.service;

import ss13_search.model.Job;

import java.util.List;

public interface IJobService {

    List<Job> getAll();

    boolean checkCode(String code);

    void addJob(Job job);

    void removeJob(String code);

    void editJob(String code, Job job);

    Job findByCode(String code);

    List<Job> findByName(String name);

    List<Job> sortByName();

    List<Job> sortByMoney();
}
