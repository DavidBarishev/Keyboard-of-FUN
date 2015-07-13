//The data collected to a single letter
public class letter {
	public char letter;
	public int avgPressTime;
	public int timesPressed;

	letter(char l) {
		letter = l;
		avgPressTime = 0;
		timesPressed = 0;
	}

	public void add(int t) {
		avgPressTime = (avgPressTime * timesPressed + t) / (timesPressed + 1);
		timesPressed++;
	}
}
