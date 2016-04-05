import java.io.PrintWriter;
import java.util.Scanner;
/*********************************************************************
 * Lab 5: Insertion sort and breakpoint processing.
 * This code is structured so the data is read one line at a time
 * and the new line is inserted into the proper order on the fly.
 *
 * Copyright (C) 2012 by Duncan A. Buell.  All rights reserved.
 *
 * @author Duncan A. Buell
 * @version 1.00 2012-01-03
**/
public class Driver
{
/*********************************************************************
 * main method.
**/
  public static void main (String[] args)
  {
    final String TAG = "Main: ";
    Scanner inFile = null;
    PrintWriter outFile = null;
    Itemset myList = null;

    inFile = FileUtils.ScannerOpen("zin1");
    outFile = FileUtils.PrintWriterOpen("zout");

    System.out.printf("%s begin execution%n", TAG);

    myList = new Itemset();
    myList.doTheWork(inFile, outFile);

    FileUtils.CloseFile(inFile);
    FileUtils.CloseFile(outFile);

    System.out.printf("%s end execution%n", TAG);
  }
} // public class Driver

