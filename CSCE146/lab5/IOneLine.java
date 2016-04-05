import java.util.Scanner;
/*********************************************************************
 * Interface for the class to handle one line of itemset data.
 *
 * Copyright (C) 2012 by Duncan A. Buell.  All rights reserved.
 *
 * @author Duncan A. Buell
 * @version 1.00 2012-01-03
**/
public interface IOneLine
{
/*********************************************************************
 * Instance variables for the class.
**/
//  private static final String DUMMYSTRING = "dummy";
//  private static final int DUMMYINT = Integer.MIN_VALUE;
//  private static final int COMPARECOUNT = 4;

//  private int[] n; // item numbers

//  private String restOfLine; // the rest of the line

/*********************************************************************
 * Accessors.
**/
/*********************************************************************
 * Accessor for an item number
 *
 * @param which the subscript whose value to return
 *
 * @return the value
**/
  public int getItemNumber(int which);

/*********************************************************************
 * Accessor for the <code>restOfLine</code>.
 *
 * @return the value of <code>restOfLine</code>.
**/
  public String getTheRest();

/*********************************************************************
 * General methods.
**/
/*********************************************************************
 * Standard comparison method.
 * This compares the itemset values.
 *
 * @return -1, 0, or 1 according as the comparison goes.
**/
  public int compareTo(OneLine that);

/*********************************************************************
 * Method to read the <code>OneLine</code> from an input
 * <code>Scanner</code> file. Note that this is more or less hard
 * coded. Also that we don't bulletproof the input; among other
 * things we assume that partial records don't appear in the input.
 *
 * @param the <code>Scanner</code> from which to read.
 *
 * @return the <code>OneLine</code> item that has been read.
**/
  public OneLine readLine(Scanner inFile);

/*********************************************************************
 * Method to convert a record to a <code>String</code>.
 *
 * @return the formatted <code>String</code> value of the record.
**/
  public String toString();

} // public interface IOneLine
