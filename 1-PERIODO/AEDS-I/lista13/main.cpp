#include "personagem.h"
using namespace std;

int main() {
  srand(time(NULL));


  //Menu
  printf("\n---RPG---\n");
  printf("ESCOLHA SUA CLASSE\n");
  printf("1. Guerreiro\n2. Ladrão\n3. Mago\n4. Paladino\n5. Animal\n6. Troll\n7. Dragão\n8. Zumbi\n");

  printf("Player 1: ");
  int player1;
  scanf("%d", &player1);
  while (player1 < 1 || player1 > 8) {
    printf("Digite um número de 1 a 8: ");
    scanf("%d", &player1);
  }

  printf("Player 2: ");
  int player2;
  scanf("%d", &player2);
  while (player2 < 1 || player2 > 8) {
    printf("Digite um número de 1 a 8: ");
    scanf("%d", &player2);
  }

  Personagem *p1, *p2;
  p1 = new Personagem(player1 - 1);
  p2 = new Personagem(player2 - 1);
  
  
  p1->printarStats();
  p2->printarStats();


  

  int round_atual = 1, gameOver = 0;
  while (gameOver == 0) {
    printf("\n----------ROUND %d----------\n", round_atual);
    printf("Player 1, escolha o que você irá fazer esse round: \n");
    std::cout << "1. Usar a arma " << p1->getArma() << std::endl;
    std::cout << "2. Usar uma magia" << std::endl;
    std::cout << "3. Ver seus stats" << std::endl;
    std::cout << "4. Desistir da partida" << std::endl;
    int decisao;
    scanf("%d", &decisao);
    while (decisao < 1 || decisao > 4) {
      printf("Selecione um valor válido: ");
      scanf("%d", &decisao);
    }

    if (decisao == 1) {
      p1->causarDanoFisico(p2);

      // dano *= p2->getRes_fisica() / 100;
      // int esquiva = dado(100, 1);
      // if (esquiva > p2->getAgilidade()) {
      //   std::cout << "ESQUIVA! O Player 2 conseguiu escapar do ataque do Player 1." << std::endl;
      // }
      // std::cout << "HIT! Player 1 atacou o Player 2 com sua arma " << p1->getArma() << ", causando " << dano << "pontos de dano." << std::endl;
      // p2->levarDanoFisico(dano);

    }




gameOver = 1;
    round_atual++;
    
  }

}