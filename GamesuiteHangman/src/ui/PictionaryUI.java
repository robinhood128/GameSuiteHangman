package ui;

import domain.*;

public class PictionaryUI {
	private Speler speler;
	private Tekening tekening;

	public PictionaryUI(Speler speler) {
		this.speler = speler;
	}

	public Speler getSpeler() {
		return speler;
	}

	public void showTekening() {
		GameHoofdScherm scherm = new GameHoofdScherm(speler.getNaam(), tekening);
		scherm.setVisible(true);
		scherm.teken();
	}

	public void showMenu() {
		tekening = new Tekening(InputDialogUtils.getInputString("Geef de naam van je tekening"));
		while (showNextCommand())
			;
	}

	public boolean showNextCommand() {
		switch (InputDialogUtils
				.getInputInteger("Wat wil je doen:\n\n1. Vorm maken\n2. Tekening tonen\n\n0. Stoppen")) {
		case 1:
			try {
				tekening.voegToe(showVormMenu());
			}

			catch (UIException e) {

			}
			break;
		case 2:
			showTekening();
			// JOptionPane.showMessageDialog(null, tekening.toString());
			return false;
		case 0:
			return false;
		}

		return true;
	}

	public Vorm showVormMenu() {
		Object[] shapes = { "Cirkel", "Rechthoek", "Driehoek", "Lijnstuk" };
		Object keuze = InputDialogUtils.getInputObject("Wat wilt u tekenen?", shapes);

		switch ((String) keuze) {
		case "Cirkel":
			return showCirkelMenu();
		case "Rechthoek":
			return showRechthoekMenu();
		case "Driehoek":
			return showDriehoekMenu();
		case "Lijnstuk":
			return showLijnstukMenu();
		default:
			return null;
		}
	}

	public Punt showPuntMenu() {
		int x = InputDialogUtils.getInputInteger("x coordinaat van het punt:");
		int y = InputDialogUtils.getInputInteger("y coordinaat van het punt:");
		return new Punt(x, y);
	}

	public Cirkel showCirkelMenu() {
		Punt midden = showPuntMenu();
		int radius = InputDialogUtils.getInputInteger("Radius van de cirkel:");
		return new Cirkel(midden, radius);
	}

	public Rechthoek showRechthoekMenu() {
		return new Rechthoek(showPuntMenu(), InputDialogUtils.getInputInteger("Breedte van de rechthoek:"),
				InputDialogUtils.getInputInteger("Lengte van de rechthoek:"));
	}

	public Driehoek showDriehoekMenu() {
		return new Driehoek(showPuntMenu(), showPuntMenu(), showPuntMenu());
	}

	public Lijnstuk showLijnstukMenu() {
		return new Lijnstuk(showPuntMenu(), showPuntMenu());
	}
}