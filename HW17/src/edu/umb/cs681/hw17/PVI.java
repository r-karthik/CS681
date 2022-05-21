package edu.umb.cs681.hw17;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PVI {

    public static void main(String[] args) {

        Path path = Paths.get("src/edu/umb/cs681/hw17/PVIData.csv");

        try( Stream<String> lines = Files.lines(path) ){
            List<List<String>> matrix = lines.map(line -> {
                        return Stream.of( line.split(",") )
                                .map(value-> value)
                                .collect( Collectors.toList() ); })
                    .collect( Collectors.toList() );


            List<List<String>> massachusetts = matrix.stream().filter((i) -> i.get(4).contains("Massachusetts")).collect(Collectors.toList());
            String totalCases = matrix.stream().filter((i) -> i.get(4).contains("Massachusetts"))
                    .map((i) -> i.get(6)).reduce("0", (temp, result) -> String.valueOf(Integer.parseInt(temp) + Integer.parseInt(result)));

            List<String> suffolk = matrix.stream().filter((i) -> i.get(5).contains("Suffolk")).collect(Collectors.toList()).get(0);

            List<String> worcester = matrix.stream().filter((i) -> i.get(5).contains("Worcester")).collect(Collectors.toList()).get(0);

            float suffolkInfectionRate = Float.parseFloat(suffolk.get(8));
            float worchesterInfectionRate = Float.parseFloat(suffolk.get(8));

            System.out.println("Total number of cases in MA: " + totalCases);
            System.out.println("\nInfection rate in Suffolk County: " + suffolk.get(8));
            System.out.println("\nInfection rate in Worcester County: " + worcester.get(8));
            System.out.println("\nAverage Infection Rate in Suffolk & Worchester: " + (suffolkInfectionRate + worchesterInfectionRate) / 2);

            if (suffolkInfectionRate > worchesterInfectionRate){
                System.out.println("\nInfection Rate in Suffolk County is Higher");
            }else{
                System.out.println("\nInfection Rate in Worchester County is Higher");
            }

        }

        catch(IOException ex) {
            ex.printStackTrace();
        }
    }

}
