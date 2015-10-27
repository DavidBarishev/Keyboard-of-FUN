import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

//all the data collected by the creator
public class profile {
	public String name;
	public letter[] letters;
	
	public ArrayList<timeBetweenTwoChars> idleTimeBetweenCharsList = new ArrayList<timeBetweenTwoChars>();
	

	public profile(String n, letter[] l,ArrayList<timeBetweenTwoChars> idleTimeBetweenCharsList ) {
		name = n;
		letters = l;
		this.idleTimeBetweenCharsList = idleTimeBetweenCharsList;
	}

	public profile(File file) {
		// initializing the array

		letters = new letter[26];
		for (int i = 0; i < letters.length; i++) {
			letters[i] = new letter();
		}

		try {
			// Declare readers
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);

			// read name
			name = br.readLine();

			// Go through the page and pick up the numbers
			for (int i = 0; i <= 25; i++) {
				letters[i] = new letter(Integer.parseInt(br.readLine()));
			}
			
			String line = br.readLine();
			while(line != null){
				//debugging purposes 
				//System.out.println(new timeBetweenTwoChars(line.charAt(0), line.charAt(1), Integer.parseInt(line.substring(2))));
				this.idleTimeBetweenCharsList.add(new timeBetweenTwoChars(line.charAt(0), line.charAt(1), Integer.parseInt(line.substring(2))));
				line = br.readLine();
			}
			
			// Close buffers
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void output() throws IOException {
		File profile = new File(System.getProperty("user.dir") + "\\Profiles\\" + name + ".txt");

		FileWriter writer = new FileWriter(profile);
		BufferedWriter out = new BufferedWriter(writer);
		
		//Name
		out.append(name);
		out.newLine();
		
		//Letters
		for (int i = 0; i < letters.length; i++) {
			out.append(Integer.toString(letters[i].avgPressTime));
			out.newLine();
		}
		
		//Time between chars 
		
		for(timeBetweenTwoChars element : this.idleTimeBetweenCharsList){
			out.append(element.getFirstLetter());
			out.append(element.getSecondLetter());
			out.append(Integer.toString(element.getAvgIdleTime()));
			out.newLine();
		}

		out.close();
	}

	public String toString() {
		String ans = name + "\n";
		for (int i = 0; i < letters.length; i++) {
			ans += (char) (i + (int) 'A') + " : " + letters[i].avgPressTime + "ms \n";
		}
		
		for(timeBetweenTwoChars element : this.idleTimeBetweenCharsList){
			ans += element.toString() + "\n";
		}
		return ans;
	}
}
