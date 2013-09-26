
public class DPIOUtility {

	public native void print();	
	public native void openDevice();
	public native void closeDevice();
	public native void printPortCount();
	public native void printPortProperties();
	public native void enablePort(int portNum);
	public native void dpioEnableEx();
	public native void dpioGetPinMask();
	public native void dpioDisable();
	public native void dpioSetPinDirection();
	public native void dpioSetPinState();
	public native void dpioGetPinState();

	
	static {
		System.loadLibrary("DPIOUtility");
	}
	
	public static void main(String[] args) throws InterruptedException {		
		DPIOUtility utility = new DPIOUtility();
		utility.print();	
		//utility.openDevice();
		//utility.printPortCount();
		//utility.printPortProperties();
		//utility.enablePort(0);
		//while(true)
		//{
			
		//}
		//utility.closeDevice();
	}
	
	
}
