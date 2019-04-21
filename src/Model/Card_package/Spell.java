package Model.Card_package;

import Model.Match_package.Cell;
import Model.Match_package.CellEffectType;
import Model.Match_package.Match;
import Model.Card_package.buff.*;
import java.util.ArrayList;

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
        if (!this.player.isManaEnoughFor(this)) {
            //handle err
            return false;
        }
        if (x >= 5 && y >= 9) {
            //handle err
            return false;
        }
        Match match = Match.getInstance();
        Cell cell = match.getMap().getCell(x, y);

        switch (spellType){
            case TOTAL_DISARM:
                return canPutTotalDisarm(cell);
            case AREA_DISPEL:
                return canPutAreaDispel(x, y);
            case EMPOWER:
                return canPutEmpower(cell);
            case FIREBALL:
                return canPutFireball(cell);
            case GOD_STRENGTH:
                return canPutGodStrength(cell);
            case HELL_FIRE:
                return canPutHellFire(x, y);
            case LIGHTING_BOLT:
                return canPutLightingBolt(cell);
            case POISON_LAKE:
                return canPutPoisonLake(x, y);
            case MADNESS:
                return canPutMadness(cell);
            case ALL_DISARM:
                return canPutAllDisarm();
            case ALL_POISON:
                return canPutAllPoison();
            case DISPEL:
                return canPutDispel(cell);
            case HEALTH_WITH_PROFIT:
                return canPutHealthWithProfit(cell);
            case POWER_UP:
                return canPutPowerUp(cell);
            case ALL_POWER:
                return canPutAllPower();
            case ALL_ATTACK:
                return canPutAllAttack(match, x, y);
            case WEAKENING:
                return canPutWeakening(cell);
            case SACRIFICE:
                return canPutSacrifice(cell);
            case KINGS_GUARD:
                return canPutKingsGuard(match, x, y);
            case SHOCK:
                return canPutShock(cell);
        }
        return true;
    }
    public void putCard(int x, int y) {
        Match match = Match.getInstance();
        switch (spellType){
            case TOTAL_DISARM:
                putTotalDisarm(x, y, match);
                break;
            case AREA_DISPEL:
                putAreaDispel(x, y, match);
                break;
            case EMPOWER:
                putEmpower(x, y, match);
                break;
            case FIREBALL:
                putFireBall(x, y, match);
                break;
            case GOD_STRENGTH:
                putGodStrength(x, y, match);
                break;
            case HELL_FIRE:
                putHellFire(x, y, match);
                break;
            case LIGHTING_BOLT:
                putLightingBolt(x, y, match);
                break;
            case POISON_LAKE:
                putPoisonLake(x, y, match);
                break;
            case MADNESS:
                /////
            case ALL_DISARM:
                putAllDisarm(match);
                break;
            case ALL_POISON:
                putAllPoison(match);
                break;
            case DISPEL:
                putDispel(x, y, match);
                break;
            case HEALTH_WITH_PROFIT:
                ///
            case POWER_UP:
            case ALL_POWER:
            case ALL_ATTACK:
            case WEAKENING:
            case SACRIFICE:
            case KINGS_GUARD:
            case SHOCK:
        }
    }




    private void putTotalDisarm(int x, int y, Match match) {
        Force force = match.getMap().getCell(x, y).getForce();
        force.addBuff(new Buff(force, BuffType.DISARM, BuffTime.CONTINUAL));
    }
    private void putAreaDispel(int x, int y, Match match) {
        ArrayList<Force> forces = getMXNForces(x, y, match, 2, 2);
        for (Force force : forces) {
            dispel(force);
        }
    }
    private void putEmpower(int x, int y, Match match) {
        match.getCell(x, y).getForce().increaseAp(2);
    }
    private void putFireBall(int x, int y, Match match) {
        match.getCell(x, y).getForce().decreaseHp(4);
    }
    private void putGodStrength(int x, int y, Match match) {
        match.getCell(x, y).getForce().increaseAp(4);
    }
    private void putHellFire(int x, int y, Match match) {
        for (Cell cell : getMXNCells(x, y, match, 2, 2)){
            cell.addCellEffect(new CellEffect(CellEffectType.FIRE, 2));
        }
    }
    private void putLightingBolt(int x, int y, Match match) {
        match.getCell(x, y).getForce().decreaseHp(8);

    }
    private void putPoisonLake(int x, int y, Match match) {
        for (Cell cell : getMXNCells(x, y, match, 3, 3)) {
            cell.addCellEffect(new CellEffect(CellEffectType.POISON, 1));
        }
    }
    private void putAllDisarm(Match match) {
        for (Force force : getMXNForces(0, 0, match, 5, 9)){
            if (!force.isTeammate(this)) {
                force.addBuff(new Buff(force, BuffType.DISARM, 1));
            }
        }
    }
    private void putAllPoison(Match match) {
        for (Force force : getMXNForces(0, 0, match, 5, 9)) {
            if (!force.isTeammate(this)) {
                force.addBuff(new Buff(force, BuffType.POISON, 4));
            }
        }
    }
    private void putDispel(int x, int y, Match match) {
        Force force = match.getCell(x, y).getForce();
        dispel(force);
    }


    private ArrayList<Force> getMXNForces(int x, int y, Match match, int m, int n){
        ArrayList<Force> forces = new ArrayList<>();
        for (Cell cell : getMXNCells(x, y, match, m, n))
            if (!cell.isEmpty())
                forces.add(cell.getForce());
        return forces;
    }
    private ArrayList<Cell> getMXNCells(int x, int y, Match match, int m, int n) {
        ArrayList<Cell> cells = new ArrayList<>();
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                cells.add(match.getCell(x + i, y + j));
        return cells;
    }
    private void dispel(Force force) {
        if (this.isTeammate(force))
            force.removeNegativeBuffs();
        else
            force.removePositiveBuffs();
    }

    private boolean canPutTotalDisarm(Cell cell) {
        if (!isEnemyForceInIt(cell)) {
            ///handle err
            return false;
        }
        return true;
    }
    private boolean canPutAreaDispel(int x, int y) {
        if (is2X2(x, y))
            return true;
        //hsndle err
        return false;
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
    private boolean canPutHellFire(int x, int y) {
        if (is2X2(x, y))
            return true;
        //handle err
        return false;
    }
    private boolean canPutLightingBolt(Cell cell) {
        if(!isEnemyHeroInIt(cell)){
            //err
            return false;
        }
        return true;
    }
    private boolean canPutPoisonLake(int x, int y) {
        if (is3X3(x, y))
            return true;
        //handle err
        return false;
    }
    private boolean canPutMadness(Cell cell) {
     if (!isOurForceInIt(cell)) {
         //handle err
         return false;
     }
     return true;
    }
    private boolean canPutAllDisarm() {
        return true;
    }
    private boolean canPutAllPoison() {
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
    private boolean canPutAllPower() {
        return true;
    }
    private boolean canPutAllAttack(Match match, int x, int y) {
        for (int i = 0; i < 5; i++) {
            if (!match.getCell(x, y).isEmpty())
                return true;
        }
        return false;
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
    private boolean canPutKingsGuard(Match match, int x, int y) {
        if (!isOurHeroInIt(match.getCell(x, y))){
            //handle err
            return false;
        }
        for (int i = -1; i < 2; i++)
            for (int j = -1; j < 2; j++) {
                if (isEnemyMinionInIt(match.getCell(x, y)))
                    return true;
            }
        return false;
    }
    private boolean canPutShock(Cell cell) {
        if (!isEnemyForceInIt(cell)) {
            //handle err
            return false;
        }
        return true;
    }

    private boolean isOurForceInIt(Cell cell) {
        if (cell.isEmpty())
            return false;
        if (cell.getForce().player == this.player)
            return true;
        return false;
    }
    private boolean isEnemyForceInIt(Cell cell) {
        if (cell.isEmpty())
            return false;
        if (cell.getForce().player != this.player)
            return true;
        return false;
    }
    private boolean isOurHeroInIt(Cell cell) {
        if (!isOurForceInIt(cell))
            return false;
        if (cell.getForce() instanceof Hero)
            return true;
        return false;
    }
    private boolean isEnemyHeroInIt(Cell cell) {
        if (!isEnemyForceInIt(cell))
            return false;
        if (cell.getForce() instanceof  Hero)
            return true;
        return false;
    }
    private boolean isOurMinionInIt(Cell cell) {
        if (!isOurForceInIt(cell))
            return false;
        if (cell.getForce() instanceof Minion)
            return true;
        return false;
    }
    private boolean isEnemyMinionInIt(Cell cell) {
        if (!isEnemyForceInIt(cell))
            return false;
        if (cell.getForce() instanceof Minion)
            return true;
        return false;
    }
    private boolean isMXM(int x, int y, int m) {
        if (x <= 5 - m && y <= 9 - m)
            return true;
        return false;
    }
    private boolean is2X2(int x, int y) {
        return isMXM(x, y, 2);
    }
    private boolean is3X3(int x, int y) {
        return isMXM(x, y, 3);
    }


}
