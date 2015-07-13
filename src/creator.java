//Creating a profile according to what the GUI sends and return s the data with a name at the end
public class creator {
	private letter[] letters;
	private int timesPressed;
	//private int avgIdleTime;
	private int lastRelease;

	creator() {
		//avgIdleTime = 0;
		timesPressed = 0;
		lastRelease = 0;
		for (int i = (int) 'a'; i <= (int) 'z'; i++) {
			letters[i - 'a'] = new letter((char) i);
		}
	}

	public void add(char c, int pressTime) {
		letters[(int) c].add(pressTime);
		/*if (lastRelease != 0) {
			avgIdleTime = (avgIdleTime * timesPressed + pressTime)
					/ (timesPressed + 1);
		}
		lastRelease = release;*/
		timesPressed++;
	}

	public profile finish(String name) {
		return new profile(name, letters);
	}
}
