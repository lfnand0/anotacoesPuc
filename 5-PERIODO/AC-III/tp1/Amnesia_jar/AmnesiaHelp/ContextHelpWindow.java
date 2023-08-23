package AmnesiaHelp;

import javax.swing.*;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;
import javax.swing.text.Document;
import javax.swing.text.html.HTMLEditorKit;
import javax.swing.text.html.HTMLFrameHyperlinkEvent;
import javax.swing.text.html.StyleSheet;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.net.URL;

/**
 * Created by CarlosEmilio on 02/10/2014.
 */
public class ContextHelpWindow extends JFrame implements ActionListener {
    private final int WIDTH = 600;
    private final int HEIGHT = 400;
    private JEditorPane editorpane;
    private URL helpURL;

    /**
     * Constructor the Help Window
     * @param title present in top page
     * @param helpURL of page present for users
     */
    public ContextHelpWindow(String title, URL helpURL){
        super(title);

        this.helpURL = helpURL;
        editorpane = new JEditorPane();

        editorpane.setEditable(false);

        try {

            // add styles css in pageTable
            addStyles();
            //prepare the content
            editorpane.setPage(helpURL);

            editorpane.addHyperlinkListener(new HyperlinkListener() {
                @Override
                public void hyperlinkUpdate(HyperlinkEvent ev) {
                    try {
                        if (ev.getEventType() == HyperlinkEvent.EventType.ACTIVATED) {
                            editorpane.setPage(ev.getURL());

                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });




            //create scroll window
            getContentPane().add(new JScrollPane(editorpane));
            addButtons();

            setDefaultCloseOperation(DISPOSE_ON_CLOSE);

            calculateLocation();

            setVisible(true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    /**
     * An Action listener so must implement this method
     * @param e capture events in page
     */
    @Override
    public void actionPerformed(ActionEvent e) {

        String strAction = e.getActionCommand();
           URL tempURL;
            try {
                if (strAction == "Contents") {
                    tempURL = editorpane.getPage();
                    editorpane.setPage(helpURL);
            }
            if (strAction == "Close") {
            // more portable if delegated
                    processWindowEvent(new WindowEvent(this,
                        WindowEvent.WINDOW_CLOSING));
            }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    /**
     * buttons present in help window
     *
     */
    private void addButtons() {
            JButton btncontents = new JButton("Contents");
            btncontents.addActionListener(this);
            JButton btnclose = new JButton("Close");
            btnclose.addActionListener(this);
            //put into JPanel
            JPanel panebuttons = new JPanel();
            panebuttons.add(btncontents);
            panebuttons.add(btnclose);
            //add panel south
            getContentPane().add(panebuttons, BorderLayout.SOUTH);
        }

    /**
     * calculate position for put help window
     */
    private void calculateLocation() {
        Dimension screenDim = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(new Dimension(WIDTH, HEIGHT));
        int locationX = (screenDim.width-WIDTH)/2;
        int locationY = (screenDim.height-HEIGHT)/2;
        setLocation(locationX, locationY);
    }

    private void addStyles() {
        HTMLEditorKit kit = new HTMLEditorKit();
        editorpane.setEditorKit(kit);

        StyleSheet styleSheet = kit.getStyleSheet();
        styleSheet.addRule("span{\n" +
                "    color: darkblue;\n" +
                "    font-family: \"Times New Roman\", sans-serif;\n" +
                "    font-size: 40px;");
        styleSheet.addRule("#menu {\n" +
                "\n" +
                "    margin: 10px; padding: 10px;\n" +
                "    float: left;\n" +
                "    position: fixed;\n" +
                "    width: 25%;\n" +
                "    z-index: 999;\n" +
                "    left: 0;\n" +
                "\n" +
                "}");
        styleSheet.addRule("#menu ul li {\n" +
                "    margin: 0; padding: 0;\n" +
                "    border-bottom: 1px solid #CCC;\n" +
                "    text-align: left;\n" +
                "    list-style-type: none;\n" +
                "}");
        styleSheet.addRule("#menu a:link {\n" +
                "    background: #F5F5F5;\n" +
                "    color: #666;\n" +
                "    font-weight: bold;\n" +
                "    text-decoration: none;\n" +
                "    padding: 8px;\n" +
                "    display: block;\n" +
                "}");
        styleSheet.addRule("#menu a:hover {\n" +
                "    background: #E5F0FF;\n" +
                "    color: #039;\n" +
                "}");

        styleSheet.addRule("#content {\n" +
                "    width: 52%;\n" +
                "    float: left;\n" +
                "    text-align: justify;\n" +
                "    margin-left: 25%;\n" +
                "    position: relative;\n" +
                "    left: auto;\n" +
                "}");
        styleSheet.addRule(" #blank_left{\n" +
                "    width: 10%;\n" +
                "    float: left;\n" +
                "    position: relative;\n" +
                "    left: auto;\n" +
                "}");
        styleSheet.addRule("#blank_right {\n" +
                "    width: 10%;\n" +
                "    float: right;\n" +
                "}");
        Document doc = kit.createDefaultDocument();
        editorpane.setDocument(doc);



    }
}
