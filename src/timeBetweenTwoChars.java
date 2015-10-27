public class timeBetweenTwoChars {
	private char first;
	private char second;
	private int avgIdleTime;

	private int timesPressed = 0;

	public timeBetweenTwoChars(char first, char second, int avgIdleTime) {
		this.first = first;
		this.second = second;
		this.avgIdleTime = avgIdleTime;
	}

	public void addIdleTime(int idleTime) {
		this.avgIdleTime = ((this.avgIdleTime * this.timesPressed) + idleTime) / (this.timesPressed + 1);
		this.timesPressed++;
	}

	public boolean isEqual(timeBetweenTwoChars other) {
		if (other.first == this.first && other.second == this.second) {
			return true;
		}
		return false;
	}

	public int getAvgIdleTime() {
		return this.avgIdleTime;
	}

	public char getFirstLetter() {
		return this.first;
	}

	public char getSecondLetter() {
		return this.second;
	}

	public String toString() {
		return "[" + this.first + "," + this.second + "]" + " Time : " + this.avgIdleTime + "ms";
	}

}
