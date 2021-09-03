class exResolvido2 {
  public static char toUpper(char c) {
    return (c >= 'a' && c <= 'z') ? ((char) (c - 32)) : c;
  }

  public static boolean isVogal(char c) {
    c = toUpper(c);
    return (c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U');
  }

  public static boolean isConsoante(String s, int i) {
    boolean resp = true;
    if (i == s.length()) {
      resp = true;
    } else if (isVogal(s.charAt(i)) || (s.charAt(i) >= '0' && s.charAt(i) <= '9')) {
      resp = false;
    } else {
      resp = isConsoante(s, i + 1);
    }

    return resp;
  }

  public static void main(String[] args) {
    MyIO.println(isConsoante("aeiou", 0));
    MyIO.println(isConsoante("bcdfg", 0));
    MyIO.println(isConsoante("abcdf", 0));
    MyIO.println(isConsoante("01234", 0));



    byte b = 0; short s = 0; int i = 0; long l = 0;
    while (true) {
      b++; s++; i++; l++;
        System.out.println(b + " " + s + " " + i + " " + l);
    }
  }
}
