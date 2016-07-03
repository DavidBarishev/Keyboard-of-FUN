import java.util.ArrayList;

//this class checks the proximity of one profile to the list of registered profiles 
//and returns the closest profile up to a threshold variable
public class Profiler {

	public static profile overallCompare(profile[] users, profile profile,
			int limit) {

		double[] percentagePerUser = new double[users.length];

		for (int i = 0; i < users.length; i++) {
			percentagePerUser[i] = percentageForProfile(profile, users[i]);
		}

		for (int i = 0; i < users.length; i++) {
			System.out.println("Name : " + users[i].name + " Odds : "
					+ percentagePerUser[i] + '%');
		}

		int bestPlace = bestMatch(percentagePerUser);

		if (percentagePerUser[bestPlace] > limit) {
			return null;
		}

		return users[bestPlace];
	}

	private static double percentageForProfile(profile user, profile optionUser) {

		int averagePercentange = 0;
		int lettersChecked = 0;
		
		//calculates average press time
		for (int i = 0; i < user.letters.length; i++) {
			if (user.letters[i].avgPressTime != 0) {
				averagePercentange += ((Math
						.abs(optionUser.letters[i].avgPressTime - user.letters[i].avgPressTime)) * 100) / user.letters[i].avgPressTime;
				lettersChecked++;
			}
		}
		
		//how much time in average between presses
		if (lettersChecked != 0) {
			ArrayList <Double> timeDifference = new ArrayList <Double> ();
			for(timeBetweenTwoChars element : user.idleTimeBetweenCharsList){
				if(optionUser.idleTimeBetweenCharsList.contains(element)){
					double difference = Math.abs(element.getAvgIdleTime() - optionUser.idleTimeBetweenCharsList.lastIndexOf(element));
					double average = (element.getAvgIdleTime() + optionUser.idleTimeBetweenCharsList.lastIndexOf(element)) / 2;
					
					timeDifference.add((difference / average) * 100);
				}	
			}
		
			
			
		}
		
		return 101;
	}

	public static int bestMatch(double[] percentagePerUser) {
		int ans = 0;

		for (int i = 1; i < percentagePerUser.length; i++) {
			if (percentagePerUser[ans] > percentagePerUser[i]) {
				ans = i;
			}
		}
		return ans;
	}
	
	public static double averagePercentage(ArrayList <Double> list){
		
		int counter = 0;
		double sum = 0;
		
		for(Double element : list){
			sum = sum + element.doubleValue();
			counter++;
		}
		
		return sum/counter;
	}
	
	//Maybe, in the future - you should add more arguments and change the formula.
	public static double overallPercentage(double lowestValue, double midValue, double highestValue){
		
		double ans = 0;
		
		ans = ((lowestValue * 40) + (highestValue * 60)) / 100;  
		
		return ans;	
	} 

	//finds most frequent combinations.
	public static double letterCombination(ArrayList <timeBetweenTwoChars> niggaArray){
	
		ArrayList <Integer> mostFrequentLetters = new ArrayList <Integer> ();
		
		String[] timeBetweenLetters = {"TH", "HE", "AN", "IN", "ER", "ON", "RE", "ED", "ND", "HA", "AT", "EN", "ES", "OF", "NT", "EA", "TI", "TO", "IO", "LE", "IS", "OU", "AR", "AS", "DE", "RT", "VE"};
		
		for(timeBetweenTwoChars element : niggaArray){
			if(contains(element.getFirstLetter() + "" + element.getSecondLetter(), timeBetweenLetters)){
				mostFrequentLetters.add(element.getAvgIdleTime());
			}
		}
		
		double sum = 0;
		int counter = 0;
		
		for(Integer element : mostFrequentLetters){
			sum += element.intValue();
			counter++;
		}
		return sum/counter;
	}
	
	public static boolean contains(String toFind, String[] toFindFrom){
		
		for(int i = 0; i < toFindFrom.length; i++){
			if(toFind.equals(toFindFrom[i].toLowerCase())){
				return true;
			}
		}
		
		return false;
	}
	
}
