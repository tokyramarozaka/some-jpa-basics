package com.example.schoolapigroupone.service;

import com.example.schoolapigroupone.model.Students;
import com.example.schoolapigroupone.repository.StudentsRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor // Cette annotation sert à injecter une instance du repository que le service utilise
public class StudentsService {
    private StudentsRepository repository; // que ce soit cette interface ou celle en JPQL ça marchera toujours
    // En vrai, on peut avoir un seul repository qui contient du JPA et du JPQL en même temps.

    public Students save(Students s){
        return repository.save(s);
    }

    public List<Students> findAllStudents(){
        return repository.findAll();
    }

    // Si c'est avec le repo JPQL rien de tout ça n'est necessaire... mais on peut pas retourner d'erreur si l'id n'existe pas
    public Students update(Long id, String newName){
        Optional<Students> student = repository.findById(id);
        if(student.isPresent()){
            student.get().setName(newName);
            return repository.save(student.get());
        }
        else {
            return null;
        }
    }

    public void deleteById(Long id){
        repository.deleteById(id);
    }

    public List<Students> findWhereNameLike(String query){
        return repository.findByNameContaining(query);
    }
}
