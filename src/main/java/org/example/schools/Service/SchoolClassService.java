package org.example.schools.Service;

import org.example.schools.entity.SchoolClass;

import java.util.List;
import java.util.Optional;

public interface SchoolClassService {
    public void save(SchoolClass c);
    public Optional<SchoolClass> getClassByName(String name);
    public List<SchoolClass> getAllClasses();
    public Optional<SchoolClass> delete(SchoolClass c);
    public SchoolClass updateClass(SchoolClass c);
}
