package se.patrikbergman.java.switchcase;

class SwitchCaseApp {

    String convertInttoString(int input) {
        switch (input) {
            case 0:
                return "0";
            case 1:
//                return "1";
            case 2:
//                return "2";
            case 3:
//                return "3";
            default:
                return "Case not found";

        }
    }

    public static void main(String args[]) {
        SwitchCaseApp switchCaseApp = new SwitchCaseApp();
        System.out.println(switchCaseApp.convertInttoString(3));
    }

}
