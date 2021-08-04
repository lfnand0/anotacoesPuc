#include "utils.h"

int PLAYER_ID = 1;
//humanos

class Personagem {
  private:
    int player;
    int hp;
    int max_hp;
    int mana;
    int max_mana;
    int forca_fisica;
    int forca_magica;
    int res_fisica;
    int res_magica;
    int agilidade;
    
    int classe;
    // Guerreiro = 0;
    // Ladrão = 1;
    // Mago = 2;
    // Paladino = 3;
    // Animal = 4
    // Troll = 5;
    // Dragão = 6;
    // Zumbi = 7;

    std::string nome_classe[8] = {"Guerreiro", "Ladrão", "Mago", "Paladino", "Animal", "Troll", "Dragão", "Zumbi"};
    int atributos[8][7] = {
      {4000, 30, 100, 20, 80, 20, 20},
      {2800, 50, 50, 30, 40, 50, 80},
      {2500, 100, 40, 100, 30, 80, 40},
      {3200, 80, 60, 50, 60, 60, 60},

      {3200, 30, 80, 20, 80, 20, 50},
      {2800, 20, 100, 20, 80, 20, 20},
      {3000, 40, 100, 20, 50, 50, 30},
      {2500, 20, 40, 20, 40, 80, 50},
    };

    // ARMAS
    std::string nome_armas[7] = {"Garra Letal", "Tridente Sagrado", "Espada Barroca", "Porrete", "Cajado", "Besta", "Esfera de Ataque"};
    int armas[8][7] = {
      {2, 3, -1, -1, -1, -1, -1}, // Guerreiro
      {3, 4, 5, 6, -1, -1, -1},
      {1, 4, -1, -1, -1, -1, -1},
      {1, 5, -1, -1, -1, -1, -1},
      {0, -1, -1, -1, -1, -1, -1},
      {3, 4, -1, -1, -1, -1, -1},
      {0, -1, -1, -1, -1, -1, -1},
      {0, 3, 4, -1, -1, -1, -1},
    };
    int armas_min[7] = {100, 220, 300, 180, 50, 220, 200};
    int armas_max[7] = {300, 420, 500, 380, 200, 420, 400};
    int arma_atual;


    // MAGIAS
    std::string nome_magias[5] = {"Hálito de Fogo", "Bio", "Flama Gelada", "Intoxicação", "Tempestade"};
    int magias[8][5] = {
      {4, -1, -1, -1, -1},  // Guerreiro
      {3, 4, -1, -1, -1},   // Ladrão
      {1, 2, 3, 4, -1},     // Mago
      {2, 4, -1, -1, -1},   // Paladino
      {1, -1, -1, -1, -1},  // Animal
      {3, -1, -1, -1, -1},   // Troll
      {0, -1, -1, -1, -1},  // Dragão
      {3,-1, -1 -1, -1},    // Zumbi
    };
    int magias_dano[5] = {400, 360, 320, 280, 200};
    int magias_custo[5] = {12, 14, 14, 12, 12};
    int quant_magias;
  public:  

    Personagem(int Classe) {
      this->player = PLAYER_ID;
      PLAYER_ID == 1 ? PLAYER_ID++ : PLAYER_ID = 1;
      this->classe = Classe;
      this->hp = atributos[Classe][0];
      this->max_hp = atributos[Classe][0];
      this->mana = atributos[Classe][1];
      this->max_mana = atributos[Classe][1];
      this->forca_fisica = atributos[Classe][2];
      this->forca_magica = atributos[Classe][3];
      this->res_fisica = atributos[Classe][4];
      this->res_magica = atributos[Classe][5];
      this->agilidade = atributos[Classe][6];

      int menor_indice = armas[Classe][0];
      for (int i = 1; i < sizeof(armas[Classe])/sizeof(armas[Classe][0]) && armas[Classe][i] != -1; i++) {
        if (armas_min[armas[Classe][i]] < armas_min[menor_indice])
          menor_indice = armas[Classe][i];
      }
      this->arma_atual = menor_indice;

      int contador = 0;
      while (magias[classe][contador] != -1) {
        contador++;
      }
      this->quant_magias = contador;
    };

