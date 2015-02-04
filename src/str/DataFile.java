package str;

import java.util.*;
import java.io.*;

public class DataFile {
    private double[] z;
    private double[] T;
    private int N;

    /*
     * Конструктор класса выполняет инициализацию массивов.
     */
    DataFile(String fileName) throws Exception {
        String line = null;

        // Открываем файл
        BufferedReader in1 = new BufferedReader(new FileReader(fileName));
        BufferedReader in2 = new BufferedReader(new FileReader(fileName));

        // Подсчитываем число непустых строк в текстовом файле
        N = 0;
        while( (line = in1.readLine()) != null) {
            if(line.trim().length()==0)
                break;
            N++;
        }

        // Создаем массивы данных для хранения N значений
        z = new double[N];
        T = new double[N];

        // Записываем данные из файла в массивы
        for(int i=0;i<N;i++) {
            StringTokenizer token = new StringTokenizer(in2.readLine(), " \t\r\n");
            z[i] = Double.parseDouble(token.nextToken().trim());
            T[i] = Double.parseDouble(token.nextToken().trim());
        }

        // Закрываем файл
        in1.close();
        in2.close();
        return;
    }


    /*
     * Преобразование всех данных из массивов в виде одной строки.
     */
    public String toString() {
        String str = "";
        for(int i=0;i<N;i++) {
            str += String.format(Locale.US, "%.0f\t%.1f\r\n", z[i], T[i]);
        }
        return str;
    }


    /*
     * Метод поиска максимального значения температуры.
     */
    public double getTmax() {
        double Tmax = -1.0E+308;
        for(int i=0;i<N;i++) {
            if(T[i]>Tmax) {
                Tmax = T[i];
            }
        }
        return Tmax;
    }


    /*
     * Метод расчета средней температуры.
     */
    public double getTmean() {
        double Tmean = 0.0;
        for(int i=0;i<N;i++) {
            Tmean += T[i];
        }
        return Tmean/N;
    }

}