package com.tmax.hyperdata.main;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.m.msl.logger.MLogger;
import com.tmax.hyperdata.processor.TbHdRequestParser;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author Jinyoung_Shin (jinyoung_shin@tmax.co.kr) 2018. 5. 31.
 */

// client sends JSONObj and

public class TCPServer {
    public static void main(String[] args) throws IOException {
        TCPServer tcpServer = new TCPServer();
        tcpServer.runServer();
    }

//    public void initSession

    public void runServer() throws IOException {
        ServerSocket serverSocket = null;
        int port = 5770;
        Socket socket = null;

        // Input Var
        InputStream iStream = null;
        InputStreamReader iStreamReader = null;
        BufferedReader bufferedReader = null;

        // Output Var
        OutputStream oStream = null;
        OutputStreamWriter oStreamWriter = null;
        BufferedWriter bufferedWriter = null;

        // Req, Res
        String request = "";
        String response = "";
//        JSONObject request = null;
//        JSONObject response = null;
        try {
        serverSocket = new ServerSocket(port);

            while(true) {
                System.out.println("DF-Server waiting for connection.");
                socket = serverSocket.accept();

                InetSocketAddress socketAddress = (InetSocketAddress) socket.getRemoteSocketAddress();
                System.out.println("DF-Server connected to" + socketAddress.getHostName());

                iStream = socket.getInputStream();
                iStreamReader = new InputStreamReader(iStream);
                bufferedReader = new BufferedReader(iStreamReader);

                String msg = null;
                while((msg = bufferedReader.readLine()) != null) {
                    request += msg;
//                    request += "\n";
                }
                System.out.println("DF-Server receive data " + request);

                // Session Handling
                // No need ?

                // Parse & Execute
                JsonParser parser = new JsonParser();
                JsonElement element = parser.parse(request);
                System.out.println(element);

                String xmlHeader = element.getAsJsonObject().get("xmlHeader").toString();
                String xmlBody = element.getAsJsonObject().get("xmlBody").toString();

                /*
                * Connection
                * 커넥션 정보가 xmlHeader에 있다고 가정...
                * */
                MLogger.INFO("Connect to TIBERO");
//                TbHdSession hyperdataSession = null;
//                HttpSession httpSession

                // getParameter
                TbHdRequestParser requestParser = new TbHdRequestParser();
                response = requestParser.parseAndExecute(xmlHeader, xmlBody); // json form

                oStream = socket.getOutputStream();
                oStreamWriter = new OutputStreamWriter(oStream);
                bufferedWriter = new BufferedWriter(oStreamWriter);

//                bufferedWriter.write(response);
//                bufferedWriter.flush();
            }

        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            try {
                // Disconnection
                bufferedWriter.close();
                oStreamWriter.close();
                oStream.close();
                socket.close();
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

}
