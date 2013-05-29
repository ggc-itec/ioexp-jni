#include<jni.h>
#include<stdio.h>
#include<windows.h>
#include "dpcdecl.h"
#include "dmgr.h"
#include "dgio.h"

#include "DGIOUtility.h"

unsigned long hif;
unsigned long dprp;
int cprt;

JNIEXPORT void JNICALL Java_DGIOUtility_print(JNIEnv *env, jobject obj)
{
	printf("hello world");
	return;
}
JNIEXPORT void JNICALL Java_DGIOUtility_openDevice (JNIEnv *env, jobject obj)
{

	char szDUT[] = "ioexp";

	if (!DmgrOpen(&hif, szDUT)) {
		printf("Unable to open device: %s\n", szDUT);
	}	
	else
	{
		printf("Success! Opened device: %s\n",szDUT);
	}	
	return;
}

JNIEXPORT void JNICALL Java_DGIOUtility_printPortCount(JNIEnv *env, jobject obj)
{
	// DGIO API Call: DgioGetPortCount
	if (DgioGetPortCount(hif, &cprt)) {
		printf("  DGIO port count: %d\n", cprt);
	}
	else {
		printf("DgioGetPortCount failed\n");
	}
	return;
}

JNIEXPORT void JNICALL Java_DGIOUtility_printPortProperties(JNIEnv *env, jobject obj)
{
	int prt;
	/* For each port, get and report the port properties. */
	for (prt = 0; prt < cprt; prt++) {
		// DGIO API Call: DgioGetPortProperties
		DgioGetPortProperties(hif, prt, &dprp);
		printf("  Port %d\n", prt);
		printf("    Properties: %8.8X\n", dprp);
	}
}

JNIEXPORT void JNICALL Java_DGIOUtility_turnOnLEDs(JNIEnv *env, jobject obj)
{
	unsigned long dwLed = 1;
	int prt = 0;

	/* Enable port with the LEDs, switches, buttons, etc. */
	
	// DGIO API Call: DgioEnableEx
	if (DgioEnableEx(hif, prt)) {
		printf("  DGIO port %d enabled\n", prt);
	}
	else {
		printf("  Unable to enable DGIO port %d\n", prt);
	}

	dwLed = 65535;
	if (!DgioPutData(hif, 0, 0, &dwLed, 4, fFalse)) {
			printf("  DgioPutData to LEDs failed\n");
	}
	/*
	for (ival = 0; ival < 16; ival++) {		
		// DGIO API Call: DgioPutData
		if (!DgioPutData(hif, 0, 0, &dwLed, 4, fFalse)) {
			printf("  DgioPutData to LEDs failed\n");
		}
		dwLed = dwLed << 1;
	}
	*/
}


JNIEXPORT void JNICALL Java_DGIOUtility_turnOffLEDs(JNIEnv *env, jobject obj)
{

}
