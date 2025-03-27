public class Main {

    public static void main(String[] args) {

        javax.swing.SwingUtilities.invokeLater(() -> {

            MyWindow window = new MyWindow();
            
            window.setVisible(true);
        });
    }
}

