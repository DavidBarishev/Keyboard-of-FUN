import java.io.File;
import java.util.ArrayList;

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
	@Test
	public void letter_add(){
	     letter x = new letter(2);
	     int y= x.getTimePressed();
	     x.add(1);
	     int z= x.getTimePressed();
	     Assert.assertEquals(z,y+1);  
	}
	
	@Test
	 public void profile_ConstructorNotNull(){
		letter [] array= new letter[2];
		letter x = new letter(3);
		letter y = new letter(2);
		array[0]=x;
		array[1]=y;
		ArrayList<timeBetweenTwoChars> d = new ArrayList<timeBetweenTwoChars>();
	     profile test=new profile("profile1",array,d);
	     Assert.assertNotNull(test);
	}
	@Test
	 public void profile_SecondConstructorNotNull(){
			File testfile= new File("test");
			profile test= new profile(testfile);
			Assert.assertNotNull(test);
	 }
	
	
	
	
	
	
	
	
}
