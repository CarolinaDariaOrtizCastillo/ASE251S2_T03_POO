package vallegrande.edu.pe;

import vallegrande.edu.pe.view.SelectionView;

public class App {
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> {
            SelectionView menu = new SelectionView();
            menu.setVisible(true);
        });
    }
}


