package net.javaguides.ems.repository;

import net.javaguides.ems.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
                                     // Jpa Reppository has two parameters 1)Type of Entity 2) Type of parameter
public interface EmployeeRepository extends JpaRepository<Employee,Long> {


}
