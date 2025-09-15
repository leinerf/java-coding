import java.util.Arrays;

/*
1) iterate through all the elements in matrix
2) rotate swap elements 4 times
    2.0.1) top, bottom, left, right
    2.0.2) i = iterating index, n = iteration boundary
    2.1) switch formula = [top, i], [i, right], [bottom, n - i - 1]
*/

public class RotateMatrix {
    public void rotate(int[][] matrix){
        int top = 0, left = 0, right = matrix.length - 1, bottom = matrix.length - 1;
        while(left < right){
            for(int i = 0; i < (right - left); i++){
                int a = matrix[top][left + i];
                int b = matrix[top + i][right];
                int c = matrix[bottom][right - i];
                int d = matrix[bottom - i][left];

                matrix[top][left + i] = d;
                matrix[top + i][right] = a;
                matrix[bottom][right - i] = b;
                matrix[bottom - i][left] = c;
            }
            top++;
            left++;
            bottom--;
            right--;
        }
    }

    public static void main(String[] args) {
        RotateMatrix sol = new RotateMatrix();
        int[][] matrix = new int[][]{
            new int[]{1,2,3},
            new int[]{4,5,6},
            new int[]{7,8,9}
        };
        
        int[][] rotatedMatrix = new int[][]{
            new int[]{7,4,1},
            new int[]{8,5,2},
            new int[]{9,6,3}
        };

        System.out.println("not rotated 90 degree");
        for(int[] row: matrix){
            System.out.println(Arrays.toString(row));
        }
        
        sol.rotate(matrix);
        
        System.out.println("rotated 90 degree");
        for(int[] row: matrix){
            System.out.println(Arrays.toString(row));
        }

        System.out.println(Arrays.deepEquals(matrix, rotatedMatrix));
    }
}
