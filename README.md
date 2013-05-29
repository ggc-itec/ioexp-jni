ioexp-jni
=========

##JNI wrapper for Digilent I/O Explorer

Digilent's [I/O Explorer](https://www.digilentinc.com/Products/Detail.cfm?NavPath=2,719,834&Prod=IOEXPLORER-USB) is a device that allows access to external input and output devices from a computer. This project attempts to provide the DLL and the JNI wrapper class to access I/O Explorer using Java.

###Prerequisites
*  [Digilent ADEPT SDK](http://www.digilentinc.com/Products/Detail.cfm?Prod=ADEPT2) 
*  Visual Studio 2010 (or any other C/C++ IDE)
*  Eclipse (or any other Java IDE)

###Creating JNI header files

A Java class with native method declarations is provided [here](https://github.com/ggc-itec/ioexp-jni/blob/master/DGIO-JNI/src/DGIOUtility.java). Run the following command in the terminal to create the JNI header file.

```
javac DGIOUtility.java
javah DGIOUtility
```

This will create a [header file]() that can be used to create a **DLL** file using C/C++.

###Creating DLL in Visual Studio



![Visual Studio Directories](https://raw.github.com/ggc-itec/ioexp-jni/master/images/vs-properties.png)

