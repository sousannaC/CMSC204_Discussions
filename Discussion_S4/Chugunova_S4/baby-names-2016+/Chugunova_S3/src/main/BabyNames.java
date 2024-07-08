package main;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class BabyName {
    String name;
    int[] counts = new int[6]; // counts from 2016 to 2021
    int total;

    BabyName(String name) {
        this.name = name;
    }

    void addCount(int year, int count) {
        int index = year - 2016;
        counts[index] = count;
        total += count;
    }
}

public class BabyNames {

    public static void main(String[] args) {
        String[] filePaths = {
            "yob2016.txt", 
            "yob2017.txt", 
            "yob2018.txt", 
            "yob2019.txt", 
            "yob2020.txt", 
            "yob2021.txt"
        };

        Map<String, BabyName> babyNamesMap = new HashMap<>();

        // Read and process the data files
        for (String filePath : filePaths) {
            try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
                String line;
                while ((line = br.readLine()) != null) {
                    String[] parts = line.split(",");
                    String name = parts[0];
                    String sex = parts[1];
                    int count = Integer.parseInt(parts[2]);

                    // Only process female names (if required)
                    if (sex.equals("F")) {
                        babyNamesMap.putIfAbsent(name, new BabyName(name));
                        int year = Integer.parseInt(filePath.substring(3, 7));
                        babyNamesMap.get(name).addCount(year, count);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // PriorityQueue to find the 20 most popular baby names
        PriorityQueue<BabyName> pq = new PriorityQueue<>((a, b) -> b.total - a.total);
        pq.addAll(babyNamesMap.values());

        // Display the 20 most popular baby names
        System.out.println("Top 20 most popular baby names:");
        for (int i = 0; i < 20 && !pq.isEmpty(); i++) {
            BabyName bn = pq.poll();
            System.out.println(bn.name + ": " + bn.total);
        }
    }
}
