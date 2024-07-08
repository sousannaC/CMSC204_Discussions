//sousanna chugunova
//CMSC204
//Dr.Thai 
package main;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class BabyNames {

    public static void main(String[] args) {
        // Creates a HashMap to store baby girl names and their occurrences
        Map<String, int[]> girlNames = new HashMap<>();

        // Processes data files from 2016 to 2021
        for (int year = 2016; year <= 2021; year++) {
            String fileName = "baby-names-2016+/yob" + year + ".txt";

            try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
                String line;
                while ((line = br.readLine()) != null) {
                    String[] parts = line.split(",");
                    String name = parts[0];
                    String sex = parts[1];
                    int number = Integer.parseInt(parts[2]);

                    //Changing the F to an M will give you the result of male baby names
                    if (sex.equals("F")) {
                        int[] counts = girlNames.getOrDefault(name, new int[7]);
                        counts[year - 2016] = number;
                        counts[6] += number; // Total count across all years
                        girlNames.put(name, counts);
                    }
                }
            } catch (IOException | NumberFormatException e) {
                System.err.println("Error reading file: " + fileName);
                e.printStackTrace();
            }
        }

        // Displays the top 20 most popular baby girl names
        System.out.println("Top 20 most popular baby names:");
        girlNames.entrySet().stream()
                .sorted((entry1, entry2) -> Integer.compare(entry2.getValue()[6], entry1.getValue()[6])) // Sort by total count descending
                .limit(20) // Limit to top 20 names
                .forEachOrdered(entry -> {
                    String name = entry.getKey();
                    int[] counts = entry.getValue();
                    int total = counts[6]; // Total count across all years
                    System.out.printf("%s: %d (2016), %d (2017), %d (2018), %d (2019), %d (2020), %d (2021) - Total: %d%n",
                            name, counts[0], counts[1], counts[2], counts[3], counts[4], counts[5], total);
                });
    }
}
