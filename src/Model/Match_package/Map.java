package Model.Match_package;

import Model.Card_package.Force;

public class Map {
    final Cell[][] cells = new Cell[5][9];


    public Cell getCell(Coordination c) {
        return cells[c.getX()][c.getY()];
    }

    public Cell getCell(int x, int y){
        return cells[x][y];
    }

    public Cell findPosition(Force force) {
        for (int i = 0; i < 5; i++)
            for (int j = 0; j < 9; j++)
                if (cells[i][j].hasCard(force))
                    return cells[i][j];
        return null;
    }

    public PathSituation checkPath(Coordination a, Coordination b, int maxDistance, int xChange, int yChange, boolean inFirstCell) {
        if (a.equals(b))
            return PathSituation.OK;
        else if (maxDistance == 0)
            return PathSituation.NOT_IN_RANGE;
        else if (getCell(a).hasCard() && !inFirstCell)
            return PathSituation.BLOCKED;
        else {
            if (checkPath(new Coordination(a.getX() + xChange, a.getY()), b, maxDistance - 1, xChange, yChange, false).equals(PathSituation.OK))
                return PathSituation.OK;
            if (checkPath(new Coordination(a.getX(), a.getY() + yChange), b, maxDistance - 1, xChange, yChange, false).equals(PathSituation.OK))
                return PathSituation.OK;
        }
        return null; // not gonna happen
    }

    public PathSituation checkPath(Coordination a, Coordination b, int maxDistance) {
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


}
