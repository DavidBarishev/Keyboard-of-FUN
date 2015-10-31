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

	// userit = user in she form.
	private static double percentageForProfile(profile user, profile optionUser) {

		int averagePercentange = 0;
		int lettersChecked = 0;
		for (int i = 0; i < user.letters.length; i++) {
			if (user.letters[i].avgPressTime != 0) {
				averagePercentange += ((Math
						.abs(optionUser.letters[i].avgPressTime
								- user.letters[i].avgPressTime)) * 100)
						/ user.letters[i].avgPressTime;
				lettersChecked++;
			}
		}
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
}

// public double smallestSum;

/*
 * public static profile compare(profile[] users, profile comparable){
 * 
 * int[] sum = new int[2]; int currentSum = 0;
 * 
 * for(int i = 0; i < users.length; i++){
 * 
 * for(int j = 0; j < comparable.letters.length; j++){ currentSum = currentSum +
 * comparable.letters[j].avgPressTime / users[i].letters[j].avgPressTime; }
 * if(sum[0] == 0){ sum[0] = currentSum; sum[1] = i; }if(currentSum < sum[0]){
 * sum[0] = currentSum; sum[1] = i; } } return users[sum[1]]; }
 */
// gets a list of profiles, a profile to compare to and a threshold of
// proximity allowed(the smaller the better)

/*
 * //////////////////////////////////////////////////////////////////////////
 * ///////////////////////////////// Barr's code
 * 
 * public profile compare(profile[] users, profile comparable, int threshold) {
 * float[] proximity = new float[users.length]; for (int i = 0; i <
 * users.length; i++) { proximity[i] = approximate(users[i], comparable); } int
 * bestOption = bestOption(proximity, threshold); if (bestOption == -1) { return
 * null; } else { proximityPercent = 100
 * -((proximity[bestOption]/avgProximity(comparable.letters))*100); return
 * users[bestOption]; } }
 * 
 * private static float avgProximity(letter[] letters) { int[] lettersTime = new
 * int[23]; for(int i = 0;i < 23;i++){ lettersTime[i]=letters[i].avgPressTime; }
 * return avgProximity(lettersTime); }
 * 
 * private static int bestOption(float[] proximity, int threshold) { float best
 * = -1; int bestProximity = -1; for (int i = 0; i < proximity.length; i++) { if
 * (proximity[i] <= threshold && proximity[i] > best) { best = proximity[i];
 * bestProximity = i; } } return bestProximity; }
 * 
 * private static float approximate(profile user, profile comparable) { int[]
 * letterProximity = new int[24]; for (int i = 0; i < 23; i++) {
 * letterProximity[i] = Math.abs(user.letters[i].avgPressTime -
 * comparable.letters[i].avgPressTime); } return avgProximity(letterProximity);
 * }
 * 
 * private static float avgProximity(int[] letterProximity) { int sum = 0; for
 * (int i = 0; i < letterProximity.length; i++) { sum += letterProximity[i]; }
 * return sum / letterProximity.length; }
 */
// Barr's code
// ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/*
 * public static profile overallCompare(profile[] users, profile compareTo){
 * 
 * for(int i = 0; i < users.length; i++){ store(compareAndSum(users[i],
 * compareTo)); }
 * 
 * }
 * 
 * public static int findTheSmallestNumberInTheArray(int[] a){ int min = 0;
 * 
 * for(int i = 0; i < a.length - 1; i++){ for(int j = i + 1; j < a.length; j++){
 * if(i < j){ min = i; } } } return min; }
 * 
 * //gives us the sum of a given array. public static double lastSum(double[]
 * a){
 * 
 * double sum = 0;
 * 
 * for(int i = 0; i < a.length; i++){ sum += a[i]; } return sum; }
 * 
 * public static double compareAndSum(profile compareTo, profile b){
 * 
 * double sum = 0;
 * 
 * for(int i = 0; i < b.letters.length; i++){ sum +=
 * Math.abs(b.letters[i].avgPressTime - compareTo.letters[i].avgPressTime); }
 * 
 * return sum; } public static double[] store (double a){
 * 
 * } }
 * 
 * 
 * public static profile overallCompare(profile[] users, profile compareTo){
 * 
 * 
 * 
 * }
 * 
 * public
 */