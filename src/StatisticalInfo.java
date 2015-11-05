import java.util.ArrayList;

public class StatisticalInfo {
	private ArrayList<timeBetweenTwoChars> pairsList;
	
	private boolean twoHands;
	private boolean oneHand;
	
	private char[] leftKeyboard = {'q','w','e','a','s','d','z','x','c'};
	private char[] rightKeyboard = {'i','o','p','k','l','n','m'};
	
	private ArrayList<timeBetweenTwoChars> longKeyboardPairs = new ArrayList<timeBetweenTwoChars>();
	
	private final int MAX_IDLE_TIME = 275;
	
	public StatisticalInfo(ArrayList<timeBetweenTwoChars> pairsList){
		this.pairsList = pairsList;
		this.setNumberOfHands();
	}
	
	private void getAllLongPairs(){
		for(timeBetweenTwoChars elemnt: this.pairsList){
			if((contains(leftKeyboard, elemnt.getFirstLetter()) && contains(rightKeyboard, elemnt.getSecondLetter()))||
					(contains(rightKeyboard, elemnt.getFirstLetter()) && contains(leftKeyboard, elemnt.getSecondLetter()))){
				this.longKeyboardPairs.add(elemnt);
			}
		}
	}
	
	private void setNumberOfHands(){
		getAllLongPairs();
		if(getAverageTimeOfLongPairs() > MAX_IDLE_TIME){
			this.oneHand = true;
			this.twoHands =false;
		}
		else{
			this.oneHand = false;
			this.twoHands = true;
		}	
		
		
		
	}
	
	private double getAverageTimeOfLongPairs(){
		int sum = 0;
		for(timeBetweenTwoChars elemnt : this.longKeyboardPairs){
			sum+= elemnt.getAvgIdleTime();
		}
		return sum / this.longKeyboardPairs.size();
	}
	
	private static boolean contains(char[] partOfKeyboard,char value){
		for(char elemnt : partOfKeyboard){
			if(elemnt == value){
				return true;
			}
		}
		return false;
	}
	public boolean getTwoHands(){
		return this.twoHands;
	}
	public boolean getOneHand(){
		return this.oneHand;
	}
}
