package domain;

import java.util.LinkedList;
import java.util.Queue;

import domain.Cirkel;
import domain.Lijnstuk;
import domain.Punt;
import domain.Rechthoek;
import domain.Tekening;
import domain.Vorm;

public class TekeningHangMan extends Tekening {

    Vorm galgBodem = new Rechthoek(new Punt(10, 350), 300, 40);
    Vorm galgStaaf = new Lijnstuk(new Punt(160, 350), new Punt(160, 50));
    Vorm hangbar = new Lijnstuk(new Punt(160,50), new Punt(280,50));
    Vorm koord = new Lijnstuk(new Punt(280, 50), new Punt(280, 100));
    Vorm hoofd = new Cirkel(new Punt(280, 125), 25);
    Vorm oogLinks = new Cirkel(new Punt(270, 118), 2);
    Vorm oogRechts = new Cirkel(new Punt(290, 118), 2);
    Vorm neus = new Cirkel(new Punt(280, 128), 2);
    Vorm mond = new Lijnstuk(new Punt(270, 138), new Punt(290, 138));
    Vorm lijf = new Lijnstuk(new Punt(280, 150), new Punt(280, 250));
    Vorm beenLinks = new Lijnstuk(new Punt(280, 250), new Punt(240, 310));
    Vorm beenRechts = new Lijnstuk(new Punt(280, 250), new Punt(320, 310));
    Vorm voetLinks = new Cirkel(new Punt(240, 310), 5);
    Vorm voetRechts = new Cirkel(new Punt(320, 310), 5);
    Vorm armLinks = new Lijnstuk(new Punt(280, 200), new Punt(230, 170));
    Vorm armRechts = new Lijnstuk(new Punt(280, 200), new Punt(330, 170));
    Vorm handLinks = new Cirkel(new Punt(230, 170), 5);
    Vorm handRechts = new Cirkel(new Punt(330, 170), 5);
    
    Queue<Vorm> onzichtbaren;

    public TekeningHangMan(String naam) {
        super(naam);
        voegToe(galgBodem);
        voegToe(galgStaaf);
        voegToe(hangbar);
        voegToe(koord);
        
        onzichtbaren = new LinkedList<Vorm>();
        onzichtbaren.add(hoofd);
        onzichtbaren.add(oogLinks);
        onzichtbaren.add(oogRechts);
        onzichtbaren.add(neus);
        onzichtbaren.add(mond);
        onzichtbaren.add(lijf);
        onzichtbaren.add(beenLinks);
        onzichtbaren.add(beenRechts);
        onzichtbaren.add(voetLinks);
        onzichtbaren.add(voetRechts);
        onzichtbaren.add(armLinks);
        onzichtbaren.add(armRechts);
        onzichtbaren.add(handLinks);
        onzichtbaren.add(handRechts);
    }
    
    public void zetVolgendeZichtbaar()
    {
    	if (onzichtbaren.size() > 0)
    	{
    		Vorm vorm = onzichtbaren.poll();
    		voegToe(vorm);
    	}
    }
    
    public int getAantalOnzichtbaar()
    {
    	return onzichtbaren.size();
    }
}
