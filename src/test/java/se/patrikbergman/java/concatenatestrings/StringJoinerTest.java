package se.patrikbergman.java.concatenatestrings;

import org.junit.Test;

import java.util.StringJoiner;

public class StringJoinerTest {

    @Test
    public void stringJoin() {
        String result = String.join(" ", "hej", "alla", "glada");
        System.out.println(result);
    }

    @Test
    public void stringJoiner() {
        String result = new StringJoiner(" ")
        .add("hej")
        .add("alla")
        .add("glada")
        .toString();
        System.out.println(result);
    }

    @Test
    public void getNodeLoginUrl() {
        Node node = new Node("99.99.99.99", 80, "root", "root");

        String loginPath = new StringJoiner("")
                .add("/getLogin.asp?userName=")
                .add(node.getUserName())
                .add("&password=")
                .add(node.getPassword())
                .add("&oneTimeLogin=false")
                .toString();
        String loginUrl = new StringJoiner("")
                .add("http://")
                .add(node.getIpAddress())
                .add(":")
                .add(Integer.toString(node.getPort()))
                .add(loginPath)
                .toString();
        System.out.println(loginUrl);
    }

    class Node {
        private final String ipAddress;
        private final int port;
        private final String userName;
        private final String password;

        Node(String ipAddress, int port, String userName, String password) {
            this.ipAddress = ipAddress;
            this.port = port;
            this.userName = userName;
            this.password = password;
        }

        public String getIpAddress() {
            return ipAddress;
        }

        public int getPort() {
            return port;
        }

        public String getUserName() {
            return userName;
        }

        public String getPassword() {
            return password;
        }
    }
}
