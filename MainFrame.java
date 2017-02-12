import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.sound.sampled.*;
import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

public class MainFrame {
	
	public static JFrame mainFrame = new JFrame("Proyecto"); //Crea la una ventana con nombre Proyecto
	
	//public static Sound nombreDeVariable = new Sound("Direccion donde estan guardados los sonidos y el nombre del archivo, cambia '\' por '/');
	public static Sound startSound = new Sound("/Users/Carmina/Documents/A - School/Redes/src/Parcial1/500Hz.wav"); 
	public static Sound endSound = new Sound("/Users/Carmina/Documents/A - School/Redes/src/Parcial1/1000Hz.wav");
	public static Sound errorSound = new Sound("/Users/Carmina/Documents/A - School/Redes/src/Parcial1/1200Hz.wav");
	public static Sound aRx = new Sound("/Users/Carmina/Documents/A - School/Redes/src/Parcial1/1500Hz.wav");
	public static Sound bRx = new Sound("/Users/Carmina/Documents/A - School/Redes/src/Parcial1/1800Hz.wav");
	public static Sound cRx = new Sound("/Users/Carmina/Documents/A - School/Redes/src/Parcial1/2000Hz.wav");
	
	/* Sonidos que faltan
	public Sound coord1 = new Sound("/Users/Carmina/Documents/A - School/Redes/src/Parcial1/????Hz.wav");
	public Sound coord2 = new Sound("/Users/Carmina/Documents/A - School/Redes/src/Parcial1/????Hz.wav");
	public Sound coord3 = new Sound("/Users/Carmina/Documents/A - School/Redes/src/Parcial1/????Hz.wav");
	public Sound coord4 = new Sound("/Users/Carmina/Documents/A - School/Redes/src/Parcial1/????Hz.wav");
	*/

	public static void main(String [] args){

		mainFrame.setSize(400,400); //Tamaño de la ventana
		mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); // para que termine el programa cuando se cierre la ventana
		

		  JPanel panel = new JPanel(); //Crea panel para poner componentes como botones o text fields
		  mainFrame.add(panel); // Agrega el panel a la ventana
		  JButton startButton = new JButton("START"); //Botón llamada startButton con texto START
		  panel.add(startButton); //Agrega el botón al panel
		  startButton.addActionListener (new StartAction()); //Para saber cuando se hace clic en el botón, que acción hacer esta decrito en la clase StartAction

		  JButton sendButton = new JButton("SEND");
		  panel.add(sendButton);
		  sendButton.addActionListener (new SendAction()); 
		  
		  JButton tryButton = new JButton("TRY");
		  panel.add(tryButton);
		  tryButton.addActionListener (new TryAction()); //Este boton es temporal para probar los sonidos
		  
		  JButton endButton = new JButton("END");
		  panel.add(endButton);
		  endButton.addActionListener (new EndAction());
		  mainFrame.setVisible(true); // Esto siempre va al final para que se vean todos los componentes
		}
	static class StartAction implements ActionListener {// clase que describe la acción a tomar cuando se hace clic al botón StartButton
		@Override
		public void actionPerformed(ActionEvent e) { //aqui va el código de que hacer
			startSound.play();
		}
	}
	
	static class EndAction implements ActionListener {        
		@Override
		public void actionPerformed(ActionEvent e) {
			endSound.play();
		}
	}
	
	static class SendAction implements ActionListener {        
		@Override
		public void actionPerformed(ActionEvent e) {
		    JFileChooser chooser = new JFileChooser();
		    FileNameExtensionFilter filter = new FileNameExtensionFilter("jpg", "txt");
		    chooser.setFileFilter(filter);
		    int returnVal = chooser.showOpenDialog(mainFrame);
		    if(returnVal == JFileChooser.APPROVE_OPTION) {
		    	File file = chooser.getSelectedFile();
                try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                    String text = null;
                    while ((text = br.readLine()) != null) {
                    	System.out.println(text);
                    }
                } catch (IOException exp) {
                    exp.printStackTrace();
                }
		    }
		}
	}
	
	//esto es para probar los sonidos
	static class TryAction implements ActionListener {        
		@Override
		public void actionPerformed(ActionEvent e) {
			
			startSound.play();
			
			try { TimeUnit.SECONDS.sleep(4);} catch (InterruptedException e1) { e1.printStackTrace();} //Para que espere 4 segundos antes de hacer la siguiente operación
			
			errorSound.play();
			
			try { TimeUnit.SECONDS.sleep(4);} catch (InterruptedException e1) { e1.printStackTrace();} 
			
			endSound.play();
			
			try { TimeUnit.SECONDS.sleep(4);} catch (InterruptedException e1) { e1.printStackTrace();} 
			
			aRx.play();
			
			try { TimeUnit.SECONDS.sleep(4);} catch (InterruptedException e1) { e1.printStackTrace();} 
			
			bRx.play();
			
			try { TimeUnit.SECONDS.sleep(4);} catch (InterruptedException e1) { e1.printStackTrace();}
			
			cRx.play();
			
		}
	}
}
