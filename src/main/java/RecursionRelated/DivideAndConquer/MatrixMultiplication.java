package RecursionRelated.DivideAndConquer;

/** that is actually
 *  a very interesting divide and conquer problem
 *  with math the matrix multiplication
 *  so the abstraction matrix multiplication
 *  we use it frequently !
 *  so the logic is we do the high level matrix multiplication with the rule
 *  and we don't know the result but we assume we get the result .
 *
 *
 *  SQUARE-MATRIX-MULTIPLY-RECURSIVE.A B/
 * 1 n D A:rows
 * 2 let C be a new n 	 n matrix
 * 3 if n == 1
 * 4 c11 D a11  b11
 * 5 else partition A, B, and C as in equations (4.9)
 * 6 C11 D SQUARE-MATRIX-MULTIPLY-RECURSIVE.A11  B11/
 * C SQUARE-MATRIX-MULTIPLY-RECURSIVE.A12; B21/
 * 7 C12 D SQUARE-MATRIX-MULTIPLY-RECURSIVE.A11 B12/
 * C SQUARE-MATRIX-MULTIPLY-RECURSIVE.A12; B22/
 * 8 C21 D SQUARE-MATRIX-MULTIPLY-RECURSIVE.A21  B11/
 * C SQUARE-MATRIX-MULTIPLY-RECURSIVE.A22; B21/
 * 9 C22 D SQUARE-MATRIX-MULTIPLY-RECURSIVE.A21  B12/
 * C SQUARE-MATRIX-MULTIPLY-RECURSIVE.A22; B22/
 * 10 return C
 *  */
public class MatrixMultiplication {

}
