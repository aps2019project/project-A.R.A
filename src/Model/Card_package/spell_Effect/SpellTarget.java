package Model.Card_package.spell_Effect;

import Menus.MenuManager;
import Model.Card_package.Hero;
import Model.Card_package.Minion;
import Model.Card_package.Spell;
import Model.Match_package.cell.Cell;
import Model.Match_package.Coordination;
import Model.Match_package.Map;

public enum SpellTarget {
    ENEMY_FORCE,
    OUR_FORCE,
    ENEMY_HERO,
    OUR_HERO,
    ENEMY_MINION,
    OUR_MINION,
    ALL_ENEMY_FORCE,
    ALL_OUR_FORCE,
    FORCE,
    VERTICAL_ENEMY,
    RANDOM_ENEMY_MINION_IN_NEIGHBOR_OF_OUR_HERO,
    CELLS2X2,
    CELLS3X3;

    public static boolean canPutSpellOn(Spell spell, Coordination coordination) {
        Cell cell = MenuManager.getCurrentMatch().getMap().getCell(coordination);
        switch (spell.getSpellTarget()) {
            case ENEMY_FORCE:
                return checkEnemyForce(spell, cell);
            case OUR_FORCE:
                return checkOurForce(spell, cell);
            case ENEMY_HERO:
                return checkEnemyHero(spell, cell);
            case OUR_HERO:
                return checkOurHero(spell, cell);
            case ENEMY_MINION:
                return checkEnemyMinion(spell, cell);
            case OUR_MINION:
                return checkOurMinion(spell, cell);
            case ALL_ENEMY_FORCE:
                return true;
            case ALL_OUR_FORCE:
                return true;
            case FORCE:
                return cell.hasForce();
            case VERTICAL_ENEMY:
                return checkVerticalEnemy(spell, coordination);
            case RANDOM_ENEMY_MINION_IN_NEIGHBOR_OF_OUR_HERO:
                return checkRandomEnemyMinionInNeighborOfOurHero(spell, coordination);
            case CELLS2X2:
                return check2X2(coordination);
            case CELLS3X3:
                return check3X3(coordination);
        }
        return true;
    }

    private static boolean checkEnemyForce(Spell spell, Cell cell) {
        if (!cell.hasForce())
            return false;
        return !cell.getForce().isTeammate(spell);
    }

    private static boolean checkEnemyHero(Spell spell, Cell cell) {
        if (!checkEnemyForce(spell, cell))
            return false;
        return cell.getForce() instanceof Hero;
    }

    private static boolean checkEnemyMinion(Spell spell, Cell cell) {
        if (!checkEnemyForce(spell, cell))
            return false;
        return cell.getForce() instanceof Minion;
    }

    private static boolean checkOurForce(Spell spell, Cell cell) {
        if (!cell.hasForce())
            return false;
        return cell.getForce().isTeammate(spell);
    }

    private static boolean checkOurHero(Spell spell, Cell cell) {
        if (!checkOurForce(spell, cell))
            return false;
        return cell.getForce() instanceof Hero;
    }

    private static boolean checkOurMinion(Spell spell, Cell cell) {
        if (!checkOurForce(spell, cell))
            return false;
        return cell.getForce() instanceof Minion;
    }

    private static boolean checkVerticalEnemy(Spell spell, Coordination coordination) {
        Map map = MenuManager.getCurrentMatch().getMap();
        Cell cell;
        for (int i = 0; i < 5; i++) {
            cell = map.getCell(i, coordination.getY());
            if (cell.hasForce() && !cell.getForce().isTeammate(spell))
                return true;
        }
        return false;
    }

    private static boolean checkRandomEnemyMinionInNeighborOfOurHero(Spell spell, Coordination coordination) {
        Map map = MenuManager.getCurrentMatch().getMap();
        Cell cell;
        if (!checkOurHero(spell, map.getCell(coordination)))
            return false;
        int x, y;
        for (int i = -1; i <= 1; i++)
            for (int j = -1; j <= 1; j++) {
                x = coordination.getX() + i;
                y = coordination.getY() + j;
                if (x < 0 || y < 0)
                    continue;
                if (x >= 5 || y >= 9)
                    continue;
                cell = map.getCell(x, y);
                if (cell.hasForce() && !cell.getForce().isTeammate(spell))
                    return true;
            }
        return false;
    }

    private static boolean check2X2(Coordination coordination) {
        return coordination.getX() < 4 && coordination.getY() < 8;
    }

    private static boolean check3X3(Coordination coordination) {
        return coordination.getX() < 3 && coordination.getY() < 7;
    }
}
