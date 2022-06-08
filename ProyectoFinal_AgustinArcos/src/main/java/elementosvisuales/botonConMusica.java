package elementosvisuales;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.util.Timer;
import java.util.TimerTask;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JButton;

public class botonConMusica extends JButton{

	
	private File musica;
	private Clip clip;
	private AudioInputStream audioInputStream;
	
/*
 * Botón con musica de elementosvisuales que reproduce el theme de Crash Bandicoot.
 */
public botonConMusica(String m) {
		super(m);
		final Timer timer = new Timer();
		setEnabled(true);
		musica = new File(FileSystems.getDefault().getPath("").toAbsolutePath() + "/musica/crashbandicoot.wav");
		
		botonConMusica.this.addActionListener(new ActionListener() {
		//BotonConMusica.this.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				play();

				setEnabled(false);
			}
		});

	}


	/**
	 * Metodo para reproducir un archivo de audio
	 */
	public void play() {
		try {
			audioInputStream = AudioSystem.getAudioInputStream(musica);
			clip = AudioSystem.getClip();
			clip.open(audioInputStream);
			clip.start();

		} catch (LineUnavailableException | IOException | UnsupportedAudioFileException e) {
			System.err.println(e);
		}
	}

	
	
}
