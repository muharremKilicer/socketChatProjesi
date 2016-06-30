package netUyg;

import java.io.*;
import java.net.*;

public class ser {

    public static void main(String[] args) throws IOException {
        String clientGelen;
        ServerSocket serverSocket = null;
        Socket clientSocket = null;
        String deger;
        String sayi;

        try {
            //*Server 7755 portundan Client'ı dinliyor *//
            serverSocket = new ServerSocket(7755);
        } catch (Exception e) {
            System.out.println("Port Hatası!");
        }
        System.out.println("SERVER BAŞLANTI İÇİN HAZIR...");

        //* Bağlantı sağlamadan program bir alt satırdaki kod parçasına geçmez (accept) *//
        clientSocket = serverSocket.accept();

        //* Client'a veri gönderimi için kullandığımız PrintWriter nesnesi oluşturulur *//
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

        //* Client'dan gelen verileri tutan BufferedReader nesnesi oluşturulur *//
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        BufferedReader data = new BufferedReader(new InputStreamReader(System.in));

        while ((clientGelen = in.readLine()) != null) {
            System.out.println("Client'dan gelen veri = " + clientGelen);
            System.out.println("cc'a gönderilecek veri giriniz:");
            while ((deger = data.readLine()) != null) {
                out.println(deger);
                System.out.println("cc'dan gelen sonuç = " + in.readLine());
                System.out.println("cc'a gönderilecek veri giriniz");
            }
        }

        out.close();
        in.close();
        clientSocket.close();
        serverSocket.close();
    }
}
