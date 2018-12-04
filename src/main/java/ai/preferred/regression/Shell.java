package ai.preferred.regression;

import ai.preferred.regression.reset.DataFiles;
import com.google.common.io.Files;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

public class Shell {

  private static final Logger LOGGER = LoggerFactory.getLogger(Shell.class);

  public static void reset() {
    final File tempDir = new File("temp");
    mkdir(tempDir);
    for (final File file : Objects.requireNonNull(tempDir.listFiles())) {
      if (!file.getName().startsWith(".") && !file.delete()) {
        LOGGER.error("Unable to delete: {}", file);
      }
    }
    mkdir(tempDir);

    File dataDir = new File("data");
    mkdir(dataDir);
    write(new File(dataDir, "icecream.csv"), DataFiles.ICECREAM_CSV);
    write(new File(dataDir, "icecream_raw.csv"), DataFiles.ICECREAM_RAW_CSV);
    write(new File(dataDir, "amazon.csv"), DataFiles.AMAZON_CSV);
    write(new File(dataDir, "camera.csv"), DataFiles.CAMERA_CSV);
    write(new File(dataDir, "amazon_extended.csv"), DataFiles.AMAZON_EXTENDED);
  }

  private static void write(File file, String content) {
    try (final PrintWriter writer = new PrintWriter(file, "UTF-8")) {
      writer.write(content);
    } catch (FileNotFoundException | UnsupportedEncodingException e) {
      LOGGER.error("Unable to reset file {}: {}", file, e);
    }
  }

  private static void mkdir(File tempDir) {
    if (!tempDir.exists() && !tempDir.mkdirs()) {
      LOGGER.error("Unable to mkdir: {}");
    }
  }

  public static void help(Class<?> clazz) {
    try {
      final Method method = clazz.getMethod("main", String[].class);
      method.invoke(null, (Object) null);
    } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
      LOGGER.error("Unable to execute {}: {}", clazz, e);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  public static void copyFile(String src, String dst) {
    try {
      Files.copy(new File(src), new File(dst));
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  public static void run(Class<?> clazz, String... args) {
    try {
      final Method method = clazz.getMethod("main", String[].class);
      method.invoke(null, (Object) args);
    } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
      LOGGER.error("Unable to execute {}: {}", clazz, e);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  public static void run(Class<?> clazz, String args) {
    run(clazz, args.trim().split("\\s+"));
  }

  private static Class<?> pe(String name) {
    final String className = "ai.preferred.regression.pe." + name;
    try {
      return Class.forName(className);
    } catch (ClassNotFoundException e) {
      LOGGER.info("Could not find PE: {}", className);
      return null;
    }
  }

  private static Class<?> command(String name) {
    final String className = "ai.preferred.regression." + name;
    try {
      return Class.forName(className);
    } catch (ClassNotFoundException e) {
      LOGGER.info("Could not find command: {}", className);
      return null;
    }
  }

  public static void exec(String filename) {
    try (final BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(filename), StandardCharsets.UTF_8))) {
      String line;
      while (null != (line = reader.readLine())) {
        line = line.trim();
        if (line.isEmpty()) {
          continue;
        }
        final String[] command = line.split("\\s+", 2);
        final String name = command[0];
        final String args = command[1];

        Class<?> clazz = pe(name);
        if (clazz == null) {
          clazz = command(name);
        }

        if (clazz == null) {
          LOGGER.error("Unable to execute command: {}", name);
          return;
        }

        run(clazz, args);
      }
    } catch (FileNotFoundException e) {
      LOGGER.error("Unable to find input file: {}", filename);
    } catch (IOException e) {
      LOGGER.error("Execution error: ", e);
    }
  }

  public static void main(String[] args) {
    for (final String arg : args) {
      exec(arg);
    }
  }

  private Shell() {
    throw new AssertionError();
  }

}
