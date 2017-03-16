//rotate matrix

public class Rotate {

    public static void main(String args[])
    {
            int[][] m = {{1,2,3},{4,5,6},{7,8,9}};
            int[][] rotated = rotate(m);

        for (int i=0; i<m[0].length; i++)
           { 
                for (int j=0;j<m.length; j++)
             {
                System.out.print(rotated[i][j]+" ");
             }
            System.out.println();
           }

            
    }

    public static int[][] rotate(int[][] matrix) 
    {
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] output = new int[m][n];
        //transpose
        // for(int i = 0;i<n;i++){
        //     for(int j=i;j<n;j++){
        //         int temp = m[i][j];
        //         m[i][j]=m[j][i];
        //         m[j][i]=temp;
        //     }
        // }
        // //swap rows for anticlockwise rotation
        // for(int i =0;i<n;i++){
        //     for(int j=0;j<n/2;j++){
        //         int temp = m[i][j];
        //         m[i][j]=m[n-1-j][j];
        //         m[n-1-j][j]=temp;
        //     }
        // }

        // for(int row=0;row<rowlen;row++){
        //     for(int col=0;col<collen/2;col++){
        //         temp = matrix[row][col];
        //         matrix[row][col]=matrix[row][collen-col-1];
        //         matrix[row][collen-col-1]=temp;
        //     }
        // }
        // clockwise
        for (int i=0; i<n; i++)
                for (int j=0;j<m; j++)
                    output [j][n-i-1] = matrix[i][j];


            // anticlockwise
        // for (int i=0; i<n; i++)
        //     {
        //         for (int j=0;j<m; j++)
        //         {
        //             output [m-j-1][i] = matrix[i][j];
        //         }
        //     }

            return output;
    }
   
}