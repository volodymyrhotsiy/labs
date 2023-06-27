package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class TransportWriter {
    public void writeToFile(List<Transport> transports) {
        try(PrintWriter out = new PrintWriter(new File("transport.csv"))){
            Map<Class<? extends Transport>, String> headers = new HashMap<>();

            for (Transport transport : transports) {
                Class<? extends Transport> cls = transport.getClass();
                if (!headers.containsKey(cls)) {
                    String header = transport.getHeaders();
                    headers.put(cls, header);
                    out.println(header);
                }
                out.println(transport.getFieldValues());
            }
        }
        catch(FileNotFoundException e){
            System.out.println("exeption");
        }
    }
}
