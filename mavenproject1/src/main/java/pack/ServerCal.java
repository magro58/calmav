/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pack;

/**
 *
 * @author informatica
 */
import java.io.*;
import java.net.*;

public class ServerCal {
                        
    ServerSocket socket_server=null;
    Socket socket_client=null;
    String risposta_server=null;
    BufferedReader dati_dal_client;
    DataOutputStream dati_al_client;
    double x;
            double y;
            double risultato = 0;
            int op;
    
    public Socket attendi(){
        try {
            System.out.println("Server in esecuzione.");
            socket_server=new ServerSocket(1235);
            System.out.println("Server in attesa del client.");
            socket_client=socket_server.accept();
            System.out.println("Client connesso.");
            dati_dal_client=new BufferedReader(new InputStreamReader(socket_client.getInputStream()));
            dati_al_client=new DataOutputStream(socket_client.getOutputStream());
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Errore nell'istanziamento del server.");
            System.exit(1);
        }
        return(socket_client);
    }
    public void calcola(){
        try {
            System.out.println("In attesa del messaggio da parte del client.");
            
                op = Integer.parseInt(dati_dal_client.readLine());
                System.out.println(op);
                
                x = dati_dal_client.read();
                System.out.println("x = " + x);
                y = dati_dal_client.read();
                System.out.println("y = " + y);
               
                switch(op){
                    case 0:
                        System.exit(1);
                        break;
                    
                    //addizione
                    case 1
                            :
                        System.out.println("Scelta: 1- Addizione");
                        risultato = x + y;
                        risposta_server = "Risultato: " + risultato;
                        System.out.println("Invio della risposta al client.");
                        dati_al_client.writeBytes(risposta_server+'\n');
                        System.out.println("Invio completato.");
                        break;
                    //differenza
                    case 2:
                        System.out.println("Scelta: 2- Differenza");
                        risultato = x - y;
                        risposta_server = "Risultato: " + risultato;
                        System.out.println("Invio della risposta al client.");
                        dati_al_client.writeBytes(risposta_server+'\n');
                        System.out.println("Invio completato.");
                        break;
                    //divisione   
                    case 3:
                        System.out.println("Scelta: 3- Divisione");
                        risultato = x / y;
                        risposta_server = "Risultato: " + risultato;
                        System.out.println("Invio della risposta al client.");
                        dati_al_client.writeBytes(risposta_server+'\n');
                        System.out.println("Invio completato.");
                        break;
                    //moltiplicazione
                    case 4:
                        System.out.println("Scelta: 4- Moltiplicazione");
                        risultato = x * y;
                        risposta_server = "Risultato: " + risultato;
                        System.out.println("Invio della risposta al client.");
                        dati_al_client.writeBytes(risposta_server+'\n');
                        System.out.println("Invio completato.");
                        break;
                }
            
        }
        catch (Exception e) {
            System.out.println("Errore durante la comunicazione.");
        }
    }

}
