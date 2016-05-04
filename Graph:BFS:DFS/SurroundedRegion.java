/* Given a 2D board containing 'X' and 'O', capture all regions surrounded by 'X'.

A region is captured by flipping all 'O's into 'X's in that surrounded region.*/

// BRAINSTORM
// input with 2D board containg X and O
// output is 2D board with captured regions turned into X

// question, how do I find a surrouneded area?
// traverse by row and column? (No, if I do that how am i supposed to keep track of which x surround which os)
// maybe traverse using row and column, when i find an o, i use bfs to find either 1) an edge which means its not surrounded, or xs.
// if i find all xs on all sides before encountering an edge, then i can turn these os into xs.
// have a helper function named visit which returns a boolean for whether it is surrounded by xs or not.

//another algo, we know that if an area of os reaches the edge, it is not surronded.
// we can start by traversing the edges and finding the o's and marking them and their connected o's as *
// then traverse over the entire map, turn untouched o's to X's
// then turn * back to O's

public class Solution {
  public void solve(char[][] board) {
    if (board == null || board.length == 0) return;
    if (board.length <= 2 || board[0].length <= 2) return;

    // traverse top row and right col
    for (int i = 0; i < board[0].length; i ++) {
      if (board[0][i] == 'O') visit(0, i, board);
      if (board[board.length - 1][i] == 'O') visit(board.length - 1, i, board);
    }

    // traverse bottom row and left col
    for (int i = 0; i < board.length; i++) {
      if (board[i][0] == 'O') visit(i, 0, board);
      if (board[i][board[0].length - 1] == 'O') visit(i, board[0].length - 1, board);

    }

    // find all o's left
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[0].length; j++) {
        if (board[i][j] == 'O') board[i][j] = 'X';
      }
    }

    // find all * and replace back to O
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[0].length; j++) {
        if (board[i][j] == '*') board[i][j] = 'O';
      }
    }
  }

  public void visit(int i, int j, char[][] board) {
    board[i][j] = '*'; // mark this as a non surrounded o
    if (canVisit(i + 1, j, board)) visit(i + 1, j, board);
    if (canVisit(i - 1, j, board)) visit(i - 1, j, board);
    if (canVisit(i, j + 1, board)) visit(i, j + 1, board);
    if (canVisit(i, j - 1, board)) visit(i, j - 1, board);
  }

  public boolean canVisit(int i, int j, char[][] board) {
    return i > 0 && i < (board.length - 1) && j > 0 && j <  (board[0].length - 1) && board[i][j] == 'O';
  }
}
