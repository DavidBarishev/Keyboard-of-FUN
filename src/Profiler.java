//this class checks if 2 profiles are the same.
//or NOT.
public class Profiler{
	
	public static profile compare(profile[] users, profile comparable){

		int[] sum = new int[2];
		int currentSum = 0;
		
		for(int i = 0; i < users.length; i++){
			for(int j = 0; j < comparable.letters.length; j++){
				currentSum = currentSum + comparable.letters[j].avgPressTime / users[i].letters[j].avgPressTime;
			}
			if(sum[0] == 0){
				sum[0] = currentSum;
				sum[1] = i;
			}if(currentSum < sum[0]){
				sum[0] = currentSum;
				sum[1] = i;
			}
		}
		return users[sum[1]];
	}
	
}
