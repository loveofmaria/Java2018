package teamView.service;

import teamView.domain.EmployeeType.Architect;
import teamView.domain.EmployeeType.Designer;
import teamView.domain.EmployeeType.Employee;
import teamView.domain.EmployeeType.Programmer;

public class TeamService {
    private int counter = 1;
    private static final int MAX_MEMBER = 5;
    private Programmer[] team = new Programmer[MAX_MEMBER];
    private int total = 0;

    public TeamService() {
    }

    public Programmer[] getTeam() {
        Programmer[] teamReality = new Programmer[total];
        for (int i = 0; i < teamReality.length; i++) {
            teamReality[i] = team[i];
        }
        return teamReality;
    }

    public void addMember(Employee e) throws TeamException {
        /*
         * 条件判断: 该员工已经是某团队成员
         * 
         **/
        // 成员已满，无法添加
        if (total >= MAX_MEMBER) {
            throw new TeamException("团队成员已满，无法继续添加!");
        }
        // 该成员不是开发人员，无法添加
        if (!(e instanceof Programmer)) {
            throw new TeamException("该成员不属于开发人员，无法添加!");
        }
        // 该员工已在本开发团队中
        if (isExist(e)) {
            throw new TeamException("该成员已经存在于团队中，无需重复添加!");
        }
        // 休假状态，忙碌状态无法添加
        Programmer programmer = (Programmer) e;
        if ("VERCATION".equals(programmer.getStatus().getName())) {
            throw new TeamException("该成员正在度假，无法添加!");
        } else if ("BUSY".equals(programmer.getStatus().getName())) {
            throw new TeamException("该成员已经存在团队中!");
        }
        // 团队最多只能有一名架构师，两名设计师，三名程序员
        int[] memberNumber = memberCounter(team);
        if (programmer instanceof Architect) {
            if (memberNumber[0] >= 1) {
                throw new TeamException("团队中最多只能有1名架构师!");
            } else if (programmer instanceof Designer) {
                if (memberNumber[1] >= 2) {
                    throw new TeamException("团队中最多只能有2名设计师!");
                }
            } else if (programmer instanceof Programmer) {
                if (memberNumber[2] >= 3) {
                    throw new TeamException("团队中最多只能有3名设计师!");
                }
            }
        }
        // 添加成员,修改状态，设置memberId
        team[total++] = programmer;
        programmer.setStatus(Status.BUSY);
        programmer.setMemberId(counter++);
    }

    // 从团队当中删除成员
    public void removeMember(int memberID) throws TeamException {
        int i = 0;
        for (; i < total; i++) {
            if (team[i].getMemberId() == memberID) {
                team[i].setStatus(Status.FREE);
                break;
            }
        }
        // 没找到
        if (i == total) {
            throw new TeamException("没有找到该成员，无法删除!");
        }
        // 获取删除对象的位置，从它后面第一个对象开始，把下标往前移动
        for (int j = i + 1; j < total; j++) {
            team[j - 1] = team[j];
        }
        // 最后一个对象删除「设置成null」
        team[--total] = null;
    }

    // 内部封装的一些方法
    private boolean isExist(Employee e) {
        for (int i = 0; i < total; i++) {
            if (team[i].getId() == e.getId()) {
                return true;
            }
        }
        return false;
    }

    private int[] memberCounter(Programmer[] programmers) {
        int numOfArch = 0;
        int numOfDes = 0;
        int numOfPro = 0;
        for (int i = 0; i < total; i++) {
            if (programmers[i] instanceof Architect) {
                numOfArch++;
            } else if (programmers[i] instanceof Designer) {
                numOfDes++;
            } else if (programmers[i] instanceof Programmer) {
                numOfPro++;
            }
        }
        int[] memberNumber = new int[3];
        memberNumber[0] = numOfArch;
        memberNumber[1] = numOfDes;
        memberNumber[2] = numOfPro;
        return memberNumber;
    }

    @Override
    public String toString() {
        // // {"13", "8", "杨任", "30", "19800", "15000", "2500"},
        String result = "";
        for (int i = 0; i < total; i++) {
            result += team[i].getId() + "\t" + team[i].getName() + "\t" + team[i].getAge() + "\t" + team[i].getSalary()
                    + "\t" + team[i].getStatus() + "\n";
        }

        return result;
    }
}
