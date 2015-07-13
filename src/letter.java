
public class letter {
	char letter;
	int avgPressTime;
	int timesPressed;
	letter(char l){
		letter = l;
		avgPressTime=0;
		timesPressed=0;
	}
	public void add(int t){
		avgPressTime=(avgPressTime*timesPressed+t)/(timesPressed+1);
		timesPressed++;
	}
}
