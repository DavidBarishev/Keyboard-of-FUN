//The data collected to a single letter
public class letter {
	public int avgPressTime;
	public int timesPressed;

	letter() {
		avgPressTime = 0;
		timesPressed = 0;
	}
	letter(int i){
		avgPressTime=i;
		timesPressed=1;
	}
	public void add(int t) {
		avgPressTime = (avgPressTime * timesPressed + t) / (timesPressed + 1);
		timesPressed++;
	}
}
