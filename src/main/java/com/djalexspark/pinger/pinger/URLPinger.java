package com.djalexspark.pinger.pinger;

import java.io.IOException;
import java.net.*;

public  class URLPinger {
    public static void main(String[] args) {
        var m = new URLPinger();
        m.ping_3();
    }

    void ping_3(){
        String ipAddress = "8.8.8.8";
        long end;
        long start;
        try {
            InetAddress inet = InetAddress.getByName(ipAddress);
            start = System.currentTimeMillis();
            while (true) {
                if (inet.isReachable(5000)) {
                    end = System.currentTimeMillis();
                    System.out.println("Время прохождения сигнала: " + (end - start) + "мс");
                    start = end;
                } else {
                    System.out.println("Узел недоступен");
                }
            }
        } catch (UnknownHostException e) {
            System.err.format("Unknown host: %s\n", ipAddress);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

     void  ping_1(){
        String ipAddress = "8.8.8.8";
        try {
            InetAddress inet = InetAddress.getByName(ipAddress);

            if (inet.isReachable(5000)) {
                System.out.println("Узел доступен");
            } else {
                System.out.println("Узел недоступен");
            }
        } catch (UnknownHostException e) {
            System.err.format("Unknown host: %s\n", ipAddress);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
     void ping_2(){
        HttpURLConnection connection = null;
        try {
            URL u = new URL("http://www.djalexspark.gihub.io/");
//            URL u = new URL("http://www.google.com/");
            connection = (HttpURLConnection) u.openConnection();
            connection.setRequestMethod("HEAD");
            int code = connection.getResponseCode();
            System.out.println(connection.getConnectTimeout());
            System.out.println("" + code);
            // You can determine on HTTP return code received. 200 is success.
        } catch (MalformedURLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }
    }
}
