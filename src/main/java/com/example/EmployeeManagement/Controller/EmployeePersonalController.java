

package com.example.EmployeeManagement.Controller;

import com.example.EmployeeManagement.DTO.EmployeeDTO;
import com.example.EmployeeManagement.DTO.EmployeePersonalDTO;
import com.example.EmployeeManagement.Model.Employee;
import com.example.EmployeeManagement.Model.EmployeePersonal;
import com.example.EmployeeManagement.Service.EmployeePersonalService;
import com.example.EmployeeManagement.Service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

        import java.util.List;

@RestController
@RequestMapping("/api/v1/hrms/employees")
@AllArgsConstructor
public class EmployeePersonalController {
    private EmployeeService employeeService;

    @GetMapping("/employees")
    public ResponseEntity<List<EmployeeDTO>> getAllEmployees(){
        List<EmployeeDTO> employees = employeeService.getAllEmployee();
        return ResponseEntity.ok(employees);
    }

    @GetMapping("/employees/{id}/profile")
    public ResponseEntity<EmployeeDTO> getEmployeeById(@PathVariable("id") Long id){
        EmployeeDTO employee = employeeService.getEmployeeById(id);
        return ResponseEntity.ok(employee);
    }

    @PostMapping("/employees")
    public ResponseEntity<EmployeeDTO> saveEmployee(@RequestBody Employee employee){
        EmployeeDTO savedEmployee = employeeService.addEmployee(employee);
        return ResponseEntity.ok(savedEmployee);
    }

    @DeleteMapping("/employees/{id}")
    public ResponseEntity<String> deleteEmployeeById(@PathVariable("id") Long id){
        employeeService.deleteEmployeeById(id);
        return ResponseEntity.ok("Employee deleted successfully");
    }
}

