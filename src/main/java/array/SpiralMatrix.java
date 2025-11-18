package array;

public class SpiralMatrix {

    /*
    // 思路1：触碰到边界则转向
    static String spiralMatrix(int n){
        int left = 0;
        int right = n-1;
        int top = 0;
        int down = n-1;
        int count = 0;
        int[][] arr = new int[n][n];
        while(top<down && left<right){
            int column = left;
            int row = top;
            while(column < right){
                arr[row][column] = ++count;
                column++;
            }
            right--;
            while(row<down){
                arr[row][column] = ++count;
                row++;
            }
            down--;
            while(column > left){
                arr[row][column] = ++count;
                column--;
            }
            left++;
            while(row>top){
                arr[row][column] = ++count;
                row--;
            }
            top++;
        }
        if(n % 2 != 0 ){
            arr[(n-1)/2][(n-1)/2] = n*n;
        }
        return arr;
    }
    */

    // 思路2：填充完边界则转向
    static int[][] spiralMatrix(int n){
        int top = 0;
        int down = n-1;
        int left = 0;
        int right = n-1;
        int count = 1;
        int[][] arr = new int[n][n];

        while(left <= right && top <= down){

            int column = left;
            int row = top;
            while(column <= right){
                arr[row][column] = count++;
                column++;
            }
            top++;  // 填充完上边界则下移

            row = top;
            column = right;
            while(row <= down){
                arr[row][column] = count++;
                row++;
            }
            right--;    // 填充完右边界则左移

            row = down;
            column = right;
            while(column >= left){
                arr[row][column] = count++;
                column--;
            }
            down--;    // 填充完下边界后上移

            row = down;
            column = left;
            while(row >= top){
                arr[row][column] = count++;
                row--;
            }
            left++;     // 填充完左边界右移
        }
        return arr;
    }

    static String translateToString(int[][] arr){

        // 将二维数组转换为字符串返回（例如 "[[0,1,2],[7,8,3],[6,5,4]]"）
        int n = arr.length;
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < n; i++) {
            sb.append("[");
            for (int j = 0; j < n; j++) {
                sb.append(arr[i][j]);
                if (j < n - 1) sb.append(",");
            }
            sb.append("]");
            if (i < n - 1) sb.append(",");
        }
        sb.append("]");
        return sb.toString();
    }

    public static void main(String[] args) {


        System.out.println(translateToString(spiralMatrix(4)));
        System.out.println(translateToString(spiralMatrix(5)));
    }
}
