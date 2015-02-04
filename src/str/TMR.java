package str;
import java.io.*;
import java.util.*;

public class TMR {
    private static final int WIDTH = 11;
    private int numberLines;
    public static final String FILE_NAME = "TMR.csv";
    private double[][] TMR;



    private void getData() throws Exception{
        BufferedReader input = new BufferedReader(new FileReader(FILE_NAME));
        String line = null;
        while( (line = input.readLine()) != null) {
            if(line.trim().length()==0)
                break;
            numberLines++;
        }
        input.close();
        TMR = new double[numberLines][WIDTH];
        BufferedReader input1 = new BufferedReader(new FileReader(FILE_NAME));
        for (int i = 0; i < numberLines; i++) {
            StringTokenizer token1 = new StringTokenizer(input1.readLine(), " \t\r\n");
            for (int j = 0; j < WIDTH; j++) {
                TMR[i][j] = Double.parseDouble(token1.nextToken().trim());
            }
        }
        input1.close();
    }


    public double interpolationTMR (double depth, double field) throws Exception {
        getData();
        int i = 1;
        if (depth < TMR[2][0]) {
            i = 1;
        } else {
            while (depth > TMR[i][0]) {
                i++;
            }
        }
        // i - tmr i x
        int k = 0;
        if (field < TMR[0][1]) {
            k = 1;
            return TMR[i][k];
        } else {
                while (field > TMR[0][k]) {
                k++;
                }
        }
        k = k - 1;
        double TMR1 = 0.0;
        TMR1 = ((field - TMR[0][k])*(TMR[i][k + 1] - TMR[i][k])) / (TMR[0][k + 1] - TMR[0][k]) + TMR[i][k];
        return TMR1;
    }
}
