package br.gov.caixa.sigcb.util;

public class TPC {
    static {
        System.loadLibrary("TPC");
    }

    public native String RANBBPWN(String string, String string_0_, int i);

    public static String encriptar(String string, String string_1_, int i)
            throws Exception {
        String string_2_ = "";
        try {
            string_2_ = new TPC().RANBBPWN(string, string_1_, i);
        } catch (IllegalArgumentException illegalargumentexception) {
            int i_3_ = Integer.parseInt(illegalargumentexception.getMessage());
            switch (i_3_) {
            case 1403:
                throw new Exception("1403");
            case 1404:
                throw new Exception("1404");
            case 1405:
                throw new Exception("1405");
            }
        }
        return string_2_;
    }
}
