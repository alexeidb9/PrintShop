package main.java.repository;

import models.Prints.Print;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

@Repository
public interface PrintRepository extends CrudRepository<Print, Long> {


    List<Print> findByPrintId(Long id);
    List<Print> findByName(String name);



}



