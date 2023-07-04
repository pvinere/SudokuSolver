import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Main {



    public static void print(int[][] board, int N)
    {

        for (int r = 0; r < N; r++)
        {
            for (int d = 0; d < N; d++)
            {
                System.out.print(board[r][d]);
                System.out.print(" ");
            }
            System.out.print("\n");

        }
    }

    public static void main(String args[]) {

        System.out.println("MENIU");
        System.out.println("1.Rezolvare Sudoku easy 9x9");
        System.out.println("2.Rezolvare Sudoku mediu 9x9");
        System.out.println("3.Rezolvare Sudoku hard 9x9");
        System.out.println("4.Rezolvare Sudoku 4x4");
        System.out.println("5.Rezolvare Sudoku 16x16");
        System.out.print("Introdu varianta:");
        Scanner s = new Scanner(System.in);
        int input = s.nextInt();

        switch (input)
        {

            case 1:
            {

                try {
                    Scanner sc = new Scanner((new BufferedReader(new FileReader("src/easy9x9.txt"))));
                    int rows = 9;
                    int cols = 9;
                    int [][] table9x9 = new int[rows][cols];
                    while(sc.hasNextLine())
                    {
                        for(int i = 0;i<table9x9.length;i++)
                        {
                            String []line = sc.nextLine().trim().split(" ");
                            for (int j=0; j<line.length; j++)
                            {
                                table9x9[i][j] = Integer.parseInt(line[j]);
                            }
                        }
                    }
                            int N = table9x9.length;
                            System.out.println("DE REZOLVAT 9X9 EASY:");
                            print(table9x9,N);

                            System.out.println(" ");

                            long startTime = System.nanoTime();
                            if (SudokuBacktracking.solveSudoku(table9x9, N))

                            {
                            //afisare solutie
                                long endTime = System.nanoTime();
                                System.out.println("Rezolvare Easy9x9: ");
                                print(table9x9, N);
                                System.out.println("TIMP REZOLVARE: " + (endTime - startTime) + " nanosecunde");
                                int ct = SudokuBacktracking.ret_counter();
                                System.out.println("DE CATE ORI S-A APELAT FUNCTIA RECURSIVA solveSudoku() "+ ct);
                             }
                            else {
                                 System.out.println("Nu are solutie!");
                            }

                            } catch (FileNotFoundException e) {
                             throw new RuntimeException(e);
                }
            }
            break;



            case 2:{
                try {
                    Scanner sc = new Scanner((new BufferedReader(new FileReader("src/mediu9x9.txt"))));
                    int rows = 9;
                    int cols = 9;
                    int [][] table9x9 = new int[rows][cols];
                    while(sc.hasNextLine())
                    {
                        for(int i = 0;i<table9x9.length;i++)
                        {
                            String []line = sc.nextLine().trim().split(" ");
                            for (int j=0; j<line.length; j++)
                            {
                                table9x9[i][j] = Integer.parseInt(line[j]);
                            }
                        }
                    }
                    int N = table9x9.length;
                    System.out.println("DE REZOLVAT 9X9 MEDIU:");
                    print(table9x9,N);
                    System.out.println(" ");


                    long startTime = System.nanoTime();
                    if (SudokuBacktracking.solveSudoku(table9x9, N))
                    {
                        long endTime = System.nanoTime();
                        //afisare solutie
                        System.out.println("Rezolvare Mediu9x9: ");
                        print(table9x9, N);
                        System.out.println("TIMP REZOLVARE: " + (endTime - startTime) + " nanosecunde");
                        int ct = SudokuBacktracking.ret_counter();
                        System.out.println("DE CATE ORI S-A APELAT FUNCTIA RECURSIVA solveSudoku() "+ ct);
                    }
                    else {
                        System.out.println("Nu are solutie!");
                    }

                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                }
            }
            break;
            //rezo
            case 3:{
                try {
                    Scanner sc = new Scanner((new BufferedReader(new FileReader("src/hard9x9.txt"))));
                    int rows = 9;
                    int cols = 9;
                    int [][] table9x9 = new int[rows][cols];
                    while(sc.hasNextLine())
                    {
                        for(int i = 0;i<table9x9.length;i++)
                        {
                            String []line = sc.nextLine().trim().split(" ");
                            for (int j=0; j<line.length; j++)
                            {
                                table9x9[i][j] = Integer.parseInt(line[j]);
                            }
                        }
                    }
                    int N = table9x9.length;
                    System.out.println("DE REZOLVAT 9X9 HARD:");
                    print(table9x9,N);
                    System.out.println(" ");
                    long startTime = System.nanoTime();
                    if (SudokuBacktracking.solveSudoku(table9x9, N))
                    {
                        long endTime = System.nanoTime();
                        //afisare solutie
                        System.out.println("Rezolvare HARD9x9: ");
                        print(table9x9, N);
                        System.out.println("TIMP REZOLVARE: " + (endTime - startTime) + " nanosecunde");
                        int ct = SudokuBacktracking.ret_counter();
                        System.out.println("DE CATE ORI S-A APELAT FUNCTIA RECURSIVA solveSudoku() "+ ct);

                    }
                    else {
                        System.out.println("Nu are solutie!");
                    }

                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                }

            }
            break;
            case 4:
            {
                try {
                    Scanner sc = new Scanner((new BufferedReader(new FileReader("src/4x4.txt"))));
                    int rows = 4;
                    int cols = 4;
                    int [][] table4x4 = new int[rows][cols];
                    while(sc.hasNextLine())
                    {
                        for(int i = 0;i<table4x4.length;i++)
                        {
                            String []line = sc.nextLine().trim().split(" ");
                            for (int j=0; j<line.length; j++)
                            {
                                table4x4[i][j] = Integer.parseInt(line[j]);
                            }
                        }
                    }
                    int N = table4x4.length;
                    System.out.println("DE REZOLVAT 4X4:");
                    print(table4x4,N);
                    System.out.println(" ");
                    long startTime = System.nanoTime();
                    if (SudokuBacktracking.solveSudoku(table4x4, N))
                    {
                        long endTime = System.nanoTime();
                        //afisare solutie
                        System.out.println("Rezolvare 4X4: ");
                        print(table4x4, N);
                        System.out.println("TIMP REZOLVARE: " + (endTime - startTime) + " nanosecunde");
                        int ct = SudokuBacktracking.ret_counter();
                        System.out.println("DE CATE ORI S-A APELAT FUNCTIA RECURSIVA solveSudoku() "+ ct);

                    }
                    else {
                        System.out.println("Nu are solutie!");
                    }

                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                }

            }
            break;
            case 5:
            {
                try {
                    Scanner sc = new Scanner((new BufferedReader(new FileReader("src/16x16.txt"))));
                    int rows = 16;
                    int cols = 16;
                    int [][] table16x16 = new int[rows][cols];
                    while(sc.hasNextLine())
                    {
                        for(int i = 0;i<table16x16.length;i++)
                        {
                            String []line = sc.nextLine().trim().split(" ");
                            for (int j=0; j<line.length; j++)
                            {
                                table16x16[i][j] = Integer.parseInt(line[j]);
                            }
                        }
                    }
                    int N = table16x16.length;
                    System.out.println("DE REZOLVAT 16X16:");
                    print(table16x16,N);
                    System.out.println(" ");
                    long startTime = System.nanoTime();
                    if (SudokuBacktracking.solveSudoku(table16x16, N))
                    {
                        long endTime = System.nanoTime();
                        //afisare solutie
                        System.out.println("Rezolvare 16X16: ");
                        print(table16x16, N);
                        System.out.println("TIMP REZOLVARE: " + (endTime - startTime) + " nanosecunde");
                        int ct = SudokuBacktracking.ret_counter();
                        System.out.println("DE CATE ORI S-A APELAT FUNCTIA RECURSIVA solveSudoku() "+ ct);
                    }
                    else {
                        System.out.println("Nu are solutie!");
                    }

                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                }
            }

        }


    }

    }







