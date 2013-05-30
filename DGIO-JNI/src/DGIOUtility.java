
public class DGIOUtility {

	public native void print();	
	public native void openDevice();
	public native void closeDevice();
	public native void printPortCount();
	public native void printPortProperties();
	public native void enablePort(int portNum);
	public native void turnOnLEDs();
	public native void turnOffLEDs();
	public native void echoSwitchToLED();
	
	static {
		System.loadLibrary("DGIOUtility");
	}
	
	public static void main(String[] args) throws InterruptedException {		
		DGIOUtility utility = new DGIOUtility();
		utility.print();	
		utility.openDevice();
		utility.printPortCount();
		utility.printPortProperties();
		utility.enablePort(0);
		while(true)
		{
			utility.echoSwitchToLED();
			Thread.sleep(2000);
			
			/** Turn on all the LEDs then turn it off after 2 seconds
			utility.turnOnLEDs();
			Thread.sleep(2000);
			utility.turnOffLEDs();
			Thread.sleep(2000);
			**/
		}
	}
	
	
}
