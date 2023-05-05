package com.example.sendapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.nio.charset.StandardCharsets;

class Network implements Runnable
{

    @Override
    public void run()
    {

        byte[] buffer = {10,23,12,31,43,32,24};
        byte [] IP = {-64,-88,1,106};
        InetAddress address = null;
        try
        {
            address = InetAddress.getByAddress(IP);
        } catch (UnknownHostException e)
        {
            e.printStackTrace();
        }
        try
        {
            address = InetAddress.getByAddress(IP);
        } catch (UnknownHostException e)
        {
            e.printStackTrace();
        }
        DatagramPacket packet = new DatagramPacket(
                buffer, buffer.length, address, 57
        );
        DatagramSocket datagramSocket = null;
        try
        {
            datagramSocket = new DatagramSocket(50);
        } catch (SocketException e)
        {
            e.printStackTrace();
        }
        try
        {
            datagramSocket.send(packet);
        } catch (IOException e)
        {
            e.printStackTrace();
        }
        try
        {
            System.out.println(InetAddress.getLocalHost().getHostAddress());
        } catch (UnknownHostException e)
        {
            e.printStackTrace();
        }
    }

}
public class MainActivity extends AppCompatActivity
{
    InetAddress receiverAddress;
    DatagramSocket datagramSocket;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Network network = new Network();
        Thread thread = new Thread(network);
        thread.start();
    }

}