import java.util.HashMap;
import java.nio.file.Paths;

public class QuinteroTester {
	public static void main(String[] args){
		QuinteroBackend sorter = new QuinteroBackend();
		String path = Paths.get("").toAbsolutePath().toString();

		sorter.addAdvisory("Lutz");
		sorter.addLocation("Janitor Closet", -10);
		sorter.removeAdvisory("Bator");
		sorter.removeLocation("Mic Stand");
		sorter.removeLocation("Nonexistent");
		sorter.editAdvisory("Wiggs", "Andersen");
		sorter.editLocationName("Student Kitchen", "Kitchen for Students");
		sorter.editLocationScore("Upper Stairs", 12);
		sorter.setLocation("Everts", "Lower Stairs");
		sorter.randomize();
		HashMap<String,String> assign = sorter.getAssignmentsAsString();
		sorter.saveCSV(path);
		sorter.save();

		for (String adv : assign.keySet()) {
			System.out.println(adv + ", " + assign.get(adv));
		}
	}
}