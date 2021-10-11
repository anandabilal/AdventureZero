package AdventureZero;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class GUI {

    static Thread t = new Thread(new MultiThread());
    public static Stats s = new Stats();

    static JLabel action;
    static JLabel levelUp;
    static JLabel statsUp;

    static JTextField fieldLevel;
    static JTextField fieldHp;
    static JTextField fieldAtk;
    static JTextField fieldDef;
    static JTextField fieldExp;

    static JButton bStart;
    static JButton bPause;
    static JButton bLoad;
    static JButton bSave;

    static JLabel progress;

    public static void main(String[] args) {

        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        frame.setSize(300, 330);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Adventure Zero");
        frame.add(panel);
        panel.setLayout(null);

        //progress
        progress = new JLabel("Click START to play the game");
        progress.setBounds(10, 260, 350, 30);
        panel.add(progress);

        //title
        JLabel title = new JLabel("Welcome to Adventure Zero");
        title.setBounds(60, 0, 200, 25);
        panel.add(title);

        //stats
        JLabel stat = new JLabel("STATS");
        stat.setBounds(8, 25, 120, 25);
        panel.add(stat);

        //value
        JLabel value = new JLabel("VALUE");
        value.setBounds(86, 25, 120, 25);
        panel.add(value);

        //level
        JLabel pLevel = new JLabel("LV");
        pLevel.setBounds(10, 50, 80, 25);
        pLevel.setToolTipText("Level");
        panel.add(pLevel);
        fieldLevel = new JTextField(Integer.toString(s.getLevel()),20);
        fieldLevel.setBounds(60, 50, 64, 25);
        fieldLevel.setToolTipText("Your level, the higher its value, the higher your stats are");
        fieldLevel.setHorizontalAlignment(SwingConstants.RIGHT);
        fieldLevel.setEditable(false);
        panel.add(fieldLevel);

        //hp
        JLabel pHp = new JLabel("HP");
        pHp.setBounds(10, 80, 80, 25);
        pHp.setToolTipText("Health Points");
        panel.add(pHp);
        fieldHp = new JTextField(Integer.toString(s.getHp()),20);
        fieldHp.setBounds(60, 80, 64, 25);
        fieldHp.setToolTipText("Determines how many health point you have");
        fieldHp.setHorizontalAlignment(SwingConstants.RIGHT);
        fieldHp.setEditable(false);
        panel.add(fieldHp);

        //atk
        JLabel pAtk = new JLabel("ATK");
        pAtk.setBounds(10, 110, 80, 25);
        pAtk.setToolTipText("Attack");
        panel.add(pAtk);
        fieldAtk = new JTextField(Integer.toString(s.getAtk()),20);
        fieldAtk.setBounds(60, 110, 64, 25);
        fieldAtk.setToolTipText("Determines how much damage you deal");
        fieldAtk.setHorizontalAlignment(SwingConstants.RIGHT);
        fieldAtk.setEditable(false);
        panel.add(fieldAtk);

        //def
        JLabel pDef = new JLabel("DEF");
        pDef.setBounds(10, 140, 80, 25);
        pDef.setToolTipText("Defense");
        panel.add(pDef);
        fieldDef = new JTextField(Integer.toString(s.getDef()),20);
        fieldDef.setBounds(60, 140, 64, 25);
        fieldDef.setToolTipText("Determines how much damage you take");
        fieldDef.setHorizontalAlignment(SwingConstants.RIGHT);
        fieldDef.setEditable(false);
        panel.add(fieldDef);

        //exp
        JLabel pExp = new JLabel("EXP");
        pExp.setBounds(10, 170, 80, 25);
        pExp.setToolTipText("Experience Points");
        panel.add(pExp);
        fieldExp = new JTextField(s.getExp() + "/1000",20);
        fieldExp.setBounds(60, 170, 64, 25);
        fieldExp.setToolTipText("Reaching 1000 EXP means level up, and will reset the EXP bar");
        fieldExp.setHorizontalAlignment(SwingConstants.RIGHT);
        fieldExp.setEditable(false);
        panel.add(fieldExp);

        //start or resume button
        bStart = new JButton(new AbstractAction("START") {
            @Override
            public void actionPerformed(ActionEvent e) {
                progress.setText("Running");
                if(bStart.getText().equals("RESUME")) {
                    bSave.setEnabled(false);
                    //resume() is deprecated, but still works in this project
                    t.resume();
                } else {
                    t.start();
                    bStart.setText("RESUME");
                    bStart.setToolTipText("Resume the current game");
                }
                bPause.setEnabled(true);
                bStart.setEnabled(false);
                bLoad.setEnabled(false);
            }
        });
        bStart.setBounds(150, 50, 100, 25);
        bStart.setToolTipText("Start the game");
        panel.add(bStart);

        //pause button
        bPause = new JButton(new AbstractAction("PAUSE") {
            @Override
            public void actionPerformed(ActionEvent e) {
                progress.setText("Paused");
                //suspend() is deprecated, but still works in this project
                t.suspend();
                bStart.setEnabled(true);
                bPause.setEnabled(false);
                bLoad.setEnabled(true);
                bSave.setEnabled(true);
            }
        });
        bPause.setBounds(150, 80, 100, 25);
        bPause.setToolTipText("Pause the game, can only be clicked when the game is running");
        bPause.setEnabled(false);
        panel.add(bPause);

        //load button
        bLoad = new JButton(new AbstractAction("LOAD") {
            @Override
            public void actionPerformed(ActionEvent e) {
                //load existing progress
                Load lf = new Load();
                lf.openFile();
                //to prevent errors in the console
                if(lf.fileExist) {
                    lf.readFile();
                    lf.closeFile();
                    progress.setText("Load save file successfully!");
                }
            }
        });
        bLoad.setBounds(150, 110, 100, 25);
        bLoad.setToolTipText("Load an existing 'saveFile.txt' in your Desktop, cannot be clicked when the game is running");
        panel.add(bLoad);

        //save button
        bSave = new JButton(new AbstractAction("SAVE") {
            @Override
            public void actionPerformed(ActionEvent e) {
                //save current game progress
                Save sf = new Save();
                sf.dirFile();
                sf.createFile();
                sf.closeFile();
                progress.setText("File saved successfully!");
            }
        });
        bSave.setBounds(150, 140, 100, 25);
        bSave.setToolTipText("Save your progress as 'saveFile.txt' into your Desktop, can only be clicked after the game has started and is not currently running");
        bSave.setEnabled(false);
        panel.add(bSave);

        //in-game action description
        action = new JLabel();
        action.setBounds(10, 200, 350, 30);
        panel.add(action);

        //levelUP
        levelUp = new JLabel();
        levelUp.setBounds(10, 220, 350, 30);
        panel.add(levelUp);

        //statsUP
        statsUp = new JLabel();
        statsUp.setBounds(10, 240, 350, 30);
        panel.add(statsUp);

        frame.setVisible(true);
    }

}
