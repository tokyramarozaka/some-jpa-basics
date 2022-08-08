package com.example.schoolapigroupone.repository;

import com.example.schoolapigroupone.model.Students;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.persistence.NamedNativeQueries;
import java.util.List;

public interface StudentsRepositoryJPQL extends JpaRepository<Students, Long>{
    // Ceci n'est pas du tout necessaire mais bon... pour montrer qu'on peut le faire aussi avec JPQL
    @Query("SELECT s from Students s")
    List<Students> findAll();

    // Contrairement a JPA on pourrait le faire directement faire UPDATE avec JPQL avec une vraie requête UPDATE
    @Query("UPDATE Students s SET s.name = :newName WHERE s.id = :id")
    Students update(@Param("id") Long id, @Param("newName") String newName);

    @Query("SELECT s FROM Students s WHERE s.name LIKE CONCAT('%',:query,'%') ")
    List<Students> findByNameContaining(@Param("query") String query);

    /* Je mets ceci tout en bas... car 1) JPQL ne reçoit pas d'insert (JPA le fait deja donc pourquoi faire ??)
    2. si vraiment vous n'avez pas les moyens, de faire la requete voulue ...
    vous pouvez faire des requêtes natives à PostgreSQL (mais je deconseilles, ça veut dire que si on change de SGBD on change de code...) */
    @Query(value = "INSERT INTO students (name, group_id) VALUES (:s, :group_id)", nativeQuery = true)
    Students save(
            @Param("s") String name,
            @Param("group_id") Long id);
}
