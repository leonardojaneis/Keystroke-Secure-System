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
- Comunicação eficiente entre o Arduino e o software via RXTX.

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

## 📊 Amostras de Usuários

O sistema requer pelo menos 15 arquivos de amostras de usuários. Cada arquivo contém os tempos de digitação em milissegundos, coletados durante a digitação de uma sequência específica no teclado numérico.

## 📖 Referências
[Documentação RXTX](https://github.com/arduino/rxtx)
[Arduino Reference](https://chatgpt.com/c/67859445-0e44-800e-83dc-23f630acbb68#:~:text=Documenta%C3%A7%C3%A3o%20RXTX-,Arduino%20Reference,-%F0%9F%93%9C%20Licen%C3%A7a)

## 🔍 Contribuições
Contribuições são bem-vindas! Sinta-se à vontade para abrir issues ou enviar pull requests com melhorias no código ou documentação.

## 📧 Contato
Para dúvidas ou mais informações, entre em contato pelo e-mail leonardojaneis@gmail.com.
