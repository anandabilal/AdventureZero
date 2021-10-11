package AdventureZero;

public class Activities {
    public String killMonster() {
        return "You killed a monster, ";
    }
}

class Ogre extends Activities {
    public String killMonster() {
        return "You killed an ogre, ";
    }
}

class Dragon extends Activities {
    public String killMonster() {
        return "You killed a dragon, ";
    }
}

class Elemental extends Activities {
    public String killMonster() {
        return "You killed an elemental, ";
    }
}

class Vampire extends Activities {
    public String killMonster() {
        return "You killed a vampire, ";
    }
}



