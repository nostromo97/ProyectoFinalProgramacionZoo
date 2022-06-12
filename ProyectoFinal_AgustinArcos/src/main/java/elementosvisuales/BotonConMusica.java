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

/**
 * Clase que contiene BotonConMusica y que extiende de JButton
 * 
 * @author Agustín Arcos
 *
 */
public class BotonConMusica extends JButton {

	/**
	 * Variable de tipo File que contiene el archivo wav de la canción.
	 */
	private File musica;
	/**
	 * Carga el audio para que pueda ser reproducido.
	 */
	private Clip clip;
	/**
	 * Flujo que contiene el audio
	 */
	private AudioInputStream audioInputStream;

	/*
	 * Función que toma un archivo de audio a partir de una ruta.
	 */

	public BotonConMusica(String m) {
		super(m);
		final Timer timer = new Timer();
		setEnabled(true);
		musica = new File(FileSystems.getDefault().getPath("").toAbsolutePath() + "/musica/crashbandicoot.wav");

		BotonConMusica.this.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				play();

				setEnabled(false);
			}
		});

	}

	/**
	 * Función para reproducir un archivo de audio a partir de la clase AudioSystem
	 * al cual se le pasa un objeto de la clase Clip y reproduce el archivo.
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
