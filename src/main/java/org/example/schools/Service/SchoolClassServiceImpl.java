package org.example.schools.Service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.example.schools.dao.SchoolClassRepository;
import org.example.schools.entity.SchoolClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
    public Optional<SchoolClass> getClassByName(String name) {
        TypedQuery<SchoolClass> query = entityManager.createQuery("select c from SchoolClass c where c.className = :name", SchoolClass.class);
        query.setParameter("name", name);
        SchoolClass c = query.getSingleResult();
        return Optional.of(c);
    }


    @Override
    public List<SchoolClass> getAllClasses() {
        TypedQuery<SchoolClass> query = entityManager.createQuery("select c from SchoolClass c", SchoolClass.class);
        List<SchoolClass> classes = query.getResultList();
        return classes;
    }

    @Override
    public Optional<SchoolClass>delete(SchoolClass c) {
        schoolClassRepository.delete(c);
        return Optional.of(c);
    }

    @Override
    public SchoolClass updateClass(SchoolClass c) {
        entityManager.merge(c);
        return c;
    }
}
