package pl.polsl.Szymon.Bartnik.models.server;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Date;
import pl.polsl.Szymon.Bartnik.controller.CalculatorController;
import pl.polsl.Szymon.Bartnik.models.NegativeNumberException;

/** 
 * The server class servicing a single connection 
 */
public class NumeralSystemsService extends Thread {

    /** socket representing connection to the client */
    private Socket socket;
    /** buffered input character stream */
    private BufferedReader in;
    /** Formatted output character stream */
    private PrintWriter out;

    private String inputNumeralSystem;
    private String outputNumeralSystem;
    private String inputNumberToConvert;
    private String convertedNumber;

    /** 
     * The constructor of instance of the SingleService class. Use the socket as a parameter.
     * 
     * @param socket socket representing connection to the client
     */
    public NumeralSystemsService(Socket socket) throws IOException {
        
        this.socket = socket;
        
        out = new PrintWriter(
                new BufferedWriter(
                new OutputStreamWriter(
                socket.getOutputStream())), true);
        
        in = new BufferedReader(
                new InputStreamReader(
                socket.getInputStream()));
    }

    /** 
     * Invoked when start() method of base Thread clas is invoked.
     * This method starts in the new thread.
     */
    @Override
    public void run() {
        try {
            startServiceLogic();
        } catch (IOException e) {
            System.err.println(e.getMessage());
        } finally {
            try {
                socket.close(); 		
            } catch (IOException e) {
                System.err.println(e.getMessage());
            }
        }
    }

    /**
     * Starts service logic responsible for handling messages which has been
     * sent to the TCP server
     * @throws IOException 
     */
    private void startServiceLogic() 
            throws IOException {
        
        // Send one time hello message
        sendMessage("Hello on NumeralCalculatorServer. "
                + "Type 'quit' to end current server session");
        
        while (true) {
            // Save received message in variable 
            String[] receivedMessage = in.readLine().split(" ");
            
            // If received 'quit' command then exit the current session
            if("quit".equals(receivedMessage[0])){
                break;
            }
            
            // Generate the answer
            String answer = processReceivedMessage(receivedMessage);
            sendMessage(answer);
        }
        
        // Send one time quit message
        sendMessage("Server is quiting...");
    }

    private void sendMessage(String messageToSend)
        throws IOException {
        
        Date currentDate = new Date(System.currentTimeMillis());
        
        System.out.println("###" + currentDate + "### Server sending: '" + messageToSend + "'");
        out.println(messageToSend);
    }

    private String processReceivedMessage(String[] receivedMessage) {
        
        try{
            switch(receivedMessage[0]){
                case "setInputNumeralSystem":
                    inputNumeralSystem = receivedMessage[1];
                    break;
                case "setOutputNumeralSystem":
                    outputNumeralSystem = receivedMessage[1];
                    break;
                case "setInputNumberToConvert":
                    inputNumberToConvert = receivedMessage[1];
                    break;
                case "convertNumber":
                    ConvertNumber();
                    break;
                case "getConvertedNumber":
                    return GetConvertedNumber();
                default:
                    return "ERROR Command '" + receivedMessage[0] + "' not recognized";
            }
        }
        catch(Exception e){
            return "ERROR " + e.getMessage();
        }
        
        return "OK";
    }

    private void ConvertNumber() 
            throws NumberFormatException, NullPointerException, NegativeNumberException,
            IllegalArgumentException, IndexOutOfBoundsException {

        if(inputNumeralSystem == null){
            throw new NullPointerException("Input numeral system has to be set first!");
        }
        
        if(outputNumeralSystem == null){
            throw new NullPointerException("Input numeral system has to be set first!");
        }
        
        if(inputNumberToConvert == null){
            throw new NullPointerException("Input number to convert has to be set first!");
        }
        
        CalculatorController calc = new CalculatorController(new String[] {
            inputNumeralSystem, 
            outputNumeralSystem});

        convertedNumber = calc.convertNumber(inputNumberToConvert).getOutputNumber();
        
        inputNumberToConvert = null;
        inputNumeralSystem = null;
        outputNumeralSystem = null;
    }

    private String GetConvertedNumber() {
        return convertedNumber != null
                ? convertedNumber
                : "ERROR Conversion has to be proceeded first.";
    }
}