package pl.polsl.Szymon.Bartnik.models;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import pl.polsl.Szymon.Bartnik.models.exceptions.ServerAnswerException;

/**
 * Class which encapsulates socket connection to the NumeralSystemsService 
 * and its methods also.
 * 
 * @author Szymon Bartnik (Grupa 2)
 * @version 1.0
 */
public class NumeralSystemsCalculatorClient {

    /** socket representing connection to the client */
    private Socket socket;
    /** buffered input character stream */
    private BufferedReader in;
    /** Formatted output character stream */
    private DataOutputStream out;
    
    /**
     * Creates a new instance of NumeralSystemsCalculatorClient
     * 
     * @param socket which will be encapsulated in the instance of class
     * @throws IOException if any communication error occures during the connection.
     */
    public NumeralSystemsCalculatorClient(Socket socket) 
            throws IOException {

        this.socket = socket;
        
        // Initialization of output server stream
        out = new DataOutputStream(socket.getOutputStream());
        // Initialization of input server stream
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    }

    /**
     * Gets the hello message from the server after successfull connection.
     * @return the hello message
     * @throws IOException if any communication error occures during the connection
     */
    public String getHelloMessage() throws IOException{
        
        return in.readLine();
    }
    
    /**
     * Converts the number on the server side using passed parameters
     * 
     * @param inputNumeralSystem input numeral system
     * @param outputNumeralSystem output numeral system
     * @param numberToConvert number to convert from one system to other
     * 
     * @return the object which represents the conversion
     * 
     * @throws IOException if any communication error occures during the connection 
     * @throws ServerAnswerException if passed inappropriate data which server can't handle
     */
    public Object[] convertNumber(String inputNumeralSystem, String outputNumeralSystem, String numberToConvert)
        throws IOException, ServerAnswerException {
        
        SendToServer("setInputNumeralSystem " + inputNumeralSystem);
        SendToServer("setOutputNumeralSystem " + outputNumeralSystem);
        SendToServer("setInputNumberToConvert " + numberToConvert);
        SendToServer("convertNumber");
        String converted = SendToServer("getConvertedNumber");
        
        return new Object[] {
            inputNumeralSystem,
            numberToConvert,
            outputNumeralSystem,
            converted,
        };
    }

    /**
     * Sends message to the server synchronously, checks if server handled it 
     * by checking the answer and returns the answer if handle was successful.
     * 
     * @param messageToSend message to send to the server
     * 
     * @return the aswer of the server
     * 
     * @throws IOException if any communication error occures during the connection 
     * @throws ServerAnswerException if passed inappropriate data which server can't handle
     */
    private String SendToServer(String messageToSend)
            throws ServerAnswerException, IOException {
        
        out.writeBytes(messageToSend + '\n');
        
        // Checking if server handled the request and returns the answer
        return CheckAnswerError();
    }
    
    /**
     * Check if the answer of the server if begins with 'ERROR' word
     * which indicates the problems of the sent request.

     * @return the answer of the server (without 'ERROR' word)
     * 
     * @throws IOException if any communication error occures during the connection 
     * @throws ServerAnswerException if passed inappropriate data which server can't handle
     */
    private String CheckAnswerError() 
            throws ServerAnswerException, IOException {
        
        // Gets the line from the output stream.
        String serverAnswer = in.readLine();
        String[] splittedServerAnswer = serverAnswer.split(" ");
        
        if(splittedServerAnswer[0].startsWith("ERROR")){
            throw new ServerAnswerException(serverAnswer);
        }
        
        return splittedServerAnswer[0];
    }
}
