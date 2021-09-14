import com.sun.xml.internal.ws.api.message.Message;

import java.io.IOException;

class Board
{
    private final int SIZE = Game.SIZE;
    static final int WIN = 5;
    Cell[][] board;
    Status turn = Status.WHITE;

    Board()
    {
        this.board = new Cell[SIZE][SIZE];
        for(int x = 0; x < SIZE; x++)
        {
            for(int y = 0; y < SIZE; y++)
            {
                this.board[x][y] = new Cell();
                this.board[x][y].setCoord(new Coord(x, y));
            }
        }
        this.board[SIZE/2][SIZE/2].setStatus(Status.BLACK);
    }

    void switchTurn()
    {
        if(this.turn == Status.WHITE)
            this.turn = Status.BLACK;
        else
            this.turn = Status.WHITE;
    }


    boolean tieCondition()
    {
        //-------New
        for(int x = 0; x < SIZE; x++) {
            for (int y = 0; y < SIZE; y++) {
                try {
                    try {
                        if ((this.board[x][y].getStatus() == Status.BLACK) &&
                                (this.board[x + 2][y].getStatus() == Status.BLACK) &&
                                (this.board[x + 1][y - 1].getStatus() == Status.BLACK) &&
                                (this.board[x + 1][y - 2].getStatus() == Status.BLACK)) {
                            return true;
                        }
                    } catch (Exception e) {

                    }
                   try{
                       if ((this.board[x][y].getStatus() == Status.BLACK) &&
                               (this.board[x + 2][y].getStatus() == Status.BLACK) &&
                               (this.board[x + 1][y + 1].getStatus() == Status.BLACK) &&
                               (this.board[x + 1][y + 2].getStatus() == Status.BLACK)) {
                           return true;
                       }
                   } catch (Exception e) {

                   }
                    try {
                        if ((this.board[x][y].getStatus() == Status.BLACK) &&
                                (this.board[x + 2][y].getStatus() == Status.BLACK) &&
                                (this.board[x + 1][y - 2].getStatus() == Status.BLACK) &&
                                (this.board[x + 1][y - 3].getStatus() == Status.BLACK) &&
                                (this.board[x + 1][y - 4].getStatus() == Status.BLACK)) {
                            return true;
                        }
                    } catch (Exception e) {

                    }
                    try {
                        if ((this.board[x][y].getStatus() == Status.BLACK) &&
                                (this.board[x + 2][y].getStatus() == Status.BLACK) &&
                                (this.board[x + 1][y + 2].getStatus() == Status.BLACK) &&
                                (this.board[x + 1][y + 3].getStatus() == Status.BLACK) &&
                                (this.board[x + 1][y + 4].getStatus() == Status.BLACK)) {
                            return true;
                        }
                    } catch (Exception e) {

                    }
                    try {
                        if (this.board[x][y].getStatus() == Status.BLACK)

                            if ((this.board[x - 1][y].getStatus() == Status.BLACK) &&
                                    (this.board[x - 2][y].getStatus() == Status.BLACK) &&
                                    (this.board[x - 3][y].getStatus() == Status.EMPTY) &&
                                    (this.board[x - 3][y - 1].getStatus() == Status.BLACK) &&
                                    (this.board[x - 3][y - 2].getStatus() == Status.BLACK) &&
                                    (this.board[x - 3][y - 3].getStatus() == Status.BLACK)) {
                                return true;
                            }
                        } catch (Exception e) {

                        }
                            try {
                                if ((this.board[x + 1][y].getStatus() == Status.BLACK) &&
                                        (this.board[x + 2][y].getStatus() == Status.BLACK) &&
                                        (this.board[x + 3][y].getStatus() == Status.BLACK) &&
                                        (this.board[x + 3][y + 1].getStatus() == Status.BLACK) &&
                                        (this.board[x + 3][y + 2].getStatus() == Status.BLACK) &&
                                        (this.board[x + 3][y + 3].getStatus() == Status.BLACK)) {
                                    return true;
                                }
                            }catch (Exception e) {

                            }

                            try {
                                if ((this.board[x + 1][y].getStatus() == Status.BLACK) &&
                                        (this.board[x + 2][y].getStatus() == Status.BLACK) &&
                                        (this.board[x + 3][y].getStatus() == Status.BLACK) &&
                                        (this.board[x + 3][y - 1].getStatus() == Status.BLACK) &&
                                        (this.board[x + 3][y - 2].getStatus() == Status.BLACK) &&
                                        (this.board[x + 3][y - 3].getStatus() == Status.BLACK)) {
                                    return true;
                                }
                            }catch (Exception e) {

                            }
                            try {
                                if ((this.board[x - 1][y].getStatus() == Status.BLACK) &&
                                        (this.board[x - 2][y].getStatus() == Status.BLACK) &&
                                        (this.board[x - 3][y].getStatus() == Status.BLACK) &&
                                        (this.board[x - 3][y + 1].getStatus() == Status.BLACK) &&
                                        (this.board[x - 3][y + 2].getStatus() == Status.BLACK) &&
                                        (this.board[x - 3][y + 3].getStatus() == Status.BLACK)) {
                                    return true;
                                }
                            }catch (Exception e) {

                            }
                             try {
                                 if ((this.board[x + 1][y - 1].getStatus() == Status.BLACK) &&
                                         (this.board[x + 2][y - 2].getStatus() == Status.BLACK) &&
                                         (this.board[x - 1][y - 1].getStatus() == Status.BLACK) &&
                                         (this.board[x - 2][y - 2].getStatus() == Status.BLACK)) {
                                     return true;
                                 }
                             } catch (Exception e) {

                             }
                             try {
                                 if ((this.board[x - 1][y + 1].getStatus() == Status.BLACK) &&
                                         (this.board[x - 2][y + 2].getStatus() == Status.BLACK) &&
                                         (this.board[x - 1][y + 1].getStatus() == Status.BLACK) &&
                                         (this.board[x + 2][y + 2].getStatus() == Status.BLACK)) {
                                     return true;
                                 }
                             }catch (Exception e) {

                             }
                            try {
                                if ((this.board[x - 1][y - 1].getStatus() == Status.BLACK) &&
                                        (this.board[x - 2][y - 2].getStatus() == Status.BLACK) &&
                                        (this.board[x - 1][y + 1].getStatus() == Status.BLACK) &&
                                        (this.board[x - 2][y + 2].getStatus() == Status.BLACK)) {
                                    return true;
                                }
                            }catch (Exception e) {

                            }
                             try {
                                 if ((this.board[x + 1][y + 1].getStatus() == Status.BLACK) &&
                                         (this.board[x + 2][y + 2].getStatus() == Status.BLACK) &&
                                         (this.board[x + 1][y - 1].getStatus() == Status.BLACK) &&
                                         (this.board[x + 2][y - 2].getStatus() == Status.BLACK)) {
                                     return true;
                                 }
                             } catch (Exception e) {

                             }
                            try {
                                if ((this.board[x + 1][y - 1].getStatus() == Status.BLACK) &&
                                        (this.board[x + 1][y + 1].getStatus() == Status.BLACK) &&
                                        (this.board[x + 2][y].getStatus() == Status.BLACK)) {
                                    return true;
                                }
                            } catch (Exception e) {

                            }
                            try {
                                if ((this.board[x][y].getStatus() == Status.WHITE) &&
                                    (this.board[x][y - 1].getStatus() == Status.WHITE) &&
                                    (this.board[x + 2][y].getStatus() == Status.WHITE) &&
                                    (this.board[x + 3][y].getStatus() == Status.WHITE) &&
                                    (this.board[x + 2][y + 1].getStatus() == Status.WHITE) &&
                                    (this.board[x + 3][y + 2].getStatus() == Status.WHITE)) {
                                return true;
                            }
                        } catch (Exception e) {

                            }
                    } catch (Exception e) {
                }
                }
        }
        return false;
    }


