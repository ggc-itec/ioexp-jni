public class JNITest {


	public native void printHello();
	public native void printGoodbye();
	public native void openDevice();
	public native void closeDevice();
	public native void printPortCount();
	public native void printPortProperties();
	public native void enablePort(int portNum);
	public native void readFromPortOne();
	public native void dpioEnableEx();
	public native void dpioGetPinMask();
	public native void dpioDisable();
	public native void dpioSetPinDirection();
	public native void dpioSetPinState();
	public native void dpioGetPinState();

	static {

		System.loadLibrary("JNITest");

	}

	public static void main(String[] args) throws InterruptedException {
	
		JNITest test = new JNITest();
		test.printHello();
		test.printGoodbye();
		test.openDevice();
		test.printPortCount();
		test.printPortProperties();
		
		test.enablePort(0);
		
		for(;;) {
		test.readFromPortOne();
		Thread.sleep(10);
		}
		//test.closeDevice();	

	}

}