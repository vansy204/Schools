package org.example.schools.Service;

import org.example.schools.entity.SchoolClass;

import java.util.List;

public interface SchoolClassService {
    public void save(SchoolClass c);
    public SchoolClass getClassByName(String name);
    public List<SchoolClass> getAllClasses();
    public void deleteClassByName(String name);

}
