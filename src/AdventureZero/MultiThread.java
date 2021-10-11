package AdventureZero;

public class MultiThread implements Runnable {

    Activities[] a = new Activities [4];

    @Override
    public void run() {
        try {
            int i = 0;
            a[0] = new Ogre();
            a[1] = new Dragon();
            a[2] = new Elemental();
            a[3] = new Vampire();
            while(true) {
                Thread.sleep(500);
                GUI.levelUp.setText(null);
                GUI.statsUp.setText(null);
                GUI.action.setText(a[i].killMonster() + "and gained " + GUI.s.getExpGain() + " EXP!");
                GUI.s.updateExp();
                if(GUI.s.getExp() >= 1000) {
                    GUI.s.updateLevel();
                    GUI.s.updateHp();
                    GUI.s.updateAtk();
                    GUI.s.updateDef();
                    GUI.s.resetExp();
                    GUI.levelUp.setText("Level UP! " + (GUI.s.getLevel() - 1) + " to " + GUI.s.getLevel());
                    GUI.statsUp.setText("HP +50, ATK +5, DEF +3");
                }
                GUI.fieldLevel.setText(Integer.toString(GUI.s.getLevel()));
                GUI.fieldHp.setText(Integer.toString(GUI.s.getHp()));
                GUI.fieldAtk.setText(Integer.toString(GUI.s.getAtk()));
                GUI.fieldDef.setText(Integer.toString(GUI.s.getDef()));
                GUI.fieldExp.setText(GUI.s.getExp() + "/1000");
                if(i == 3) {
                    i = 0;
                } else {
                    i++;
                }
            }
        } catch(Exception e) {
            //blank
        }
    }

}
