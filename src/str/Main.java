package str;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {

        // Задаем имя текстового файла
        String fileName = "output.csv";

        // Создаем объект типа DataFile и сообщаем его конструктору имя файла с данными
        DataFile data = new DataFile(fileName);

        // Находим максимальное значение температуры
        double Tmax = data.getTmax();

        // Определяем среднее значение температуры
        double Tmean = data.getTmean();


        // Выводим все данные из массивов на консоль,
        // а так же значения максимальной и средней температуры
        System.out.printf("%s", data.toString());
        System.out.printf(Locale.US, "max %.1f K\r\n", Tmax);
        System.out.printf(Locale.US, "middle %.1f K\r\n", Tmean);
        System.out.println();
    }
}