    int getHp() {
      return hp;
    };

    int getAgilidade() {
      return agilidade;
    }

    int getRes_fisica() {
      return res_fisica;
    }

    int getPlayer() {
      return player;
    }

    std::string getArma() {
      return nome_armas[arma_atual];
    }

    void levarDanoFisico(int dano, Personagem *p) {
      int esquiva = dado(100, 1);
      if (esquiva > agilidade) {
        dano *= res_fisica / 100;
        if (hp - dano < 0) {
          hp = 0;
          std::cout << "HIT! O Player " << player << " recebeu " << dano << " de dano e morreu! :(" << std::endl;
        } else {
          hp -= dano;
          std::cout << "HIT! O Player " << player << " recebeu " << dano << " de dano do Player" << p->getPlayer() << " e agora está com " << hp << "HP." << std::endl;
        }
      } else {
        std::cout << "ESQUIVA! O Player" << player << " se esquivou do ataque do Player" << p->getPlayer() << std::endl;
      }
    };

    void levarDanoMagico(int dano) {
      int esquiva = dado(100, 1);
      if (esquiva > agilidade) {
        if (hp - dano < 0) {
          hp = 0;
        } else {
          hp -= dano * res_magica/100;
        }
      }
    };

    void causarDanoFisico(Personagem *p) {
      int dano = dado(armas_max[arma_atual], armas_min[arma_atual]);
      dano *= (forca_fisica/100.0 + 1);

      p->levarDanoFisico(dano, this);
    }

    void uparArma() {
      int menor_indice = armas[classe][0];
      if (menor_indice == arma_atual) {
        menor_indice = armas[classe][1];
      }
      for (int i = 1; i < sizeof(armas[classe])/sizeof(armas[classe][0]) && armas[classe][i] != -1; i++) {
        if (armas_min[armas[classe][i]] < armas_min[menor_indice] && armas[classe][i] != arma_atual) {
          menor_indice = armas[classe][i];
        }
      }
      this->arma_atual = menor_indice;
    }

    void printarStats() {
      printf("\n-----STATS-----\n");
      printf("HP Máximo: %d\n", max_hp);
      printf("HP Atual: %d\n", hp);
      printf("Mana: %d\n", mana);
      std::cout << "Classe: " << nome_classe[classe] << std::endl;
      std::cout << "Arma Atual: " << arma_atual << std::endl;
      printf("Magias: ");
      for (int i = 0; i < quant_magias; i++) {
        std::cout << nome_magias[magias[classe][i]];
        printf(", ");
      };
    };

    ~Personagem(){};
};


// class Guerreiro : public Personagem {
//   protected:
//     int max_hp;
//     int forca_fisica;
//     int forca_magica;
//     int res_fisica;
//     int res_magica;
//     int agilidade;
//     int hp;
//     int mana;

//   public:
//     int armas[8][7];
    
//     Guerreiro(){
//       this->max_hp = 4000;
//       this->forca_fisica = 100;
//       this->forca_magica = 20;
//       this->res_fisica = 80;
//       this->res_magica = 20;
//       this->agilidade = 20;
//       this->hp = 4000;
//       this->mana = 30;

//       int menor_indice = armas[0];
//       for (int i = 1; i < sizeof(armas)/sizeof(armas[0]); i++) {
//         if (armas_min[armas[i]] < armas_min[menor_indice])
//           menor_indice = armas[i];
//       }
//       arma_atual = menor_indice;
//     };

//     int getHp() override {
//       return hp;
//     };

//     void levarDanoFisico(int dano) override {
//       int esquiva = dado(100, 1);
//       if (esquiva > agilidade) {
//         if (hp - dano < 0) {
//           hp = 0;
//         } else {
//           hp -= dano * res_fisica / 100;
//         }
//       }
//     };

//     void levarDanoMagico(int dano) override {
//       int esquiva = dado(100, 1);
//       if (esquiva > agilidade) {
//         if (hp - dano < 0) {
//           hp = 0;
//         } else {
//           hp -= dano * res_magica/100;
//         }
//       }
//     };

