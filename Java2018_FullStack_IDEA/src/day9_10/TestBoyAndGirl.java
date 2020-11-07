package day9_10;

public class TestBoyAndGirl {
    public static void main(String[] args) {
        Boy b1 = new Boy();
        Girl g1 = new Girl();
        Boy b2 = new Boy();
        Girl g2 = new Girl();
        b1.setAge(25);
        b1.setName("王不帅");
        g1.setAge(25);
        g1.setName("张美丽");
        b2.setAge(22);
        b2.setName("马超帅");
        g2.setAge(18);
        g2.setName("郝稠");

        b1.marryGirl(g2);
        g1.wantMarry(b2);
        b2.shout();
        g2.compare(g1);
    }
}
