package ss13_search.service;

import ss13_search.model.Job;
import ss13_search.utils.IdNotFoundException;
import ss13_search.utils.UniqueIDException;

import java.util.List;

public interface IJobService {

    List<Job> getAll();

    boolean checkCode(String code) throws UniqueIDException;

    void addJob(Job job);

    void removeJob(String code) throws IdNotFoundException;

    void editJob(String code, Job job);

    Job findByCode(String code);

    List<Job> findByName(String name);

    List<Job> sortByName();

    List<Job> sortByMoney();
}
