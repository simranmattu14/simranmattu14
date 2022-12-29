import java.util.*;

public class TicTacToe {

    static ArrayList<Integer> playerPostion = new ArrayList<Integer>();
    static ArrayList<Integer> cpuPostion = new ArrayList<Integer>();

    static boolean endGame;

    public static void main(String[] args) {

        char[][] gameBoard = {{' ', '|', ' ', '|', ' '},
                            {'-', '+', '-', '+', '-'},
                            {' ', '|', ' ', '|', ' '},
                            {'-', '+', '-', '+', '-'},
                            {' ', '|', ' ', '|', ' '}};

        printGameBoard(gameBoard);

        while(true) {
            Scanner scan = new Scanner(System.in);
            System.out.println("Enter your placement (1-9):");
            int pos = scan.nextInt();

            while(playerPostion.contains(pos) || cpuPostion.contains(pos)){
                System.out.println("Position Taken. Please try again.");
                pos = scan.nextInt();
            }

            placePiece(gameBoard, pos, "player");

            String winner = checkWinner();
            System.out.println(winner);
            if(endGame){
                break;
            }

            Random rand = new Random();
            int cpuPos = rand.nextInt(9) + 1;
            while(playerPostion.contains(cpuPos) || cpuPostion.contains(cpuPos)){
                cpuPos = rand.nextInt(9) + 1;
            }
            placePiece(gameBoard, cpuPos, "computer");

            printGameBoard(gameBoard);

            winner = checkWinner();
            System.out.println(winner);
            if(endGame){
                break;
            }

        }
    }

    public static void printGameBoard(char[][] gameBoard){
        for(char[] row: gameBoard){
            for(char place: row){
                System.out.print (place);
            }
            System.out.println();
        }
    }
    public static void placePiece(char[][] gameBoard, int pos, String user){

        char symbol = 'X';
        if(user.equals("computer")){
            symbol = 'O';
            cpuPostion.add(pos);
        } else if (user.equals("player")) {
            playerPostion.add(pos);
        }

        switch (pos) {
            case 1 -> gameBoard[0][0] = symbol;
            case 2 -> gameBoard[0][2] = symbol;
            case 3 -> gameBoard[0][4] = symbol;
            case 4 -> gameBoard[2][0] = symbol;
            case 5 -> gameBoard[2][2] = symbol;
            case 6 -> gameBoard[2][4] = symbol;
            case 7 -> gameBoard[4][0] = symbol;
            case 8 -> gameBoard[4][2] = symbol;
            case 9 -> gameBoard[4][4] = symbol;
        }
    }

    public static String checkWinner(){
        List<Integer> topRow = Arrays.asList(1, 2, 3);
        List<Integer> midRow = Arrays.asList(4, 5, 6);
        List<Integer> botRow = Arrays.asList(7, 8, 9);

        List<Integer> cross1 = Arrays.asList(1, 5, 9);
        List<Integer> cross2 = Arrays.asList(3, 5, 7);

        List<Integer> topCol = Arrays.asList(1, 4, 7);
        List<Integer> midCol = Arrays.asList(2, 5, 8);
        List<Integer> botCol = Arrays.asList(3, 6, 9);

        List<List<Integer>> winningConditions = new ArrayList<>();
        winningConditions.add(topRow);
        winningConditions.add(midRow);
        winningConditions.add(botRow);
        winningConditions.add(cross1);
        winningConditions.add(cross2);
        winningConditions.add(topCol);
        winningConditions.add(midCol);
        winningConditions.add(botCol);

        for(List<Integer> l: winningConditions){
            if(playerPostion.containsAll(l)){
                endGame = true;
                return "Congrats. You won!";
            }else if(cpuPostion.containsAll(l)){
                endGame = true;
                return "Sorry. You lost.";
            } else if (playerPostion.size() + cpuPostion.size() >= 9){
                endGame = true;
                return "Tied.";
            }
        }
        return "";
    }

}
