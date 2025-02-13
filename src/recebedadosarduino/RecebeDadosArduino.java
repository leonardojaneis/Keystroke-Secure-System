package recebedadosarduino;

import Serial.Protocolo;
import Serial.SerialRxTx;
import SistemaAutenticacao.Login;
import java.io.IOException;
import javax.swing.JFrame;

public class RecebeDadosArduino {

    public static void main(String[] args) {
        Login l = new Login();
        Protocolo c = new Protocolo();
        SerialRxTx serial = new SerialRxTx();

        l.setSize(415, 210);
        l.setLocationRelativeTo(null);
        l.setTitle("KeystrokeSecure 2.0");
        l.setVisible(true);

        if (serial.iniciaSerial()) {
            while (true) {
                try {
                    Thread.sleep(100); 
                } catch (InterruptedException e) {
                    System.err.println("Erro no loop principal: " + e.getMessage());
                    Thread.currentThread().interrupt();
                    break;
                }
            }
        } else {
            System.err.println("Falha ao iniciar a comunicação serial.");
        }
    }
}