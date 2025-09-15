import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SpiralOrder {
    public List<Integer> spiralOrder(int[][] matrix){
        int left = 0, top = 0, bottom = matrix.length - 1, right = matrix[0].length - 1;
        List<Integer> arr = new ArrayList<>();
        while(left < right && top < bottom){
            for(int i = left; i <= right; i++){
                arr.add(matrix[top][i]);
            }
            top++;

            for(int i = top; i <= bottom; i++){
                arr.add(matrix[i][right]);
            }
            right--;

            for(int i = right; i >= left; i--){
                arr.add(matrix[bottom][i]);
            }
            bottom--;

            for(int i = bottom; i >= top; i--){
                arr.add(matrix[i][left]);
            }
            left++;
        }
        if(arr.size() != matrix.length * matrix[0].length){
            if(top == bottom){
                for(int i = left; i <= right; i++){
                    arr.add(matrix[top][i]);
                }
            } else {
                for(int i = top; i <= bottom; i++){
                    arr.add(matrix[i][right]);
                }
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        SpiralOrder sol = new SpiralOrder();
        
        int[][] matrix = new int[][]{
            new int[]{1,2,3,4},
            new int[]{5,6,7,8},
            new int[]{9,10,11,12}
        };
        ArrayList<Integer> target = new ArrayList<>(Arrays.asList(1,2,3,4,8,12,11,10,9,5,6,7));
        
        System.out.println(sol.spiralOrder(matrix).equals(target));
    }
}
