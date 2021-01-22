package teamView.junit;

import org.junit.Test;

import teamView.domain.EmployeeType.Employee;
import teamView.service.NameListService;
import teamView.service.TeamException;
import teamView.service.TeamService;

public class TeamServiceTest {

    private TeamService teamService = new TeamService();    

    @Test
    public void testAddMember() {
        NameListService nameListService = new NameListService();
        Employee[] employees = nameListService.getAllEmployees();
        for (int i = 0; i < employees.length; i++) {
            try {
                teamService.addMember(employees[i]);
            } catch (TeamException e) {
                System.out.println(e.getMessage());
            }
        }
       
        for (int i=0; i<5; i++) {
            System.out.println(teamService.getTeam()[i]);
        }
    }

    @Test
    public void testRemoveMember() {
        NameListService nameListService = new NameListService();
        Employee[] employees = nameListService.getAllEmployees();
        for (int i = 0; i < employees.length; i++) {
            try {
                teamService.addMember(employees[i]);
            } catch (TeamException e) {
                System.out.println(e.getMessage());
            }
        }
        
        System.out.println(teamService);
       
        try {
            teamService.removeMember(2);
        } catch (TeamException e) {
            System.out.println(e.getMessage());
        } 
        
        System.out.println("------------------------------------------");
        System.out.println(teamService);
    }
}
