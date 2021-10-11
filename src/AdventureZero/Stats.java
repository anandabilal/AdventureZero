package AdventureZero;

public class Stats {

    private int level = 1, hp = 100, atk = 10, def = 6, exp = 50;

    public void setLevel(int newLevel) {
        this.level = newLevel;
    }

    public void setHp(int newHp) {
        this.hp = newHp;
    }

    public void setAtk(int newAtk) {
        this.atk = newAtk;
    }

    public void setDef(int newDef) {
        this.def = newDef;
    }

    public void setExp(int newExp) {
        this.exp = newExp;
    }

    public void updateLevel() {
        level += 1;
    }

    public void updateHp() {
        hp += 50;
    }

    public void updateAtk() {
        atk += 5;
    }

    public void updateDef() {
        def += 3;
    }

    public void updateExp() {
        double currExp = exp;
        currExp = currExp * 0.65;
        exp += currExp;
    }

    public void resetExp() {
        exp %= 1000;
    }

    public int getLevel() {
        return this.level;
    }

    public int getHp() {
        return this.hp;
    }

    public int getAtk() {
        return this.atk;
    }

    public int getDef() {
        return this.def;
    }

    public int getExp() {
        return this.exp;
    }

    public int getExpGain() {
        double currExp = exp;
        currExp = currExp * 0.65;
        return (int) currExp;
    }

}
