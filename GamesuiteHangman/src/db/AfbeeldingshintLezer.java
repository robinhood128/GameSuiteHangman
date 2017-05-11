package db;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

import domain.Cirkel;
import domain.Driehoek;
import domain.Lijnstuk;
import domain.PictionaryWoordEnTekening;
import domain.Punt;
import domain.Rechthoek;
import domain.Vorm;

public class AfbeeldingshintLezer {
	private String pad;

	public AfbeeldingshintLezer(String pad) {
		setPad(pad);
	}

	private void setPad(String pad) {
		this.pad = pad;
	}

	public ArrayList<PictionaryWoordEnTekening> leesTekeningen() {
		File woordenFile = new File(pad);
		ArrayList<PictionaryWoordEnTekening> woorden = new ArrayList<PictionaryWoordEnTekening>();


		try {
			Scanner scannerFile = new Scanner(woordenFile);

			while (scannerFile.hasNextLine()) {
				ArrayList<Vorm> vormen = new ArrayList<Vorm>();
				String naam = scannerFile.nextLine();
				while (!scannerFile.nextLine().equals("EINDE")) {
					String temp = scannerFile.nextLine();
					String[] tokens = temp.split(",", -1);
					Punt a = new Punt(Integer.parseInt(tokens[1]),Integer.parseInt(tokens[2]));
					if (tokens[0].equals("cirkel")) {
						Cirkel cirkel = new Cirkel(a,Integer.parseInt(tokens[3]));
						vormen.add(cirkel);
					}	else if (tokens[0].equals("lijnstuk")) {
						Punt b = new Punt(Integer.parseInt(tokens[3]),Integer.parseInt(tokens[4]));
						Lijnstuk lijnstuk = new Lijnstuk(a,b);
						vormen.add(lijnstuk);
					}else if (tokens[0].equals("rechthoek")) {
						Rechthoek rechthoek = new Rechthoek(a,Integer.parseInt(tokens[3]),Integer.parseInt(tokens[4]));
						vormen.add(rechthoek);
					}else if (tokens[0].equals("driehoek")) {
						Punt b = new Punt(Integer.parseInt(tokens[3]),Integer.parseInt(tokens[4]));
						Punt c = new Punt(Integer.parseInt(tokens[5]),Integer.parseInt(tokens[6]));
						Driehoek driehoek = new Driehoek(a,b,c);
						vormen.add(driehoek);
					}
				
				}
				PictionaryWoordEnTekening woord = new PictionaryWoordEnTekening(naam,vormen);
				woorden.add(woord);
			}

			scannerFile.close();
		}

		catch (Exception e) {
			throw new DBException("Fout bij inlezen.");
		}

		return woorden;
	}
}
