package hibernate.one.actions;

import hibernate.one.Controllers.myMailSender;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collections;


/**
 * @author Bianca Culea
 */
@Component
public class sendMailWithErrorsLogs {

    private static final Logger logger = LogManager.getLogger(sendMailWithErrorsLogs.class);

    @Autowired
    myMailSender sender;

    public void sendMail(Exception e) {
        String adminEmail ="bianca_culea@yahoo.com";
        String body=getStackTraceString(e,"  ");
        try(PrintWriter pw = new PrintWriter(Files.newBufferedWriter(Paths.get("D:/fisiereJ8/exception.txt")))) {
         //Collections.singletonList(body).stream().forEach(pw::println);
            pw.println(e.toString()+"\n"+"\n");
            pw.println("\n"+"\n"+" getStackTrace():  "+"\n"+"\n");
            Arrays.stream(e.getStackTrace()).map(x->x.toString()).forEach(pw::println);
            pw.println("\n"+"\n"+" getCause():  "+"\n");
            pw.println((e.getCause()).toString());
            pw.println("\n");
            Arrays.stream((e.getCause()).getStackTrace()).map(x->x.toString()).forEach(pw::println);
            pw.println("\n"+"\n"+" getSuppressed():  "+"\n"+"\n");
            Arrays.stream(e.getSuppressed()).forEach(pw::println);
        }catch (IOException e2){System.out.println(e2.toString());}

        try {
            sender.sendExceptionMail(adminEmail, e, new File("D:/fisiereJ8/exception.txt"));
        } catch (javax.mail.MessagingException e1) {
            logger.error("Eroare la trasmisia unei erori prin mail  " + e1.toString());
        }
    }

    private static String getStackTraceString(Throwable e, String indent) {
        StringBuilder sb = new StringBuilder();
        sb.append(e.toString());
        sb.append("\n");

        StackTraceElement[] stack = e.getStackTrace();
        if (stack != null) {
            for (StackTraceElement stackTraceElement : stack) {
                sb.append(indent);
                sb.append("\tat ");
                sb.append(stackTraceElement.toString());
                sb.append("\n");
            }
        }

        Throwable[] suppressedExceptions = e.getSuppressed();
        // Print suppressed exceptions indented one level deeper.
        if (suppressedExceptions != null) {
            for (Throwable throwable : suppressedExceptions) {
                sb.append(indent);
                sb.append("\t\nSuppressed: ");
                sb.append(getStackTraceString(throwable, indent + "\t"));
            }
        }

        Throwable cause = e.getCause();
        if (cause != null) {
            sb.append(indent);
            sb.append("\t\nCaused by: ");
            sb.append(getStackTraceString(cause, indent));
        }

        return sb.toString();
    }


}
