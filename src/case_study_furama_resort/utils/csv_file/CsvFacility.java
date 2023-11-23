package case_study_furama_resort.utils.csv_file;

import case_study_furama_resort.models.facility.Facility;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.Set;

public class CsvFacility {
    private static final String PATH = "src/case_study_furama_resort/data/facility.csv";

//    public static void writeToFile(Map<Integer, Facility> facilityMap){
//        File file = new File(PATH);
//        FileWriter fileWriter = null;
//        BufferedWriter bufferedWriter = null;
//        try {
//            fileWriter = new FileWriter(file);
//            bufferedWriter = new BufferedWriter(fileWriter);
//            Set<Map.Entry<Integer, Facility>> facilities = facilityMap.entrySet();
//            for (Map.Entry<Integer, Facility> entry: facilities){
//
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
}
