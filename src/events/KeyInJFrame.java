package events;
// run this for christine reader

// /Users/hkon/utd/170729grails/180112JavaSwingMomReader/src/events/KeyInJFrame.java
// /Users/hkon/utd/170729grails/180112JavaSwingMomReader

import events.clipboard.HKClipboard;
import events.components.ArrayJTextFields;

import java.awt.*;
import java.awt.datatransfer.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Properties;
import javax.swing.*;


//https://www.excelsior-usa.com/articles/java-to-exe.html

public class KeyInJFrame extends JFrame
        implements KeyListener,
        ClipboardOwner
{

    private static ArrayJTextFields arrayJTextFields;
    private static int iWordIndexLastShown = -1;
    private static JLabel jLabel;
    static final String newline = ";"; // System.getProperty("line.separator");
    static int indexWordShown = 0;
    static java.util.List<String> copyBufList = null;

    public void lostOwnership(Clipboard clipboard, Transferable contents){}
    ;

    public static Properties appProps = AppProps.getProperties(0);

    public static void main(String[] args) {
        System.out.print("appProps.size()appProps.size():" + appProps.size());
        /* Use an appropriate Look and Feel */
        try {
            //UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
            //UIManager.setLookAndFeel("com.sun.java.swing.plaf.gtk.GTKLookAndFeel");
            UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
        } catch (UnsupportedLookAndFeelException ex) {
            ex.printStackTrace();
        } catch (IllegalAccessException ex) {
            ex.printStackTrace();
        } catch (InstantiationException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        /* Turn off metal's use of bold fonts */
        UIManager.put("swing.boldMetal", Boolean.FALSE);

        //Schedule a job for event dispatch thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });

        // DUP HBK

    }

    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event-dispatching thread.
     */
    private static void createAndShowGUI() {
        //Create and set up the window.
        KeyInJFrame frame = new KeyInJFrame();

        frame.setPreferredSize(new Dimension(1600,1000));
        frame.setLayout(new FlowLayout(FlowLayout.LEFT));

        arrayJTextFields = new ArrayJTextFields(
                AppProps.getNumLines(),
                AppProps.getFontSize(),
                AppProps.getNumCharactersPerLine(),
                AppProps.getNumCharactersPerLine()
        );
        arrayJTextFields.addArrayJTextFields ( frame.getContentPane() );

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.addWindowStateListener(new WindowStateListener() {
            @Override
            public void windowStateChanged(WindowEvent e) {
                //JOptionPane.showMessageDialog(frame.getContentPane(),
                //"Eggs are not supposed to be green.");
                // TODO Auto-generated method stub
                if((e.getNewState() & Frame.ICONIFIED) == Frame.ICONIFIED){

                }
                else if ((e.getNewState() & Frame.MAXIMIZED_BOTH) == Frame.MAXIMIZED_BOTH){
                    System.out.println("Maximized");

                    //scaleButtons();
                    //maximized = true;
                }
                else{
                    //maximized = false;
                }
            }
        });


        // MAIN FOCUS HANDLER
        // MAIN FOCUS HANDLER
        // MAIN FOCUS HANDLER
        // MAIN FOCUS HANDLER
        // MAIN FOCUS HANDLER
        // MAIN FOCUS HANDLER
        // MAIN FOCUS HANDLER
        // MAIN FOCUS HANDLER
        // MAIN FOCUS HANDLER
        frame.addWindowFocusListener(new WindowFocusListener() {
            @Override
            public void windowGainedFocus(WindowEvent e) {
                indexWordShown = 0;
                copyBufList = new ArrayList( Arrays.asList( HKClipboard.getClipboardContents().trim().split(" ")));


                iWordIndexLastShown = arrayJTextFields.fillPage(copyBufList, iWordIndexLastShown+1);

                // BIG UPPER PART

                // SMALL LOWER PART
                //jLabel.setText("zzjlabel:" + HKClipboard.class(). trim());



                // TODO Auto-generated method stub
                if((e.getNewState() & Frame.ICONIFIED) == Frame.ICONIFIED){

                }
                else if ((e.getNewState() & Frame.MAXIMIZED_BOTH) == Frame.MAXIMIZED_BOTH){
                    System.out.println("Maximized");

                    //scaleButtons();
                    //maximized = true;
                }
                else{
                    //maximized = false;
                }
            }
            @Override
            public void windowLostFocus(WindowEvent e) {

                //   JOptionPane.showMessageDialog(myself,
                //         "Eggs are not supposed to be green2.");
                // TODO Auto-generated method stub
                System.out.print("LOSTFOCUS");
                if((e.getNewState() & Frame.ICONIFIED) == Frame.ICONIFIED){

                }
                else if ((e.getNewState() & Frame.MAXIMIZED_BOTH) == Frame.MAXIMIZED_BOTH){
                    System.out.println("Maximized");

                    //scaleButtons();
                    //maximized = true;
                }
                else{
                    //maximized = false;
                }
            }
        });


        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }

//    private void addComponentsToPane() {
//
//
//        JButton button = new JButton("Font Bigger");
//        button.addActionListener(getComponentPane());
//
//
//        int sz1 = Integer.parseInt((appProps.get("fontsize")).toString());
//        System.out.print("fontsize:" + appProps.get("fontsize"));
//        float sz = 200;
//
//        jTextField.addKeyListener(this);
//
//        jLabel = new JLabel();
//        jLabel.setText("jLabelaaaa");
//        jLabel.setFont(new Font("Courier New", Font.ITALIC, 50));
//
//        Font font2 = jLabel.getFont();
//        font2 = font2.deriveFont(
//                Collections.singletonMap(
//                        TextAttribute.WEIGHT, TextAttribute.WEIGHT_EXTRABOLD));
//        jLabel.setFont(font2);
//
//
//        jTextArea = new JTextArea();
//        jTextArea.setEditable(false);
//        jTextArea.setText("hi mom!");
//        jTextArea.setFont(new Font("Arial", Font.BOLD, 200));
//        JScrollPane scrollPane = new JScrollPane(jTextArea);
//        scrollPane.setPreferredSize(new Dimension(1200, 400));
//
//        //getContentPane().add(new JScrollPane(jTextField), BorderLayout.PAGE_START);
//        // 1111111111111111
//        JScrollPane scrollPanehkLabel = new JScrollPane(jLabel);
//        // 2222222222222222
//        getContentPane().add(scrollPanehkLabel, BorderLayout.CENTER);
//        //getContentPane().add(scrollPane, BorderLayout.CENTER);
//
//
//        // 4444444444444
//        getContentPane().add(button, BorderLayout.EAST);
//    }




    /** Handle the key typed event from the text field. */
    public void keyTyped(KeyEvent e) {
//aaa
        displayInfo(e, "KEY TYPED: ");
        //System.out.print("asdasdasd");
    }

    /** Handle the key pressed event from the text field. */
    public void keyPressed(KeyEvent e) {
//        displayInfo(e, "KEY PRESSED: ");
//        if (e.getKeyCode() == 38) {
//            // up arrow
//            //            JOptionPane.showMessageDialog(this,
//            //                    "down arrow");
//            indexWordShown = java.lang.Math.max(0, indexWordShown-1);
//            jTextField.setText(copyBufList.get(indexWordShown));
//            jTextField.setCaretPosition(0);
//        }
//        else if (e.getKeyCode() == 40) {
//            // down arrow
//            //            JOptionPane.showMessageDialog(this,
//            //                    "down arrow");
//            indexWordShown = java.lang.Math.min(copyBufList.size()-1, indexWordShown+1);
//            jTextField.setText(copyBufList.get(indexWordShown));
//            jTextField.setCaretPosition(0);
//        }
//
//

        //System.out.print("asdasdasd");
        // JOptionPane.showMessageDialog(this,
        //       "Eggs are not supposed to be green.");

        //displayInfo(e, "KEY PRESSED: ");
    }

    /** Handle the key released event from the text field. */
    public void keyReleased(KeyEvent e) {

        //  JOptionPane.showMessageDialog(this,
        //        "Eggs are not supposed to be green.");
        //displayInfo(e, "KEY RELEASED: ");
    }

    /*
     * We have to jump through some hoops to avoid
     * trying to print non-printing characters
     * such as Shift.  (Not only do they not print,
     * but if you put them in a String, the characters
     * afterward won't show up in the text area.)
     */
    private void displayInfo(KeyEvent e, String keyStatus){

        //You should only rely on the key char if the event
        //is a key typed event.
        int id = e.getID();
        String keyString;
        if (id == KeyEvent.KEY_TYPED) {
            char c = e.getKeyChar();
            keyString = "key character = '" + c + "'";
        } else {
            int keyCode = e.getKeyCode();
            keyString = "key code = " + keyCode
                    + " ("
                    + KeyEvent.getKeyText(keyCode)
                    + ")";
        }

        int modifiersEx = e.getModifiersEx();
        String modString = "extended modifiers = " + modifiersEx;
        String tmpString = KeyEvent.getModifiersExText(modifiersEx);
        if (tmpString.length() > 0) {
            modString += " (" + tmpString + ")";
        } else {
            modString += " (no extended modifiers)";
        }

        String actionString = "action key? ";
        if (e.isActionKey()) {
            actionString += "YES";
        } else {
            actionString += "NO";
        }

        String locationString = "";
        int location = e.getKeyLocation();
        if (location == KeyEvent.KEY_LOCATION_STANDARD) {
            locationString += "standard";
        } else if (location == KeyEvent.KEY_LOCATION_LEFT) {
            locationString += "left";
        } else if (location == KeyEvent.KEY_LOCATION_RIGHT) {
            locationString += "right";
        } else if (location == KeyEvent.KEY_LOCATION_NUMPAD) {
            locationString += "numpad";
        } else { // (location == KeyEvent.KEY_LOCATION_UNKNOWN)
            locationString += "unknown";
        }


        System.out.println(keyStatus + newline
                + "    " + keyString + newline
                + "    " + modString + newline
                + "    " + actionString + newline
                + "    " + locationString + newline);
    }





}