    boolean winCondition(Coord coord)
    {
        int temp = 0;
        for(int i = -1 * (WIN - 1); i <= WIN - 1; i++)
        {
            if((coord.x + i < 0) || (coord.x + i >= SIZE))
                continue;
            if(this.board[coord.x + i][coord.y].getStatus() == this.turn)
            {
                temp++;
            }
            else
            {
                temp = 0;
            }
            if(temp == WIN)
            {
                return true;
            }
        }

        temp = 0;

        for(int i = -1 * (WIN - 1); i <= WIN - 1; i++)
        {
            if((coord.y + i < 0) || (coord.y + i >= SIZE))
                continue;
            if(this.board[coord.x][coord.y + i].getStatus() == this.turn)
            {
                temp++;
            }
            else
            {
                temp = 0;
            }
            if(temp == WIN)
            {
                return true;
            }
        }

        temp = 0;

        for(int i = -1 * (WIN - 1); i <= WIN - 1; i++)
        {
            if((coord.x + i < 0) || (coord.x + i >= SIZE) || (coord.y + i < 0) || (coord.y + i >= SIZE))
                continue;
            if(this.board[coord.x + i][coord.y + i].getStatus() == this.turn)
            {
                temp++;
            }
            else
            {
                temp = 0;
            }
            if(temp == WIN)
            {
                return true;
            }
        }

        temp = 0;

        for(int i = -1 * (WIN - 1); i <= WIN - 1; i++)
        {
            if((coord.x - i < 0) || (coord.x - i >= SIZE) || (coord.y + i < 0) || (coord.y+i >= SIZE))
                continue;
            if(this.board[coord.x-i][coord.y+i].getStatus() == this.turn)
            {
                temp++;
            }
            else
            {
                temp = 0;
            }
            if(temp == WIN)
            {
                return true;
            }
        }
        return false;
    }
}


