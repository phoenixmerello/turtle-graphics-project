import java.awt.FlowLayout;
import javax.swing.JFrame;
import uk.ac.leedsbeckett.oop.LBUGraphics;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;


//main class extending LBUGraphics to inherit turtle methods and drawing
public class TurtleGraphics extends LBUGraphics {

    //keeps track of all valid user commands for saving and reloading
    private StringBuilder commandHistory = new StringBuilder();

    //flags to track whether image or commands have unsaved changes
    private boolean imageUnsaved = false;
    private boolean commandUnsaved = false;

    //default settings for the pen colour and width
    private Color defaultPencolour = Color.white;
    private int defaultPenWidth = 1;

    //constructor class provided to set up the GUI frame and initialize the turtle
    public TurtleGraphics() {
        JFrame MainFrame = new JFrame();                //create a frame to display the turtle panel on
        MainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Make sure the app exits when closed
        MainFrame.setLayout(new FlowLayout());  //not strictly necessary
        MainFrame.add(this);                                    //"this" is this object that extends turtle graphics so we are adding a turtle graphics panel to the frame
        MainFrame.pack();                                               //set the frame to a size we can see
        MainFrame.setVisible(true);                             //now display it
        //call the LBUGraphics about method to display version information.
        reset();
        drawOn();
    }

    //stores commands unless they are system, saved or load commands
    private void recordCommand(String cmd) {
        String lowerCmd = cmd.trim().toLowerCase();
        if (lowerCmd.startsWith("saveimage") ||
                lowerCmd.startsWith("loadimage") ||
                lowerCmd.startsWith("savecommands") ||
                lowerCmd.startsWith("loadcommands")) {
            return;
        }

        commandHistory.append(cmd).append("\n");
        commandUnsaved = true;
        //the commands that affect drawing will mark the image as unsaved
        if (lowerCmd.matches("^(penup|pendown|left(\\s+.*)?|right(\\s+.*)?|move\\s+.*|reverse\\s+.*|black|green|red|white|reset|clear)$")) {
            imageUnsaved = true;
        }

    }

    //Override the about command to show a message on screen
    @Override
    public void about() {
        super.about();
        displayMessage("Phoenix");
    }

    //draws a square by repeating move 4 times and turns
    private void drawSquare(int length) {
        for (int i = 0; i < 4; i++) {
            forward(length);
            right(90);
        }
    }

    //sets the width of the pen line
    private void setPenWidth(int width) {
        setStroke(width);
    }

    //draws an equilateral triangle
    private void triangleEquilateral (int size) {
        for (int i = 0; i < 3; i++) {
            forward(size);
            right(120);
        }
    }

    //draws an arbitrary triangle based on 3 side lengths using trigonometry
    private void triangleArbitrary(double side1, double side2, double side3) {
        double angleA = Math.toDegrees(Math.acos((side2 * side2 + side3 * side3 - side1 * side1) / (2 * side2 * side3)));
        double angleB = Math.toDegrees(Math.acos((side1 * side1 + side3 * side3 - side2 * side2) / (2 * side1 * side3)));
        double angleC = 180 - angleA - angleB;

        forward((int) side1);
        right((int) (180 - angleA));
        forward((int) side2);
        right((int) (180 - angleB));
        forward((int) side3);
        right((int) (180 - angleC));
    }

    //resets the turtle and pen settings to default
    @Override
    public void reset() {
        super.reset();
        setPenColour(defaultPencolour);
        setStroke(defaultPenWidth);
    }

