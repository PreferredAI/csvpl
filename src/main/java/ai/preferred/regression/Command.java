package ai.preferred.regression;

import org.kohsuke.args4j.CmdLineException;
import org.kohsuke.args4j.CmdLineParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class Command {

  private static final Logger LOGGER = LoggerFactory.getLogger(Command.class);

  protected abstract void exec() throws Exception;

  protected static void parseArgsAndRun(Class<? extends Command> clazz, String[] args) {
    Command command = null;
    try {
      command = clazz.newInstance();
    } catch (IllegalAccessException | InstantiationException e) {
      System.err.println("Please check if there is the public default constructor for the class: " + clazz.getCanonicalName());
      System.exit(1);
    }

    if (args == null) {
      System.out.println("=========== HELP ===========");
      System.out.println();
      System.out.println("Processing Element: " + clazz.getSimpleName() + ".class");
      System.out.println();
      System.out.println("Shell.run(" + clazz.getSimpleName() + ".class, \"\");");
      final CmdLineParser parser = new CmdLineParser(command);
      System.out.println();
      parser.printUsage(System.out);
      System.out.println();
      System.out.println("============================");
      System.out.println();
      System.out.println();
      return;
    }

    final CmdLineParser parser = new CmdLineParser(command);
    try {
      parser.parseArgument(args);
    } catch (CmdLineException e) {
      System.err.println("Command: " + clazz.getCanonicalName());
      System.err.println(e.getMessage());
      System.err.println();
      parser.printUsage(System.err);
      System.exit(1);
    }

    try {
      command.exec();
    } catch (Exception e) {
      LOGGER.error("Unable to execute command (" + clazz.getCanonicalName() + "): ", e);
      System.exit(1);
    }
  }

}