//     int causarDanoFisico() override {
//       int dano = dado(armas_max[arma_atual], armas_min[arma_atual]);
//       dano *= (forca_fisica/100.0 + 1);
//       return dano;
//     }

//     ~Guerreiro(){};
// };
// class Ladrao {
//   private:
//     int max_hp = 2800;
//     int forca_fisica = 50;
//     int forca_magica = 30;
//     int res_fisica = 40;
//     int res_magica = 50;
//     int agilidade = 80;
//     std::string nome_armas[7] = {"Garra Letal", "Tridente Sagrado", "Espada Barroca", "Porrete", "Cajado", "Besta", "Esfera de Ataque"};
//     int armas_min[7] = {100, 220, 300, 180, 50, 220, 200};
//     int armas_max[7] = {300, 420, 500, 380, 200, 420, 400};
//     int armas[2] = {2, 3};
//     int arma_atual;

//   public:
//     int hp = 2800;
//     int mana = 50;
//     Ladrao(){
//       int menor_indice = armas[0];
//       for (int i = 1; i < sizeof(armas)/sizeof(armas[0]); i++) {
//         if (armas_min[armas[i]] < armas_min[menor_indice])
//           menor_indice = armas[i];
//       }
//       arma_atual = menor_indice;
//     };
//     void levarDanoFisico(int dano) {
//       int esquiva = dado(100, 1);
//       if (esquiva > agilidade) {
//         if (hp - dano < 0) {
//           hp = 0;
//         } else {
//           hp -= dano * res_fisica / 100;
//         }
//       }
//     };

//     void levarDanoMagico(int dano) {
//       int esquiva = dado(100, 1);
//       if (esquiva > agilidade) {
//         if (hp - dano < 0) {
//           hp = 0;
//         } else {
//           hp -= dano * res_magica/100;
//         }
//       }
//     };

//     void printarStats() {
//       printf("%d\n", hp);
//     }
//     ~Ladrao(){};
// };
// class Mago {
//   private:
//     int max_hp = 2500;
//     int forca_fisica = 40;
//     int forca_magica = 100;
//     int res_fisica = 30;
//     int res_magica = 80;
//     int agilidade = 40;

//   public:
//     int hp = 2500;
//     int mana = 100;
//     std::string nome_armas[7] = {"Garra Letal", "Tridente Sagrado", "Espada Barroca", "Porrete", "Cajado", "Besta", "Esfera de Ataque"};
//     int armas_min[7] = {100, 220, 300, 180, 50, 220, 200};
//     int armas_max[7] = {300, 420, 500, 380, 200, 420, 400};
//     int armas[2] = {2, 3};
//     int arma_atual;

//     Mago(){
//       int menor_indice = armas[0];
//       for (int i = 1; i < sizeof(armas)/sizeof(armas[0]); i++) {
//         if (armas_min[armas[i]] < armas_min[menor_indice])
//           menor_indice = armas[i];
//       }
//       arma_atual = menor_indice;
//     };
//     void levarDanoFisico(int dano) {
//       int esquiva = dado(100, 1);
//       if (esquiva > agilidade) {
//         if (hp - dano < 0) {
//           hp = 0;
//         } else {
//           hp -= dano * res_fisica / 100;
//         }
//       }
//     };

//     void levarDanoMagico(int dano) {
//       int esquiva = dado(100, 1);
//       if (esquiva > agilidade) {
//         if (hp - dano < 0) {
//           hp = 0;
//         } else {
//           hp -= dano * res_magica/100;
//         }
//       }
//     };

//     void printarStats() {
//       printf("%d\n", hp);
//     }
//     ~Mago(){};
// };
// class Paladino {
//   private:
//     int max_hp = 3200;
//     int forca_fisica = 60;
//     int forca_magica = 50;
//     int res_fisica = 60;
//     int res_magica = 60;
//     int agilidade = 60;

//   public:
//     int hp = 3200;
//     int mana = 80;
//     std::string nome_armas[7] = {"Garra Letal", "Tridente Sagrado", "Espada Barroca", "Porrete", "Cajado", "Besta", "Esfera de Ataque"};
//     int armas_min[7] = {100, 220, 300, 180, 50, 220, 200};
//     int armas_max[7] = {300, 420, 500, 380, 200, 420, 400};
//     int armas[2] = {2, 3};
//     int arma_atual;

