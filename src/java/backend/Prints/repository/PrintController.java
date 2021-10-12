package backend.Prints.repository;


import backend.Prints.Print;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PrintController extends CrudRepository<Print, Long> {


    List<Print> findAll();

    List<Print> findByNameContainsIgnoreCase(String name);


//    @Query(
//            " SELECT d FROM Print d " +
//                    " WHERE " +
//                    " lower(d.name) LIKE lower(concat('%', :name, '%')) " +
//                    " AND lower(d.surname) LIKE lower(concat('%', :surname, '%')) "
//    )
//    List<Print> findByNameAndSurname(@Param("name") String name, @Param("surname") String surname);

}



