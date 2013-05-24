package siet.lcis;

public class SendMessage extends Action {
	
	protected String mMessage = "";
	protected String mReceiverServiceID = "";
	protected VAssistant mVAssistant = null;

	SendMessage(VAssistant pVAssistant, String pReceiverServiceID, String pMessage)
	{
		mVAssistant = pVAssistant;
		mReceiverServiceID = pReceiverServiceID;
		mMessage = pMessage;
	}

	public void execute()
	{
		System.out.println("Send Message execute");
		mVAssistant.getCommTask(mReceiverServiceID).writeToStream(mMessage);
	}
}