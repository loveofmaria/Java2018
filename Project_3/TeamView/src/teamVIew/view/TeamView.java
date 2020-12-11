package teamVIew.view;

import teamView.domain.EmployeeType.Architect;
import teamView.domain.EmployeeType.Designer;
import teamView.domain.EmployeeType.Employee;
import teamView.domain.EmployeeType.Programmer;
import teamView.service.NameListService;
import teamView.service.TeamException;
import teamView.service.TeamService;

public class TeamView {
    private NameListService nameListService = new NameListService();
    private TeamService teamService = new TeamService();

    public static void main(String[] args) {
        TeamView teamView = new TeamView();
        teamView.enterMainMenu();
    }

    public void enterMainMenu() {
        boolean loopFlag = true;
        while (loopFlag) {
            listAllemployees();
            System.out.println(
                    "-----------------------------------------------------------------------------------------------------------------------------------------\n");
            System.out.print("1-团队列表 2-添加团队成员 3-删除团队成员 4-退出 请选择(1-4): ");
            char menuSelected = TSUtility.readMenuSelection();
            switch (menuSelected) {
                case '1':
                    getTeam();
                    break;
                case '2':
                    try{
                        addMember();
                    } catch (TeamException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case '3':
                    try {
                        deleteMember();
                    } catch (TeamException e) {
                        System.out.println(e.getMessage());
                    }
                    
                    break;
                case '4':
                    System.out.print("确认退出(Y/N): ");
                    if (TSUtility.readConfirmSelection() == 'Y') {
                        loopFlag = false;
                    }
                    break;
                default:
                    loopFlag = false;
                    break;
            }
        }

    }

    private void listAllemployees() {
        System.out.println(
                "--------------------------------------------------------开发团队调度---------------------------------------------------------------------\n");
        System.out.println("ID\t\t姓名\t\t年龄\t\t工资\t\t职位\t\t状态\t奖金\t\t股票\t\t领用设备");
        Employee[] employees = nameListService.getAllEmployees();

        for (int i = 0; i < employees.length; i++) {
            if (employees[i] instanceof Architect) {
                System.out.println((((Architect) employees[i]).getDescription()));
            } else if (employees[i] instanceof Designer) {
                System.out.println((((Designer) employees[i]).getDescription()));
            } else if (employees[i] instanceof Programmer) {
                System.out.println((((Programmer) employees[i]).getDescription()));
            } else {
                System.out.println(employees[i].getDescription());
            }
        }

    }

    private void getTeam() {
        Employee[] team = teamService.getTeam();
        System.err.println("\n---------------------------------------------------------团队成员名单---------------------------------------------------------------");
        if (team.length == 0) {
            System.out.println("\n\t\t\t\t\t\t\t团队中没有添加任何成员!\n");
        } else {
            for (int i = 0; i < team.length; i++) {
                if (team[i] instanceof Architect) {
                    System.out.println((((Architect) team[i]).getDescription()));
                } else if (team[i] instanceof Designer) {
                    System.out.println((((Designer) team[i]).getDescription()));
                } else if (team[i] instanceof Programmer) {
                    System.out.println((((Programmer) team[i]).getDescription()));
                } else {
                    System.out.println(team[i].getDescription());
                }
            }
        }
    }

    private void addMember() throws TeamException {
        int employeeID = TSUtility.readInt();
        Employee employee = nameListService.getEmployee(employeeID);
        teamService.addMember(employee);
        System.out.println("添加成功!");
        getTeam();
    }

    private void deleteMember() throws TeamException {
        int employeeID = TSUtility.readInt();
        teamService.removeMember(employeeID);
        System.out.println("删除成功!");
        getTeam();
    }
}
