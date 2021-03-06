package Model.Match_package;

import Exceptions.SelectedCardIsNotForceForMoveException;
import Exceptions.TargetNotInRangeException;
import Exceptions.ThePathIsBlockedException;
import Exceptions.WrongCommandException;
import Menus.MenuManager;
import Model.Card_package.Card;
import Model.Card_package.Force;
import Model.Match_package.cell.Cell;

import java.util.ArrayList;
import java.util.Random;

public class Map {
    final Cell[][] cells = new Cell[5][9];

    Map(){
        for(int x = 0; x<5; x++)
            for(int y = 0; y<9; y++)
                cells[x][y] = new Cell(x,y);
    }

    public Cell[][] getCells() {
        return cells;
    }

    public Cell getCell(Coordination c) {
        return cells[c.getX()][c.getY()];
    }

    public Cell getCell(int x, int y) {
        if(x<0 || x>4 || y<0 || y>8)
            throw new WrongCommandException();
        return cells[x][y];
    }

    public Cell findPosition(Force force) {
        for (int i = 0; i < 5; i++)
            for (int j = 0; j < 9; j++)
                if (cells[i][j].hasForce(force))
                    return cells[i][j];
        return null;
    }

    public boolean checkPath(Coordination a, Coordination b, int maxDistance, int xChange, int yChange, boolean inFirstCell) {
        if (a.equals(b))
            return true;
        else if (maxDistance == 0)
            throw new TargetNotInRangeException();
        else if (getCell(a).hasForce() && !inFirstCell)
            throw new ThePathIsBlockedException();
        else {
            if (checkPath(new Coordination(a.getX() + xChange, a.getY()), b, maxDistance - 1, xChange, yChange, false))
                return true;
            if (checkPath(new Coordination(a.getX(), a.getY() + yChange), b, maxDistance - 1, xChange, yChange, false))
                return true;
        }
        return false; // not gonna happen
    }

    public boolean checkPath(Coordination a, Coordination b, int maxDistance) {
        int xChange = 0;
        if (b.getX() > a.getX())
            xChange = 1;
        else if (b.getX() < a.getX())
            xChange = -1;
        int yChange = 0;
        if (b.getY() > a.getY())
            yChange = 1;
        else if (b.getY() < a.getY())
            yChange = -1;
        return checkPath(a, b, maxDistance, xChange, yChange, true);
    }

    public boolean hasCard(Card card) {
        for (Cell[] cellRow : cells)
            for (Cell cell : cellRow)
                if (cell.getForce().equals(((Force) card)))
                    return true;
        return false;
    }

    public void move(int x, int y){
        Match match = MenuManager.getCurrentMatch();
        Card card = match.getOwnPlayer().getSelectedCard();
        if (!(card instanceof Force))
            throw new SelectedCardIsNotForceForMoveException();
        Force force = (Force) card;
        Coordination target = new Coordination(x, y);
        Coordination startPoint = findPosition(force).getCoordination();
        if(checkPath(startPoint, target, 2)) {//todo check working
            getCell(target).setForce(force);
            getCell(startPoint).deleteForce();
        }//todo handle flags and collectable;
    }

    public ArrayList<Force> getForcesInMap() {
       return getForcesInMap(0, 0, 4, 8);
    }

    public ArrayList<Force> getForcesInMap(Player player) {
        ArrayList<Force> forces = new ArrayList<>();
        for(Force force : getForcesInMap())
            if (force.getPlayer() == player)
                forces.add(force);
        return forces;
    }

    public Force getRandomForceInMap(Player player){
        Random random = new Random();
        ArrayList<Force> forces = getForcesInMap(player);
        int index = random.nextInt(forces.size());
        return forces.get(index);
    }

    public ArrayList<Force> getForcesInMap(int x1, int y1, int x2, int y2) {
        ArrayList<Force> forces = new ArrayList<>();
        for(int i = x1; i <= x2; i++)
            for(int j = y1; j <= y2; j++)
                if (cells[i][j].hasForce())
                    forces.add(cells[i][j].getForce());
        return forces;
    }

    public ArrayList<Force> getForcesInMap(Player player, int x1, int y1, int x2, int y2) {
        ArrayList<Force> forces = new ArrayList<>();
        for (Force force : getForcesInMap(x1, y1, x2, y2)) {
            if (force.getPlayer() == player)
                forces.add(force);
        }
        return forces;
    }


    public Coordination getCoordination(Force force) {
        for (int i = 0; i < 5; i++)
            for(int j = 0; j < 9; j++)
                if (cells[i][j].hasForce() && cells[i][j].getForce().getID().equals(force.getID()))
                    return new Coordination(i, j);
        return null;
    }

    public void decrementTime() {
        for (Cell[] cells : cells) {
            for (Cell cell : cells) {
                cell.decrementTime();
            }
        }
    }
}
