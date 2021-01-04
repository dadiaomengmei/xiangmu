package com.example.hardcoredemo.modular.tx.wxpay.utils;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Enumeration;

/**
 * 查询本机IP地址
 */
public class LocalIPUtil {
    public LocalIPUtil() {
    }

    public static String getLocalAddr() {
        Enumeration interfaces = null;

        try {
            interfaces = NetworkInterface.getNetworkInterfaces();
        } catch (SocketException var4) {
            var4.printStackTrace();
            return null;
        }

        while (interfaces.hasMoreElements()) {
            NetworkInterface ifc = (NetworkInterface) interfaces.nextElement();
            Enumeration addressesOfAnInterface = ifc.getInetAddresses();

            while (addressesOfAnInterface.hasMoreElements()) {
                InetAddress address = (InetAddress) addressesOfAnInterface.nextElement();
                if (address.isSiteLocalAddress()) {
                    return address.getHostAddress();
                }
            }
        }
        try {
            String ip = InetAddress.getLocalHost().getHostAddress();
            return ip;
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

        return null;
    }
}