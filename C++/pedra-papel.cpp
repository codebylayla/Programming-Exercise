#include <iostream>
#include <cstdlib>
#include <ctime>

using namespace std;

int main() {

    int jogador;
    int computador;

    srand(time(0));

    cout << "==============================" << endl;
    cout << "    PEDRA, PAPEL E TESOURA" << endl;
    cout << "==============================" << endl;

    cout << "\n1 - Pedra" << endl;
    cout << "\n2 - Papel" << endl;
    cout << "\n3 - Tesoura" << endl;

    cout << "\nEscolha uma opcao: ";
    cin >> jogador;

    if (jogador < 1 || jogador > 3) {
        cout << "\nOpcao invalida!" << endl;
        return 0;
    }

    computador = rand() % 3 + 1;

    cout << "\nSua escolha: ";

    if (jogador == 1) {
        cout << "Pedra";
    } else if (jogador == 2) {
        cout << "Papel";
    } else {
        cout << "Tesoura";
    }

    cout << "\nEscolha do computador: ";

    if (computador == 1) {
        cout << "Pedra";
    } else if (computador == 2) {
        cout << "Papel";
    } else {
        cout << "Tesoura";
    }

    cout << "\n";

    if (jogador == computador) {
        cout << "\nEmpate!" << endl;
    }
    else if (
        (jogador == 1 && computador == 3) ||
        (jogador == 2 && computador == 1) ||
        (jogador == 3 && computador == 2)
    ) {
        cout << "\nVoce venceu! 🎉" << endl;
    }
    else {
        cout << "\nO computador venceu!" << endl;
    }

    return 0;
}
