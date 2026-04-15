# Sudoku Generator

Ashfaque Fahim

A Java program that generates a valid 9x9 Sudoku puzzle using a cyclic permutation algorithm. No backtracking — the board is built mathematically using three randomly shuffled number sets.

How to Run:

1. Make sure you have Java installed
2. Compile the program:
   ```
   javac Sudoku.java
   ```
3. Run it:
   ```
   java Sudoku
   ```
A new puzzle is printed to the console every time you run it.

---

## How the Board is Generated

Three arrays (`a`, `b`, `c`) are randomly filled with the digits 1–9, three numbers each, with no repeats across all three. These arrays are placed onto the puzzle in a triangle pattern inside each 3×3 box, then cyclically rotated as the program moves across each column of boxes. Edge cells are filled by borrowing values from adjacent boxes above and below. Finally, the middle column of each box is filled using a shifted assignment of the three arrays, again rotating between box rows. The result is a fully valid Sudoku board with no repeated digits in any row, column, or 3×3 box.

---

## Files

| File | Description |
|------|-------------|
| `Sudoku.java` | Main source file containing all logic |
| `README.md` | This file |
