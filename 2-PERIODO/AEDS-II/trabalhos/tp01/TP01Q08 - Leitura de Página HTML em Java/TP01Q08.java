import java.io.*;
import java.net.*;

class TP01Q08 {
  public static boolean isFim(String s){
    return (s.length() == 3 && s.charAt(0) == 'F' && s.charAt(1) == 'I' && s.charAt(2) == 'M');
  }

  public static String getHtml(String endereco){
    URL url;
    InputStream is = null;
    BufferedReader br;
    String resp = "", line;

    try {
       url = new URL(endereco);
       is = url.openStream();  // throws an IOException
       br = new BufferedReader(new InputStreamReader(is));
       while ((line = br.readLine()) != null) {
          resp += line + "\n"; // lê o html linha por linha e salva na string
       }
    } catch (MalformedURLException mue) {
       mue.printStackTrace();
    } catch (IOException ioe) {
       ioe.printStackTrace();
    } 

    try {
       is.close();
    } catch (IOException ioe) {
       // Captura erro
    }

    return resp;
  }

  public static String parser(String nome, String link) {
    String html = getHtml(link);
    int[] resp = new int[25];
    for (int i = 0; i < 25; i++) {
      resp[i] = 0; // zerando os valores do array
    }
    /* 
      Posições no array resp:
      a - 0; e - 1; i - 2; o - 3; u - 4;
      á - 5; é - 6; í - 7; ó - 8; ú - 9;
      à - 10; è - 11; ì - 12; ò - 13; ù - 14;
      ã - 15; õ - 16;
      â - 17; ê - 18; î - 19; ô - 20; û - 21;
      consoante - 22;
      <br> - 23;
      <table> - 24;
    */

    for (int i = 0; i < html.length(); i++) {
      if (html.charAt(i) == '<') {
          if (html.charAt(i + 1) == 'b' && html.charAt(i + 2) == 'r' && html.charAt(i + 3) == '>') {
            resp[23]++; // <br>
            i += 4;
          } else if (html.charAt(i+1) == 't' && html.charAt(i+2) == 'a' && html.charAt(i+3) == 'b' &&
                     html.charAt(i+4) == 'l' && html.charAt(i+5) == 'e' && html.charAt(i+6) == '>' ) {
            resp[24]++; // <table>
            i += 7;
          }
      } else {
        if (html.charAt(i) == 97) {
          resp[0]++; // a
        } else if (html.charAt(i) == 101) {
          resp[1]++; // e
        } else if (html.charAt(i) == 105) {
          resp[2]++; // i
        } else if (html.charAt(i) == 111) {
          resp[3]++; // o
        } else if (html.charAt(i) == 117) {
          resp[4]++; // u
        } else if (html.charAt(i) == 225) {
          resp[5]++; // á
        } else if (html.charAt(i) == 233) {
          resp[6]++; // é
        } else if (html.charAt(i) == 237) {
          resp[7]++; // í
        } else if (html.charAt(i) == 243) {
          resp[8]++; // ó
        } else if (html.charAt(i) == 250) {
          resp[9]++; // ú
        } else if (html.charAt(i) == 224) {
          resp[10]++; // à
        } else if (html.charAt(i) == 232) {
          resp[11]++; // è
        } else if (html.charAt(i) == 236) {
          resp[12]++; // ì
        } else if (html.charAt(i) == 242) {
          resp[13]++; // ò
        } else if (html.charAt(i) == 249) {
          resp[14]++; // ù
        } else if (html.charAt(i) == 227) {
          resp[15]++; // ã
        } else if (html.charAt(i) == 245) {
          resp[16]++; // õ
        } else if (html.charAt(i) == 226) {
          resp[17]++; // â
        } else if (html.charAt(i) == 234) {
          resp[18]++; // ê
        } else if (html.charAt(i) == 238) {
          resp[19]++; // î
        } else if (html.charAt(i) == 244) {
          resp[20]++; // ô
        } else if (html.charAt(i) == 251) {
          resp[21]++; // û
        } else if (html.charAt(i) >= 98 && html.charAt(i) <= 122) {
          resp[22]++; // consoantes
        }
      }
    }

    // Criando string de resposta;
    String resposta = "";
    resposta += "a(" + resp[0] + ") "
    + "e(" + resp[1] + ") "
    + "i(" + resp[2] + ") "
    + "o(" + resp[3] + ") "
    + "u(" + resp[4] + ") "
    + "á(" + resp[5] + ") "
    + "é(" + resp[6] + ") "
    + "í(" + resp[7] + ") "
    + "ó(" + resp[8] + ") "
    + "ú(" + resp[9] + ") "
    + "à(" + resp[10] + ") "
    + "è(" + resp[11] + ") "
    + "ì(" + resp[12] + ") "
    + "ò(" + resp[13] + ") "
    + "ù(" + resp[14] + ") "
    + "ã(" + resp[15] + ") "
    + "õ(" + resp[16] + ") "
    + "â(" + resp[17] + ") "
    + "ê(" + resp[18] + ") "
    + "î(" + resp[19] + ") "
    + "ô(" + resp[20] + ") "
    + "û(" + resp[21] + ") "
    + "consoante(" + resp[22] + ") "
    + "<br>(" + resp[23] + ") "
    + "<table>(" + resp[24] + ") "
    + nome;

    return resposta;    
  }

  public static void main(String[] args){
    String[] entrada = new String[1000];
    int numEntrada = 0;
    //MyIO.setCharset("UTF-8");

    //Leitura da entrada padrao
    do {
      entrada[numEntrada] = MyIO.readLine();
    } while (isFim(entrada[numEntrada++]) == false);
    numEntrada--;   //Desconsiderar ultima linha contendo a palavra FIM

    //Para cada linha de entrada, gerando uma de saida contendo o numero de letras maiusculas da entrada
    for(int i = 0; i < numEntrada; i += 2){
      MyIO.println(parser(entrada[i], entrada[i + 1]));
    }
  }
}
