package ss13_search.repository;

import ss13_search.model.Job;
import ss13_search.utils.IdNotFoundException;
import ss13_search.utils.UniqueIDException;

import java.io.IOException;
import java.util.List;

public interface IJobRepository {

    List<Job> getAll();

    boolean checkCode(String code);

    void addJob(Job job);

    void removeJob(String code);

    void editJob(String code, Job job);

    Job findByCode(String code);

    List<Job> findByName(String name);
}
