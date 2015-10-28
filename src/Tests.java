import org.junit.Test;
import org.junit.Assert;

public class Tests {
	/*
	 * testing for: letter
	 */
	@Test
	public void letter_ConstructorNotNull() {
		letter x = new letter();

		Assert.assertNotNull("letter should not be null", x);
	}

	@Test
	public void letter_SecondConstructorNotNull(){
		letter x = new letter(1);
	     Assert.assertNotNull("letter should not be null",x);
	     
	}
}
