package com.hhaie.backend.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@Service
public class UtilService {


    public static <T> T safeFindById(JpaRepository<T, Long> repository, Long id) {
        Optional<T> optional = repository.findById(id);
        if(optional.isPresent()) {
            return optional.get();
        } else {
            throw new EntityNotFoundException("Es wurde kein Element mit der gegebenen Id gefunden in: " + repository.getClass().getSimpleName());
        }
    }
}
