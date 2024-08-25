package main;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class TextEditor<main> {
	
	public int SMS;
	public int font;
	public boolean darkMode = false;
	Color backGrnd;
	
	
	public static void main(String[] args) {
		
		 TextEditor editor = new TextEditor();
		
		
		int systemMenuSize = 20;
		editor.backGrnd = new Color(255,255,255);
		
		// Create the frame
        JFrame frame = new JFrame("Text Editor");
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        ImageIcon frameIcon = new ImageIcon("res/art/JavaWrite.png");
        frame.setIconImage(frameIcon.getImage());
        frame.getContentPane().setBackground(editor.backGrnd);
        frame.setFocusable(true);
        
        // Create the text area
        JTextArea textArea = new JTextArea();
        textArea.setFont(new Font("SansSerif", Font.PLAIN, 30));
        JScrollPane scrollPane = new JScrollPane(textArea);
        frame.add(scrollPane, BorderLayout.CENTER);
        textArea.setBackground(editor.backGrnd);
        textArea.setForeground(Color.black);

        //menu bar
        JMenuBar menuBar = new JMenuBar();
        menuBar.setBackground(editor.backGrnd);
        
        //file menu  !!!!!!!!
        //!!!!!!!!!!!!!!!!!!!
        //!!!!!!!!!!!!!!!!!!!
        //!!!!!!!!!!!!!!!!!!!
        JMenu fileMenu = new JMenu("File |");
        setSystemFont(systemMenuSize, fileMenu);

        // Create menu items
        JMenuItem openItem = new JMenuItem("Open");
        setSystemFont(systemMenuSize, openItem);
        JMenuItem saveItem = new JMenuItem("Save");
        setSystemFont(systemMenuSize, saveItem);
        JMenuItem exitItem = new JMenuItem("Exit");
        setSystemFont(systemMenuSize, exitItem);
        
        fileMenu.add(openItem);
        fileMenu.add(saveItem);
        fileMenu.add(exitItem);

        // Add action listeners to the menu items
        openItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                int result = fileChooser.showOpenDialog(frame);
                
                editor.setSystemSelectFont(fileChooser);
                
                
                if (result == JFileChooser.APPROVE_OPTION) {
                    File file = fileChooser.getSelectedFile();
                    try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                        textArea.read(reader, null);
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });

        saveItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                int result = fileChooser.showSaveDialog(frame);
                
                editor.setSystemSelectFont(fileChooser);   
                
                if (result == JFileChooser.APPROVE_OPTION) {
                    File file = fileChooser.getSelectedFile();
                    try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
                        textArea.write(writer);
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });

        exitItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        
        //font menu !!!!!!!!!
        //!!!!!!!!!!!!!!!!!!!
        //!!!!!!!!!!!!!!!!!!!
        //!!!!!!!!!!!!!!!!!!!
        JMenu fontMenu = new JMenu("Font Size |");
        setSystemFont(systemMenuSize, fontMenu);
       

        // Create font size menu items
        JMenuItem ultraSmallFont = new JMenuItem("XS");
        setSystemFont(systemMenuSize, ultraSmallFont);
        JMenuItem smallFont = new JMenuItem("S");
        setSystemFont(systemMenuSize, smallFont);
        JMenuItem mediumFont = new JMenuItem("M");
        setSystemFont(systemMenuSize, mediumFont);
        JMenuItem largeFont = new JMenuItem("L");
        setSystemFont(systemMenuSize, largeFont);
        JMenuItem ultraLargeFont = new JMenuItem("XL");
        setSystemFont(systemMenuSize, ultraLargeFont);
        JMenuItem ultraUltraLargeFont = new JMenuItem("XXL");
        setSystemFont(systemMenuSize, ultraUltraLargeFont);
        
        fontMenu.add(ultraSmallFont);
        fontMenu.add(smallFont);
        fontMenu.add(mediumFont);
        fontMenu.add(largeFont);
        fontMenu.add(ultraLargeFont);
        fontMenu.add(ultraUltraLargeFont);

        // Add action listeners for font size changes
        smallFont.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	editor.font = 20;
            	setFont(editor.font, textArea);
            }
        });

        mediumFont.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	editor.font = 30;
            	setFont(editor.font, textArea);
            }
        });

        largeFont.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	editor.font = 50;
            	setFont(editor.font, textArea);
            }
         
        });
        
        
        ultraLargeFont.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	editor.font = 80;
            	setFont(editor.font, textArea);
            }
         
        });
        ultraUltraLargeFont.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	editor.font = 120;
                setFont(editor.font, textArea);
            }
         
        });
        ultraSmallFont.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	editor.font = 10;
            	setFont(editor.font, textArea);
            }
         
        });
        
      //Dark mode toggle !!
        //!!!!!!!!!!!!!!!!!!!
        //!!!!!!!!!!!!!!!!!!!
        //!!!!!!!!!!!!!!!!!!!
        JButton DarkModeTogle = new JButton("Togle Dark");
        setButtonFont(20, DarkModeTogle);  
        DarkModeTogle.setBorderPainted(false);
        DarkModeTogle.setContentAreaFilled(false);
        DarkModeTogle.setFocusPainted(false);
        DarkModeTogle.setMargin(null);
        
        
        
        //system size menu !!
        //!!!!!!!!!!!!!!!!!!!
        //!!!!!!!!!!!!!!!!!!!
        //!!!!!!!!!!!!!!!!!!!
        JMenu systemSizeMenu = new JMenu("System Size |");
        setSystemFont(systemMenuSize, systemSizeMenu);
        
        
        JMenuItem XSSF = new JMenuItem("XS");
        setSystemFont(systemMenuSize, XSSF);
        JMenuItem SSF = new JMenuItem("S");
        setSystemFont(systemMenuSize, SSF);
        JMenuItem MSF = new JMenuItem("M");
        setSystemFont(systemMenuSize, MSF);
        JMenuItem LSF = new JMenuItem("L");
        setSystemFont(systemMenuSize, LSF);
        JMenuItem XLSF = new JMenuItem("XL");
        setSystemFont(systemMenuSize, XLSF);
        JMenuItem XXLSF = new JMenuItem("XXL");
        setSystemFont(systemMenuSize, XXLSF);
        JMenuItem XXXLSF = new JMenuItem("XXXL");
        setSystemFont(systemMenuSize, XXXLSF);
        
        systemSizeMenu.add(XSSF);
        systemSizeMenu.add(SSF);
        systemSizeMenu.add(MSF);
        systemSizeMenu.add(LSF);
        systemSizeMenu.add(XLSF);
        systemSizeMenu.add(XXLSF);
        systemSizeMenu.add(XXXLSF);
        
        SSF.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	
            	 editor.SMS = 10;
            	 setSystemFont(editor.SMS, fileMenu);
            	 setSystemFont(editor.SMS, openItem);
            	 setSystemFont(editor.SMS, saveItem);
            	 setSystemFont(editor.SMS, exitItem);
            	 setSystemFont(editor.SMS, fontMenu);
            	 setSystemFont(editor.SMS, ultraSmallFont);
            	 setSystemFont(editor.SMS, smallFont);
            	 setSystemFont(editor.SMS, mediumFont);
            	 setSystemFont(editor.SMS, largeFont);
            	 setSystemFont(editor.SMS, ultraLargeFont);
            	 setSystemFont(editor.SMS, ultraUltraLargeFont);
            	 setSystemFont(editor.SMS, systemSizeMenu);
            	 setSystemFont(editor.SMS, XSSF);
            	 setSystemFont(editor.SMS, SSF);
            	 setSystemFont(editor.SMS, MSF);
            	 setSystemFont(editor.SMS, LSF);
            	 setSystemFont(editor.SMS, XLSF);
            	 setSystemFont(editor.SMS, XXLSF);
            	 setSystemFont(editor.SMS, XXXLSF);
            	 setButtonFont(editor.SMS, DarkModeTogle);
            	
            	
            	
            }
        });
        
        XSSF.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
           
            	 editor.SMS = 5;
            	 setSystemFont(editor.SMS, fileMenu);
            	 setSystemFont(editor.SMS, openItem);
            	 setSystemFont(editor.SMS, saveItem);
            	 setSystemFont(editor.SMS, exitItem);
            	 setSystemFont(editor.SMS, fontMenu);
            	 setSystemFont(editor.SMS, ultraSmallFont);
            	 setSystemFont(editor.SMS, smallFont);
            	 setSystemFont(editor.SMS, mediumFont);
            	 setSystemFont(editor.SMS, largeFont);
            	 setSystemFont(editor.SMS, ultraLargeFont);
            	 setSystemFont(editor.SMS, ultraUltraLargeFont);
            	 setSystemFont(editor.SMS, systemSizeMenu);
            	 setSystemFont(editor.SMS, XSSF);
            	 setSystemFont(editor.SMS, SSF);
            	 setSystemFont(editor.SMS, MSF);
            	 setSystemFont(editor.SMS, LSF);
            	 setSystemFont(editor.SMS, XLSF);
            	 setSystemFont(editor.SMS, XXLSF);
            	 setSystemFont(editor.SMS, XXXLSF);
            	 setButtonFont(editor.SMS, DarkModeTogle);
            	
            	
            }
        });
        MSF.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	
            	 editor.SMS = 20;
            	 setSystemFont(editor.SMS, fileMenu);
            	 setSystemFont(editor.SMS, openItem);
            	 setSystemFont(editor.SMS, saveItem);
            	 setSystemFont(editor.SMS, exitItem);
            	 setSystemFont(editor.SMS, fontMenu);
            	 setSystemFont(editor.SMS, ultraSmallFont);
            	 setSystemFont(editor.SMS, smallFont);
            	 setSystemFont(editor.SMS, mediumFont);
            	 setSystemFont(editor.SMS, largeFont);
            	 setSystemFont(editor.SMS, ultraLargeFont);
            	 setSystemFont(editor.SMS, ultraUltraLargeFont);
            	 setSystemFont(editor.SMS, systemSizeMenu);
            	 setSystemFont(editor.SMS, XSSF);
            	 setSystemFont(editor.SMS, SSF);
            	 setSystemFont(editor.SMS, MSF);
            	 setSystemFont(editor.SMS, LSF);
            	 setSystemFont(editor.SMS, XLSF);
            	 setSystemFont(editor.SMS, XXLSF);
            	 setSystemFont(editor.SMS, XXXLSF);
            	 setButtonFont(editor.SMS, DarkModeTogle);
            	
            	
            	
            }
        });
        LSF.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	
            	 editor.SMS = 30;
            	 setSystemFont(editor.SMS, fileMenu);
            	 setSystemFont(editor.SMS, openItem);
            	 setSystemFont(editor.SMS, saveItem);
            	 setSystemFont(editor.SMS, exitItem);
            	 setSystemFont(editor.SMS, fontMenu);
            	 setSystemFont(editor.SMS, ultraSmallFont);
            	 setSystemFont(editor.SMS, smallFont);
            	 setSystemFont(editor.SMS, mediumFont);
            	 setSystemFont(editor.SMS, largeFont);
            	 setSystemFont(editor.SMS, ultraLargeFont);
            	 setSystemFont(editor.SMS, ultraUltraLargeFont);
            	 setSystemFont(editor.SMS, systemSizeMenu);
            	 setSystemFont(editor.SMS, XSSF);
            	 setSystemFont(editor.SMS, SSF);
            	 setSystemFont(editor.SMS, MSF);
            	 setSystemFont(editor.SMS, LSF);
            	 setSystemFont(editor.SMS, XLSF);
            	 setSystemFont(editor.SMS, XXLSF);
            	 setSystemFont(editor.SMS, XXXLSF);
            	 setButtonFont(editor.SMS, DarkModeTogle);
            	 
            	
            	
            }
        });
        XLSF.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	
            	editor.SMS = 45;
            	setSystemFont(editor.SMS, fileMenu);
           	 setSystemFont(editor.SMS, openItem);
           	 setSystemFont(editor.SMS, saveItem);
           	 setSystemFont(editor.SMS, exitItem);
           	 setSystemFont(editor.SMS, fontMenu);
           	 setSystemFont(editor.SMS, ultraSmallFont);
           	 setSystemFont(editor.SMS, smallFont);
           	 setSystemFont(editor.SMS, mediumFont);
           	 setSystemFont(editor.SMS, largeFont);
           	 setSystemFont(editor.SMS, ultraLargeFont);
           	 setSystemFont(editor.SMS, ultraUltraLargeFont);
           	 setSystemFont(editor.SMS, systemSizeMenu);
           	 setSystemFont(editor.SMS, XSSF);
           	 setSystemFont(editor.SMS, SSF);
           	 setSystemFont(editor.SMS, MSF);
           	 setSystemFont(editor.SMS, LSF);
           	 setSystemFont(editor.SMS, XLSF);
           	 setSystemFont(editor.SMS, XXLSF);
           	 setSystemFont(editor.SMS, XXXLSF);
           	 setButtonFont(editor.SMS, DarkModeTogle);
            	
            	
            }
        });
        XXLSF.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	
            	 editor.SMS = 60;
            	 setSystemFont(editor.SMS, fileMenu);
            	 setSystemFont(editor.SMS, openItem);
            	 setSystemFont(editor.SMS, saveItem);
            	 setSystemFont(editor.SMS, exitItem);
            	 setSystemFont(editor.SMS, fontMenu);
            	 setSystemFont(editor.SMS, ultraSmallFont);
            	 setSystemFont(editor.SMS, smallFont);
            	 setSystemFont(editor.SMS, mediumFont);
            	 setSystemFont(editor.SMS, largeFont);
            	 setSystemFont(editor.SMS, ultraLargeFont);
            	 setSystemFont(editor.SMS, ultraUltraLargeFont);
            	 setSystemFont(editor.SMS, systemSizeMenu);
            	 setSystemFont(editor.SMS, XSSF);
            	 setSystemFont(editor.SMS, SSF);
            	 setSystemFont(editor.SMS, MSF);
            	 setSystemFont(editor.SMS, LSF);
            	 setSystemFont(editor.SMS, XLSF);
            	 setSystemFont(editor.SMS, XXLSF);
            	 setSystemFont(editor.SMS, XXXLSF);
            	 setButtonFont(editor.SMS, DarkModeTogle); 
            	
            	
            }
        });
        XXXLSF.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	
            	
            	 editor.SMS = 80;
            	 setSystemFont(editor.SMS, fileMenu);
            	 setSystemFont(editor.SMS, openItem);
            	 setSystemFont(editor.SMS, saveItem);
            	 setSystemFont(editor.SMS, exitItem);
            	 setSystemFont(editor.SMS, fontMenu);
            	 setSystemFont(editor.SMS, ultraSmallFont);
            	 setSystemFont(editor.SMS, smallFont);
            	 setSystemFont(editor.SMS, mediumFont);
            	 setSystemFont(editor.SMS, largeFont);
            	 setSystemFont(editor.SMS, ultraLargeFont);
            	 setSystemFont(editor.SMS, ultraUltraLargeFont);
            	 setSystemFont(editor.SMS, systemSizeMenu);
            	 setSystemFont(editor.SMS, XSSF);
            	 setSystemFont(editor.SMS, SSF);
            	 setSystemFont(editor.SMS, MSF);
            	 setSystemFont(editor.SMS, LSF);
            	 setSystemFont(editor.SMS, XLSF);
            	 setSystemFont(editor.SMS, XXLSF);
            	 setSystemFont(editor.SMS, XXXLSF);
            	 setButtonFont(editor.SMS, DarkModeTogle);
            	
            	
            }
        });
        
        //dark mode toggle !!!!!
        //!!!!!!!!!!!!!!!!!!!!!!
        //!!!!!!!!!!!!!!!!!!!!!!
        
        DarkModeTogle.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	if(editor.darkMode == true) {
            	editor.backGrnd = new Color(255,255,255);
            	 frame.getContentPane().setBackground(editor.backGrnd);
            	 textArea.setBackground(editor.backGrnd);
            	 menuBar.setBackground(editor.backGrnd);
            	 fileMenu.setForeground(Color.black);
            	 openItem.setForeground(Color.black);
            	 saveItem.setForeground(Color.black);
            	 exitItem.setForeground(Color.black);
            	 fontMenu.setForeground(Color.black);
            	 ultraSmallFont.setForeground(Color.black);
            	 smallFont.setForeground(Color.black);
            	 mediumFont.setForeground(Color.black);
            	 largeFont.setForeground(Color.black);
            	 ultraLargeFont.setForeground(Color.black);
            	 ultraUltraLargeFont.setForeground(Color.black);
            	 systemSizeMenu.setForeground(Color.black);
            	 XSSF.setForeground(Color.black);
            	 SSF.setForeground(Color.black);
            	 MSF.setForeground(Color.black);
            	 LSF.setForeground(Color.black);
                 XLSF.setForeground(Color.black);
                 XXLSF.setForeground(Color.black);
            	 XXXLSF.setForeground(Color.black);
                 DarkModeTogle.setForeground(Color.black);
                 textArea.setForeground(Color.black);
            	 editor.darkMode = false;
            	}else {
            		editor.backGrnd = new Color(0,0,0);
               	 frame.getContentPane().setBackground(editor.backGrnd);
               	 textArea.setBackground(editor.backGrnd);
               	 menuBar.setBackground(editor.backGrnd);
               	 fileMenu.setForeground(Color.white);
            	 openItem.setForeground(Color.white);
            	 saveItem.setForeground(Color.white);
            	 exitItem.setForeground(Color.white);
            	 fontMenu.setForeground(Color.white);
            	 ultraSmallFont.setForeground(Color.white);
            	 smallFont.setForeground(Color.white);
            	 mediumFont.setForeground(Color.white);
            	 largeFont.setForeground(Color.white);
            	 ultraLargeFont.setForeground(Color.white);
            	 ultraUltraLargeFont.setForeground(Color.white);
            	 systemSizeMenu.setForeground(Color.white);
            	 XSSF.setForeground(Color.white);
            	 SSF.setForeground(Color.white);
            	 MSF.setForeground(Color.white);
            	 LSF.setForeground(Color.white);
                 XLSF.setForeground(Color.white);
                 XXLSF.setForeground(Color.white);
            	 XXXLSF.setForeground(Color.white);
                 DarkModeTogle.setForeground(Color.white);
                 textArea.setForeground(Color.white);
               	 editor.darkMode = true;
            	}
            }
        });
       
       
        
        
        
        //seting menu bar items !!
        //!!!!!!!!!!!!!!!!!!!!!!!!
        //!!!!!!!!!!!!!!!!!!!!!!!!
        menuBar.add(fileMenu);
        menuBar.add(fontMenu);
        menuBar.add(systemSizeMenu);
        menuBar.add(DarkModeTogle);
        
        
        
        frame.setJMenuBar(menuBar);
        frame.setVisible(true);	
        
		
	}
	
	public static void setFont(int font, JTextArea Txt) {
		
		 
		 Txt.setFont(new Font("SansSerif", Font.PLAIN, font)); // Large font
		
	}
	public static void setSystemFont(int systemMenuSize, JMenuItem menu ) {
		
		menu.setFont(new Font("SansSerif", Font.PLAIN, systemMenuSize));
		
	}
    public static void setButtonFont(int systemMenuSize, JButton button ) {
		
		button.setFont(new Font("SansSerif", Font.PLAIN, systemMenuSize));
		
	}
		
		
	 
	public void setSystemSelectFont( JFileChooser menu ) {
		
		
		 UIManager.put("FileChooser.font", new Font("Arial", Font.PLAIN, SMS));
         UIManager.put("FileChooser.listFont", new Font("Arial", Font.PLAIN, SMS));
         UIManager.put("FileChooser.buttonFont", new Font("Arial", Font.PLAIN, SMS));
         UIManager.put("FileChooser.labelFont", new Font("Arial", Font.PLAIN, SMS));
         UIManager.put("FileChooser.fileNameLabelText", new Font("Arial", Font.PLAIN, SMS));
         UIManager.put("FileChooser.fileNameTextFieldFont", new Font("Arial", Font.PLAIN, SMS));
         UIManager.put("FileChooser.directoryComboBoxFont", new Font("Arial", Font.PLAIN, SMS));
         UIManager.put("FileChooser.upFolderToolTipText", new Font("Arial", Font.PLAIN, SMS));
         UIManager.put("FileChooser.lookInLabelMnemonic", new Font("Arial", Font.PLAIN, SMS));
         UIManager.put("FileChooser.lookInLabelText", new Font("Arial", Font.PLAIN, SMS));
         UIManager.put("FileChooser.fileTypeLabelText", new Font("Arial", Font.PLAIN, SMS));
         UIManager.put("FileChooser.fileNameTextFieldFont", new Font("Arial", Font.PLAIN, SMS));
         UIManager.put("FileChooser.filesOfTypeLabelText", new Font("Arial", Font.PLAIN, SMS));
			
	}

	
}
