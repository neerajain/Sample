

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * The purpose of Server is to accept incoming requests from Clients and to relay messages received from them.
 */
public class Server
{
    public void go() throws IOException {

        Frame frame =new Frame();

    }
}

/**
 * Frame is a runnable and it defines the various components for the JFrame.
 */
class Frame extends JFrame
{
    public Frame() throws IOException
    {
        setBounds(1200, 300, 280, 350);

        setTitle("Admin Chat");

        JPanel jpanel = new ServerPanel();
        
        add(jpanel);

        setVisible(true);

      }   
}


class ServerPanel extends JPanel implements Runnable
    {
        private JTextField messageField;
        private JTextField nameField;
        public JTextArea textArea;
        public Socket clientSocket;
    	public ServerSocket serverSocket;

        ServerPanel() throws IOException
        {
            serverSocket = new ServerSocket(5050);
            JLabel nameLabel = new JLabel("Chat with patient");
            add(nameLabel);

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

    @Override    
    public void run()
    {
        try
        {
        	clientSocket = serverSocket.accept();
            String clientInformation;
            DataInputStream din=new DataInputStream(clientSocket.getInputStream());
         
            while (true)
            {
                clientInformation = din.readUTF();  
                textArea.append("\n" + clientInformation);    
            }
         
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
    }
    class SendTextListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            try
            {

            	DataOutputStream dout=new DataOutputStream(clientSocket.getOutputStream());  
                textArea.append("\nAdmin: " + messageField.getText());
                dout.writeUTF(messageField.getText());  
                messageField.setText("");
                dout.flush();  
            }
            catch (IOException e1)
            {
                System.out.println(e1.getMessage());
            }
        }
    }
}
