package Serial;

import gnu.io.CommPortIdentifier;
import gnu.io.SerialPort;
import gnu.io.SerialPortEvent;
import gnu.io.SerialPortEventListener;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.Enumeration;

/**
 *
 * @author Leonardo J. de Melo
 */
public class SerialRxTx implements SerialPortEventListener {

    SerialPort serialPort = null;
    private Protocolo protocolo = new Protocolo();
    private String appName; //nome da aplicação
    private BufferedReader input; // receber dados
    private OutputStream output;  // enviar dados
    private static final int TIME_OUT = 1000; // tempo de espera para comunicacao
    private static int DATA_RATE = 9600;
    private String serialPortName = "COM3";
    public String a = "";

    public boolean iniciaSerial() {
        boolean status = false;

        try {
            //Obtem portas seriais do sistema
            CommPortIdentifier portId = null;
            Enumeration portEnum = CommPortIdentifier.getPortIdentifiers();

            while (portId == null && portEnum.hasMoreElements()) {
                CommPortIdentifier currPortId = (CommPortIdentifier) portEnum.nextElement();

                if (currPortId.getName().equals(serialPortName) || currPortId.getName().startsWith(serialPortName)) {
                    serialPort = (SerialPort) currPortId.open(appName, TIME_OUT);
                    portId = currPortId;
                    System.out.println("Conectado em: " + currPortId.getName());
                    break;
                }
            }

            if (portId == null || serialPort == null) {
                return false;
            }
            serialPort.setSerialPortParams(DATA_RATE,
                    SerialPort.DATABITS_8,
                    SerialPort.STOPBITS_1,
                    SerialPort.PARITY_NONE);
            serialPort.addEventListener(this);
            serialPort.notifyOnDataAvailable(true);
            status = true;
            try {
                Thread.sleep(1000);

            } catch (InterruptedException e) {
                System.out.println("ERRO");
                e.printStackTrace();
            }
        } catch (Exception e) {
            System.out.println("ERRO");
            e.printStackTrace();
            status = false;
        }

        return status;

    }

    // Método que envia dados pela serial caso necessário
    public void sendData(String data) {
        try {
            output = serialPort.getOutputStream();
            output.write(data.getBytes());
        } catch (Exception e) {
            System.err.println(e.toString());

        }

    }

    // Método que fecha a porta serial
    public synchronized void close() {
        if (serialPort != null) {
            serialPort.removeEventListener();
            serialPort.close();

        }
    }

    public void serialEvent(SerialPortEvent spe) {
        //Método que lida com a chegada de dados pela serial do computador
        try {
            switch (spe.getEventType()) {
                case SerialPortEvent.DATA_AVAILABLE:
                    if (input == null) {
                        input = new BufferedReader(
                                new InputStreamReader(
                                        serialPort.getInputStream()));
                    }

                    protocolo.setLeituraComando(input.readLine());
                    a += protocolo.getLeituraComando() + "\r\n";
                    break;

                default:
                    break;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Protocolo getProtocolo() {
        return protocolo;
    }

    public void setProtocolo(Protocolo protocolo) {
        this.protocolo = protocolo;
    }

    public static int getDATA_RATE() {
        return DATA_RATE;
    }

    public static void setDATA_RATE(int DATA_RATE) {
        SerialRxTx.DATA_RATE = DATA_RATE;
    }

    public String getSerialPortName() {
        return serialPortName;
    }

    public void setSerialPortName(String serialPortName) {
        this.serialPortName = serialPortName;
    }
}
