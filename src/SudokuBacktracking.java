public class SudokuBacktracking {

    static int counter = 0;

    public static boolean isSafe(int[][] board,int row, int col,int num)
    {
        //verifica daca exista numarul pe un rand
        for (int d = 0; d < board.length; d++)
        {
            //daca numarul pe care incercam as il introducem este prezent returneaza false
            if (board[row][d] == num) {
                return false;
            }
        }
        //verifica daca exista numarul pe o coloana
        for (int r = 0; r < board.length; r++)
        {
            //daca numarul pe care incercam as il introducem este prezent returneaza false
            if (board[r][col] == num)
            {
                return false;
            }
        }
        //verificare daca exista numarul intr-un box
        //se face radical din dimensiunea tabelei pentru a afla dimensiuniile boxului(la o tabela de 9x9 va fii box-ul 3x3
        int sqrt = (int)Math.sqrt(board.length);
        //seteaza start-ul la box
        int boxRowStart = row - row % sqrt;
        int boxColStart = col - col % sqrt;

        //parcurge box-ul
        for (int r = boxRowStart;r < boxRowStart + sqrt; r++)
        {
            for (int d = boxColStart; d < boxColStart + sqrt; d++)
            {
                //daca numarul se afla in box returneaza false
                if (board[r][d] == num)
                {
                    return false;
                }
            }
        }

        //daca numarul nu s-a gasit nici pe linie si coloana nici in box-uri atunci numarul merge adaugat
        return true;
    }
    //rezolvare sudoku cu Backtracking
    public static boolean solveSudoku(int[][] board, int n)
    {
        //contorizeaza de cate ori s-a apelat functia recursiva solveSudoku
        counter++;
        //variabilele row si col sunt initializate cu -1 si vor fi folosite pentru a retine pozitia unei celule libere din tabla de joc
        int row = -1;
        int col = -1;
        //variabila isEmpty este initializata cu true si va fi folosita pentru a verifica daca mai exista celule libere în tabela.
        boolean isEmpty = true;


        //se cauta o celula libera
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < n; j++)
            {
                //daca se gaseste o celula libera adica val este 0 si se actualizeaza isEmpty in true
                if (board[i][j] == 0)
                {
                    //row si col sunt actualizate cu pozitia acelei celule
                    row = i;
                    col = j;

                    isEmpty = false;
                    break;
                }
            }
            if (!isEmpty) {
                break;
            }
        }
        //daca nu mai sunt celule libere inseamna ca jocul s-a completat si returneaza true
        if (isEmpty)
        {
            return true;
        }
        //parcurgem numerele de la 1 la 9
        for (int num = 1; num <= n; num++)
        {
            //verifica daca numarul pe care il punem este sigur(poate fii pus in rand, coloana)
            if (isSafe(board, row, col, num))
            {
                board[row][col] = num;
                //apel recursiv pentru toate cazurile sigure de la 0 la 9

                if (solveSudoku(board, n))
                {
                    return true;
                }
                else
                {
                    board[row][col] = 0;
                }
            }
        }
        //daca nu s-a completat se reintoarce pana la if-ul care face solveSudoku true
        return false;
    }

    //pentru a afisa counter-ul
    public static int ret_counter()
    {
        return counter;
    }


}
