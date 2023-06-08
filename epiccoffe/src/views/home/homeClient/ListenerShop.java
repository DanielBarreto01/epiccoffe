package views.home.homeClient;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JTextField;

public class ListenerShop implements ActionListener {
	
	private JPanelHomeClient jPanelHomeClient;
	private int count;

	public ListenerShop(JPanelHomeClient jPanelHomeClient) {
		this.jPanelHomeClient = jPanelHomeClient;
		count = 0;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Componets[][] prodcuts = jPanelHomeClient.getBody();
		for (int i = 0; i < prodcuts.length; i++) {
			for (int j = 0; j < prodcuts[0].length; j++) {
			if (prodcuts[i][j] != null) {
					count = prodcuts[i][j].getUnits();
					if (e.getSource() == prodcuts[i][j].getLees()) {
						if (count > 0) {
							count--;
							prodcuts[i][j].setUnits(count);
							prodcuts[i][j].getNumber().setText(count + "");
						}
					}
					if (e.getSource() == prodcuts[i][j].getMore() && count < prodcuts[i][j].getMaximed()) {
						count++;
						prodcuts[i][j].setUnits(count);
						prodcuts[i][j].getNumber().setText(count + "");
						break;
					}
				}
			}
		}
	}
				
}
