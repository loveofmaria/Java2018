package teamView.junit;

import org.junit.Test;

import teamView.domain.EmployeeType.Employee;
import teamView.service.NameListService;
import teamView.service.TeamException;

public class NameListServiceTest {

    @Test
    public void testGetAllEmployees() throws TeamException {
        NameListService service = new NameListService();
        Employee[] employees =  service.getAllEmployees(); 
        for(int i=0; i<employees.length; i++) {
            System.out.println(employees[i]);
        }      
    }

    @Test
    public void testGetEmployee() throws TeamException {
        NameListService service = new NameListService();
        service.getEmployee(11);               
    }

}
