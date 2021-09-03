class exResolvido1 {
  public static char toUpper(char c) {
    return (c >= 'a' && c <= 'z') ? ((char) (c - 32)) : c;
  }

  public static boolean isVogal(char c) {
    c = toUpper(c);
    return (c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U');
  }

  public static boolean isConsoante(String s, int n) {
    boolean resp = true;
    if (n != s.length()) {
      if(s.charAt(n) >= '0' && s.charAt(n) <= '9'){
        resp = false;
      } else {
        if (isVogal(s.charAt(n)) == true) {
          resp = false;
        } else {
          resp = isConsoante(s, n + 1);
        }
      }
    }
    return resp;
  }

  public static void main(String[] args) {
    MyIO.println(isConsoante("aeiou", 0));
    MyIO.println(isConsoante("bcdfg", 0));
    MyIO.println(isConsoante("abcdf", 0));
    MyIO.println(isConsoante("01234", 0));
  }
}
