//package backend.Prints;
//
//
//import java.util.List;
//
//public interface PrintRepository extends CrudRepository<Print, PrintType> {
//
//
//    List<Print> findAll();
//
//    List<Print> findByNameContainsIgnoreCase(String name);
//
//
//    @Query(
//            " SELECT d FROM Print d " +
//                    " WHERE " +
//                    " lower(d.name) LIKE lower(concat('%', :name, '%')) " +
//                    " AND lower(d.surname) LIKE lower(concat('%', :surname, '%')) "
//    )
//    List<Print> findByNameAndSurname(@Param("name") String name, @Param("surname") String surname);
//
//}
//
//
//}
