/**
 * @author User
 *
 */
/**
 * @author User
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
	
	
	private static profile getBestMatch_INTERNAL(profile[] profilePool , profile profileToFind){
		return null;
	}
}
