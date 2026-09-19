function converter() {
    const celsius = Number(document.getElementById("celsius").value);

    if (isNaN(celsius)) {
        document.getElementById("resultado").textContent = "Digite um valor válido.";
        return;
    }

    const fahrenheit = (celsius * 9 / 5) + 32;
    const kelvin = celsius + 273.15;

    document.getElementById("resultado").innerHTML =
        `${celsius.toFixed(1)}°C = ${fahrenheit.toFixed(1)}°F<br>
         ${celsius.toFixed(1)}°C = ${kelvin.toFixed(2)} K`;
}