package Serial;

// Classe para tratar os dados recebidos do arduíno 
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import static java.rmi.Naming.list;
import java.util.ArrayList;
import java.util.Arrays;
import static java.util.Arrays.asList;
import static java.util.Collections.list;
import java.util.List;
import java.util.Vector;
import javax.swing.JFileChooser;

public class Protocolo {
    
    private JFileChooser fileChooser = new JFileChooser();
    String linha;
    List<String> media = new ArrayList<String>();
    List<String> desvPad = new ArrayList<String>();
    
    
    private String soma;
    private String m1;
    private String leituraComando;
    int qtdF = 0, qtdT = 0;
    int vetorForca[] = new int[500], vetorTempo[] = new int[500];
    int amostra[] = new int[11]; // Vetor para formar uma amostra

    public List<String> abrirArquivo() throws IOException {
        
        int returnVar = fileChooser.showOpenDialog(null);
        if (returnVar == JFileChooser.APPROVE_OPTION) {
            String nomeArquivo = fileChooser.getSelectedFile().getAbsolutePath();
            try {
                BufferedReader file = new BufferedReader(new FileReader(nomeArquivo));
                linha = file.readLine();
                media = new ArrayList<String>(Arrays.asList(linha.split(",")));
                System.out.println("A media do usuario é: " + media);
                linha = file.readLine();
                desvPad = new ArrayList<String>(Arrays.asList(linha.split(",")));
                System.out.println("O desvio padrão do usuário é: " + desvPad);
                
            } catch (FileNotFoundException ex) {
                System.err.println("ERRO ABERTURA ARQUIVO:  " + ex);
                abrirArquivo();
            }
            
        }
        
        return media;
        
    }
    
    private void interpretaComando() throws IOException {
        //Separa a string de comando em substrings delimitadas por um caracter especifico

        String aux[];
        aux = leituraComando.split(",");

//       if (aux.length == 2) {
//       soma = aux[1];
//       m1 = aux[1];
//       }
        for (int i = 0; i < aux.length; i++) {
            
            if (aux[i].equals("F")) {
                
                vetorForca[qtdF++] = Integer.parseInt(aux[i + 1]);
                
            } else {
                
                if (aux[i].equals("T")) {
                    
                    vetorTempo[qtdT++] = Integer.parseInt(aux[i + 1]);
                    
                }
                
            }
        }
        int[] forcaVetor = new int[10];
        int c = 0;
        int soma_forcas1 = 0;
        for (int i = 0; i < qtdF; i++) {
            
            soma_forcas1 += vetorForca[i];
            forcaVetor[c] += vetorForca[i];
            
        }
        
        int soma_tempo = 0;
        for (int i = 0; i < qtdT; i++) {
            
            soma_tempo += vetorTempo[i];
            
        }
        
        int tempo_total1 = 0;
        for (int i = 0; i < qtdT; i++) {
            
            if (i > 0) {
                
                tempo_total1 += vetorTempo[i] - vetorTempo[i - 1];
                
            }
            
        }
        
        int[] tempototalVetor = new int[10];
        int[] latencia = new int[11];
        
        int latencia1 = 0;
        int a = 0;
        int b = 0;
        int cont = 1;
        
        for (int i = 0; i < qtdT; i++) {
            
            if (i > 0) {
                
                latencia[a] = vetorTempo[i] - vetorTempo[i - 1];
                latencia1 = vetorTempo[i] - vetorTempo[i - 1];
                tempototalVetor[b] += vetorTempo[i] - vetorTempo[i - 1];
                
            }
            a++;
            cont++;
        }
        
        System.out.println("Chegou: " + getLeituraComando());
        System.out.println("Forca Media: " + (int) soma_forcas1 / qtdF);
        System.out.println("Tempo: " + (float) soma_tempo);
        System.out.println("Latencia: " + (int) latencia1);
        System.out.println("Tempo Total de Digitacao: " + (int) tempo_total1);
        System.out.println();
        
        if (cont == 10) {
            
            for (int l = 1; l < latencia.length; l++) {         // A posicão 0 do vetor não é utilizada pois não temos latência na primeira batida de teclas
                amostra[l] = latencia[l]; // Amostra recebe as latências e coloca e coloca no vetor amostra[]
                amostra[9] = tempototalVetor[b]; // A posição 8 do vetor vai receber o tempoTotal da digitação
                amostra[10] = forcaVetor[c] / qtdF; // A posição 9 vai alocar a força média da digitação
            }
            
            for (int i = 0; i < amostra.length; ++i) {
                System.out.print(Arrays.asList(amostra[i])); // Para exibir o vetor formado
                System.out.println();
            }
            
            //abrirArquivo();
            //classifica();
            //System.exit(0);
            
        }
        
    }
    
    public String getSoma() {
        return soma;
    }
    
    public void setSoma(String soma) {
        this.soma = soma;
    }
    
    public String getM1() {
        return m1;
    }
    
    public void setM1(String m1) {
        this.m1 = m1;
    }
    
    public String getLeituraComando() {
        return leituraComando;
    }
    
    public void classifica() {
        
        int[] floatMedia = new int[media.size()];
        int[] floatDesv = new int[desvPad.size()];
        
        for (int i = 0; i < media.size(); i++) {
            floatMedia[i] = Integer.parseInt(media.get(i));
        }
        
        for (int i = 0; i < desvPad.size(); i++) {
            floatDesv[i] = Integer.parseInt(desvPad.get(i));
        }
        
        float resultado = 0;
        int n = amostra.length;
        for (int i = 1; i < n; i++) {
            
            resultado += Math.abs(floatMedia[i] - amostra[i]) / floatDesv[i];
        }
        resultado /= 10; // Dividir por 10 pois o vetor amostra tem tamanho 11 e o laço começa em 1, temos 10 valores para dividir

        System.out.println("Resultado " + resultado);
        if (resultado <= 1) {
            
            System.out.println("USUARIO ACEITO");
        } else {
            
            System.out.println("USUARIO IMPOSTOR");
        }
        
    }
    
    public void setLeituraComando(String LeituraComando) throws IOException {
        this.leituraComando = LeituraComando; // temos a string dados
        this.interpretaComando(); // interpretando a string
    }
    
}
