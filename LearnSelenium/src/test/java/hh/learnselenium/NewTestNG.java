package hh.learnselenium;

import org.testng.annotations.Test;

public class NewTestNG {
  @Test
  public void f() {
	  SimpleTest test1 = new SimpleTest();
	  test1.setup();
	  test1.test();
	  test1.cleanup();
	  
  }
}
