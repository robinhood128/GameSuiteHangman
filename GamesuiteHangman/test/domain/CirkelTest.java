package domain;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CirkelTest {
	
	@Before
	public void setUp() throws Exception{
		
	}
	
	@Test
		public void testCirkel() {
			Cirkel cirkel = new Cirkel();
			assertEquals(1,cirkel.getRadius());
			assertNotNull(cirkel.getMiddelPunt());
		}
	
	@Test(expected = IllegalArgumentException.class)
	public void testCirkel_middelPunt_null_gooit_exception(){
		new Cirkel(new Punt(2,2),0);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testCirkel_radius_kleinerDanNul_gooit_exception(){
		new Cirkel(new Punt(2,2),-5);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testCirkel_radius_gelijkAanNul_gooit_exception(){
		new Cirkel(new Punt(2,2),0);
	}
	
	@Test
	public void testCirkel_twee_cirkels_gelijk(){
		Cirkel een = new Cirkel(new Punt(2,2),5);
		Cirkel twee = new Cirkel(new Punt(2,2),5);
		assertTrue(een.equals(twee));

	}
	
	@Test
	public void testCirkel_tweede_cirkel_null_verschillend(){
		Cirkel een = new Cirkel(new Punt(2,2),5);
		Cirkel twee = null;
		assertFalse(een.equals(twee));
	}
	
	@Test
	public void testCirkel_twee_cirkels_middelPunt(){
		Cirkel een = new Cirkel(new Punt(2,2),5);
		Cirkel twee = new Cirkel(new Punt(2,3),5);
		assertFalse(een.equals(twee));
	}
	
	@Test
	public void testCirkel_twee_cirkels_radius(){
		Cirkel een = new Cirkel(new Punt(2,2),4);
		Cirkel twee = new Cirkel(new Punt(2,3),5);
		assertFalse(een.equals(twee));
	}
	

}
