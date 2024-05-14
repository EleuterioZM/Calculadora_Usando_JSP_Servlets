<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Calculadora</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
    <script>
        
        
        function appendToDisplay(value) {
            if (value === '^') {
                // Se o valor for "^", adicione "**" ao invés de "^"
                document.getElementById('display').innerText += "^";
                document.getElementById('expressao').value += "**";
            } else if (value === '√') {
                // Se o valor for "√", adicione "Math.sqrt(" ao invés de "√("
                document.getElementById('display').innerText += "√";
                document.getElementById('expressao').value += "Math.sqrt(";
            } else {
                // Caso contrário, adicione o valor normalmente
                document.getElementById('display').innerText += value;
                document.getElementById('expressao').value += value;
            }
        }

        function calculate() {
            try {
                let expressao = document.getElementById('expressao').value;
                // Substitua a função Math.sqrt pelo seu valor numérico
                expressao = expressao.replace(/Math.sqrt/g, 'Math.sqrt(');
                // Substitua todos os parênteses de fechamento ausentes
                let countOpeningParenthesis = (expressao.match(/\(/g) || []).length;
                let countClosingParenthesis = (expressao.match(/\)/g) || []).length;
                for (let i = 0; i < countOpeningParenthesis - countClosingParenthesis; i++) {
                    expressao += ')';
                }
                let result = eval(expressao);
                document.getElementById('display').innerText = result;
                document.getElementById('expressao').value = result;
            } catch (error) {
                document.getElementById('display').innerText = 'Erro';
            }
        }

        function clearDisplay() {
            document.getElementById('display').innerText = '0';
            document.getElementById('expressao').value = '';
        }
        
    </script>
</head>
<body>
    <div class="calculator">
        <form method="post" onsubmit="calculate(); return false;">
            <input type="hidden" name="expressao" id="expressao">
            <div class="display" id="display">0</div>
            <div class="buttons">
                <button type="button" onclick="appendToDisplay('7')">7</button>
                <button type="button" onclick="appendToDisplay('8')">8</button>
                <button type="button" onclick="appendToDisplay('9')">9</button>
                <button type="button" onclick="appendToDisplay('+')">+</button>

                <button type="button" onclick="appendToDisplay('4')">4</button>
                <button type="button" onclick="appendToDisplay('5')">5</button>
                <button type="button" onclick="appendToDisplay('6')">6</button>
                <button type="button" onclick="appendToDisplay('-')">-</button>

                <button type="button" onclick="appendToDisplay('1')">1</button>
                <button type="button" onclick="appendToDisplay('2')">2</button>
                <button type="button" onclick="appendToDisplay('3')">3</button>
                <button type="button" onclick="appendToDisplay('*')">*</button>

                <button type="button" onclick="appendToDisplay('0')">0</button>
                <button type="button" onclick="appendToDisplay('.')">.</button>
                <button type="button" onclick="appendToDisplay('√')">√</button>
                <button type="button" onclick="appendToDisplay('^')">^</button>

                <button type="button" onclick="appendToDisplay('/')">/</button>
                <button type="submit">=</button>

                <!-- Botão C para limpar -->
                <button type="button" id="clear" onclick="clearDisplay()">CE</button>
            </div>
        </form>
    </div>
</body>
</html>
