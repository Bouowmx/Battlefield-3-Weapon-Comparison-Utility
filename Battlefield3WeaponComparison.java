package Battlefield3WeaponComparison;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class Battlefield3WeaponComparison {
	public static void main(String[] args) throws Exception {
		String location = "C:\\Users\\User\\Documents\\CS\\Java\\Battlefield X Weapon Comparison\\Battlefield 3 Weapon Comparison\\data.txt";
		File file = new File(location);
		if (!(file.exists())) {throw new FileNotFoundException("\"Data.txt\" was not found.");}
		String hash = SHA256.hash(location);
		if (!(hash.equals("a7a6bff1faefe5b826088ce888d7898ff0ca4c02ae9c4b457ea773c2dd1a7c4f")) || !(hash.equals("a7a6bff1faefe5b826088ce888d7898ff0ca4c02ae9c4b457ea773c2dd1a7c4f"))) {throw new Exception("Data file hash mismatch. \"Data.txt\" has been modified.");}
		
		Scanner scanner = (new Scanner(new File(location))).useDelimiter(", ");
		HashMap<String, Weapon> weapons = new HashMap<>(63, 1);
		while (scanner.hasNext()) {
				String name = scanner.next().trim();
				weapons.put(name, new Weapon(name, scanner.nextDouble(), scanner.nextDouble(), scanner.nextDouble(), scanner.nextDouble(), scanner.nextDouble(), scanner.nextDouble(), scanner.nextDouble(), scanner.nextDouble(), scanner.nextDouble(), scanner.nextDouble(), scanner.nextDouble(), scanner.nextDouble(), scanner.nextDouble(), scanner.nextDouble(), scanner.nextDouble(), scanner.nextDouble(), scanner.nextDouble(), scanner.nextDouble(), scanner.nextDouble(), scanner.nextDouble(), scanner.nextDouble(), scanner.nextDouble(), scanner.nextDouble(), scanner.nextDouble(), scanner.nextDouble(), scanner.nextDouble(), scanner.nextBoolean()));
		}
		
		//System.out.println(weapons);
		
		//weapons.put(, new Weapon(, ));
		
		Weapon weapon1 = weapons.get("M416");
		
		for (int i = 0; i <= 100; i++) {System.out.println(i + ": " + Round.roundToOnePlaceAndRemoveTrailingZero(weapon1.timeToKill(100, i)));}
		System.out.println();
		for (int i = (int) Math.ceil(100 / weapon1.MAX_DAMAGE); i <= Math.ceil(100 / weapon1.MIN_DAMAGE); i++) {System.out.println(i + ": " + Round.roundToOnePlaceAndRemoveTrailingZero(weapon1.hitKillDistance(100, i)));}
	}
}
