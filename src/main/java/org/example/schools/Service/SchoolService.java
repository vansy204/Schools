package org.example.schools.Service;

import org.example.schools.entity.School;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface SchoolService {
    public void saveSchool(School school);
    public Optional<School> getSchoolById(Long id);
    public School getSchoolByName(String schoolName);
    public School updateSchool(School school);
    public void deleteSchool(Long id);
    public List<School> findAll();
}
