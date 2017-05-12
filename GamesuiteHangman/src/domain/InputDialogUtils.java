package domain;

import javax.swing.JOptionPane;

import ui.UIException;

public class InputDialogUtils {

	public static String getInputString(String content) {
		String result = "";

		while (result.trim().isEmpty()) {
			result = JOptionPane.showInputDialog(content);
			if (result == null)
				throw new UIException("Cancel");
		}

		return result;
	}

	public static Object getInputObject(String content, Object... multiplechoise) {
		Object obj = JOptionPane.showInputDialog(null, content, "input", JOptionPane.INFORMATION_MESSAGE, null,
				multiplechoise, null);
		if (obj == null)
			throw new UIException("Cancel");
		return obj;
	}

	public static int getInputInteger(String content) {
		int result = -1;

		while (result == -1) {
			try {
				String s = JOptionPane.showInputDialog(content);
				if (s == null)
					throw new UIException("Cancel");
				result = Integer.parseInt(s);
			}

			catch (NumberFormatException e) {
				result = -1;
			}
		}

		return result;
	}
}
