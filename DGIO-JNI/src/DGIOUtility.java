
public class DGIOUtility {

	public static native void print();	
	public static native void openDevice();
	public static native void closeDevice();
	public static native void printPortCount();
	public static native void printPortProperties();
	public static native void turnOnLEDs();
	public static native void turnOffLEDs();
	
	static {
		System.loadLibrary("DGIOUtility");
	}
	
	public static void main(String[] args) {
		
		print();	
		openDevice();
		printPortCount();
		printPortProperties();
		turnOnLEDs();
	}
	
	
}
