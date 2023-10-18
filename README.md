# Arquitetura de Software Netflix

## Integrantes
  * Arthur Menexes
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
