# Bomber 💣

Um jogo de estratégia e ação inspirado no clássico *Bomberman*, desenvolvido em **Java** utilizando o framework **Greenfoot**. O projeto conta com mecânicas de movimentação, destruição de cenários, múltiplos power-ups e suporte para modo multijogador local.

---

## 🎮 Sobre o Jogo

Em **Bomber**, os jogadores se enfrentam em uma arena repleta de blocos destrutíveis e indestrutíveis. O objetivo principal é derrotar o adversário posicionando bombas estrategicamente, coletando melhorias pelo mapa e escapando das explosões antes que suas vidas cheguem a zero.

### Principais Mecânicas:
* **Modo Multijogador:** Disputa local entre dois jogadores: **Player Ciano** e **Player Pink**.
* **Destruição de Cenário:** Blocos destrutíveis (tijolos) podem ser eliminados com o impacto das explosões, liberando novos caminhos pelo mapa.
* **Sistema de Explosão Dinâmico:** As explosões se propagam em direções verticais e horizontais a partir do centro da bomba, parando ao atingir blocos indestrutíveis.
* **Power-ups:** Ao destruir blocos de tijolo, há uma chance de dropar itens que melhoram os atributos do seu personagem durante a partida:
  * 👟 **Velocidade:** Aumenta a agilidade de movimentação do jogador.
  * 💣 **Mais Bomba:** Permite posicionar mais de uma bomba simultaneamente na arena.
  * 🔥 **Chama:** Aumenta o raio de alcance da explosão da bomba, permitindo atingir áreas maiores e inimigos mais distantes.

---

## 🛠️ Estrutura do Projeto

O código está organizado seguindo a arquitetura padrão do Greenfoot (Atores e Mundos):

### Mundos (Worlds)
* `MyWorld`: A arena principal onde a partida acontece.
* `Menu`: Tela inicial do jogo com opções de inicialização.
* `TelaVitoria`: Tela exibida ao final da partida declarando o vencedor.

### Atores (Actors)
* **Personagens:** `Player` (Classe base), `PlayerCiano` e `PlayerPink`.
* **Elementos de Combate:** `Bomba`, `Explosao`, `ExplosaoLateral`, `ExplosaoVertical` e `Chama`.
* **Obstáculos:** `BlocoDestrutivel` e `BlocoIndestrutivel`.
* **Itens/Power-ups:** `Velocidade` e `MaisBomba`.
* **Interface (UI):** `BotaoIniciar`, `BotaoReiniciar`, `AnimacaoIcone` e `Vitoria`.

---

## 🚀 Como Executar

### Pré-requisitos
Para rodar ou modificar o projeto, você precisará de:
1. **Greenfoot IDE** instalado (versão recomendada: 3.x ou superior).
2. **Java Development Kit (JDK)** compatível com a sua versão do Greenfoot.

### Passo a Passo
1. Baixe ou clone este repositório em sua máquina.
2. Abra o software **Greenfoot**.
3. No menu superior, clique em `Scenario` -> `Open...` e selecione a pasta do projeto (onde está localizado o arquivo `project.greenfoot`).
4. Clique no botão **Compile** no canto inferior direito para compilar as classes Java.
5. Clique em **Run** para iniciar o jogo!

---

## 🕹️ Controles

* **Player Ciano (Azul):**
  * Movimentação: Setas Direcionais (`↑`, `↓`, `←`, `→`)
  * Posicionar Bomba: Tecla `5`

* **Player Pink (Rosa):**
  * Movimentação: Teclas `W`, `A`, `S`, `D`
  * Posicionar Bomba: Tecla `J`

---

## 🎨 Créditos e Recursos

Todos os assets visuais (sprites de jogadores, animações de explosão, ícones de vidas e botões de interface) estão localizados na pasta `Bomber/images/` e foram projetados sob medida para o tema clássico e colorido do jogo.

Desenvolvido como projeto educacional para a disciplina do curso de Licenciatura em Computação (LCC) da Universidade Federal da Bahia (UFBA), utilizando o ecossistema **Greenfoot**.
