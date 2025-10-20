package org.example.UP1.Practica;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Practica {

    static void main(String[] args){

        try(RandomAccessFile raf = new RandomAccessFile("src/main/java/org/example/UP1/Practica/datos.dat","rw")){

            raf.setLength(0);

            raf.writeChar('a');
            raf.writeInt(55);

            raf.seek(2);
            int intleido = raf.readInt();
            System.out.println((char)intleido);



        }catch (IOException e){
            System.out.println(e.getMessage());
        }


    }
}
