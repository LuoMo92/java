package com.luomo.java.concurrent;

/**
 * @author LiuMei
 * @date 2019/5/16 0016
 */
public final class Router {

    private final String ip;

    private final Integer port;

    private final String iface;

    public Router(String ip, Integer port, String iface) {
        this.ip = ip;
        this.port = port;
        this.iface = iface;
    }

    @Override
    public boolean equals(Object obj) {

        if (obj instanceof Router) {
            Router r = (Router) obj;
            return iface.equals(r.iface) && ip.equals(r.ip) && port.equals(r.ip);
        }
        return false;
    }

    public String getIface() {
        return iface;
    }
}