    //this is the core command parser method
    @Override
    public void processCommand(String command)      //this method must be provided because LBUGraphics will call it when it's JTextField is used
    {
        String trimmedCommand = command.trim();
        String[] tokens = trimmedCommand.split("\\s+");

        if (tokens.length == 0 || tokens[0].isEmpty()) {
            displayMessage("Error: No command entered");
            return;
        }

        String baseCommand = tokens[0].toLowerCase();
        //saves history unless the command is system related
        if (!baseCommand.startsWith("saveimage") &&
            !baseCommand.startsWith("loadimage") &&
            !baseCommand.startsWith("savecommands") &&
            !baseCommand.startsWith("loadcommands")) {

            recordCommand(command);
        }

        try {
            switch (baseCommand) {
                //pen control
                case "penup":
                    drawOff();
                    break;

                case "pendown":
                    drawOn();
                    break;
                //turn commands with degree input
                case "left":
                    if (tokens.length >= 2) {
                        int degrees = Integer.parseInt(tokens[1]);
                        if (degrees < 0) {
                            displayMessage("Error: 'left' parameter must be non-negative");
                        } else {
                            left(tokens[1]);
                        }
                    } else {
                        left(90);
                    }
                    break;

                case "right":
                    if (tokens.length >= 2) {
                        int degrees = Integer.parseInt(tokens[1]);
                        if (degrees < 0) {
                            displayMessage("Error: 'right' parameter must be non-negative");
                        } else {
                            right(tokens[1]);
                        }
                    } else {
                        right(90);
                    }
                    break;
                //forward movement
                case "move":
                    if (tokens.length < 2) {
                        displayMessage("Error: 'move' command requires a distance parameter.");
                    } else {
                        try {
                            int distance = Integer.parseInt(tokens[1]);
                            if (distance < 0) {
                                displayMessage("Error: 'move' parameter must be non-negative.");
                            } else {
                                forward(tokens[1]);
                                recordCommand(command); // Moved here after validation
                            }
                        } catch (NumberFormatException e) {
                            displayMessage("Error: 'move' parameter must be a valid integer.");
                        }
                    }
                    break;
                //reverse -> turn 180 degrees and move forward
                case "reverse":
                    if (tokens.length < 2) {
                        displayMessage("Error: 'reverse' command requires a distance parameter.");
                    } else {
                        try {
                            int revDistance = Integer.parseInt(tokens[1]);
                            if (revDistance < 0) {
                                displayMessage("Error: 'reverse' parameter must be non-negative.");
                            } else {
                                right(180);
                                forward(tokens[1]);
                                right(180);
                                recordCommand(command); // Moved here after validation
                            }
                        } catch (NumberFormatException e) {
                            displayMessage("Error: 'reverse' parameter must be a valid integer.");
                        }
                    }
                    break;
                //pen colour input shortcuts
                case "black":
                    setPenColour(Color.black);
                    break;

                case "green":
                    setPenColour(Color.green);
                    break;

                case "red":
                    setPenColour(Color.red);
                    break;

                case "white":
                    setPenColour(Color.white);
                    break;

                case "blue":
                    setPenColour(Color.blue);
                    break;
                //canvas commands
                case "clear":
                    clear();
                    break;

                case "about":
                    about();
                    break;

                case "reset":
                    reset();
                    break;
                //will save drawing as png
                case "saveimage":
                {
                    JFileChooser saveChooser = new JFileChooser();
                    int returnVal = saveChooser.showSaveDialog(this);
                    if (returnVal == JFileChooser.APPROVE_OPTION) {
                        File savefile = saveChooser.getSelectedFile();
                        try {
                            BufferedImage bufImg = getBufferedImage();
                            ImageIO.write(bufImg, "png", savefile);
                            imageUnsaved = false;
                            displayMessage("image saved successfully");
                        } catch (IOException e) {
                            displayMessage("Error saving image: " + e.getMessage());
                        }
                    }
                    break;
                }

                //load the image from png
                case "loadimage":
                {
                    if (imageUnsaved) {
                        int response = JOptionPane.showConfirmDialog(this,
                                "current image is not saved. save now?",
                                "warning", JOptionPane.YES_NO_OPTION);

                        if (response ==  JOptionPane.YES_OPTION) {
                            processCommand("saveimage");
                        }
                    }

                    JFileChooser openChooser =  new JFileChooser();
                    int openVal = openChooser.showOpenDialog(this);
                    if (openVal == JFileChooser.APPROVE_OPTION) {
                        File openFile = openChooser.getSelectedFile();
                        try {
                            BufferedImage loadImg = ImageIO.read(openFile);
                            setBufferedImage(loadImg);
                            imageUnsaved = false;
                            repaint();
                            displayMessage("image loaded successfully");
                        } catch (IOException e) {
                            displayMessage("Error loading image: " + e.getMessage());
                        }
                    }
                    break;
                }

                //saves all recorded commands to a file
                case "savecommands":
                {
                    JFileChooser cmdSaveChooser =  new JFileChooser();
                    int returnCmd = cmdSaveChooser.showOpenDialog(this);
                    if (returnCmd == JFileChooser.APPROVE_OPTION) {
                        File cmdFile = cmdSaveChooser.getSelectedFile();
                        try (FileWriter fw = new FileWriter(cmdFile)) {
                            fw.write(commandHistory.toString());
                            commandUnsaved = false;
                            displayMessage("Command saved successfully");
                        } catch (IOException e) {
                            displayMessage("Error saving command; " + e.getMessage());
                        }
                    }
                    break;
                }

                //loads and executes commands from file
                case "loadcommands":
                {
                    if (commandUnsaved) {
                        int response = JOptionPane.showConfirmDialog(this,
                                "Current commands have not been saved. Save now?",
                                "Warning", JOptionPane.YES_NO_OPTION);
                        if (response == JOptionPane.YES_OPTION) {
                            processCommand("savecommand");
                        }
                    }

                    JFileChooser cmdOpenChooser = new JFileChooser();
                    int openCmdVal = cmdOpenChooser.showOpenDialog(this);
                    if (openCmdVal == JFileChooser.APPROVE_OPTION) {
                        File cmdFile = cmdOpenChooser.getSelectedFile();
                        try (BufferedReader br = new BufferedReader(new FileReader(cmdFile))) {
                            String line;
                            while ((line = br.readLine()) != null) {
                                // Execute each line as a command.
                                processCommand(line);
                            }
                            displayMessage("Commands loaded and executed.");
                        } catch (IOException e) {
                            displayMessage("Error loading commands: " + e.getMessage());
                        }
                    }
                    break;
                }

                //draws a square from side length
                case "square":
                {
                    if (tokens.length < 2) {
                        displayMessage("Error: 'square' command requires a length parameter");
                    } else {
                        int length = Integer.parseInt(tokens[1]);
                        if (length < 0) {
                            displayMessage("Error: 'square' parameter must be non-negative");
                        } else {
                            drawSquare(length);
                        }
                    }
                    break;
                }

                //sets the pen colour using RGB values
                case "pencolour":
                {
                    if (tokens.length < 2) {
                        displayMessage("Error: 'pencolour' command requires three values separated by commas");
                    } else {
                        String[] rgb = tokens[1].split(",");
                        if (rgb.length != 3) {
                            displayMessage("Error: 'pencolour' requires exactly three comma separated values");
                        } else {

                            int r = Integer.parseInt(rgb[0]);
                            int g = Integer.parseInt(rgb[1]);
                            int b = Integer.parseInt(rgb[2]);
                            if (r < 0 || r > 255 || g < 0 || g > 255 || b < 0 || b > 255) {
                                displayMessage("Error: RGB values must be between 0 and 255.");
                            } else {
                                setPenColour(new Color(r, g, b));
                            }
                        }
                    }
                    break;
                }

                //sets the width of the pen
                case "penwidth":
                {
                    if (tokens.length < 2) {
                        displayMessage("Error: 'penwidth' command requires a width parameter");
                    } else {
                        int width = Integer.parseInt(tokens[1]);
                        if (width <= 0) {
                            displayMessage("Error: 'penwidth' must be a positive whole number");
                        } else {
                            setPenWidth(width);
                        }
                    }
                    break;
                }

                //draws a triangle, either equilateral or with 3 sides
                case "triangle":
                {
                    if (tokens.length < 2) {
                        displayMessage("Error: 'triangle' command requires a parameter");

                    } else if (tokens[1].contains(",")) {
                        String[] sides = tokens[1].split(",");
                        if (sides.length != 3) {
                            displayMessage("Error: 'triangle' with three sides requires three comma separated values");

                        } else {
                            double s1 = Double.parseDouble(sides[0]);
                            double s2 = Double.parseDouble(sides[1]);
                            double s3 = Double.parseDouble(sides[2]);

                            if (s1 <= 0 || s2 <= 0 || s3 <= 0) {
                                displayMessage("Error: Triangle side lengths must be positive");
                            } else {
                                triangleArbitrary(s1, s2, s3);
                            }
                        }

                    } else {
                        int size = Integer.parseInt(tokens[1]);
                        if (size <= 0) {
                            displayMessage("Error: 'triangle' size must be positive");
                        } else {
                            triangleEquilateral(size);
                        }
                    }
                    break;
                }

                //last requirement, shows a help popup menu with all commands
                case "help":
                    String helpMessage = """
                    🐢 Turtle Graphics Help Menu 🐢
                
                    penup                  – Lifts the pen (no drawing)
                    pendown                – Puts the pen down (draws)
                    left [deg]             – Turns left by degrees (default 90)
                    right [deg]            – Turns right by degrees (default 90)
                    move <distance>        – Moves forward
                    reverse <distance>     – Moves backward
                    square <length>        – Draws a square
                    triangle <size>        – Equilateral triangle
                    triangle a,b,c         – Triangle with custom sides
                    pencolour r,g,b        – RGB pen colour (0-255)
                    penwidth <width>       – Pen line thickness
                    red/green/blue/etc     – Quick pen colours
                    reset                  – Clear + reset pen settings
                    clear                  – Just clear drawing
                    saveimage              – Save drawing as image
                    loadimage              – Load saved image
                    savecommands           – Save command history
                    loadcommands           – Run saved commands
                    about                  – Turtle dance + author info
                    help                   – Show this help menu
                    """;

                    JOptionPane.showMessageDialog(null, helpMessage, "Help Menu", JOptionPane.INFORMATION_MESSAGE);
                    break;

                //handles unrecognised commands
                default:
                    displayMessage("Error: Invalid command '" + command + "'");

            }

        } catch(NumberFormatException e){
             displayMessage("Error: Parameter must be an integer");
        }
    }
}
