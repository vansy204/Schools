package org.example.schools.Service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.example.schools.dao.SchoolClassRepository;
import org.example.schools.entity.SchoolClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SchoolClassServiceImpl implements SchoolClassService {
    SchoolClassRepository schoolClassRepository;
    EntityManager entityManager;

    @Autowired
    public SchoolClassServiceImpl(SchoolClassRepository schoolClassRepository, EntityManager entityManager) {
        this.schoolClassRepository = schoolClassRepository;
        this.entityManager = entityManager;
    }

    @Override
    public void save(SchoolClass c) {
        schoolClassRepository.save(c);
    }

    @Override
    public SchoolClass getClassByName(String name) {
        return null;
    }

    @Override
    public List<SchoolClass> getAllClasses() {
        TypedQuery<SchoolClass> query = entityManager.createQuery("select c from SchoolClass c", SchoolClass.class);
        List<SchoolClass> classes = query.getResultList();
        return classes;
    }

    @Override
    public void deleteClassByName(String name) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteClassByName'");
    }
}
