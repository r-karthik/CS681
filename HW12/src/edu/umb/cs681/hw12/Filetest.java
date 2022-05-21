package edu.umb.cs681.hw12;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Filetest {

    public static void main(String[] args){
        LocalDateTime creationTime=LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy HH:MM");
        String time = creationTime.format(formatter);

        LocalDateTime creationTime1=LocalDateTime.now();
        Directory root=new Directory(null,"Root",0,creationTime );


        LocalDateTime creationTime2=LocalDateTime.now();
        Directory home=new Directory(root,"home",0,creationTime1 );
        Directory system=new Directory(root,"system",0,creationTime1 );
        Directory pictures=new Directory(home,"pictures",0,creationTime1 );
        File fileA=new File(home,"file:a",1,creationTime2 );
        File fileB=new File(home,"file:b",1,creationTime2 );
        File fileC=new File(system,"file:c",1,creationTime2 );
        File fileD=new File(system,"file:d",1,creationTime2 );
        File fileE=new File(system,"file:e",1,creationTime2 );
        File fileF=new File(pictures,"file:f",1,creationTime2 );
        File fileG=new File(pictures,"file:g",1,creationTime2 );

        System.out.println("The Size of the directory home: " + home.getTotalSize());
        System.out.println("The Size of the directory root: " + root.getTotalSize());
        System.out.println("The Size of the directory system: " + system.getTotalSize());
        System.out.println("The Size of the directory pictures: " + pictures.getTotalSize());


    }
}
