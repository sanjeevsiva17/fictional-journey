import cars.Cars;
import utils.CsvReader;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        String path = args[0];
        String n = args[1];
        String origin = args[2];

        CsvReader csvReader = new CsvReader();
        List<Cars> carsList = csvReader.CsvRead(path);

//        String n = "5";
//        String origin = "US";
        printCars(carsList, Integer.parseInt(n), origin);

    }

    public static void printCars(List<Cars> cars, int n, String origin) {
        List<Cars> originCars = new ArrayList<>();
        float sum = 0;
        int count = 0;

        for (int i = 0; i < cars.size(); i++) {
            if (cars.get(i).getOrigin().equals(origin)) {
                originCars.add(cars.get(i));
                sum = sum + cars.get(i).getHorsepower();
                count++;
            }
        }

        float average = sum / count;

        //Descending
        Collections.sort(originCars);

        for (int i = 0; i < n; i++) {
            if (originCars.get(i).getHorsepower() > average) {
                System.out.println(originCars.get(i).output());
            }
        }

    }
}
