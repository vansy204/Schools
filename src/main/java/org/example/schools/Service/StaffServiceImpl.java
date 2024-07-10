package org.example.schools.Service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.example.schools.dao.StaffRepository;
import org.example.schools.entity.Staff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class StaffServiceImpl implements StaffService {
    EntityManager entityManager;
    StaffRepository staffRepository;
    @Autowired
    public StaffServiceImpl(EntityManager entityManager, StaffRepository staffRepository) {
        this.entityManager = entityManager;
        this.staffRepository = staffRepository;
    }
    @Override
    public List<Staff> findStaffByFirstName(String firstName) {
        TypedQuery<Staff> query = entityManager.createQuery("select s from Staff s where s.firstName=:firstName", Staff.class);
        query.setParameter("firstName", firstName);
        List<Staff> staffs = query.getResultList();
        return staffs;
    }

    @Override
    public List<Staff> findStaffByRole(String role) {
        TypedQuery<Staff> query = entityManager.createQuery("select s from Staff s where s.role=:role", Staff.class);
        query.setParameter("role", role);
        List<Staff> staffs = query.getResultList();
        return staffs;
    }

    @Override
    public Staff findStaffByEmail(String email) {
        TypedQuery<Staff> query = entityManager.createQuery("select s from Staff s where s.email=:email", Staff.class);
        query.setParameter("email", email);
        Staff staff = query.getSingleResult();
        return staff;
    }

    @Override
    public Staff findStaffByClassLeader(String classLeader) {
        TypedQuery<Staff> query = entityManager.createQuery("select s from Staff s where s.classLeader=:classLeader", Staff.class);
        query.setParameter("classLeader", classLeader);
        Staff staff = query.getSingleResult();
        return staff;
    }
}
