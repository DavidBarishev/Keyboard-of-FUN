/**
 * @author david
 *
 */
public class FixedProfiler {
	
	
	/**
	 * @param profilePool - profile to find the profile from
	 * @param profileToFind - the profile to find best match to
	 * @return best matching profile
	 */
	public static profile getBestMatchingProfile(profile[] profilePool , profile profileToFind){
		if(profileToFind != null && profilePool != null && profilePool.length!=0){
			return getBestMatch_INTERNAL(profilePool, profileToFind);
		}
		else{
			throw new RuntimeException("Invalid arumants");
		}
	}
	
	
	/**
	 * @param profilePool - profile to find the profile from (Valid values)
	 * @param profileToFind - the profile to find best match to (Valid values)
	 * @return best matching profile
	 */
	private static profile getBestMatch_INTERNAL(profile[] profilePool , profile profileToFind){
		double[] gradesForEachProfile =  new double[profilePool.length];
		
		for(int i = 0 ; i < gradesForEachProfile.length ; i++){
			gradesForEachProfile[i] = getGradeForProfile(profilePool[i],profileToFind);
		}

		return getBestProfileByGrade(profilePool,profileToFind,gradesForEachProfile);
	}


	private static profile getBestProfileByGrade(profile[] profilePool, profile profileToFind,
			double[] gradesForEachProfile) {
		double max = 0;
		int index  = 0;
		for(int i = 0 ; i < gradesForEachProfile.length ; i++){
			if(gradesForEachProfile[i] > max){
				max = gradesForEachProfile[i];
				index  = i;
			}
		}
		return profilePool[index];
	}


	private static double getGradeForProfile(profile profile, profile profileToFind) {
		// TODO Auto-generated method stub
		return 0;
	}
}
