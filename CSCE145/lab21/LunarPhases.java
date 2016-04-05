import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * LunarPhases.java
 * Program to display the different lunar phases
 * from Sun Microsystem's "The Java Tutorial"
 *
 * @lastAuthor Prof. Michael N. Huhns
 * @version November 9, 2011
 */

public class LunarPhases extends JFrame implements ActionListener {
    // Constants and instance variables
    private final static int NUM_IMAGES = 8;
    private final static int START_INDEX = 3;
    private final static String IMAGES_DIR = "images";

    private ImageIcon[] images = new ImageIcon[NUM_IMAGES];
    private JPanel mainPanel, selectPanel, displayPanel;

    private JComboBox phaseChoices = null;
    private JLabel phaseIconLabel = null;

    /**
     * Constructor that sets up the entire application and displays the GUI
     */
    public LunarPhases() {
    	super();
    	
    	// Setup the GUI
    	initialize();
    	// Define the main container
    	setTitle("Lunar Phases");
    	setContentPane(mainPanel);
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	// Display the GUI
    	pack();
    	setVisible(true);
    }

    /**
     * Initializes and organizes the various GUI components   
     */
    private void initialize() {

	// Create the phase selection and display panels.
	selectPanel = new JPanel();
	displayPanel = new JPanel();
	// Add various widgets to the sub panels.
	addWidgets();
	// Create the main panel to contain the two sub panels.
	mainPanel = new JPanel();
	mainPanel.setLayout(new GridLayout(2,1,5,5));
	mainPanel.setBorder(BorderFactory.createEmptyBorder(8,8,8,8));
	// Add the select and display panels to the main panel.
	mainPanel.add(selectPanel);
	mainPanel.add(displayPanel);
    }
    
    /**
     * Creates and adds the widgets to select and display the phases of the moon
     */
    private void addWidgets() {

	// Get the images and put them into an array of ImageIcon.
	for(int i = 0; i < NUM_IMAGES; i++)
	{
		String imageName = IMAGES_DIR + "/image" + i +".jpg";
		System.out.println("get image: " + imageName);
		images[i] = new ImageIcon(imageName);
	}
	
		// Create label for displaying moon phase images and put a border around it.
		phaseIconLabel = new JLabel();
		phaseIconLabel.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLoweredBevelBorder(), BorderFactory.createEmptyBorder(5,5,5,5)));
		// Display the first image.
		phaseIconLabel.setIcon(images[START_INDEX]);

	
		// Create combo box with lunar phase choices.
//    	phaseChoices = new JComboBox();
		String [] phases = {"New", "Waxing Cresent", "First Quarter", "Waxing Gibbous", "Full", "Waning Gibbous", "Third", "Waning Crescent"};
		phaseChoices = new JComboBox(phases);
		phaseChoices.setSelectedIndex(START_INDEX);
    	// Listen to events from combo box.
		phaseChoices.addActionListener(this);
	
    	// Add moon phases combo box to select panel and image label to displayPanel.
		selectPanel.add(phaseChoices);
//		displayPanel.add(phaseChoices);
//		selectPanel.setBorder(BorderFactory.createEmptyBorder(8,8,8,8));
		selectPanel.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
		displayPanel.setBorder(BorderFactory.createBevelBorder(1));
    	// Add border around the select panel.
		selectPanel.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createTitledBorder("Select Phase"), BorderFactory.createEmptyBorder(5,5,5,5)));
	
    	// Add border around the display panel.
		displayPanel.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createTitledBorder("Display Phase"), BorderFactory.createEmptyBorder(5,5,5,5)));
    	displayPanel.add(phaseIconLabel);
    }
    
    /**
     * Implements the listener interface
     */
    public void actionPerformed(ActionEvent event) {
	// Update the icon to display the new phase each time the combo box fires an event.
    	if("comboBoxChanged".equals(event.getActionCommand()))
    	{
    		phaseIconLabel.setIcon(images[phaseChoices.getSelectedIndex()]);
    	}
    }

    /**
     * Starts the application
     */
    public static void main(String[] args) {
    	// create a new instance of LunarPhases
	LunarPhases phases = new LunarPhases();
    }
} // LunarPhases
