package sgalib;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

/**
 * This class can be used to create ready to use list selector component on any swing frame/panel etc.
 * The main method describes the use of this component.
 * @author : Niraj Agarwal
 * @version : 1.0
 * @jdk version tested on : jdk 1.4
 */
public class JListSelector extends JPanel implements ActionListener
{
    private JList listFrom = new JList();
    private JList listTo = new JList();
    private JButton btnAddSel = new JButton(">");;
    private JButton btnRemoveSel = new JButton("<");
    private JButton btnAddAll = new JButton(">>");;
    private JButton btnRemoveAll = new JButton("<<");;

    private static final int minWidth = 100;
    private static final int minHeight = 95;

    private DefaultListModel modelTo = new DefaultListModel();
    private DefaultListModel modelFrom = new DefaultListModel();

    private int width;
    private int height;

    /**
     * This is the only constructor for this class. It has 2 parameters
     * @param width : This is the width of each List (From and To), the actual width of this component will be
     *                [ (passed width * 2) + width ] for buttons. So it is advisable to use method getWidth() to  
     *                determine the toal width of this component. If passed width is less than 100 it takes it as 100.
     * @param height : This is the height of each list (From and To). The total height of the component will be same as 
     *                 passed height in all cases except passed height is less than 95, in that case the actual height of 
     *                 ths component will be 95.
     */
    public JListSelector(int width, int height)
    {
        setLayout(null);

        if( width < minWidth )
            width = minWidth;

        if( height < minHeight )
            height = minHeight;

        this.height = height;
        this.width = (2 * width) + 70;

        listFrom = new JList(modelFrom);
        JScrollPane spFrom = new JScrollPane(listFrom);
        spFrom.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        spFrom.setBounds(0,0,width,height);

        int btnY = (height - 95) / 2;

        btnAddAll.setBounds(width+10,btnY,50,20);
        btnAddSel.setBounds(width+10,btnY+25,50,20);
        btnRemoveSel.setBounds(width+10,btnY+50,50,20);
        btnRemoveAll.setBounds(width+10,btnY+75,50,20);

        listTo = new JList(modelTo);
        JScrollPane spTo = new JScrollPane(listTo);
        spTo.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        spTo.setBounds(width+70,0,width,height);

        add(spFrom);
        add(btnAddAll);
        add(btnAddSel);
        add(btnRemoveSel);
        add(btnRemoveAll);
        add(spTo);

        btnAddAll.addActionListener(this);
        btnAddSel.addActionListener(this);
        btnRemoveSel.addActionListener(this);
        btnRemoveAll.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e)
    {
        Object source = e.getSource();
        if( source == btnAddAll )
            doActionForAddAll();
        else if( source == btnAddSel )
            doActionForAddSel();
        else if( source == btnRemoveSel )
            doActionForRemoveSel();
        else if( source == btnRemoveAll )
            doActionForRemoveAll();
    }

    private void doActionForAddAll()
    {
        Object objFrom;
        int iSize = modelFrom.getSize();
        int iStart = modelTo.getSize();

        for( int i=0; i<iSize; i++ )
        {
            objFrom = modelFrom.getElementAt(0);
            if( !modelTo.contains(objFrom) )
                modelTo.addElement(objFrom);

            modelFrom.removeElementAt(0);
        }

        listFrom.clearSelection();
        if( iSize != 0 )
            listTo.setSelectionInterval(iStart, iStart+iSize-1);
    }

    private void doActionForAddSel()
    {
        Object[] objFrom = listFrom.getSelectedValues();

        int iSize = objFrom.length;
        int iStart = modelTo.getSize();
        for( int i=0; i<iSize; i++ )
        {
            if( !modelTo.contains(objFrom[i]) )
                modelTo.addElement(objFrom[i]);

            modelFrom.removeElement(objFrom[i]);
        }

        listFrom.clearSelection();
        if( iSize != 0 )
            listTo.setSelectionInterval(iStart, iStart+iSize-1);
    }

    private void doActionForRemoveSel()
    {
        Object[] objTo = listTo.getSelectedValues();

        int iSize = objTo.length;
        int iStart = modelFrom.getSize();
        for( int i=0; i<iSize; i++ )
        {
            if( !modelFrom.contains(objTo[i]) )
                modelFrom.addElement(objTo[i]);

            modelTo.removeElement(objTo[i]);
        }

        listTo.clearSelection();
        if( iSize != 0 )
            listFrom.setSelectionInterval(iStart, iStart+iSize-1);
    }

    private void doActionForRemoveAll()
    {
        Object objTo;
        int iSize = modelTo.size();
        int iStart = modelFrom.getSize();

        for( int i=0; i<iSize; i++ )
        {
            objTo = modelTo.getElementAt(0);
            if( !modelFrom.contains(objTo) )
                modelFrom.addElement(objTo);

            modelTo.removeElementAt(0);
        }

        listTo.clearSelection();
        if( iSize != 0 )
            listFrom.setSelectionInterval(iStart, iStart+iSize-1);
    }

    public void setListFont(Font font)
    {
        listTo.setFont(font);
        btnAddAll.setFont(font);
        btnAddSel.setFont(font);
        btnRemoveSel.setFont(font);
        btnRemoveAll.setFont(font);
        listFrom.setFont(font);
    }

    public int getWidth()
    {
        return width;
    }

    public int getHeight()
    {
        return height;
    }

    public DefaultListModel getToModel()
    {
        return modelTo;
    }

    public DefaultListModel getFromModel()
    {
        return modelFrom;
    }

    public void setEnabled(boolean editable)
    {
        listTo.setEnabled(editable);
        btnAddAll.setEnabled(editable);
        btnAddSel.setEnabled(editable);
        btnRemoveSel.setEnabled(editable);
        btnRemoveAll.setEnabled(editable);
        listFrom.setEnabled(editable);
    }

    public void requestFocus(DefaultListModel model)
    {
        if( model == modelTo )
            listTo.requestFocus();
        else if( model == modelFrom )
            listFrom.requestFocus();
    }

    public static void main(String args[])
    {
        // Width of each list (From and To) will be 180 and height will be 130
        JListSelector listSelector = new JListSelector(180, 130);
        int width = listSelector.getWidth();        // Actual total width of the component
        int height = listSelector.getHeight();      // Actual total height of the component

        JDialog jframe = new JDialog(new JFrame(), "JListSelector - Select Colors", true);
        jframe.getContentPane().setLayout(null);
        jframe.setSize(width+25, height+45);

        JPanel panel = new JPanel(null);
        panel.setBorder(BorderFactory.createEtchedBorder());
        panel.setBounds(0,0,width+25,height+45);
        listSelector.setBounds(10,10,width, height);

        panel.add(listSelector);
        jframe.getContentPane().add(panel);

        // Add list of items to FromList
        DefaultListModel fromModel = listSelector.getFromModel();
        fromModel.addElement("Red");
        fromModel.addElement("Blue");
        fromModel.addElement("Green");
        fromModel.addElement("White");
        fromModel.addElement("Black");

        jframe.setVisible(true);

        // Get the list of items from ToList
        DefaultListModel toModel = listSelector.getToModel();
        int iSize = toModel.getSize();
        System.out.println("Selected items:");
        for(int i=0; i<iSize; i++)
            System.out.println("\t"+toModel.get(i));
    }
}


