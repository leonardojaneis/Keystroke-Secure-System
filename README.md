# Keystroke Secure System

O **Keystroke Secure System** é um projeto desenvolvido em **Java** que utiliza a biblioteca **RXTX** para comunicação com um Arduino e sensores piezoelétricos. Este sistema autentica um usuário com base no padrão de digitação em um teclado numérico, analisando as características únicas de cada indivíduo.

---

## 🎯 Objetivo do Projeto

Criar um sistema de autenticação biométrica baseado na dinâmica de digitação, explorando a interação entre hardware (Arduino e sensores piezoelétricos) e software (Java).

---

## 🚀 Funcionalidades

- Coleta de padrões de digitação de usuários em um teclado numérico.
- Processamento e análise dos dados coletados.
- Comparação em tempo real do padrão de digitação do usuário com os padrões previamente cadastrados.
- Sistema de Login.
- Comunicação eficiente entre o Arduino e o software via RXTX.

---

## 📚 Publicações Relacionadas

Este software foi utilizado no seguinte artigo acadêmico:

**Título do Artigo**: "Improvement of Security Systems by Keystroke Dynamics of Passwords"  
**Publicado em**: *International Journal of Computer Science and Information Security (IJCSIS)*  
**Autores**: Leonardo Janeis de Melo e Heleno Murilo Campeão Vale 
**Link**: [Acesse o artigo aqui](https://d1wqtxts1xzle7.cloudfront.net/55691451/Journal_of_Computer_Science_IJCSIS_September_2017_Full_Volume.pdf?1517495118=&response-content-disposition=inline%3B+filename%3DJournal_of_Computer_Science_IJCSIS_Septe.pdf&Expires=1736812949&Signature=UCqrqVLWhd1FT-WEKcp4s7uzFM10pJH3zFX4pHajqxVkj7EeSN~tKdzvKIyEa~CBH78vyl4Rbt~Pkk6od6dQVtDdYogLgUrgqyrodpTn~GJStP7T3LrH3ZMutlF2P9-1WHldWwtSielRgfzpYWvycRr3QxmXkTgkTF8j6x5xX2l6bPdwy7AEWH1DktjnGml03oCBpHA7Lj7Sav8vRFut-bDLMmnwbw-9ZbmgYEgN1fTBcSK5-ZSM0j3bVpF-e5We~5tM7flsqJSyo5TxBMG941JphqSARF6cQTIkWobYrszFgWbpWqJDVW-gE-xt1NWiCpz81Pfa~tFoQuxtBMrnaQ__&Key-Pair-Id=APKAJLOHF5GGSLRBV4ZA#page=169) 

---

## 🛠️ Requisitos

### Hardware

- **Arduino Uno** (ou modelo compatível).
- **Teclado numérico** equipado com sensores piezoelétricos.
- Cabos e conexões adequados para comunicação serial.

### Software

- **Java Development Kit (JDK)** 8 ou superior.
- Biblioteca **RXTX** para comunicação serial.
- Sistema operacional compatível com RXTX (Windows, Linux ou macOS).

---

## 🔧 Instalação

1. **Clone o repositório**:

   ```bash
   git clone https://github.com/seu-usuario/keystroke-secure-system.git
   cd keystroke-secure-system

2. **Configure a bliblioteca RXTX**:
    Baixe a biblioteca RXTX para seu sistema operacional.
    Adicione os arquivos RXTXcomm.jar e rxtxSerial.dll (ou equivalente para Linux/macOS) ao classpath do projeto.

3. **Compile o código**:
    Compile o projeto usando um ambiente de desenvolvimento Java

4. **Execute o programa**

---

## 📊 Amostras de Usuários

O sistema requer pelo menos 30 arquivos de amostras de usuários. Cada arquivo contém a força aplicada a tecla (F), o tempo total de digitação em milissegundos (T), e a tecla digitada. 

Exemplo de arquivo de amostra (user1_sample.txt):

F,164,T,300669,3

Os arquivos de amostras estão localizados na pasta amostras/.

---

## 📖 Referências
[Documentação RXTX](https://github.com/arduino/rxtx)

[Arduino Reference](https://store.arduino.cc/products/arduino-uno-rev3?srsltid=AfmBOoqsw2egKcKqWqr116-zqBcWOcaVt5u1zi07cr29sa6iyumgMWD7)

---

## 🔍 Contribuições
Contribuições são bem-vindas! Sinta-se à vontade para abrir issues ou enviar pull requests com melhorias no código ou documentação.

---

## 📧 Contato
Para dúvidas ou mais informações, entre em contato pelo e-mail leonardojaneis@gmail.com.
