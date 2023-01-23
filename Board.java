public class Board {

    // creating board of 2D Array
    private char[][] board;
    private int boardSize = 3;
    // two players having there symbols
    private char p1, p2;
    // count will tell no. of cells of board that have been marked
    private int count;
    public final static int PLAYER_1_WINS = 1;
    public final static int PLAYER_2_WINS = 2;
    public final static int DRAW = 3;
    public final static int INCOMPLETE = 4;
    public final static int INVALID = 5;

    public Board(char p1, char p2) {
        // creating board of size 3X3
        board = new char[boardSize][boardSize];

        for(int i=0; i<boardSize; i++) {
            for(int j=0; j<boardSize; j++) {
                // initially we are storing ' ' in every cell
                // which ensures empty cell
                board[i][j] = ' ';
            }
        }
        // and lastly updating both players with symbol p1, p2
        this.p1 = p1;
        this.p2 = p2;
    }

    public int move(char symbol, int x, int y) {
        // we cannot make a move if these conditions are true
        if(x<0 || x>=boardSize || y<0 || y>=boardSize || board[x][y] != ' ') {
            return INVALID;
        }
        board[x][y] = symbol;
        count++;

        // Now checking we made a Win or Loose or Draw
        // Check Row
        if(board[x][0] == board[x][1] && board[x][0] == board[x][2]) {
            // if symbol is equals to player1 symbol then he wins else player 2 wins
            return symbol == p1 ? PLAYER_1_WINS : PLAYER_2_WINS;
        }
        // Check Column
        if(board[0][y] == board[1][y] && board[0][y] == board[2][y]) {
            // if symbol is equals to player1 symbol then he wins else player 2 wins
            return symbol == p1 ? PLAYER_1_WINS : PLAYER_2_WINS;
        }
        // Check first Diagonal
        // if diagonals are empty then it is also a match so, we check if it's not equal to empty
        if(board[0][0] != ' ' && board[0][0] == board[1][1] && board[0][0] == board[2][2]) {
            // if symbol is equals to player1 symbol then he wins else player 2 wins
            return symbol == p1 ? PLAYER_1_WINS : PLAYER_2_WINS;
        }
        // Check Second Diagonal
        // if diagonals are empty then it is also a match so, we check if it's not equal to empty
        if(board[0][2] != ' ' && board[0][2] == board[1][1] && board[0][2] == board[2][0]) {
            // if symbol is equals to player1 symbol then he wins else player 2 wins
            return symbol == p1 ? PLAYER_1_WINS : PLAYER_2_WINS;
        }

        // Now Checking for DRAW condition
        if(count == boardSize*boardSize) {
            return DRAW;
        }
        else {
            return INCOMPLETE;
        }
    }

    public void print() {
        System.out.println("-------------");
        for(int i=0; i<boardSize; i++) {
            for(int j=0; j<boardSize; j++) {
                System.out.print("| "+board[i][j]+" |");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println("-------------");
    }

}
