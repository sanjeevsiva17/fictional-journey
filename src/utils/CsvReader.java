package utils;

import cars.Cars;
import com.opencsv.CSVReader;
import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.CsvToBean;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;


public class CsvReader {
    public static List<Cars> CsvRead(String location) {
        List<Cars> carsList = new ArrayList<>();
        ColumnPositionMappingStrategy strat = new ColumnPositionMappingStrategy();
        strat.setType(Cars.class);
        String[] columns = new String[]{"name", "origin", "horsepower"};
        strat.setColumnMapping(columns);
        CsvToBean csv = new CsvToBean();
        CSVReader csvReader = null;
        try {
            csvReader = new CSVReader(new FileReader(location));
        } catch (FileNotFoundException e) {
            System.out.println("FIle not found");
            e.printStackTrace();
        }
        List list = csv.parse(strat, csvReader);
        for (Object object : list) {
            Cars cars = (Cars) object;
            carsList.add(cars);
        }
        return carsList;
    }
}
