import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

//all the data collected by the creator
public class profile {
	public String name;
	public letter[] letters;
	public profile(String n, letter[] l) {
		name = n;
		letters = l;
	}
	public profile(File file){
		
	}
	public void output() throws IOException{
		File profile = new File(name+".txt");
		FileWriter writer = new FileWriter(profile);
		BufferedWriter out = new BufferedWriter(writer);
		out.append(name);
		out.newLine();
		for(int i =0;i<letters.length;i++){
			out.append(Integer.toString(letters[i].avgPressTime));
			out.newLine();
		}
		out.close();
	}
}
