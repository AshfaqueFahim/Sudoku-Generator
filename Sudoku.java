import java.util.*;
public class Sudoku{
    public static void main(String[] args){
        int[][] puzzle = new int[9][9];
        int[] a = new int[3];
        int[] b = new int[3];
        int[] c = new int[3];
        threeLists(a, b, c); // create 3 random triangles
        
        setTriangles(puzzle, a, b, c, 0); //place them on puzzle, rotating through each column
        fillEdgeColumns(puzzle);
        fillMiddleColumns(puzzle, a, b, c, 1); //fills middle colum obviosuly
        printpuzzle(puzzle);

        
    }
    
    public static void threeLists(int[]a, int[]b, int[]c){
        ArrayList<Integer> lol = new ArrayList<>();
        for (int i = 1; i <=9; i++){
            lol.add(i);                  //[1,2,3,4,5,6,7,8,9]
        }
        for (int i = 0; i < 3; i++){
            int x = (int) (Math.random() * lol.size());
            a[i] = lol.get(x);
            lol.remove(x);
            x = (int) (Math.random() * lol.size());
            b[i] = lol.get(x);
            lol.remove(x);
            x = (int) (Math.random() * lol.size());
            c[i] = lol.get(x);
            lol.remove(x);
        }
    }
    
    public static void setTriangles(int[][]puzzle, int[]a, int[]b, int[]c, int column){ //put all orientations of trianlgles in their deidcated box
        if (column >= 3) {
            return;
        }
        int[][] conc = new int[3][3];
        conc[0] = a;
        conc[1] = b; 
        conc[2] = c;
        for (int i = 0; i < 3; i++){
            puzzle[i * 3][column*3] = conc[i][0]; 
            puzzle [i * 3 + 2][column * 3] = conc[i][1]; 
            puzzle[i*3 + 1][column*3 + 2] = conc[i][2]; 
        }
        column++;
        rotateTriangle(a);
        rotateTriangle(b);
        rotateTriangle(c);
        setTriangles(puzzle, a, b, c, column);
    }
    
    public static void rotateTriangle(int[]a){ //[195] -> [951] -> [519]
        int temp = a[0];
        a[0] = a[1];
        a[1] = a[2];
        a[2] = temp;
    }
    
    
    public static void printpuzzle(int[][] puzzle) { //prints puzzle...
        for (int i = 0; i < puzzle.length; i++) {
            if (i > 0 && i % 3 == 0) {
                System.out.println();
                System.out.println();
                System.out.println();
            }
            for (int j = 0; j < puzzle[i].length; j++) {
                if (j > 0 && j % 3 == 0) {
                    System.out.print("      ");
                }
                System.out.print(puzzle[i][j] + " ");
            }
            System.out.println();
        }
    }
    
    public static void fillEdgeColumns(int[][]puzzle){ //fills columns 1,3,4,6,7,9... 
        for (int i = 0; i < 3; i++){
            puzzle[1][i*3] = puzzle[7][i*3 + 2]; 
            puzzle[0][i*3 + 2] = puzzle[6][i*3]; 
            puzzle[2][i*3 + 2] = puzzle[8][i*3]; 
            
            puzzle[4][i*3] = puzzle[1][i*3 + 2];
            puzzle[3][i*3 + 2] = puzzle[0][i*3];
            puzzle[5][2 + i*3] = puzzle[2][i*3]; 
            
            puzzle[7][i*3] = puzzle[4][i*3 + 2];
            puzzle[6][i*3 + 2] = puzzle[3][i*3];
            puzzle[8][i*3 + 2] = puzzle[5][i*3];
        }
        
    }
    
    public static void fillMiddleColumns(int[][]puzzle, int[]a, int[]b, int[]c, int column){
        if (column >= 8) return;
        int[][] conc = new int[3][3];
        conc[0] = b;
        conc[1] = c; 
        conc[2] = a;
        for (int i = 0; i < 3; i++){
            puzzle[i*3][column] = conc[i][0]; 
            puzzle[i*3 + 1][column] = conc[i][1]; 
            puzzle[i*3 + 2][column] = conc[i][2];
        }
        rotateTriangle(a); rotateTriangle(b); rotateTriangle(c);
        column+=3;
        fillMiddleColumns(puzzle, a,b,c,column);
    }
    
}