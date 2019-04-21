package Model.Card_package;

import Model.Card_package.Spells.SpellType;
import Model.Match_package.Cell;
import Model.Match_package.Match;

public class Spell extends Card {
    SpellType spellType;

    public Spell(String ID, int cost, int mana) {
        super(ID, cost, mana);
    }

    private Spell(String ID, Spell mainSpell) {
        super(ID, mainSpell);
        this.spellType = mainSpell.spellType;
    }

    public Spell getCopy(String ID) {
        return new Spell(ID, this);
    }

    public boolean canPutCard(int x, int y) {
        if (!this.isManaEnough()) {
            return false;
        }
        Cell cell = Match.getInstance().getMap().getCell(x, y);
        switch (spellType) {
            case TOTAL_DISARM:
                return canPutTotalDisarm(cell);
            case EMPOWER:
                return canPutEmpower(cell);
            case FIREBALL:
                return canPutFireball(cell);
            case GOD_STRENGTH:
                return canPutGodStrength(cell);
            case LIGHTING_BOLT:
                return canPutLightingBolt(cell);
            case MADNESS:
                return canPutMadness(cell);
            case DISPEL:
                return canPutDispel(cell);
            case HEALTH_WITH_PROFIT:
                return canPutHealthWithProfit(cell);
            case POWER_UP:
                return canPutPowerUp(cell);
            case WEAKENING:
                return canPutWeakening(cell);
            case SACRIFICE:
                return canPutSacrifice(cell);
            case SHOCK:
                return canPutShock(cell);
        }
        return true;
    }

    private boolean canPutTotalDisarm(Cell cell) {
        if (!isEnemyForceInIt(cell)) {
            ///handle err
            return false;
        }
        return true;
    }

    private boolean canPutEmpower(Cell cell) {
        if (!isOurForceInIt(cell)) {
            //handle err
            return false;
        }
        return true;
    }

    private boolean canPutFireball(Cell cell) {
        if (!isEnemyForceInIt(cell)) {
            //handle err
            return false;
        }
        return true;
    }

    private boolean canPutGodStrength(Cell cell) {
        if (!isOurHeroInIt(cell)) {
            // handle err
            return false;
        }
        return true;
    }

    private boolean canPutLightingBolt(Cell cell) {
        if (!isEnemyHeroInIt(cell)) {
            //err
            return false;
        }
        return true;
    }

    private boolean canPutMadness(Cell cell) {
        if (!isOurForceInIt(cell)) {
            //handle err
            return false;
        }
        return true;
    }

    private boolean canPutDispel(Cell cell) {
        if (!isOurForceInIt(cell) && !isEnemyForceInIt(cell)) {
            //handle err
            return false;
        }
        return true;
    }

    private boolean canPutHealthWithProfit(Cell cell) {
        if (!isOurForceInIt(cell)) {
            //handle err
            return false;
        }
        return true;
    }

    private boolean canPutPowerUp(Cell cell) {
        if (isOurForceInIt(cell)) {
            //handle err
            return false;
        }
        return true;
    }

    private boolean canPutWeakening(Cell cell) {
        if (!isEnemyMinionInIt(cell)) {
            //handle err
            return false;
        }
        return true;
    }

    private boolean canPutSacrifice(Cell cell) {
        if (!isOurMinionInIt(cell)) {
            //handle err
            return false;
        }
        return true;
    }

    private boolean canPutShock(Cell cell) {
        if (!isEnemyForceInIt(cell)) {
            //handle err
            return false;
        }
        return true;
    }

    private boolean isOurForceInIt(Cell cell) {
        if (!cell.hasCard())
            return false;
        if (cell.hasPlayerCard(Match.getInstance().ownPlayer))
            return true;
        return false;
    }

    private boolean isEnemyForceInIt(Cell cell) {
        if (!cell.hasCard())
            return false;
        if (cell.hasPlayerCard(Match.getInstance().opponent))
            return true;
        return false;
    }

    private boolean isOurHeroInIt(Cell cell) {
        if (!isOurForceInIt(cell))
            return false;
        if (cell.getCard() instanceof Hero)
            return true;
        return false;
    }

    private boolean isEnemyHeroInIt(Cell cell) {
        if (!isEnemyForceInIt(cell))
            return false;
        if (cell.getCard() instanceof Hero)
            return true;
        return false;
    }

    private boolean isOurMinionInIt(Cell cell) {
        if (!isOurForceInIt(cell))
            return false;
        if (cell.getCard() instanceof Minion)
            return true;
        return false;
    }

    private boolean isEnemyMinionInIt(Cell cell) {
        if (!isEnemyForceInIt(cell))
            return false;
        if (cell.getCard() instanceof Minion)
            return true;
        return false;
    }
}
