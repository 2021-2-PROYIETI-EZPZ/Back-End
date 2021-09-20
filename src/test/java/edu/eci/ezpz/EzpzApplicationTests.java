package edu.eci.ezpz;
import junit.framework.Test;
import junit.framework.TestCase;
import static junit.framework.TestCase.assertTrue;
import junit.framework.TestSuite;
public class EzpzApplicationTests
		extends TestCase
{
	public EzpzApplicationTests( String testName )
	{
		super( testName );
	}
	public static Test suite()
	{
		return new TestSuite( EzpzApplicationTests.class );
	}
	public void testApp()
	{
		assertTrue( true );
	}
}