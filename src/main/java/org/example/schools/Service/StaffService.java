package org.example.schools.Service;

import org.example.schools.entity.Staff;

import java.util.List;

public interface StaffService {
    public List<Staff> findStaffByFirstName(String firstName);
    public List<Staff> findStaffByRole(String role);
    public Staff findStaffByEmail(String email);
    public Staff findStaffByClassLeader(String classLeader);
}
