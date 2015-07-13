public class creator {
	private letter[] letters;
	private int timesPressed;
	private int avgIdleTime;
	private int lastRelease;
	creator(){
		avgIdleTime=0;
		timesPressed=0;
		lastRelease=0;
		for(int i =(int)'a';i<=(int)'z';i++){
			letters[i-'a']= new letter((char)i);
		}
	}
	public void add(char c,int press,int release){
		letters[(int)c].add(release-press);
		if(lastRelease!=0){
			avgIdleTime=(avgIdleTime*timesPressed+release-press)/(timesPressed+1);
		}
		lastRelease=release;
		timesPressed++;
	}
	public profile finish(){
		return new profile(letters,avgIdleTime);
	}
}
