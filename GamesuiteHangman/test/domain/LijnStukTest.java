package domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class LijnStukTest {
	private Punt punt1 = new Punt(10, 20);
	private Punt zelfdeAlsPunt1 = new Punt(10, 20);
	private Punt punt2 = new Punt(190, 30);
	private Punt zelfdeAlsPunt2 = new Punt(190, 30);

	@Test
	public void LijnStuk_moet_lijnstuk_aanmaken_met_gegeven_startPunt_en_eindPunt() {
		Lijnstuk lijnstuk = new Lijnstuk(punt1, punt2);

		assertEquals(punt1, lijnstuk.getStartPunt());
		assertEquals(punt2, lijnstuk.getEindPunt());
	}
	
	@Test (expected = DomainException.class)
	public void LijnStuk_Moet_exception_gooien_als_startpunt_null()  {
		new Lijnstuk(null, punt2);
	}
	
	@Test (expected = DomainException.class)
	public void LijnStuk_Moet_exception_gooien_als_eindpunt_null()  {
		new Lijnstuk(punt1, null);
	}
	
	@Test
	public void equals_moet_true_teruggeven_als_begin_en_eindpunt_gelijk_zijn(){
		Lijnstuk lijnStuk = new Lijnstuk(punt1, punt2);
		Lijnstuk zelfdeLijnStuk = new Lijnstuk(zelfdeAlsPunt1, zelfdeAlsPunt2);
		assertTrue(lijnStuk.equals(zelfdeLijnStuk));
	}
	
	@Test
	public void equals_moet_true_teruggeven_als_begin_en_eindpunt_niet_gelijk_zijn() {
		Punt nieuwpunt = new Punt(45,67);
		Lijnstuk lijnstuk = new Lijnstuk(nieuwpunt, punt1);
		Lijnstuk anderLijnstuk = new Lijnstuk(nieuwpunt, punt2);
		assertFalse(lijnstuk.equals(anderLijnstuk));
	}
	
	@Test
	public void equals_moet_false_teruggeven_als_parameter_null(){
		Lijnstuk lijnStuk = new Lijnstuk(punt1, punt2);
		assertFalse(lijnStuk.equals(null));
	}
	@Test
	public void testGetOmhullende_geeft_correcte_Omhullende(){
		Lijnstuk een = new Lijnstuk(new Punt(10,10),new Punt(20,20));
		Punt linkerbovenhoek = new Punt(10,10);
		Omhullende test = new Omhullende(linkerbovenhoek,10,10);
		assertTrue(test.equals(een.getOmhullende()));
	}
}
	
