package org.example.schools.Service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.example.schools.dao.SchoolRepository;
import org.example.schools.entity.School;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SchoolServiceImpl  implements SchoolService {
    SchoolRepository schoolRepository;
    EntityManager entityManager;
    @Autowired
    public SchoolServiceImpl(SchoolRepository schoolRepository, EntityManager entityManager) {
        this.schoolRepository = schoolRepository;
        this.entityManager = entityManager;
    }

    @Override
    public void saveSchool(School school) {
        schoolRepository.save(school);
    }

    @Override
    public Optional<School> getSchoolById(Long id) {
        Optional<School> school = schoolRepository.findById(id);
        return school;
    }

    @Override
    public School getSchoolByName(String schoolName) {
        TypedQuery<School> query = entityManager.createQuery("SELECT s FROM School s WHERE s.name = :schoolName", School.class);
        query.setParameter("schoolName", schoolName);
        return query.getResultStream().findFirst().orElse(null);
    }
    @Override
    public School updateSchool(School school) {
        entityManager.merge(school);
        return school;
    }

    @Override
    public void deleteSchool(Long id) {
        Optional<School> school = schoolRepository.findById(id);
        if(school.isPresent()) {
            schoolRepository.delete(school.get());
        }
        return;
    }
    public List<School> findAll() {
        return schoolRepository.findAll();
    }
}
