package RecursionRelated.BackTracing;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/*1 what is the constraint of the problem ?
 *   ok the constraint is the
 *       1  the movement of the knight
 *       2  the boundary condition which also limit the knight movements
 *       3  each square can have only single number , no repeat numbers ---- each position we travel just once !
 *       so the constraint will influence the solution set !
 *   suppose we have a solution !
 *   which contains the fixed size of the solution set x1  to x64
 *   and what is the value of that ?
 *   and we already know the x0 is 1 .
 *   [x0,x1,x2.......x63]
 *   that is very great !
 *   and the value for the selection of xi is setB{ 1 to 64 }
 *   and each step the value ++ but the x i ?  i is not with the fixed order . so we search the
 *   xi for push the setB value into the xi
 *   AND
 *   WHERE  IS THE  the end base condition of the search
 *   ？
 *   we get the 64 ! ?
 *   but such modeling maybe hard to code
 *   so after the sleep we got another modeling !
 *   so this time we use the
 *   x1 x2 ... x64 for the step and the
 *   value of the xi is the position of the step i
 *   this modeling seems more potential !
 *   and that is matching the node graph of the code !
 *
 *   so the layer indicates the step and the node value  represents the location !
 *   so the best the way to local the position so the value should be row and column
 *   so the solution is use the constraints to computing the next xi
 *   and use the backTracing to find the solution !
 *
 *   so the core code will be using the constraint to compute the set of the next choices of the xi
 *
 *  */
public class KnightTour {

    public static class Position {
        Integer row;
        Integer column;

        public Integer getRow() {
            return row;
        }

        public void setRow(Integer row) {
            this.row = row;
        }

        public Integer getColumn() {
            return column;
        }

        public void setColumn(Integer column) {
            this.column = column;
        }

        public Position(Integer row, Integer column) {
            this.row = row;
            this.column = column;
        }
    }


    int[][] tourMap = new int[5][5];
    int step = 1;

    List<Position> moveMent = Arrays.asList(
            new Position(1, 2),
            new Position(1, -2),
            new Position(-1, 2),
            new Position(-1, -2),
            new Position(2, 1),
            new Position(2, -1),
            new Position(-2, 1),
            new Position(-2, -1)
    );

    public void findTheSolution(Position position) {
        tourMap[position.row][position.column] = step;
        if (step == 25) {

            display();
        }
        List<Position> candidateList = findTheValueSet(position);
        for (Position nextPosition : candidateList) {
            step++;
            findTheSolution(nextPosition);
            tourMap[nextPosition.row][nextPosition.column] = 0;
            step--;
        }
    }

    private void display() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.printf("%5d", tourMap[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }

    /**
     * with this method we will use the constraints to compute all the potential values for the next back tracing !
     * but how to do that ?
     * 1  the movement of the knight
     * *       2  the boundary condition which also limit the knight movements
     * *       3  each square can have only single number , no repeat numbers ---- each position we travel just once !
     */
    public List<Position> findTheValueSet(Position currentRowColumn) {
        Integer currentRow = currentRowColumn.row;
        Integer currentColumn = currentRowColumn.column;
        return moveMent.stream().map(p -> {
            Integer newRow = p.row + currentRow;
            Integer newColumn = p.column + currentColumn;
            return new Position(newRow, newColumn);
        }).filter(e -> {
            Integer row = e.row;
            Integer column = e.column;
            boolean checkRow = (row >= 0) && (row <= 4);
            boolean checkColumn = (column >= 0) && (column <= 4);
            if (!checkColumn || !checkRow) return false;
            return tourMap[row][column] == 0;
        }).collect(Collectors.toList());
    }

    public static void main(String[] args) {
        KnightTour tour = new KnightTour();
        tour.findTheSolution(new Position(0, 0));
    }
}
