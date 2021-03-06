package siet.lcis;

import java.net.*;
import java.io.*;

/**
 * 
 * Class responsible for listening on the agent port and a launching
 * {@link CommHandlerTask} for each active connection.
 *
 */
public class CommHandler extends Thread {

	private ServerSocket mSocket;
	private VAssistant mVirtualAssistant;
    
    public CommHandler(VAssistant virtualAssistant)
    {
    	mSocket = null;
    	mVirtualAssistant = virtualAssistant;
    	
    	try {
    		mSocket = new ServerSocket(7920);
        } catch (IOException e) {
            System.err.println("Could not listen on port: 7920.");
            e.printStackTrace();
            System.exit(-1);
        }
    }
    
    public void run()
    {
    	do
    	{
			try 
			{
				CommHandlerTask vAssistantCommTask = new CommHandlerTask(mSocket.accept());
				System.err.println("new comm handler task created.");
				vAssistantCommTask.setAssistant(mVirtualAssistant);
				vAssistantCommTask.start();
			}
			catch (IOException e)
			{
				System.err.println("Error while accepting connection.");
				e.printStackTrace();
			}
    		 
    	} while (true);
    }
}
