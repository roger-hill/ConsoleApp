package com.roger.http;

import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Roger Hill
 * Date 07/03/2016.
 */
public class HttpServer implements Runnable {

    private static Logger log = Logger.getLogger(HttpServer.class);

    public static final int DEFAULT_PORT = 80;
    private static final int MIN_PORT = 0;
    private static final int MAX_PORT = 65535;

    private static int port = DEFAULT_PORT;

    private Socket clientSocket;

    public static void main(String[] args) {

        if (parseArguments(args)) {
            try {
                listen();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static boolean parseArguments(String[] args) {

        boolean retVal = true;

        if (args.length == 1) {
            try {
                port = Integer.parseInt(args[0]);

                if (port < MIN_PORT ||
                        port > MAX_PORT) {
                    printUsage();
                    retVal = false;
                }
            } catch (NumberFormatException nfe) {
                printUsage();
                retVal = false;
            }
        } else if (args.length > 1) {
            printUsage();
            retVal = false;
        }

        return retVal;
    }

    private static void printUsage() {

        System.err.println("Usage: " + HttpServer.class.toString() + " [<port number>]");
        System.err.println("<port number> if provided must be a positive integer not greater than " + MAX_PORT);
        System.err.println("If <port number> is not provided the default port number is " + DEFAULT_PORT);
    }

    private static void listen() throws IOException {

        log.info("Listening for connections on port: " + port);
        ServerSocket serverSocket = new ServerSocket(port);

        while (true) {
            Socket clientSocket = serverSocket.accept();
            log.debug("Accepted new connection: " + clientSocket);
            HttpServer server = new HttpServer(clientSocket);
            Thread thread = new Thread(server);
            thread.start();
        }
    }

    private HttpServer(Socket clientSocket) {

        this.clientSocket = clientSocket;
    }

    public void run() {

        log.debug("HttpServer thread started");
        try {
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            log.debug("Start HTTP Request:");
            int contentLength = readRequestHeader(in);
            readRequestBody(in, contentLength);
            log.debug("End HTTP Request:");

            writeOKResponse(out);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                clientSocket.close();
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        }
        log.debug("HttpServer thread stopping");
    }

    private int readRequestHeader(BufferedReader in) throws IOException {

        int contentLength = 0;
        final Map<String, String> properties = new HashMap<String, String>();
        StringBuilder sb = new StringBuilder();
        int c;
        while ((c = in.read()) != -1) {

            sb.append((char)c);
            if (sb.toString().endsWith("\r\n")) {
                String line = sb.toString();
                System.out.print(line);
                if (line.indexOf(": ") != -1) {
                    properties.put(line.substring(0, line.indexOf(": ")), line.substring(line.indexOf(": ") + 2).trim());
                }
                sb = new StringBuilder();
                if ("\r\n".equals(line)) {
                    break;
                }
            }
        }

        if (properties.containsKey("Content-Length")) {
            String contentLengthString = properties.get("Content-Length");
            contentLength = Integer.parseInt(contentLengthString);
        }

        return contentLength;
    }

    private void readRequestBody(BufferedReader in, int contentLength) throws IOException {

        StringBuilder sb = new StringBuilder();
        int c;
        int count = 0;
        while (count < contentLength) {

            if ((c = in.read()) != -1) {
                sb.append((char) c);
            } else {
                break;
            }
            ++count;
        }

        System.out.println(sb.toString());
    }

    private void writeOKResponse(PrintWriter out) {

        out.write(createOKResponse());
        out.flush();
    }
    
    private String createOKResponse() {
      
        final String CRLF = "\r\n";
        String statusLine = "HTTP/1.0 200 OK";

        return statusLine + CRLF + CRLF;
    }
}
