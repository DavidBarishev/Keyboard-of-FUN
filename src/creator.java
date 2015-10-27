import java.io.IOException;
import java.util.ArrayList;

//Creating a profile according to what the GUI sends and return s the data with a name at the end
//needs more variables of identity for the profile!
public class creator {
	private letter[] letters;
	private ArrayList<timeBetweenTwoChars> idleTimeBetweenCharsList = new ArrayList<timeBetweenTwoChars>();

	private int timesPressed = 0;
	private int avgIdleTime;

	creator() {
		// avgIdleTime = 0;
		// timesPressed = 0;
		// lastRelease = 0;
		letters = new letter[26];
		for (int i = 0; i < letters.length; i++) {
			letters[i] = new letter();
		}
	}

	public void add(char c, int pressTime) {
		letters[(int) c - 'a'].add(pressTime);
		/*
		 * if (lastRelease != 0) { avgIdleTime = (avgIdleTime * timesPressed +
		 * pressTime) / (timesPressed + 1); } lastRelease = release;
		 */
		// timesPressed++;
	}

	public void addIdleTime(timeBetweenTwoChars time) {
		if(time != null){
			if(time.getAvgIdleTime() < 1000){
				for(timeBetweenTwoChars element : this.idleTimeBetweenCharsList){
					if(element.equals(time)){
						element.addIdleTime(time.getAvgIdleTime());
					}
					else{
						this.idleTimeBetweenCharsList.add(time);
					}
				}
			}
		}
	}

	public void finish(String name) {
		profile profile = new profile(name, letters, avgIdleTime,idleTimeBetweenCharsList);
		try {
			profile.output();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
