package events.components;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Owner on 2/24/2018.
 */
public class ArrayJTextFields {

    List <JTextField> arrayJTextFields;
    int numCharactersPerLine;

    public ArrayJTextFields (int numlines, int fontsize, int numCharactersPerLine, int verticalLineSpacing) {

        arrayJTextFields = new ArrayList<JTextField>(numlines);
        this.numCharactersPerLine = numCharactersPerLine;

        for (int i = 0; i < numlines; i++) {
            arrayJTextFields.add(new JTextField(30));
            JTextField jTextField = arrayJTextFields.get(i);
            jTextField.setPreferredSize(new Dimension(1,fontsize + verticalLineSpacing));
            jTextField.setFont(new Font("Arial", Font.BOLD, fontsize));// big font 500 600 700 800
            //jTextField.setText("jTextField:" + i);
            jTextField.setCaretPosition(0);
        }
    }

    public void addArrayJTextFields(Container container) {
        //GridBagConstraints c = new GridBagConstraints();
        container.setPreferredSize(new Dimension(800,800));

//        JTextField jTextField = new JTextField();
//        jTextField.setPreferredSize(new Dimension(800,200));
//        //jTextField.setFont(new Font("Arial", Font.BOLD, 72));// big font 500 600 700 800
//        jTextField.setFont(new Font("Arial", Font.BOLD, 72));// big font 500 600 700 800
//        jTextField.setText("jTextFieldhk");
//        //jTextField.setCaretPosition(0);
//        container.add(jTextField );
//
//        JTextField jTextField2 = new JTextField();
//        jTextField2.setPreferredSize(new Dimension(800,200));
//        //jTextField.setFont(new Font("Arial", Font.BOLD, 72));// big font 500 600 700 800
//        jTextField2.setFont(new Font("Arial", Font.BOLD, 72));// big font 500 600 700 800
//        jTextField2.setText("jTextFieldhk2");
//        //jTextField.setCaretPosition(0);
//        container.add(jTextField2 );
//



        for (int i = 0; i < arrayJTextFields.size(); i++) {
            container.add(arrayJTextFields.get(i));
        }


    }


    public int fillPage(List<String> copyBufList , int iWordIndexToStartWith) {

        int iWordIndexLastShown = iWordIndexToStartWith;
        String delimeter = "   ";

        for (int i = 0; i < arrayJTextFields.size(); i++)
        {
            int numCharsThisLineCum = 0;
            StringBuffer sb = new StringBuffer();
            do
            {

                if (numCharsThisLineCum + copyBufList.get(iWordIndexLastShown).length() > numCharactersPerLine) {
                    break;
                }
                sb.append(copyBufList.get(iWordIndexLastShown) + delimeter);
                numCharsThisLineCum += copyBufList.get(iWordIndexLastShown).length() + delimeter.length();
                iWordIndexLastShown++;
            } while (numCharsThisLineCum < numCharactersPerLine && iWordIndexLastShown < copyBufList.size());
            arrayJTextFields.get(i).setText(sb.toString());
            arrayJTextFields.get(i).setCaretPosition(0);
        }

        return iWordIndexLastShown;
    }

}
