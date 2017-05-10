package domain;

import javax.swing.JOptionPane;

public class InputDialogUtils {

	public static String getInputString(String content) {
		String result = "";

		while (result == null || result.trim().isEmpty()) {
			result = JOptionPane.showInputDialog(content);
		}

		return result;
	}

	public static Object getInputObject(String content, Object... multiplechoise) {
		Object result = null;

		while (result == null) {
			result = JOptionPane.showInputDialog(null, content, "input", JOptionPane.INFORMATION_MESSAGE, null,
					multiplechoise, null);
		}

		return result;
	}

	public static int getInputInteger(String content) {
		int result = -1;

		while (result == -1) {
			try {
				result = Integer.parseInt(JOptionPane.showInputDialog(content));
			}

			catch (Exception e) {
				result = -1;
			}
		}

		return result;
	}
}
