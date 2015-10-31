import java.io.IOException;
import java.util.ArrayList;

//Creating a profile according to what the GUI sends and return s the data with a name at the end
//needs more variables of identity for the profile!
public class creator {
	private letter[] letters;
	private ArrayList<timeBetweenTwoChars> idleTimeBetweenCharsList = new ArrayList<timeBetweenTwoChars>();

	private int timesPressed = 0;
	
	private final int MAX_IDLE_TIME_BETWEEN_LETTERS = 1000;

	public creator() {
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
			if(time.getAvgIdleTime() < this.MAX_IDLE_TIME_BETWEEN_LETTERS){
				boolean wasFound = false;
				for(timeBetweenTwoChars element : this.idleTimeBetweenCharsList){
					if(element.equals(time)){
						element.addIdleTime(time.getAvgIdleTime());
						wasFound = true;
					}
				}
				if(!wasFound){
					this.idleTimeBetweenCharsList.add(time);
				}
			}
		}
	}

	public void finish(String name) {
		profile profile = new profile(name, letters,idleTimeBetweenCharsList);
		System.out.println(profile);
		try {
			profile.output();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
