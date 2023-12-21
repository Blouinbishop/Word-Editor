import javax.swing.JFrame;
	import java.awt.Container;
	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;
	import java.awt.event.WindowAdapter;
	import java.awt.event.WindowEvent;
	import java.io.File;
	import java.io.FileNotFoundException;
	import java.io.PrintWriter;
	import java.util.Scanner;

	import javax.swing.JButton;
	import javax.swing.JFileChooser;
	import javax.swing.JFrame;
	import javax.swing.JLabel;
	import javax.swing.JMenu;
	import javax.swing.JMenuBar;
	import javax.swing.JMenuItem;
	import javax.swing.JPanel;
	import javax.swing.JScrollPane;
	import javax.swing.JTextArea;
	import javax.swing.JTextField;




	@SuppressWarnings("serial")
	public class WordEdit extends JFrame implements ActionListener {
		
		
		 private JTextArea textArea = new JTextArea(8, 40);

		  private JScrollPane scrollPane = new JScrollPane(textArea);

		  private JTextField fromField = new JTextField(8);

		  private JTextField toField = new JTextField(8);
		
		 
		  JButton openButton;
		  JButton saveButton;
		  JButton exitButton;
		  
		  public WordEdit() {
				
			  JButton openButton = new JButton("Open");
			    JButton saveButton = new JButton("Save");
			    JButton exitButton = new JButton("Exit");
				   
			   
			    saveButton.addActionListener
			    (
			            new ActionListener() {
			                public void actionPerformed(ActionEvent e) {
			                  
			                }
			            }
			        );
			     
				 setTitle("Word Edit");
				    setSize(600, 600);
				    addWindowListener(new WindowAdapter() {
				      public void windowClosing(WindowEvent e) {
				        System.exit(0);
				      }
				    });
				
				    Container contentPane = getContentPane();
				    JPanel panel = new JPanel();
				    saveButton.addActionListener
				    (
				            new ActionListener() {
				                public void actionPerformed(ActionEvent e) {
				                	 if(e.getSource()==saveButton) {
				         				JFileChooser fileChooser = new JFileChooser(); 
				         				fileChooser.setCurrentDirectory(new File("."));
				         				
				         				int saved = fileChooser.showSaveDialog(null);
				         				if(saved == JFileChooser.APPROVE_OPTION) {
				         					File file; 
				         					PrintWriter fileOut = null;
				         					file = new File(fileChooser.getSelectedFile().getAbsolutePath()); 
				         					try {
				         						fileOut = new PrintWriter(file);
				         						fileOut.println(textArea.getText());
				         					} 
				         					
				         					catch (FileNotFoundException e1) {
				         						
				         						e1.printStackTrace();
				         					}
				         					finally {
				         						fileOut.close(); 
				         					}
				         				}
				         				
				         			}
				                }
				            }
				        );
				    openButton.addActionListener
				    (
				            new ActionListener() {
				                public void actionPerformed(ActionEvent e) {
				                	if(e.getSource()==openButton) {
				            			JFileChooser fileChooser = new JFileChooser(); 
				            			fileChooser.setCurrentDirectory(new File("."));
				            			
				            			int open = fileChooser.showOpenDialog(null);
				            			
				            			if(open == JFileChooser.APPROVE_OPTION) {
				            				File file = new File(fileChooser.getSelectedFile().getAbsolutePath()); 
				            				Scanner fileIn = null;
				            				try {
				            					fileIn = new Scanner(file);
				            					if(file.isFile()) {
				            						while(fileIn.hasNextLine()) {
				            							String Line = fileIn.nextLine()+"\n"; 
				            							textArea.append(Line);
				            							
				            						}
				            						
				            					}
				            				} catch (FileNotFoundException e1) {
				            					// TODO Auto-generated catch block
				            					e1.printStackTrace();
				            				}
				            				finally {
				            					fileIn.close();
				            				}
				         					}
				         				}
				         				
				         			}
				                
				            }
				        );
				    
				    exitButton.addActionListener
				    (	new ActionListener() {
		                public void actionPerformed(ActionEvent e) {
		                	if(e.getSource()==exitButton) {
		            			System.exit(0);
		            		}
		                }
				    }
		                 );
				    		
				    JButton replaceButton = new JButton("Remove");
				  
				    panel.add(replaceButton);
				    panel.add(saveButton);
				    panel.add(openButton);
				    panel.add(exitButton); 
				    replaceButton.addActionListener(this); 
				    
				    panel.add(fromField);
				    
				    
				    panel.add(new JLabel(" to remove enter text ")); 

				    panel.add(toField);

				    contentPane.add(panel, "South");
				    contentPane.add(scrollPane, "Center");
				    
				    
				    
				  
				  }

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==openButton) {
				JFileChooser fileChooser = new JFileChooser(); 
				fileChooser.setCurrentDirectory(new File("."));
				
				int open = fileChooser.showOpenDialog(null);
				
				if(open == JFileChooser.APPROVE_OPTION) {
					File file = new File(fileChooser.getSelectedFile().getAbsolutePath()); 
					Scanner fileIn = null;
					try {
						fileIn = new Scanner(file);
						if(file.isFile()) {
							while(fileIn.hasNextLine()) {
								String Line = fileIn.nextLine()+"\n"; 
								textArea.append(Line);
								
							}
							
						}
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					finally {
						fileIn.close();
					}
					
					
							
				}
			}
			// remove text
			String from = fromField.getText();
	        int start = textArea.getText().indexOf(from);
	        if (start >= 0 && from.length() > 0)
	          textArea.replaceRange(toField.getText(), start, start
	              + from.length());
			// remove text
		
			 if(e.getSource()==saveButton) {
					JFileChooser fileChooser = new JFileChooser(); 
					fileChooser.setCurrentDirectory(new File("."));
					
					int saved = fileChooser.showSaveDialog(null);
					if(saved == JFileChooser.APPROVE_OPTION) {
						File file; 
						PrintWriter fileOut = null;
						file = new File(fileChooser.getSelectedFile().getAbsolutePath()); 
						try {
							fileOut = new PrintWriter(file);
							fileOut.println(textArea.getText());
						} 
						
						catch (FileNotFoundException e1) {
							
							e1.printStackTrace();
						}
						finally {
							fileOut.close(); 
						}
					}
					
				}
			
		}
		

		

	}
