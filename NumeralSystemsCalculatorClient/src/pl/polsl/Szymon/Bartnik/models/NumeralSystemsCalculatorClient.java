package pl.polsl.Szymon.Bartnik.models;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

/**
 *
 * @author Szymon
 */
public class NumeralSystemsCalculatorClient extends Thread {

    /** socket representing connection to the client */
    private Socket socket;
    /** buffered input character stream */
    private BufferedReader in;
    /** Formatted output character stream */
    private DataOutputStream out;
    
    public NumeralSystemsCalculatorClient(Socket socket) 
            throws IOException {

        this.socket = socket;
        
        out = new DataOutputStream(socket.getOutputStream());
        
        in = new BufferedReader(
                new InputStreamReader(
                socket.getInputStream()));
    }

    public String getHelloMessage() throws IOException{
        return in.readLine();
    }
    
    public Object[] convertNumber(String inputNumeralSystem, String outputNumeralSystem, String numberToConvert)
        throws IOException {
        
        out.writeBytes("setInputNumeralSystem " + inputNumeralSystem + '\n');
        String x2 = in.readLine();
        
        out.writeBytes("setOutputNumeralSystem " + outputNumeralSystem + '\n');
        String x3 = in.readLine();
        
        out.writeBytes("setInputNumberToConvert " + numberToConvert + '\n');
        String x4 = in.readLine();
        
        out.writeBytes("convertNumber" + '\n');
        String x5 = in.readLine();
        
        out.writeBytes("getConvertedNumber" + '\n');
        String converted = in.readLine();
        
        return new Object[] {
            inputNumeralSystem,
            numberToConvert,
            outputNumeralSystem,
            converted,
        };
    }
}
