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

Once the header file is generated using `javah`, the next step is to include this header file in your Visual Studio project. 
On the **Solutions Tab**, right click on the **Included Files** folder and add the generated header file as an existing item.

You must also include header files located on other directories. Under **Project Properties**, you should see **VC++ Directories**. Go ahead and add the **Include** directories and **Library** directories to the project. 
Specifically, they would be the following:

**Include Directories**
* `include` folder from your JDK installation. In Windows, this looks like the following:  
**C:/Program Files/Java/jdk1.7.0/include/**  
* `win32` folder from  your JDK installation. In Windows, this looks like the following:  
**C:/Program Files/Java/jdk1.7.0/include/win32**
* The folder that contains the generated header file from `javah`
* Header from from the **Digilent ADEPT SDK**

**Library Directories**
* Library directory from **Digilent ADEPT SDK** 

![Visual Studio Directories](https://raw.github.com/ggc-itec/ioexp-jni/master/images/vs-properties.png)

Under the properties page, go to Linker -> Input -> Additional Depedencies, and add the relevant .lib files.

The implemented cpp file is shown [here](https://github.com/ggc-itec/ioexp-jni/blob/master/DGIO-DLL/DGIO-DLL/DGIOUtility.cpp). Build the solution and the **DLL** will be generated.

###Using the DLL
Since the DLL was compiled with Visual Studio 2010, the [Visual Studio 2010 Redistributable package](http://www.microsoft.com/en-us/download/details.aspx?id=5555) needs to be installed. 

You can load the DLL in your Java file in the following ways:

```
// if the DLL file is specified in the path
System.loadLibrary("DGIOUtility")

```
or

```
// for an absolute path 
System.load("C:\\User\\Files\\DGIOUtility.dll");

```

