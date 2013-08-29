ioexp-jni
=========

##JNI wrapper for Digilent I/O Explorer

Digilent's [I/O Explorer](https://www.digilentinc.com/Products/Detail.cfm?NavPath=2,719,834&Prod=IOEXPLORER-USB) is a device that allows access to external input and output devices from a computer. This project attempts to provide the DLL and the JNI wrapper class to access I/O Explorer using Java.


###Prerequisites
*  [Digilent ADEPT System](http://www.digilentinc.com/Products/Detail.cfm?Prod=ADEPT2) 
*  [Digilent ADEPT SDK](http://www.digilentinc.com/Products/Detail.cfm?Prod=ADEPT2) 
*  JDK 6 or 7
*  Visual Studio 2010 (or any other C/C++ IDE)
*  Eclipse (or any other Java IDE)

###Creating JNI header files

A Java class with native method declarations is provided [here](https://github.com/ggc-itec/ioexp-jni/blob/master/DGIO-JNI/src/DGIOUtility.java). Run the following command in the terminal to create the JNI header file.

```
javac DGIOUtility.java
javah DGIOUtility
```

This will create a [header file](https://github.com/ggc-itec/ioexp-jni/blob/master/DGIO-JNI/src/DGIOUtility.h) that will be used to create a **DLL** file using C/C++.


###Creating DLL in Visual Studio
Using the wizard, create a `Win32` project and select `DLL` as its application type. 

Once the header file is generate using `javah`, the next step is to include this header file in your Visual Studio project. 
On the **Solutions Tab**, right click on the **Included Files** folder and add the generated header file as an existing item.

Under **Project Properties**, you should see **VC++ Directories**. Add the **Include** and **Library** directories to the project:

**Include Directories**
* Inlcude folder from your JDK installation 
* win32 folder from  your JDK installation
* The folder that contains the generated header file from `javah`
* Header from from the **Digilent ADEPT SDK**

**Library Directories**
* Library directory from **Digilent ADEPT SDK** 

![Visual Studio Directories](https://raw.github.com/ggc-itec/ioexp-jni/master/images/vs-properties.png)

The implemented cpp file is shown [here](https://github.com/ggc-itec/ioexp-jni/blob/master/DGIO-DLL/DGIO-DLL/DGIOUtility.cpp). Build the solution and the **DLL** will be generated.

###Using the DLL