//     Paladino(){
//       int menor_indice = armas[0];
//       for (int i = 1; i < sizeof(armas)/sizeof(armas[0]); i++) {
//         if (armas_min[armas[i]] < armas_min[menor_indice])
//           menor_indice = armas[i];
//       }
//       arma_atual = menor_indice;
//     };
//     void levarDanoFisico(int dano) {
//       int esquiva = dado(100, 1);
//       if (esquiva > agilidade) {
//         if (hp - dano < 0) {
//           hp = 0;
//         } else {
//           hp -= dano * res_fisica / 100;
//         }
//       }
//     };

//     void levarDanoMagico(int dano) {
//       int esquiva = dado(100, 1);
//       if (esquiva > agilidade) {
//         if (hp - dano < 0) {
//           hp = 0;
//         } else {
//           hp -= dano * res_magica/100;
//         }
//       }
//     };
//     ~Paladino(){};
// };


// // inumanos

// class Animal {
//   private:
//     int max_hp = 3200;
//     int forca_fisica = 80;
//     int forca_magica = 20;
//     int res_fisica = 80;
//     int res_magica = 20;
//     int agilidade = 50;

//   public:
//     int hp = 3200;
//     int mana = 30;
//     std::string nome_armas[7] = {"Garra Letal", "Tridente Sagrado", "Espada Barroca", "Porrete", "Cajado", "Besta", "Esfera de Ataque"};
//     int armas_min[7] = {100, 220, 300, 180, 50, 220, 200};
//     int armas_max[7] = {300, 420, 500, 380, 200, 420, 400};
//     int armas[2] = {2, 3};
//     int arma_atual;

//     Animal(){
//       int menor_indice = armas[0];
//       for (int i = 1; i < sizeof(armas)/sizeof(armas[0]); i++) {
//         if (armas_min[armas[i]] < armas_min[menor_indice])
//           menor_indice = armas[i];
//       }
//       arma_atual = menor_indice;
//     };
//     void levarDanoFisico(int dano) {
//       int esquiva = dado(100, 1);
//       if (esquiva > agilidade) {
//         if (hp - dano < 0) {
//           hp = 0;
//         } else {
//           hp -= dano * res_fisica / 100;
//         }
//       }
//     };

//     void levarDanoMagico(int dano) {
//       int esquiva = dado(100, 1);
//       if (esquiva > agilidade) {
//         if (hp - dano < 0) {
//           hp = 0;
//         } else {
//           hp -= dano * res_magica/100;
//         }
//       }
//     };
//     ~Animal(){
//       int menor_indice = armas[0];
//       for (int i = 1; i < sizeof(armas)/sizeof(armas[0]); i++) {
//         if (armas_min[armas[i]] < armas_min[menor_indice])
//           menor_indice = armas[i];
//       }
//       arma_atual = menor_indice;
//     };
// };
// class Troll {
//   private:
//     int max_hp = 2800;
//     int forca_fisica = 100;
//     int forca_magica = 20;
//     int res_fisica = 80;
//     int res_magica = 20;
//     int agilidade = 20;


//   public:
//     int hp = 2800;
//     int mana = 20;
//     std::string nome_armas[7] = {"Garra Letal", "Tridente Sagrado", "Espada Barroca", "Porrete", "Cajado", "Besta", "Esfera de Ataque"};
//     int armas_min[7] = {100, 220, 300, 180, 50, 220, 200};
//     int armas_max[7] = {300, 420, 500, 380, 200, 420, 400};
//     int armas[2] = {2, 3};
//     int arma_atual;

//     Troll(){
//       int menor_indice = armas[0];
//       for (int i = 1; i < sizeof(armas)/sizeof(armas[0]); i++) {
//         if (armas_min[armas[i]] < armas_min[menor_indice])
//           menor_indice = armas[i];
//       }
//       arma_atual = menor_indice;
//     };
//     void levarDanoFisico(int dano) {
//       int esquiva = dado(100, 1);
//       if (esquiva > agilidade) {
//         if (hp - dano < 0) {
//           hp = 0;
//         } else {
//           hp -= dano * res_fisica / 100;
//         }
//       }
//     };

