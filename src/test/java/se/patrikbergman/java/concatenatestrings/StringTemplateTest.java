package se.patrikbergman.java.concatenatestrings;

import org.junit.Test;
import org.stringtemplate.v4.ST;

public class StringTemplateTest {

    @Test
    public void test() {
        ST hello = new ST("Hello, <name>!");
        hello.add("name", "World");
        String output = hello.render();
        System.out.println(output);
    }

    @Test
    public void getNodeLoginUrl() {
        Node node = new Node("99.99.99.99", 80, "root", "root");
        ST loginPath = new ST("http://<ipaddress>:<port>/getLogin.asp?userName=<username>&password=<password>&oneTimeLogin=false");
        loginPath.add("ipaddress", node.getIpAddress());
        loginPath.add("port", node.getPort());
        loginPath.add("username", node.getUserName());
        loginPath.add("password", node.getPassword());
        System.out.println(loginPath.render());
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
