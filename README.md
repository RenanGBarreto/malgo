![Malgo](https://github.com/RenanGBarreto/malgo/raw/master/icon.png)

# Malgo: Uma ferramenta para o ensino dos algoritmos de substituição de página / Malgo: A tool for teaching memory page replacement algorithms

## SCREENSHOTS
<p align="center">
  <img alt="Malgo Software Demo" src="https://github.com/RenanGBarreto/malgo/raw/master/screenshots/malgo-demo.gif"> 
</p>

## ALGORITMOS SUPORTADOS

### NÃO USADA RECENTEMENTE (NUR)

A maioria dos computadores com memória virtual tem dois bits de status – o bit referenciada (R) e o bit modificada (M) – associados a cada página virtual, que permitem que o sistema operacional saiba quais páginas físicas estão sendo usadas e quais não estão. O bit R é colocado em 1 sempre que a página é refereciada (lida ou escrita). O bit M é colocado em 1 sempre que se escreve na página (isto é, a página é modificada). Os bits estão contidos em cada entrada da tabela de páginas. É importante perceber que estes bits devem ser atualizados em todas as referências à memória, de modo que é essencial que esta atualização se dê por hardware. Uma vez que um bit é colocado em 1 por hardware, ele permanece em 1 até o sistema operacional coloca-lo em 0 por software.

O algoritmo NUR, remove aleatoriamente uma página da classe de ordem mais baixa que não esteja vazia. Está implícito neste algoritmo que é melhor remover uma página modificada mas não referenciada a pelo menos uma interrupção do relógio do que uma página não modificada que está sendo intensamente referenciada. A principal vantagem do algoritmo NUR é ser fácil de entender e de implementar, e, além disso, fornece um desempenho que, apesar de não ser ótimo, pode ser adequado.

### FIFO (First In First Out)

O algoritmo FIFO, é um algoritmo de baixo custo. O sistema operacional mantém uma lista de todas as páginas atuais na memória, com a página mais antiga na cabeça da lista e a página que chegou mais recentemente situada no final desta lista. Na ocorrência de uma falta de página, a primeira página da lista é removida e a nova página é adicionada no final da lista.

### SEGUNDA CHANCE (SC)

Uma modificação simples no algoritmo de substituição FIFO evita o problema de se jogar fora uma página intensamente usada, e isso é feito simplesmente inspecionando o bit R da página mais antiga, ou seja, a primeira página da fila. Se o bit R for 0, essa página além de ser mais antiga, não estará sendo usada, de modo que será substituída imediatamente. Se o bit R for 1, ele será colocado em 0; Essa página será posta no final da lista de páginas e seu tempo de carregamento (chegada) será atualizado como se ela tivesse acabado de ser carregada na memória. A pesquisa então continua.

### MENOS RECENTE USADA (MRU)

É provável que páginas que não foram referenciadas nas últimas instruções não o sejam nas próximas instruções. Essa idéia é implementável, ou seja, quando ocorre uma falta de página, descartamos a página que há mais tempo não é usada. Embora possível, a implementação do MRU é onerosa. Para implementa-la integralmente, é necessário manter uma lista encadeada de todas as páginas na memória, com a página mais recentemente usada no início desta lista e a página menos recentemente usada no fim desta lista. A desvantagem é que esta lista encadeada deve ser atualizada a cada referência à memória. Encontrar uma página nessa lista, descartá-la e então movê-la para o início da lista é uma operação que consome muito tempo.

## REQUERIMENTOS DO SISTEMA

Para usar o Malgo você precisará ter um computador pelo menos as caracteristicas abaixo:
* Sistema Operacional Windows (Xp, Vista ou Seven), Linux
   (Compatível com pacotes DEB ou RPM) ou qualquer outro Sistema Operacional capaz
   de executar aplicativos JAVA™;
* JRE™ (Java Runtime Environment) instalado. Caso não possua, acesse:
   http://www.java.com/ e instale a versão mais recente do Java™.
* Processador de no mínimo 1Ghz;
* 256MB de Memória RAM;
* 100MB de espaço disponível em disco;
* Conexão com a internet.

## LICENSE

Copyright (C) 2012 Renan Gomes Barreto
This program is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with this program.  If not, see http://www.gnu.org/licenses/.
