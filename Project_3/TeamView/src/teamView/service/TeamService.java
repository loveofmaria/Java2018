package teamView.service;

import teamView.domain.EmployeeType.Employee;
import teamView.domain.EmployeeType.Programmer;

public class TeamService {
    private int counter=1;
    private static final int MAX_MEMBER=5;
    private Programmer[] team = new Programmer[MAX_MEMBER];
    private int total = 0;

    public Programmer[] getTeam() {
        return team;
    }

    public void addMember(Employee e) throws TeamException {

    }

    public void removeMember(int memberID) throws TeamException {

    }
    
}
