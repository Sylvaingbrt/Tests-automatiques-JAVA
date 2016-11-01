package date;

import static org.junit.Assert.*;
import org.junit.Test;

public class MyDateTest {
	
	  /**
	   * Test method for {@link MyDate#getDay()}.
	   */
	  @Test
	  public void testGetDay() {
		  MyDate d = new MyDate(31, 12, 2006);
		  assertEquals(31, d.getDay());
		  assertTrue(d.getDay()==(31));
		  assertFalse(d.getDay()==(1));
	  }

	  /**
	   * Test method for {@link MyDate#getMonth()}.
	   */
	  @Test
	  public void testGetMonth() {
		  MyDate d = new MyDate(31, 12, 2006);
		  assertEquals(12, d.getMonth());
		  MyDate c = new MyDate(1,333333,1);
		  assertTrue(c.getMonth()==(333333));
		  assertFalse(c.getMonth()==(1));
	  }

	  /**
	   * Test method for {@link MyDate#getYear()}.
	   */
	  @Test
	  public void testGetYear() {
		  MyDate d = new MyDate(31, 12, 2006);
		  assertEquals(2006, d.getYear());
		  MyDate c = new MyDate(1,2,-20);
		  assertTrue(c.getYear()==(-20));
		  assertFalse(c.getYear()==(1));
	  }

	  /**
	   * Test method for {@link MyDate#checkData()} .
	   */
	  @Test
	  public void testCheckData() {
		  MyDate d = new MyDate(31, 12, 2006);
		  assertTrue(d.checkData());
		  MyDate c = new MyDate(1,2,-20);
		  assertFalse(c.checkData());
	  }

	  /**
	   * Test simple valid dates
	   */
	  @Test
	  public void testSimpleValidDates() {
	    boolean b = MyDate.isValidDate(1, 1, 2000);
	    assertTrue(b);
	    b = MyDate.isValidDate(12, 25, 2000);
	    assertFalse(b);
	  }

	  /**
	   * Test simple invalid dates
	   */
	  @Test
	  public void testSimpleInvalidDates() {
	    boolean b = MyDate.isValidDate(0, 1, 2000);
	    assertFalse("0 est invalide pour le jour", b);
	    b = MyDate.isValidDate(32, 12, 2000);
	    assertFalse("32 est aussi invalide",b);
	  }

	  /**
	   * Test valid limit dates
	   */
	  @Test
	  public void testValidLimitDates() {
	    boolean b = MyDate.isValidDate(31, 1, 2000);
	    assertTrue("31 janvier est une date valide", b);
	    b = MyDate.isValidDate(32, 1, 2000);
	    assertFalse("32 janvier n'est pas une date valide",b);
	  }

	  /**
	   * Test invalid limit dates
	   */
	  @Test
	  public void testInvalidLimitDates() {
	    boolean b = MyDate.isValidDate(31, 4, 2000);
	    assertFalse("31 avril est une date invalide", b);
	    boolean c = MyDate.isValidDate(1, 1, 4001);
	    assertFalse("L'an 4001 est une date invalide", c);
	    boolean d = MyDate.isValidDate(31, 12, 0);
	    assertFalse("L'an 0 est une date invalide", d);
	  }

	  /**
	   * Test February valid limit dates
	   */
	  @Test
	  public void testFebruaryValidLimitDates() {
	    boolean b = MyDate.isValidDate(29, 2, 2000);
	    assertTrue("29 fevrier 2000 est une date valide", b);
	    boolean c = MyDate.isValidDate(29, 2, 2400);
	    assertTrue("29 fevrier 2400 est une date valide", c);
	    boolean d = MyDate.isValidDate(29, 2, 2016);
	    assertTrue("29 fevrier 2016 est une date valide", d);
	  }

	  /**
	   * Test February invalid limit dates
	   */
	  @Test
	  public void testFebruaryInvalidLimitDates() {
	    boolean b = MyDate.isValidDate(29, 2, 2001);
	    assertFalse("29 fevrier 2001 est une date invalide", b);
	    boolean c = MyDate.isValidDate(29, 2, 2100);
	    assertFalse("29 fevrier 2100 est une date invalide", c);
	    boolean d = MyDate.isValidDate(29, 2, 1400);
	    assertFalse("29 fevrier 1400 est une date invalide", d);
	  }
	  
	  /**
	   * Test method for {@link MyDate#nextDay()}.
	   */
	  @Test
		public void testNextDay() {
			MyDate d = new MyDate(31, 12, 4000);
			MyDate e = new MyDate(28, 2, 2006);
			MyDate f = new MyDate(30, 4, 2006);
			MyDate g = new MyDate(40, 580, -3000);
			MyDate h = new MyDate(2, 12, 1582);
			assertTrue(d.nextDay().getDay()==(1));
			assertFalse(d.getYear()==(4000));
			assertTrue(e.nextDay().getDay()==(1));
			assertFalse(e.getMonth()==(2));
			assertTrue(f.nextDay().getDay()==(1));
			assertFalse(f.getMonth()==(4));
			assertTrue(g.nextDay().getDay()==(0));
			assertTrue(g.getMonth()==(0));
			assertTrue(g.getYear()==(0));
			assertTrue(h.nextDay().getDay()==(3));
			assertTrue(h.getMonth()==(12));
			assertTrue(d.nextDay().getDay()==(0));
			assertTrue(d.nextDay().getDay()==(0));
			assertEquals(e, new MyDate(1,3,2006));
			assertEquals(f, new MyDate(1,5,2006));
			assertEquals(h, new MyDate(3,12,1582));
			assertEquals(g, d);
			for(int i=0; i<154586;i++){
				h.nextDay();
			}
			assertEquals(h, e);
		}

}
