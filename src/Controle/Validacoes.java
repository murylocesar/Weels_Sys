/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import java.awt.HeadlessException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import javax.swing.JOptionPane;

/**
 *
 * @author Murylo César Souza
 */
public class Validacoes {

    // Metados e conversao de DATAs (StringDate ou DateToString)
    public java.util.Date formDataStrToData(String data) {

        /*função de conversão de uma data do tipo String dd/MM/yyyy
         para formato date do java.util
         */
        java.util.Date formatoIso = null;

        try {
            //define o formato da data
            DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
            java.util.Date bd = df.parse(data);
            formatoIso = new Date(bd.getTime());
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(null, "Erro no formato de data\n\n" + ex);
        }
        return formatoIso;
    }

    public String formDataDateToStr(java.util.Date data) {

        /*função para conversão do compo DATE do java.util
         para dd/MM/yyyy utilizado nos campos jxDate
         */
        SimpleDateFormat formatoBra = new SimpleDateFormat("dd/MM/yyyy");
        return formatoBra.format(data);
    }

    public String incrementarData(String DataStr, int dd, int MM, int yyyy) {

        try {
            java.util.Date data = new Date(new SimpleDateFormat("dd/MM/yyyy").parse(DataStr).getTime());

            //retonar em formato Date
//            return new Date(new SimpleDateFormat("dd/MM/yyyy").parse(new SimpleDateFormat("dd/MM/yyyy").format(new GregorianCalendar(Integer.parseInt(new SimpleDateFormat("yyyy").format(data)) + yyyy,
//                    Integer.parseInt(new SimpleDateFormat("MM").format(data)) - 1 + MM, Integer.parseInt(new SimpleDateFormat("dd").format(data)) + dd).getTime())).getTime());
//
            //retonar em formato String
            return new SimpleDateFormat("dd/MM/yyyy").format(new GregorianCalendar(Integer.parseInt(new SimpleDateFormat("yyyy").format(data)) + yyyy,
                    Integer.parseInt(new SimpleDateFormat("MM").format(data)) - 1 + MM, Integer.parseInt(new SimpleDateFormat("dd").format(data)) + dd).getTime());

        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(null, "Erro no formato de data\n\n" + ex);
            return null;
        }
    }

    public boolean Data_Bloqueio(String data) {//Verificado de data

        try {
            Date formatoIso = new Date(new SimpleDateFormat("dd/MM/yyyy").parse(data).getTime());

            return (((Integer.parseInt(new SimpleDateFormat("yyyy").format(formatoIso)) <= Integer.parseInt(new SimpleDateFormat("yyyy").format(new java.util.Date()))) && (Integer.parseInt(new SimpleDateFormat("MM").format(formatoIso)) <= Integer.parseInt(new SimpleDateFormat("MM").format(new java.util.Date()))) && (Integer.parseInt(new SimpleDateFormat("dd").format(formatoIso)) <= Integer.parseInt(new SimpleDateFormat("dd").format(new java.util.Date()))))
                    || ((Integer.parseInt(new SimpleDateFormat("MM").format(formatoIso)) < Integer.parseInt(new SimpleDateFormat("MM").format(new java.util.Date()))) && (Integer.parseInt(new SimpleDateFormat("yyyy").format(formatoIso)) <= Integer.parseInt(new SimpleDateFormat("yyyy").format(new java.util.Date())))) || (Integer.parseInt(new SimpleDateFormat("yyyy").format(formatoIso)) < Integer.parseInt(new SimpleDateFormat("yyyy").format(new java.util.Date()))));

        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(null, "Erro no formato de data\n\n" + ex);
        }
        return false;
    }

