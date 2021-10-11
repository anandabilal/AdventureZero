package AdventureZero;

import java.io.File;
import java.util.Scanner;

public class Load {

    private Scanner scan;
    boolean fileExist = true;
    int  level, hp, atk, def, exp;

    public void openFile() {
        try {
            scan = new Scanner(new File(System.getProperty("user.home") + "/Desktop" + "/saveFile.txt"));
        } catch(Exception e) {
            //if file is not found
            fileExist = false;
            GUI.progress.setText("Unable to locate a save file!");
        }
    }

    public void readFile() {
        level = scan.nextInt();
        hp = scan.nextInt();
        atk = scan.nextInt();
        def = scan.nextInt();
        exp = scan.nextInt();
        GUI.s.setLevel(level);
        GUI.s.setHp(hp);
        GUI.s.setAtk(atk);
        GUI.s.setDef(def);
        GUI.s.setExp(exp);
        GUI.fieldLevel.setText(Integer.toString(GUI.s.getLevel()));
        GUI.fieldHp.setText(Integer.toString(GUI.s.getHp()));
        GUI.fieldAtk.setText(Integer.toString(GUI.s.getAtk()));
        GUI.fieldDef.setText(Integer.toString(GUI.s.getDef()));
        GUI.fieldExp.setText(GUI.s.getExp() + "/1000");
    }

    public void closeFile() {
        scan.close();
    }

}
