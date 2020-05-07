package br.com.southsystem;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;

import br.com.southsystem.utils.FileProcessor;
import br.com.southsystem.utils.Log;

/**
 * A developer challenge from South System
 * 
 * @author marcioferoli <marcioferoli@gmail.com>
 * @version 1.0
 * @since 2020-05-07
 */
public class Challenge {

	private static final String TARGET_EXTENSION = "dat";
	private static final String DATA_IN_DIR = "data/in";
	private static final String DATA_OUT_DIR = "data/out";

	/**
	 * Processes a valid file
	 * 
	 * @param fileName
	 */
	private static void processAValidFile(String fileName) {
		if (!fileName.endsWith("." + TARGET_EXTENSION)) {
			Log.warning(String.format("File [%s] not valid", fileName));
			return;
		}

		Log.warning(String.format("File [%s] processing ...", fileName));
		File fileToProcess = Paths.get(System.getProperty("user.home"), DATA_IN_DIR, fileName).toFile();
		FileProcessor fileProcessor = new FileProcessor(fileToProcess);
		if (fileProcessor.isAValidFile()) {
			String summaryFileName = fileName.replace("." + TARGET_EXTENSION, ".done." + TARGET_EXTENSION);

			// Writting summary file ...
			try (FileWriter summaryFileWriter = new FileWriter(
					Paths.get(System.getProperty("user.home"), DATA_OUT_DIR, summaryFileName).toString())) {
				summaryFileWriter.write(fileProcessor.getSummary().toString());
				Log.warning(String.format("Summary [%s] created", summaryFileName));
			} catch (IOException e) {
				Log.severe(e);
			}

		} else {
			Log.warning(String.format("File [%s] contains [%s] errors", fileName, fileProcessor.getLinesWithErrors()));
		}
	}

	/**
	 * Waits for files created in the default path and start their processing
	 * 
	 * @param watchService
	 * @throws IOException
	 */
	private static void processFiles(WatchService watchService) throws IOException {
		Path path = Paths.get(System.getProperty("user.home"), DATA_IN_DIR);
		try {

			// Processes the current files ...
			File[] currentFiles = (new File(path.toString())).listFiles();
			for (File currentFile : currentFiles) {
				processAValidFile(currentFile.getName());
			}

			// Waits for more files ...
			path.register(watchService, StandardWatchEventKinds.ENTRY_CREATE, StandardWatchEventKinds.ENTRY_MODIFY);
			WatchKey key;
			while ((key = watchService.take()) != null) {
				for (WatchEvent<?> event : key.pollEvents()) {
					Log.info(String.format("Waiting ... File [%s] Event kind [%s] ", event.context(), event.kind()));
					if (event.context() != null) {
						processAValidFile(event.context().toString());
					}
				}
				key.reset();
			}

		} catch (InterruptedException e) {
			Log.severe(e);
		}
	}

	/**
	 * Starts the application
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Log.info("Application started");
		try {
			processFiles(FileSystems.getDefault().newWatchService());
		} catch (IOException e) {
			Log.severe(e);
		}
	}

}
