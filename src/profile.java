import java.io.BufferedReader;
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
		//initializing the array
		letters = new letter[24];
		for(int i = 0 ; i < letters.length ; i++){
			letters[i] = new letter();
		}
		
		try {
			//Declare readers
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			
			//read name
			name = br.readLine();
			
			//Go through the page and pick up the numbers
			for(int i = 0 ; i < 23 ; ++i){
				letters[i] = new letter(Integer.parseInt(br.readLine()));
			}
			
			//Close buffers
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	
	
	public void output() throws IOException{
		File profile = new File(System.getProperty("user.dir")+"\\Profiles\\"+name+".txt");
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
	public String toString(){
		String ans=name+"\n";
		for(int i=0;i<letters.length;i++){
			ans+=(char)(i+(int)'A')+" : "+letters[i].avgPressTime+"ms \n";
		}
		return ans;
	}
}
