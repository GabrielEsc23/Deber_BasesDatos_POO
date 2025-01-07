import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        // Ejecutar la GUI en el hilo de eventos de Swing
        SwingUtilities.invokeLater(() -> {
            // Crear y mostrar el JFrame del login
            JFrame loginFrame = new JFrame("Login");
            login loginPanel = new login(loginFrame); // Pasamos el JFrame para controlarlo

            loginFrame.setContentPane(loginPanel.loginPanel);
            loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            loginFrame.setSize(400,400);
            loginFrame.setPreferredSize(new Dimension(400,400));
            loginFrame.pack();
            loginFrame.setVisible(true);
        });
    }
}
