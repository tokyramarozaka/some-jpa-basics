package com.example.schoolapigroupone.repository;

import com.example.schoolapigroupone.model.Students;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/*
    IMPORTANT :  on peut avoir un repository qui utilise JPA et JPQL. Pas de soucis.
 */
public interface StudentsRepository extends JpaRepository<Students,Long>{
    // Add est deja présent à travers save dans JPA

    // FindALl est deja présent à traver findAll de JPA

    // deleteById est déjà présent à travers deleteById de JPA (dans le CRUD repository dont il herite)

    // Update se fait en 2 étapes: elle requiert de trouver l'etudiant et de setter son nom (si elle existe) et de le sauverarder
    // Pour cela je le mettrai plutot dans la couche service : ça appelle le repository deux fois.

    // Au final, on ajoute que ceci en fait ...
    List<Students> findByNameContaining(String query);
}

