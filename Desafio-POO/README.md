# Desafio: Aprendendo na Prática o Paradigma de Orientação a Objetos com Java

Este projeto foi desenvolvido como parte do desafio de projeto da plataforma **Digital Innovation One (DIO)**. O objetivo principal é consolidar o entendimento dos pilares da Programação Orientada a Objetos (POO) através de um cenário real de domínio: a estrutura de um **Bootcamp**.

## 🎯 Objetivo do Projeto
Abstrair o domínio de um Bootcamp e modelar seus atributos e métodos, aplicando os conceitos fundamentais de POO para criar um sistema de gerenciamento de cursos, mentorias e desenvolvedores.

## 🧱 Pilares de POO Aplicados
Durante a implementação, foram exercitados os 4 pilares fundamentais:

1.  **Abstração:** Foco nos aspectos essenciais do domínio (Bootcamp, Dev, Conteúdo), ignorando detalhes irrelevantes.
2.  **Encapsulamento:** Proteção dos dados das classes utilizando modificadores de acesso e métodos getters/setters.
3.  **Herança:** Criação de uma classe pai `Conteudo` para reaproveitamento de código em `Curso` e `Mentoria`.
4.  **Polimorfismo:** Capacidade de tratar diferentes tipos de conteúdos (Curso ou Mentoria) de forma genérica através da classe base.

## 🛠️ Tecnologias e Ferramentas
* **Linguagem:** Java (JDK 11+)
* **IDE:** IntelliJ IDEA
* **Versionamento:** Git & GitHub

## 📂 Estrutura do Domínio
O projeto consiste nas seguintes classes principais:

* **Bootcamp:** Representa o evento principal, com data de início, término e lista de conteúdos/devs.
* **Curso:** Conteúdo específico com carga horária.
* **Mentoria:** Conteúdo com data específica para interação ao vivo.
* **Dev:** Representa o aluno, capaz de se inscrever em Bootcamps e progredir nos conteúdos.
* **Conteúdo (Abstract):** Classe base para evitar duplicação de lógica e permitir o polimorfismo.

## 👣 Passo-a-Passo de Implementação
1.  **Abstração do Domínio:** Definição das classes e seus papéis.
2.  **Modelagem:** Criação de atributos e métodos (ex: `calcularXp()`).
3.  **Relacionamentos:** Utilização de `Set` e `LinkedHashSet` para gerenciar as coleções de conteúdos e inscritos (evitando duplicidade).
4.  **Instanciação:** Transformação das classes em objetos no método `Main` para validar as regras de negócio.

## 🤝 Créditos
Projeto original co-criado por **Camila Cavalcante** e disponibilizado pela **Digital Innovation One**.

---
*Desenvolvido por [Lev-TheDev]*
