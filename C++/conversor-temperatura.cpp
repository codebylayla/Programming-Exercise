#include <iostream>
#include <iomanip>

using namespace std;

int main() {

    int opcao;
    double temperatura;
    double resultado;

    cout << "===== CONVERSOR DE TEMPERATURA =====" << endl;
    cout << "1 - Celsius para Fahrenheit" << endl;
    cout << "2 - Fahrenheit para Celsius" << endl;
    cout << "3 - Celsius para Kelvin" << endl;

    cout << "\nEscolha uma opcao: ";
    cin >> opcao;

    cout << "Digite a temperatura: ";
    cin >> temperatura;

    switch (opcao) {

        case 1:
            resultado = (temperatura * 9 / 5) + 32;

            cout << fixed << setprecision(2);
            cout << "\n" << temperatura
                 << " Celsius = "
                 << resultado
                 << " Fahrenheit" << endl;
            break;

        case 2:
            resultado = (temperatura - 32) * 5 / 9;

            cout << fixed << setprecision(2);
            cout << "\n" << temperatura
                 << " Fahrenheit = "
                 << resultado
                 << " Celsius" << endl;
            break;

        case 3:
            resultado = temperatura + 273.15;

            cout << fixed << setprecision(2);
            cout << "\n" << temperatura
                 << " Celsius = "
                 << resultado
                 << " Kelvin" << endl;
            break;

        default:
            cout << "\nOpcao invalida!" << endl;
    }

    return 0;
}
