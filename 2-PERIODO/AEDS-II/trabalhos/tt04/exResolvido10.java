void questaoA(int n, int a, int b, int c) {
  for (int i = 0; i < n; i++) {
    a--; b--; c--;
    for (int j = 0; j < n; j++) {
      a--; b--;
    }
  }
}

void questaoB(int n, int a, int b, int c, int d) {
  for (int i = 0; i < n; i++) {
    int e = 5;
    while (e < 0) {
      e--;
    } 
    for (int j = 0; j < n; j++) {
      for (int k = 0; k < n; k++) {
        a--;
        b--;
        c--;
        d--;
      }
    }
  }
}

void questaoC(int n, int a) {
  int b = n;
  while (i > 1) {
    i--;
  }
  for (int i = n; i > 0; i /= 2) {
    a--;
  }
}

void questaoD(int n, int a, int b) {
  int i = 5;
  while (i > 0) {
    i--;
  }

  for (int i = 0; i < n; i++) {
    for (int j = 0; j < n; j++) {
      for (int k = 0; k < n; k++) {
        a--;
        b--;
      }
    }
  }
}

void questaoE(int n, int c) {

  for (int i = 0; i < n; i++) {
    if (i % 2 == 0) {
      c--; 
    }
    for (int j = 0; j < n; j++) {
      int b = 5;
      while (b > 0) {
        b--;
      }
      for (int k = 0; k < n; k++) {
        for (int w = 0; w < n; w++) {
          int a = 9;
          while (a > 0) {
            a--;
          }
        }
      }
    }
  }
}

void questaoF(int n, int b) {
  int a = 6;
  while (a > 0) {
    for (int i = n; i > 0; i /= 2) {
      b--
    }
  }
}
