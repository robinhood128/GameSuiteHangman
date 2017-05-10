package domain;

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

    public TekeningHangMan(String naam) {
        super(naam);
        voegToe(galgBodem);
        voegToe(galgStaaf);
        voegToe(hangbar);
        voegToe(koord);
        voegToe(hoofd);
        voegToe(oogLinks);
        voegToe(oogRechts);
        voegToe(neus);
        voegToe(mond);
        voegToe(lijf);
        voegToe(beenLinks);
        voegToe(beenRechts);
        voegToe(voetLinks);
        voegToe(voetRechts);
        voegToe(armLinks);
        voegToe(armRechts);
        voegToe(handLinks);
        voegToe(handRechts);
    }
}
