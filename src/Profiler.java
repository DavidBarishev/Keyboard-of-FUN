
//this class checks the proximity of one profile to the list of registered profiles 
//and returns the closest profile up to a threshold variable
public class Profiler {
	/*
	 * public static profile compare(profile[] users, profile comparable){
	 * 
	 * int[] sum = new int[2]; int currentSum = 0;
	 * 
	 * for(int i = 0; i < users.length; i++){
	 * 
	 * for(int j = 0; j < comparable.letters.length; j++){ currentSum =
	 * currentSum + comparable.letters[j].avgPressTime /
	 * users[i].letters[j].avgPressTime; } if(sum[0] == 0){ sum[0] = currentSum;
	 * sum[1] = i; }if(currentSum < sum[0]){ sum[0] = currentSum; sum[1] = i; }
	 * } return users[sum[1]]; }
	 */
	// gets a list of profiles, a profile to compare to and a threshold of
	// proximity allowed(the smaller the better)
	public static profile compare(profile[] users, profile comparable, int threshold) {
		float[] proximity = new float[users.length];
		for (int i = 0; i < users.length; i++) {
			proximity[i] = approximate(users[i], comparable);
		}
		int bestOption = bestOption(proximity, threshold);
		if (bestOption == -1) {
			return null;
		} else {
			return users[bestOption];
		}
	}

	private static int bestOption(float[] proximity, int threshold) {
		float best = -1;
		int bestProximity = -1;
		for (int i = 0; i < proximity.length; i++) {
			if (proximity[i] <= threshold && proximity[i] > best) {
				best = proximity[i];
				bestProximity = i;
			}
		}
		return bestProximity;
	}

	private static float approximate(profile user, profile comparable) {
		int[] letterProximity = new int[24];
		for (int i = 0; i < 23; i++) {
			letterProximity[i] = Math.abs(user.letters[i].avgPressTime - comparable.letters[i].avgPressTime);
		}
		return avgProximity(letterProximity);
	}

	private static float avgProximity(int[] letterProximity) {
		int sum = 0;
		for (int i = 0; i < letterProximity.length; i++) {
			sum += letterProximity[i];
		}
		return sum / letterProximity.length;
	}

}
