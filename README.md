# Arquitetura de Software Netflix

## Integrantes
  * Arthur Menezes
  * André Sathler
  * Lucas Santos
  * Matheus Fontes
  * Pablo Magalhães

## Motivação: 
Uma plataforma de streaming baseada em microserviços, sendo reconhecido como um sinônimo de arquitetura, além de ter criado o 'Eureka Netflix' como Discovery de serviços para o Spring Boot


# Introdução:
A Netflix é uma empresa de entretenimento que opera uma plataforma de streaming de vídeo, permitindo que os assinantes assistam a uma ampla variedade de programas de TV, filmes, documentários e outros conteúdos através da internet. Fundada em 1997 nos Estados Unidos por Reed Hastings e Marc Randolph, a empresa começou como um serviço de locação de DVDs pelo correio, mas posteriormente se tornou líder no mercado de streaming de vídeo.


A principal característica da Netflix é a sua extensa biblioteca de conteúdo sob demanda. Os assinantes pagam uma taxa mensal para acessar o catálogo da Netflix, que inclui uma ampla variedade de filmes e programas de TV em diferentes gêneros e idiomas. A plataforma oferece a flexibilidade de assistir ao conteúdo a qualquer momento, em praticamente qualquer dispositivo com acesso à internet, como computadores, smartphones, tablets, smart TVs e consoles de videogame.


De acordo com matéria divulgada pelo jornal Exame, a Netflix informou que possui, em janeiro de 2023, cerca de 231 milhões de usuários ativos, em mais de 200 países, que assinam a plataforma mensalmente, totalizando um valor de U$830 milhões em 2023. Nesse sentido, visando a otimização do funcionamento do sistema e a disponibilidade ininterrupta da plataforma, foi configurada uma arquitetura de software visando esses pontos.

# Requisitos de Segurança
Sob esse viés, o artigo chamado “Netflix Security Architecture”, publicado pela Netflix em 2023, definiu os seguintes requisitos de segurança que o sistema deve seguir, sendo eles: 


Confidencialidade: Os dados dos usuários devem ser protegidos contra acesso não autorizado.

Integridade: Os dados dos usuários devem ser protegidos contra alterações não autorizadas.

Disponibilidade: Deve estar disponível para os usuários o tempo todo.

Resistência: Deve ser resistente a ataques maliciosos.


Visando atender todas essas regras, a empresa decidiu seguir várias medidas de segurança, como: 


Autenticação e autorização: Autenticação e autorização para verificar a identidade dos usuários e restringir seu acesso aos dados.

Criptografia: Uso de criptografia para proteger os dados dos usuários em trânsito e em repouso.

Monitoramento e alerta: Monitoramento da própria infraestrutura para detectar e responder a ameaças de segurança.

Recuperação de desastres: Planejamento de um protocolo de recuperação de desastres para restaurar o serviço em caso de falha.


Segundo a empresa Antenna, instituição especializada em pesquisa de mercado, é difícil estipular uma quantidade de acessos simultâneos que a Netflix suporta. Contudo, fazendo uma conta básica, é possível presumir que, considerando a média de 2,2 acessos por dia de cada usuário, são cerca de 450 milhões de acessos que a plataforma possui por dia. Outrossim, levando em conta ainda o total de 2 horas por dia de consumo de produtos dentro da plataforma de streaming por cada usuário, cerca de 440 milhões de horas/dia são assistidas dentro da Netflix



# Photon
## Introdução

O Photon nasceu com a proposta de melhorar o Buffering dos Steamings feito pela Netflix, sendo este um dos projetos Open Source disponibilizados por eles. Ele funciona via as regras impostas pela SMPTE utilizando-se do TimeCode para metrificação e sincronização de áudio/vídeo.

## Objetivos
O Photon tem como objetivo principal simplificar e aprofundar a utilização do padrão IMF (Interoperable Master Format), sendo este um padrão internacional de entrega e troca de conteúdo audiovisual, usado na produção, pós-produção e distribuição de filmes e programas de televisão. O IMF foi desenvolvido para simplificar e padronizar a distribuição de conteúdo audiovisual em diferentes plataformas e regiões. Ele permite a criação de um único pacote mestre que pode ser adaptado para atender a várias especificações de entrega, como resolução, idioma e legendas. Isso oferece eficiência na distribuição global de conteúdo, reduzindo a necessidade de múltiplas versões do mesmo conteúdo para diferentes plataformas ou regiões.

Sob esse viés, o Photon utiliza-se de todo o seu conhecimento para gerar um flow automatizado e baseado em nuvem que consegue potencializar os benefícios do IMF, conforme visto nessa imagem: 
![image](https://github.com/pabloaugustocm17/tp-arquitetura-software/assets/91166507/a291f06e-65d7-40d2-9c68-238f429b6fd0)

A Netflix continua usando essa arquitetura e possui um time especializado que busca sempre aprimorar os passos desse workflow, visando sempre melhorias para a arquitetura já consolidada.

Ademais, o Photon possui toda a lógica necessária para validar o IMF ncluindo Mapa de Ativos, Lista de Empacotamento (PKL), Lista de Reprodução de Composição (CPL) e arquivos de faixas de Áudio/Vídeo. A Netflix utiliza-se de algumas normas para manutenção da implementação do Photon, como:
1. Suporte para múltiplos espaços de nomes para Lista de Reprodução de Composição, Lista de Empacotamento e Mapa de Ativos, a fim de manter a conformidade com os novos esquemas publicados pela SMPTE.
2. Implementação de inspeção detalhada de ativos IMF, incluindo algoritmos para conformidade e associatividade da Lista de Reprodução de Composição (mais sobre esse aspecto abaixo).
3. Uma interface sem estado para validação IMF que pode ser utilizada como backend em um serviço web RESTful para validar pacotes IMF.
4. Uma arquitetura modular juntamente com um conjunto de classes seguras para threads para validar ativos IMF, como Lista de Reprodução de Composição, Lista de Empacotamento e Mapa de Ativos.

## Instalação

O Funcionamento desta ferramenta é focado em Java, segue sua biblioteca no gerenciador do Maven:

```xml
<dependency>
    <groupId>com.netflix.photon</groupId>
    <artifactId>Photon</artifactId>
    <version>0.1.1</version>
</dependency>
```

### Referências
https://netflixtechblog.com/netflix-and-the-imf-community-7117a66b3c47
https://github.com/Netflix/photon
