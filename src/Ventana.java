import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Ventana {
    private JPanel ventana;
    private JTable tableDatos; // Tabla para mostrar los datos


    public Ventana() {
        // Mostrar los datos automáticamente al abrir la ventana
        mostrarDatos();


    }

    private void mostrarDatos() {
        try (Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/bd_ins", "root", "")) {
            PreparedStatement pst = cn.prepareStatement("SELECT * FROM alumnos");
            ResultSet rs = pst.executeQuery();

            DefaultTableModel modelo = new DefaultTableModel();
            modelo.addColumn("ID");
            modelo.addColumn("Nombre");
            modelo.addColumn("Grupo");
            modelo.addColumn("Usuario");
            modelo.addColumn("Password");

            while (rs.next()) {
                Object[] fila = new Object[5];
                fila[0] = rs.getString("ID");
                fila[1] = rs.getString("NombreAlumno");
                fila[2] = rs.getString("Grupo");
                fila[3] = rs.getString("Usuario");
                fila[4] = rs.getString("Password");
                modelo.addRow(fila);
            }

            tableDatos.setModel(modelo);

        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al mostrar los datos: " + ex.getMessage());
        }
    }

    public JPanel getVentana() {
        return ventana;
    }
}
