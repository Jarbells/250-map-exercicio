package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
	
		Map<String, Integer> map = new LinkedHashMap<>();
		
		try (Scanner sc = new Scanner(System.in)) {
			System.out.print("Enter file full path: ");
			String path = sc.nextLine();
			
			try (BufferedReader br = new BufferedReader(new FileReader(path))) {
				String line = br.readLine();
				while (line != null) {
					String[] fields = line.split(",");
					String name = fields[0];
					int votes = Integer.parseInt(fields[1]);
					
					if (!map.containsKey(name)) {
						map.put(name, votes);
					}
					else {
						int sumVotes = map.get(name);
						map.put(name, sumVotes + votes);
					}
					line = br.readLine();
				}
				for (String k : map.keySet()) {
					System.out.println(k + ": " + map.get(k));
				}
			}
			catch (IOException e) {
				System.out.println("Error: " + e.getMessage());
			}
		}		
	}
}