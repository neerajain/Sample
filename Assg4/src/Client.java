

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.ServerSocket;
import java.net.Socket;

public class Client
{
    public void go(String repName) throws IOException {

        ClientFrame clientFrame=new ClientFrame(repName);
    }
}

/**
 * Constructs a JFrame and adds ClientPanel to it
 * Then it registers NotifyActiveStatus with window listener to notify Server that this client is online
 */
class ClientFrame extends JFrame{

    ClientFrame(String repName) throws IOException{

        setBounds(600,300,270,370);

        setTitle("Team Rep Chat");

        ClientPanel panel=new ClientPanel(repName);

        add(panel);

        setVisible(true);
    }
}

/**
 * JPanel which is a runnable and defines the various components for the JFrame.
 */
class ClientPanel extends JPanel implements Runnable
{
    private JTextField messageField;
    private JTextField nameField;
    public JTextArea textArea;
    public Socket serverClient;
    public String clientName;
    ClientPanel(String repName) throws IOException
    {
    	serverClient = new Socket("localhost", 5050);
        clientName = repName;

        //Name
        JLabel nameLabel = new JLabel("Patient's Id :");
        nameField = new JTextField(15);
        nameField.setEditable(false);
        nameField.setText(clientName);
        add(nameLabel);
        add(nameField);

        //Text area
        textArea = new JTextArea(14,20);
        textArea.setEditable(false);
        add(textArea);

        //Message
        messageField = new JTextField(15);
        add(messageField);

        //Button
        JButton submitButton = new JButton("Send");
        submitButton.addActionListener(new SendTextListener());
        add(submitButton);

        Thread thread = new Thread(this);
        thread.start();
    }

    /**
     * Listens for and accepts incoming requests from the Server to display message relayed back to it
     */
    @Override
    public void run()
    {
        try
        {
        	String clientInformationReceived;
            DataInputStream din=new DataInputStream(serverClient.getInputStream());  
            while(true)
            {
            	
           		clientInformationReceived = din.readUTF();
                textArea.append("\nAdmin: " + clientInformationReceived);
            	
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    /**
     * Attempts to connect to Server upon 'send' and send messages
     */
    class SendTextListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            try
            {
            	DataOutputStream dout=new DataOutputStream(serverClient.getOutputStream()); 
            	String str = clientName + ": " + messageField.getText();
                textArea.append("\n" + str);
                messageField.setText("");
                dout.writeUTF(str);  
                dout.flush();  
            }
            catch (IOException e1)
            {
                System.out.println(e1.getMessage());
            }
        }
    }
}