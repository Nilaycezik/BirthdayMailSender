package main.java;

import main.java.mail.Mail;
import main.java.utils.DateUtils;
import main.java.utils.FileUtils;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;

import static main.java.Main.pathAbsolute;
//import java.util.Calendar;



public class SendMail {
    //Path Alma
    private static String workingDir = System.getProperty( "user.dir" );
    private static Path pathAbsolute = Paths.get( workingDir + "\\src\\main\\resources\\Birthday.txt" );
    public static void main(String[] args) throws ParseException {

        DateUtils dateUtils=new DateUtils();
        FileUtils fileUtils=new FileUtils();

    }
}

