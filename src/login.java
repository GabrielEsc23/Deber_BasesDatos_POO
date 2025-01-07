import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class login {
    public JTextField txt_usuario;
    public JTextField txt_password;
    public JButton ingresarButton;
    public JPanel loginPanel;

    public JFrame loginFrame; // Referencia al JFrame de login

    // Constructor para inicializar el login
    public login(JFrame loginFrame) {
        this.loginFrame = loginFrame; // Guardamos la referencia del JFrame

        // Configuramos el evento del botón "Ingresar"
        ingresarButton.addActionListener(e -> {
            boolean accesoValido = validarCredenciales();
            if (accesoValido) {
                // Si las credenciales son válidas, cerramos el login y abrimos la ventana principal
                loginFrame.dispose(); // Cerramos el JFrame del login
                abrirVentanaPrincipal(); // Abrimos la ventana principal
            } else {
                // Mostramos un mensaje de error si las credenciales son incorrectas
                JOptionPane.showMessageDialog(loginFrame, "Usuario o contraseña incorrectos.");
            }
        });
    }

    // Método para validar credenciales
    public boolean validarCredenciales() {
        boolean accesoValido = false;

        try (Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/bd_ins", "root", "")) {
            String query = "SELECT * FROM alumnos WHERE Usuario = ? AND Password = ?";
            PreparedStatement pst = cn.prepareStatement(query);
            pst.setString(1, txt_usuario.getText().trim()); // Usuario ingresado
            pst.setString(2, txt_password.getText().trim()); // Contraseña ingresada

            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                accesoValido = true; // Usuario y contraseña correctos
            } else {
                JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos.");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return accesoValido;
    }


    // Método para abrir la ventana principal
    public void abrirVentanaPrincipal() {
        JFrame ventanaPrincipal = new JFrame("Ventana Principal");
        Ventana ventana = new Ventana(); // Instancia de la ventana principal

        // Configurar la ventana principal
        ventanaPrincipal.setContentPane(ventana.getVentana());
        ventanaPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventanaPrincipal.setSize(400,600);
        ventanaPrincipal.setPreferredSize(new Dimension(400,600));
        ventanaPrincipal.pack();
        ventanaPrincipal.setVisible(true);
    }
}