    public static String Criptografia(String criptografia) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            BigInteger hash = new BigInteger(1, md.digest(criptografia.getBytes()));
            return String.format("%32x", hash);
        } catch (NoSuchAlgorithmException ex) {
            JOptionPane.showConfirmDialog(null, "Erro ao criptografa\n\n" + ex, "Erro", JOptionPane.ERROR);
        }
        return criptografia;
    }

    public boolean ValidarDDDbr(String fone) {
        ////////////////////////////////DDD Brasileiro/////////////////////////////
        int[] DDD = {11, 12, 13, 14, 15, 16, 17, 18, 19, 21, 22, 24, 27, 28, 31, 32,
            33, 34, 35, 37, 38, 41, 42, 43, 44, 45, 46, 47, 48, 49, 51, 53, 54, 55,
            61, 62, 63, 64, 65, 66, 67, 68, 69, 71, 73, 74, 75, 77, 79, 81, 82, 83,
            84, 85, 86, 87, 88, 89, 91, 92, 93, 94, 95, 96, 97, 98, 99};

        for (int i = 0; i < DDD.length; ++i) {
            if (("(" + String.valueOf(DDD[i]) + ")").equals(fone.split("( )")[0])) {
                return true;
            }
        }
        return false;
    }

    public boolean Validar_Email(String Email_Validar) {

        int ok = 0;
        for (int n = 0; n < Email_Validar.length() - 1; n++) {
            if (((Email_Validar.startsWith("@", n)) && (ok == 0)) || ((Email_Validar.startsWith(".", n)) && (ok > 0))) {
                ok++;
            }
        }
        return (ok > 1) || ("".equals(Email_Validar));
    }

    public static boolean ValidarCNPJ(String CNPJ) {
        return !(CNPJ.equals("__.___.___/____-__") || CNPJ.equals("00.000.000/0000-00") || CNPJ.equals("11.111.111/1111-11") || CNPJ.equals("22.222.222/2222-22")
                || CNPJ.equals("33.333.333/3333-33") || CNPJ.equals("44.444.444/4444-44") || CNPJ.equals("55.555.555/5555-55")
                || CNPJ.equals("66.666.666/6666-66") || CNPJ.equals("77.777.777/7777-77")
                || CNPJ.equals("88.888.888/8888-88") || CNPJ.equals("99.999.999/9999-99"));
    }

    public static boolean ValidarCPF(String CPF) {
        return !(CPF.equals("___.___.___-__") || CPF.equals("000.000.000-00") || CPF.equals("111.111.111-22") || CPF.equals("222.222.222-22")
                || CPF.equals("333.333.333-33") || CPF.equals("444.444.444-44") || CPF.equals("555.555.555-55")
                || CPF.equals("666.666.666-66") || CPF.equals("777.777.777-77")
                || CPF.equals("888.888.888-88") || CPF.equals("999.999.999-99"));
    }

    public boolean ValidarNome(String Nome) {

        char[] validarNome = Nome.toCharArray();
        int ok = 0;
        for (int n = 0; n < Nome.length(); n++) {
            if (validarNome[n] == ' ') {
                ok++;
            }
        }
        return !(ok == Nome.length());
    }

    public String Lucro_Veiculo_Entrada(String Valor_pago, String LucroAdicional, float Lucro) {

        Valor_pago = Valor_pago.replaceAll("\\.", "").replaceAll(",", ".").replaceAll("\\..", ".").replaceAll("\\..", ".").replaceAll("\\..", ".");

        LucroAdicional = LucroAdicional.replaceAll("\\.", "").replaceAll(",", ".").replaceAll("\\..", ".").replaceAll("\\..", ".").replaceAll("\\..", ".");

        try {
            if (("".equals(String.valueOf(Valor_pago))) && ("".equals(String.valueOf(LucroAdicional)))) {
                return "0";

            } else if (("".equals(String.valueOf(Valor_pago))) && (!"".equals(String.valueOf(LucroAdicional)))) {

                return String.valueOf(((Float.valueOf(LucroAdicional))));

            } else if ((!"".equals(String.valueOf(Valor_pago))) && (!"".equals(String.valueOf(LucroAdicional)))) {

                return String.valueOf((Float.valueOf(LucroAdicional) + Float.valueOf(Valor_pago) + ((Float.valueOf(Valor_pago) * Lucro))));
            } else {
                return String.valueOf((Float.valueOf(Valor_pago) + ((Float.valueOf(Valor_pago) * Lucro))));
            }

        } catch (HeadlessException | NumberFormatException ex) {
            return "";
        }
    }

    public boolean chassi(String text) {
        int numero = 0, letra = 0;
        text = text.replace(" ", "");
        char[] Erro = text.toCharArray();
        if (!("".equals(text) || (text.length() != 17))) {

            for (int n = text.length() - 1; n > -1; n--) {
                if ((Erro[n] == 'O') || (Erro[n] == 'I') || (Erro[n] == 'Q')) {
                    return false;
                }
                if ((Erro[n] == '0') || (Erro[n] == '1') || (Erro[n] == '2') || (Erro[n] == '3') || (Erro[n] == '4')
                        || (Erro[n] == '5') || (Erro[n] == '6') || (Erro[n] == '7') || (Erro[n] == '8') || (Erro[n] == '9')) {
                    numero++;
                } else if ((Erro[n] == 'A') || (Erro[n] == 'B') || (Erro[n] == 'C') || (Erro[n] == 'D') || (Erro[n] == 'E') || (Erro[n] == 'F') || (Erro[n] == 'G')
                        || (Erro[n] == 'H') || (Erro[n] == 'I') || (Erro[n] == 'J') || (Erro[n] == 'K') || (Erro[n] == 'L') || (Erro[n] == 'M')
                        || (Erro[n] == 'D') || (Erro[n] == 'N') || (Erro[n] == 'P') || (Erro[n] == 'R') || (Erro[n] == 'S') || (Erro[n] == 'T')
                        || (Erro[n] == 'U') || (Erro[n] == 'V') || (Erro[n] == 'W') || (Erro[n] == 'X') || (Erro[n] == 'Y') || (Erro[n] == 'Z')) {
                    letra++;
                }
            }
        }
        return (((numero <= 12) && (letra <= 12))) && (!("".equals(text) || (text.length() != 17)));
    }

    public String[] preencherCampo(String campo) {
        if ("Moto".equals(campo)) {
            return new String[]{"HONDA", "KAWASAKI", "SUZUKI", "YAMAHA"};
        } else if ("Automovel".equals(campo)) {
            return new String[]{"AUDI", "CHEVROLET", "FIAT", "FORD", "HYUNDAI", "MERCEDES_BENZ", "NISSAN", "TOYOTA", "VOLKSWAGEN", "VOLVO"};
        } else if ("Micro/Ônibus".equals(campo)) {
            return new String[]{"COMIL", "IRIZAR", "EVECO", "MARCOPOLO", "MERCEDES_BENZ", "NEOBUS", "RENAULT", "TOYOTA", "VOLKSWAGEN", "VOLVO"};
        } else if ("Caminhão".equals(campo)) {
            return new String[]{"AUDI", "CHEVROLET", "HYUNDAI", "MERCEDES_BENZ", "NISSAN", "SCANIA", "TOYOTA", "VOLKSWAGEN", "VOLVO"};
        }
        return null;
    }

    public String preencherFoto(String campo) {

        if ("HONDA".equals(campo)) {
            return "/Imagens/HONDA.jpg";

        } else if ("KAWASAKI".equals(campo)) {
            return "/Imagens/KAWASAKI.jpg";

        } else if ("SUZUKI".equals(campo)) {
            return "/Imagens/SUZUKI.jpg";

        } else if ("YAMAHA".equals(campo)) {
            return "/Imagens/YAMAHA.jpg";

        } else if ("AUDI".equals(campo)) {
            return "/Imagens/AUDI.jpg";

        } else if ("CHEVROLET".equals(campo)) {
            return "/Imagens/CHEVROLET.jpg";

        } else if ("FIAT".equals(campo)) {
            return "/Imagens/FIAT.jpg";

        } else if ("FORD".equals(campo)) {
            return "/Imagens/FORD.jpg";

        } else if ("HYUNDAI".equals(campo)) {
            return "/Imagens/HYUNDAI.jpg";

        } else if ("MERCEDES_BENZ".equals(campo)) {
            return "/Imagens/MERCEDES_BENZ.png";

        } else if ("NISSAN".equals(campo)) {
            return "/Imagens/NISSAN.jpg";

        } else if ("TOYOTA".equals(campo)) {
            return "/Imagens/TOYOTA.jpg";

        } else if ("VOLKSWAGEN".equals(campo)) {
            return "/Imagens/VOLKSWAGEN.jpg";

        } else if ("VOLVO".equals(campo)) {
            return "/Imagens/VOLVO.jpg";

        } else if ("AGRAVE".equals(campo)) {
            return "/Imagens/AGRAVE.jpg";

        } else if ("COMIL".equals(campo)) {
            return "/Imagens/COMIL.jpg";

        } else if ("IRIZAR".equals(campo)) {
            return "/Imagens/IRIZAR.jpg";

        } else if ("EVECO".equals(campo)) {
            return "/Imagens/EVECO.jpg";

        } else if ("MARCOPOLO".equals(campo)) {
            return "/Imagens/MARCOPOLO.jpg";

        } else if ("NEOBUS".equals(campo)) {
            return "/Imagens/NEOBUS.jpg";

        } else if ("RENAULT".equals(campo)) {
            return "/Imagens/RENAULT.jpg";

        } else if ("SCANIA".equals(campo)) {
            return "/Imagens/SCANIA.png";
        } else {
            JOptionPane.showMessageDialog(null, "Imagens da marca '" + campo + "' não existe encontrada no sistema", "Erro", JOptionPane.ERROR_MESSAGE);
        }
        return null;
    }
}
