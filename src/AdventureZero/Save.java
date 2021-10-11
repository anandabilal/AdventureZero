package AdventureZero;

import java.util.Formatter;

public class Save {

    private Formatter f;
    int level, hp, atk, def, exp;

    public void dirFile() {
        try {
            f = new Formatter(System.getProperty("user.home") + "/Desktop" + "/saveFile.txt");
        } catch(Exception e) {
            //blank
        }
    }

    public void createFile() {
        level = GUI.s.getLevel();
        hp = GUI.s.getHp();
        atk = GUI.s.getAtk();
        def = GUI.s.getDef();
        exp = GUI.s.getExp();
        f.format("%d\n%d\n%d\n%d\n%d\n", level, hp, atk, def, exp);
    }

    public void closeFile() {
        f.close();
    }

}
