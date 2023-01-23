import java.util.Scanner;

// IT IS THE MANAGER CLASS WHICH MANAGES ALL THE FUNCTIONS & MANAGES THE GAME
public class TicTacToe {
    // we should have 2 players
    private Player p1, p2;
    private Board board;


    // This Function, takes players input
    // creates Board
    // Conducts the game
    public void startGame() {
        Scanner sc = new Scanner(System.in);
        // Players input
        p1 = takePlayerInput(1);
        p2 = takePlayerInput(2);
        // we have to check whether symbol are matching or not
        // we had to keep checking until symbols are not same
        // so, we use while loop for this
        while(p1.getSymbol() == p2.getSymbol()) {
            System.out.println("Symbol already taken !! Pick another symbol !!");
            // taking new symbol as input
            char symbol = sc.next().charAt(0);
            // setting up new symbol for player 2
            p2.setSymbol(symbol);
        }

        // creating Board
        board = new Board(p1.getSymbol(), p2.getSymbol());

        // conducting Game
        // initially it is true means player's 1 turn
        boolean player1Turn = true;
        // initially assuming board is Incomplete
        int status = Board.INCOMPLETE;
        // loops runs until status is incomplete or invalid
        // loop will stop when p1 or p2 wins, or it's a draw
        while (status == Board.INCOMPLETE || status == Board.INVALID) {
            // if player 1 turn
            if(player1Turn) {
                System.out.println("Player1- "+p1.getName()+"s turn");
                System.out.println("Enter X: ");
                int x = sc.nextInt();
                System.out.println("Enter Y: ");
                int y = sc.nextInt();
                // this function tells us which symbol turn it is and at which coordinate
                // if coordinates are wrong it tells us that our coordinates are invalid
                // it will also tell us the status of the game whether it's a draw,p1 won, Incomplete
                status = board.move(p1.getSymbol(), x, y);
                if(status != Board.INVALID) {
                    // if status is not invalid then,
                    // now it's player2 turn so player1Turn must be false now
                    player1Turn = false;
                    board.print();
                }
                else {
                    System.out.println("INVALID MOVE !! TRY AGAIN !!");
                }
            }
            // if player 2 turn
            else {
                System.out.println("Player2 "+p2.getName()+"s turn");
                System.out.println("Enter X: ");
                int x = sc.nextInt();
                System.out.println("Enter Y: ");
                int y = sc.nextInt();
                // this function tells us which symbol turn it is and at which coordinate
                // if coordinates are wrong it tells us that our coordinates are invalid
                // it will also tell us the status of the game whether it's a draw,p1 won, Incomplete
                status = board.move(p2.getSymbol(), x, y);
                if(status != Board.INVALID) {
                    // if status is not invalid then,
                    // now it's player1 turn so player1Turn must be true now
                    player1Turn = true;
                    board.print();
                }
                else {
                    System.out.println("INVALID MOVE !! TRY AGAIN !!");
                }
            }
        }

        // if we come out of while loop
        if(status == Board.PLAYER_1_WINS) {
            System.out.println("Player1- "+p1.getName()+" wins!!");
        }
        else if(status == Board.PLAYER_2_WINS) {
            System.out.println("Player2- "+p2.getName()+" wins!!");
        }
        else {
            System.out.println("Draw!!");
        }
    }

    private Player takePlayerInput(int num) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter player "+num+" name:");
        String name = sc.nextLine();
        System.out.println("Enter player "+num+" symbol:");
        char symbol = sc.next().charAt(0);

        // creating a player object
        Player p = new Player(name, symbol);

        return p;
    }

    public static void main(String[] args) {
        TicTacToe t = new TicTacToe();
        t.startGame();
    }
}
