package com.kristin.Tasks;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface TaskRepo extends CrudRepository<Tasks, Long> {

}
