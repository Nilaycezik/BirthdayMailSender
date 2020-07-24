package main.java;

import main.java.mail.Mail;
import main.java.model.Person;
import main.java.test.Properties;
import main.java.utils.DateUtils;
import main.java.utils.FileUtils;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class SendMail {

    //Path Alma
    private static String workingDir = System.getProperty( "user.dir" );
    private static Path pathAbsolute = Paths.get( workingDir + "\\src\\main\\resources\\Birthday.txt" );


    public static void main(String[] args) throws IOException, ParseException {

        DateUtils dateUtils = new DateUtils();
        SimpleDateFormat sdf = new SimpleDateFormat( "dd/MM/yyyy" );
        Properties properties = new Properties();
        properties.getPropValue();
        properties.Read();

        List<Person> pList = FileUtils.splitFile( pathAbsolute.toString() );

        List<Person> birthdayPersons = new ArrayList<>();


        for (Person p : pList) {

            Date personDate = p.getBirthday();
            String personName = FileUtils.upperCase( p.getName() );


            List dayCount = dateUtils.differenceBetweenTwoDates( sdf.format( personDate ) );

            if(((Integer)dayCount.get( 1 )).intValue() == 0){ //kalan ay
                int rDay = ((Integer)dayCount.get( 0 )).intValue();
                if( !(rDay<0) && rDay <= 7){
                    if(rDay == 0){
                        System.out.println( personName + " " + " in bugun dogum gunu kutlamaya ne dersin :)\n" );
                        birthdayPersons.add( p );
                    }else{
                        System.out.println( personName + " " + "Dogum gunune"+rDay+" gun kaldi.\n" );
                    }

                    Mail.sendMail( properties.getProperty( "host" ),properties.getProperty( "port" ),properties.getProperty( "username" ),
                            properties.getProperty( "password" ),"nilaycezik@gmail.com","Dogum Gunu",
                            "Dogum Gununuz Kutlu olsun:)" );

                }

            }
        }
    }
}