package practice20190909;

import java.util.Random;

abstract class Role{
    private String name;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public abstract int attack();
}
//魔法师
class Magicer extends Role{
    private int magicLevel;         //魔法等级
    private int magicHurt=5;        //魔法伤害
    public int getMagicLevel(){
        return magicLevel;
    }
    public void setMagicLevel(int level){
        if(level>0&&level<=10){
            magicLevel=level;
        }
        else
            System.out.println("魔法等级不对，重新输入。");
    }
    public int getMagicHurt() {
        return magicHurt;
    }
    @Override
    public int attack(){
        return getMagicLevel()*magicHurt;
    }
}
//战士
class Soldier extends Role{
    private int attackNum;

    public int getAttackNum() {
        return attackNum;
    }

    public void setAttackNum(int attackNum) {
        this.attackNum = attackNum;
    }
    @Override
    public int attack(){
        return getAttackNum();
    }
}

public class Team {
    Role[] roles=new Role[6];
    public void addMember(Role role){
        for(int i=0;i<roles.length;i++){
            if(roles[i]==null){
                roles[i]=role;
                break;
            }
//            else
//                System.out.println("队伍满了，重新组队。");
        }
    }
    public int attackSum(Role[] roles){
        int attackSum=0;
        for(Role role:roles){
            attackSum+=role.attack();
        }
        return attackSum;
    }

    public static void main(String[] args) {
        Random random=new Random();
        int a=10;
        Magicer m1=new Magicer();
        m1.setName("m1");
        m1.setMagicLevel(random.nextInt(a)+1);
        Magicer m2=new Magicer();
        m2.setName("m2");
        m2.setMagicLevel(random.nextInt(a)+1);
        Magicer m3=new Magicer();
        m3.setName("m3");
        m3.setMagicLevel(random.nextInt(a)+1);
        Soldier s1=new Soldier();
        s1.setName("s1");
        s1.setAttackNum(random.nextInt(a)+10);
        Soldier s2=new Soldier();
        s2.setName("s2");
        s2.setAttackNum(random.nextInt(a)+10);
        Soldier s3=new Soldier();
        s3.setName("s3");
        s3.setAttackNum(random.nextInt(a)+10);

        Team team=new Team();
        team.addMember(m1);
        team.addMember(m2);
        team.addMember(m3);
        team.addMember(s1);
        team.addMember(s2);
        team.addMember(s3);

        for(Role ro:team.roles){
            System.out.println(ro.getName()+"\t"+ro.attack());
        }
        System.out.println(team.attackSum(team.roles));
    }
}
