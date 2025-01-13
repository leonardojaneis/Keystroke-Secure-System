package recebedadosarduino;


import Serial.Protocolo;
import Serial.SerialRxTx;

import SistemaAutenticacao.Login;
import java.awt.Color;
import java.awt.Font;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.swing.JFrame;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import javax.swing.JFileChooser;

public class RecebeDadosArduino {

    public static void main(String[] args) throws IOException,FileNotFoundException {

    
     Login l = new Login();
     Protocolo c = new Protocolo();
     SerialRxTx serial = new SerialRxTx();
     l.setSize(415,210);
     l.setLocationRelativeTo(null);
     l.setTitle("KeystrokeSecure 2.0");
     l.setVisible(true);
    
     
     
     if (serial.iniciaSerial()) {

            while (true) {
                
            }

        } else {
            
        }

  }

}
