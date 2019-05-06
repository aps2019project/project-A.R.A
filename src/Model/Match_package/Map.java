package Model.Match_package;

import Exceptions.TargetNotInRangeException;
import Exceptions.ThePathIsBlockedException;
import Exceptions.WrongCommandException;
import Model.Card_package.Card;
import Model.Card_package.Force;

public class Map {
    final Cell[][] cells = new Cell[5][9];

    Map(){
        for(int x = 0; x<9; x++)
            for(int y = 0; y<5; y++)
                cells[y][x] = new Cell(x,y);
    }

    public Cell getCell(Coordination c) {
        return cells[c.getY()][c.getX()];
    }

    public Cell getCell(int x, int y) {
        if(x<1 || x>9 || y<1 || y>5)
            throw new WrongCommandException();
        return cells[y][x];
    }

    public Cell findPosition(Force force) {
        for (int i = 0; i < 5; i++)
            for (int j = 0; j < 9; j++)
                if (cells[i][j].hasCard(force))
                    return cells[i][j];
        return null;
    }

    public boolean checkPath(Coordination a, Coordination b, int maxDistance, int xChange, int yChange, boolean inFirstCell) {
        if (a.equals(b))
            return true;
        else if (maxDistance == 0)
            throw new TargetNotInRangeException();
        else if (getCell(a).hasCard() && !inFirstCell)
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

    public void move(Card card , int x, int y){
        Coordination target = new Coordination(x, y);
        Coordination startPoint = findPosition(((Force) card)).getCoordination();
        if(checkPath(startPoint, target, ((Force) card).getRange())) {
            getCell(target).setCard(card);
            getCell(startPoint).deleteCard();
        }
    }
}
