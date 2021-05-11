package tech.getarrays.employeemanager;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import tech.getarrays.employeemanager.model.Employee;
import tech.getarrays.employeemanager.service.EmployeeService;

import java.util.List;

@Transactional
@RestController
@RequestMapping("/employee")
public class EmployeeResource {
    private final EmployeeService employeeService;

    public EmployeeResource(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    @CrossOrigin("*")
    @GetMapping("/all")
    public ResponseEntity<List<Employee>> getAllEmployees()
    {
        List<Employee> employees = employeeService.findALLEmployees();
        return  new ResponseEntity<>(employees, HttpStatus.OK);
    }
    @GetMapping("/find/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") long id)
    {
        Employee employee = employeeService.findEmployeeById(id);
        return  new ResponseEntity<>(employee, HttpStatus.OK);
    }
    @PostMapping("/add")
     public  ResponseEntity<Employee>  addEmployee(@RequestBody Employee employee)
    {
        Employee newemp= employeeService.addEmployee(employee);
        return  new ResponseEntity<>(newemp, HttpStatus.CREATED);
    }
    @PutMapping("/update")
    public  ResponseEntity<Employee>  updateEmployee(@RequestBody Employee employee)
    {
        Employee updateemp= employeeService.updateEmployee(employee);
        return  new ResponseEntity<>(updateemp, HttpStatus.OK);
    }
 @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable("id") long id)
 {
  employeeService.deleteEmployee(id);
  return  new ResponseEntity<>(HttpStatus.OK);
 }





}