//     void levarDanoMagico(int dano) {
//       int esquiva = dado(100, 1);
//       if (esquiva > agilidade) {
//         if (hp - dano < 0) {
//           hp = 0;
//         } else {
//           hp -= dano * res_magica/100;
//         }
//       }
//     };
//     ~Troll(){
//       int menor_indice = armas[0];
//       for (int i = 1; i < sizeof(armas)/sizeof(armas[0]); i++) {
//         if (armas_min[armas[i]] < armas_min[menor_indice])
//           menor_indice = armas[i];
//       }
//       arma_atual = menor_indice;
//     };
// };
// class Dragao {
//   private:
//     int max_hp = 3000;
//     int forca_fisica = 100;
//     int forca_magica = 20;
//     int res_fisica = 50;
//     int res_magica = 50;
//     int agilidade = 30;

//   public:
//     int hp = 3000;
//     int mana = 40;
//     std::string nome_armas[7] = {"Garra Letal", "Tridente Sagrado", "Espada Barroca", "Porrete", "Cajado", "Besta", "Esfera de Ataque"};
//     int armas_min[7] = {100, 220, 300, 180, 50, 220, 200};
//     int armas_max[7] = {300, 420, 500, 380, 200, 420, 400};
//     int armas[2] = {2, 3};
//     int arma_atual;

//     Dragao(){
//       int menor_indice = armas[0];
//       for (int i = 1; i < sizeof(armas)/sizeof(armas[0]); i++) {
//         if (armas_min[armas[i]] < armas_min[menor_indice])
//           menor_indice = armas[i];
//       }
//       arma_atual = menor_indice;
//     };
//     void levarDanoFisico(int dano) {
//       int esquiva = dado(100, 1);
//       if (esquiva > agilidade) {
//         if (hp - dano < 0) {
//           hp = 0;
//         } else {
//           hp -= dano * res_fisica / 100;
//         }
//       }
//     };

//     void levarDanoMagico(int dano) {
//       int esquiva = dado(100, 1);
//       if (esquiva > agilidade) {
//         if (hp - dano < 0) {
//           hp = 0;
//         } else {
//           hp -= dano * res_magica/100;
//         }
//       }
//     };
//     ~Dragao(){};
// };
// class Zumbi {
//   private:
//     int max_hp = 2500;
//     int forca_fisica = 40;
//     int forca_magica = 20;
//     int res_fisica = 40;
//     int res_magica = 80;
//     int agilidade = 50;

//   public:
//     int hp = 2500;
//     int mana = 20;
//     std::string nome_armas[7] = {"Garra Letal", "Tridente Sagrado", "Espada Barroca", "Porrete", "Cajado", "Besta", "Esfera de Ataque"};
//     int armas_min[7] = {100, 220, 300, 180, 50, 220, 200};
//     int armas_max[7] = {300, 420, 500, 380, 200, 420, 400};
//     int armas[2] = {2, 3};
//     int arma_atual;

//     Zumbi(){
//       int menor_indice = armas[0];
//       for (int i = 1; i < sizeof(armas)/sizeof(armas[0]); i++) {
//         if (armas_min[armas[i]] < armas_min[menor_indice])
//           menor_indice = armas[i];
//       }
//       arma_atual = menor_indice;
//     };
    
//     void levarDanoFisico(int dano) {
//       int esquiva = dado(100, 1);
//       if (esquiva > agilidade) {
//         if (hp - dano < 0) {
//           hp = 0;
//         } else {
//           hp -= dano * res_fisica / 100;
//         }
//       }
//     };

//     void levarDanoMagico(int dano) {
//       int esquiva = dado(100, 1);
//       if (esquiva > agilidade) {
//         if (hp - dano < 0) {
//           hp = 0;
//         } else {
//           hp -= dano * res_magica/100;
//         }
//       }
//     };
//     ~Zumbi(){};
// };

