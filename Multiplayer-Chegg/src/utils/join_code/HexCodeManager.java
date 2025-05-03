package utils.join_code;

public abstract class HexCodeManager {

    static String shortToHexString(short s) {

        StringBuilder hex = new StringBuilder(Integer.toHexString(s - Short.MIN_VALUE));

        while (hex.length() < 4)
            hex.insert(0, "0");

        return hex.toString();
    }

    static short hexStringToShort(String hex) {
        return (short) (Integer.parseInt(hex, 16) + Short.MIN_VALUE);
    }



    static String byteToHexString(byte b) {

        String hex = Integer.toHexString(b - Byte.MIN_VALUE);
        if (hex.length() == 1)
            hex = "0" + hex;

        return hex;
    }

    static byte hexStringToByte(String hex) {

        return (byte) (Integer.parseInt(hex, 16) - Byte.MIN_VALUE);
    }

}
