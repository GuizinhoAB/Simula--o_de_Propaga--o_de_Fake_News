/**
 * Importa a classe ArrayList para criar listas dinâmicas.
 */
import java.util.ArrayList;

/**
 * Importa a classe Arrays para trabalhar com arrays.
 */
import java.util.Arrays;

/**
 * Importa a classe List para trabalhar com listas.
 */
import java.util.List;

/**
 * Importa a classe Random para gerar números aleatórios.
 */
import java.util.Random;

/**
 * Feito por Guilherme de Abreu Guimarães
 * 22.222.028-7
 */


/**
 * Classe Pessoa representa uma pessoa abstrata que pode se mover.
 * Esta classe implementa a interface IMovable.
 */
abstract class Pessoa implements IMovable {
    
    /**
     * Posição horizontal da Pessoa no espaço bidimensional.
     */
    protected int x;

    /**
     * Posição vertical da Pessoa no espaço bidimensional.
     */
    protected int y;

    /**
     * Identificação única da Pessoa no aplicativo Whatsapp.
     */
    protected String whatsappID;

    /**
     * Lista que representa a agenda de contatos da Pessoa no Whatsapp.
     */
    protected ArrayList<String> agendaContatos;

    /**
     * Horário da última vez em que a Pessoa resistiu a uma notícia falsa.
     * Este atributo é medido em milissegundos desde a época UNIX (1 de janeiro de 1970).
     */
    protected long fakeNewsResistanceTimestamp;

    /**
     * Construtor da classe Pessoa.
     *
     * @param x         A posição horizontal inicial da Pessoa.
     * @param y         A posição vertical inicial da Pessoa.
     * @param whatsappID  A identificação única da Pessoa no Whatsapp.
     */
    public Pessoa(int x, int y, String whatsappID) {
        this.x = x;
        this.y = y;
        this.whatsappID = whatsappID;
        this.agendaContatos = new ArrayList<>();
        this.fakeNewsResistanceTimestamp = 0;
    }

    /**
     * Método para mover a pessoa em uma direção aleatória.
     *
     * @param maxX  O limite horizontal do espaço de movimentação.
     * @param maxY  O limite vertical do espaço de movimentação.
     */
    public void mover(int maxX, int maxY) {
        // Cria um objeto Random para gerar números aleatórios.
        Random random = new Random();

        // Gera um número aleatório entre 0 e 3 que representa uma direção no espaço.
        int direction = random.nextInt(4);

        // Move a pessoa na direção escolhida.
        switch (direction) {
            case 0:
                // Move para cima.
                y = (y + 1) % maxY;
                break;
            case 1:
                // Move para a direita.
                x = (x + 1) % maxX;
                break;
            case 2:
                // Move para baixo.
                y = (y - 1 + maxY) % maxY;
                break;
            case 3:
                // Move para a esquerda.
                x = (x - 1 + maxX) % maxX;
                break;
        }
    }

    /**
     * Retorna a posição x da Pessoa.
     *
     * @return A posição horizontal atual da Pessoa.
     */
    public int getX() {
        return x;
    }

    /**
     * Retorna a posição y da Pessoa.
     *
     * @return A posição vertical atual da Pessoa.
     */
    public int getY() {
        return y;
    }

    /**
     * Define a posição x da Pessoa.
     *
     * @param x  A nova posição horizontal da Pessoa.
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * Define a posição y da Pessoa.
     *
     * @param y  A nova posição vertical da Pessoa.
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * Retorna a identificação única da Pessoa no Whatsapp.
     *
     * @return A identificação única da Pessoa no Whatsapp.
     */
    public String getWhatsappID() {
        return whatsappID;
    }

    /**
     * Retorna a lista de contatos da Pessoa no Whatsapp.
     *
     * @return A lista de contatos da Pessoa.
     */
    public ArrayList<String> getAgendaContatos() {
        return agendaContatos;
    }

    /**
     * Retorna o horário da última vez em que a Pessoa resistiu a uma notícia falsa.
     *
     * @return O timestamp de resistência a notícias falsas.
     */
    public long getFakeNewsResistanceTimestamp() {
        return fakeNewsResistanceTimestamp;
    }

    /**
     * Define o horário da última vez em que a Pessoa resistiu a uma notícia falsa.
     *
     * @param fakeNewsResistanceTimestamp  O novo timestamp de resistência a notícias falsas.
     */
    public void setFakeNewsResistanceTimestamp(long fakeNewsResistanceTimestamp) {
        this.fakeNewsResistanceTimestamp = fakeNewsResistanceTimestamp;
    }
}

/**
 * Classe PessoaBemInformada representa uma Pessoa que está bem informada.
 * Esta classe estende a classe Pessoa.
 */
class PessoaBemInformada extends Pessoa {
    /**
     * Construtor da classe PessoaBemInformada.
     *
     * @param x         A posição horizontal inicial da Pessoa.
     * @param y         A posição vertical inicial da Pessoa.
     * @param whatsappID  A identificação única da Pessoa no Whatsapp.
     */
    public PessoaBemInformada(int x, int y, String whatsappID) {
        super(x, y, whatsappID);
    }
}

/**
 * Classe PessoaMalInformada representa uma Pessoa que está mal informada.
 * Esta classe estende a classe Pessoa.
 */
class PessoaMalInformada extends Pessoa {
    /**
     * Construtor da classe PessoaMalInformada.
     *
     * @param x         A posição horizontal inicial da Pessoa.
     * @param y         A posição vertical inicial da Pessoa.
     * @param whatsappID  A identificação única da Pessoa no Whatsapp.
     */
    public PessoaMalInformada(int x, int y, String whatsappID) {
        super(x, y, whatsappID);
    }
}

/**
 * Interface IMovable representa a capacidade de um objeto de se mover.
 * Este objeto deve ser capaz de mover-se em um espaço bidimensional com limites definidos.
 */
interface IMovable {
    /**
     * Método para mover o objeto.
     *
     * @param maxX  O limite horizontal do espaço de movimentação.
     * @param maxY  O limite vertical do espaço de movimentação.
     */
    void mover(int maxX, int maxY);
}

/**
 * Classe ANSIColors representa uma coleção de códigos de cores ANSI.
 * Esses códigos podem ser usados para colorir o texto no console.
 */
class ANSIColors {
    /**
     * Reseta a cor do texto no console para a cor padrão.
     */
    public static final String ANSI_RESET = "\u001B[0m";

    /**
     * Muda a cor do texto no console para vermelho.
     */
    public static final String ANSI_RED = "\u001B[31m";

    /**
     * Muda a cor do texto no console para verde.
     */
    public static final String ANSI_GREEN = "\u001B[32m";

    /**
     * Muda a cor do texto no console para amarelo.
     */
    public static final String ANSI_YELLOW = "\u001B[33m";

    /**
     * Muda a cor do texto no console para azul.
     */
    public static final String ANSI_BLUE = "\u001B[34m";

    /**
     * Muda a cor do texto no console para roxo.
     */
    public static final String ANSI_PURPLE = "\u001B[35m";
}


/**
 * Classe Mundo representa o ambiente da simulação.
 * Esta classe contém um mapa bidimensional onde os objetos podem ser posicionados e movidos.
 */
class Mundo {
    /**
     * Mapa bidimensional que representa o ambiente da simulação.
     */
    public char[][] mapa;

    /**
     * Número de linhas do mapa.
     */
    private int linhas;

    /**
     * Número de colunas do mapa.
     */
    private int colunas;

    /**
     * Construtor da classe Mundo.
     *
     * @param linhas  O número de linhas do mapa.
     * @param colunas  O número de colunas do mapa.
     */
    public Mundo(int linhas, int colunas) {
        this.linhas = linhas;
        this.colunas = colunas;

        // Cria um mapa 2D com base nas linhas e colunas fornecidas
        mapa = new char[linhas][colunas];

        // Preenche o mapa com o caractere '.'
        for (int i = 0; i < linhas; i++) {
            Arrays.fill(mapa[i], '.');
        }
    }

    /**
     * Método para desenhar o mapa no console.
     * Este método exibe o estado atual do mapa, com cada objeto representado por um caractere de cor diferente.
     */
    public void desenhaMundo() {
        // Percorre as linhas do mapa
        for (int i = 0; i < linhas; i++) {
            // Percorre as colunas do mapa
            for (int j = 0; j < colunas; j++) {
                // Obtém o caractere na posição atual do mapa
                char symbol = mapa[i][j];

                // Exibe o caractere com a cor ANSI correspondente
                switch (symbol) {
                    case 'B':
                        System.out.print(ANSIColors.ANSI_GREEN + symbol + ANSIColors.ANSI_RESET);
                        break;
                    case 'M':
                        System.out.print(ANSIColors.ANSI_RED + symbol + ANSIColors.ANSI_RESET);
                        break;
                    case 'F':
                        System.out.print(ANSIColors.ANSI_YELLOW + symbol + ANSIColors.ANSI_RESET);
                        break;
                    case 'D':
                        System.out.print(ANSIColors.ANSI_BLUE + symbol + ANSIColors.ANSI_RESET);
                        break;
                    case 'C':
                        System.out.print(ANSIColors.ANSI_PURPLE + symbol + ANSIColors.ANSI_RESET);
                        break;
                    default:
                        System.out.print(symbol);
                        break;
                }
            }
            // Move para a próxima linha no console
            System.out.println();
        }
    }
}




/**
 * Classe MeioComunicacaoConfiavel representa um meio de comunicação confiável dentro da simulação.
 * Esta classe possui um posicionamento específico no mapa.
 */
class MeioComunicacaoConfiavel {
    /**
     * Coordenada X do meio de comunicação confiável.
     */
    public int x;

    /**
     * Coordenada Y do meio de comunicação confiável.
     */
    public int y;

    /**
     * Símbolo que representa o meio de comunicação confiável no mapa.
     */
    public char symbol = 'C';

    /**
     * Construtor da classe MeioComunicacaoConfiavel.
     *
     * @param x A coordenada X inicial do meio de comunicação confiável.
     * @param y A coordenada Y inicial do meio de comunicação confiável.
     */
    public MeioComunicacaoConfiavel(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Método para obter a coordenada X do meio de comunicação confiável.
     *
     * @return A coordenada X do meio de comunicação confiável.
     */
    public int getX() {
        return x;
    }

    /**
     * Método para obter a coordenada Y do meio de comunicação confiável.
     *
     * @return A coordenada Y do meio de comunicação confiável.
     */
    public int getY() {
        return y;
    }
}



/**
 * Classe IADestruidoraFakeNews representa uma inteligência artificial que destrói fake news dentro da simulação.
 * Esta classe possui um posicionamento específico no mapa.
 */
class IADestruidoraFakeNews {
    /**
     * Coordenada X da IA destruidora de fake news.
     */
    public int x;

    /**
     * Coordenada Y da IA destruidora de fake news.
     */
    public int y;

    /**
     * Símbolo que representa a IA destruidora de fake news no mapa.
     */
    public char symbol = 'D';

    /**
     * Construtor da classe IADestruidoraFakeNews.
     *
     * @param x A coordenada X inicial da IA destruidora de fake news.
     * @param y A coordenada Y inicial da IA destruidora de fake news.
     */
    public IADestruidoraFakeNews(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Método para obter a coordenada X da IA destruidora de fake news.
     *
     * @return A coordenada X da IA destruidora de fake news.
     */
    public int getX() {
        return x;
    }

    /**
     * Método para obter a coordenada Y da IA destruidora de fake news.
     *
     * @return A coordenada Y da IA destruidora de fake news.
     */
    public int getY() {
        return y;
    }
}




/**
 * Classe IAGeradoraFakeNews representa uma inteligência artificial que gera fake news dentro da simulação.
 * Esta classe possui um posicionamento específico no mapa.
 */
class IAGeradoraFakeNews {
    /**
     * Coordenada X da IA geradora de fake news.
     */
    public int x;

    /**
     * Coordenada Y da IA geradora de fake news.
     */
    public int y;

    /**
     * Símbolo que representa a IA geradora de fake news no mapa.
     */
    public char symbol = 'F';

    /**
     * Construtor da classe IAGeradoraFakeNews.
     *
     * @param x A coordenada X inicial da IA geradora de fake news.
     * @param y A coordenada Y inicial da IA geradora de fake news.
     */
    public IAGeradoraFakeNews(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Método para obter a coordenada X da IA geradora de fake news.
     *
     * @return A coordenada X da IA geradora de fake news.
     */
    public int getX() {
        return x;
    }

    /**
     * Método para obter a coordenada Y da IA geradora de fake news.
     *
     * @return A coordenada Y da IA geradora de fake news.
     */
    public int getY() {
        return y;
    }
}



/**
 * A classe Simulacao representa a simulação como um todo. Nela são definidos os parâmetros
 * e a lógica principal da simulação.
 */
public class Simulacao {
    /**
     * Constante que representa o número de linhas no mapa da simulação.
     */
    private static final int LINHAS = 30;

    /**
     * Constante que representa o número de colunas no mapa da simulação.
     */
    private static final int COLUNAS = 60;

    /**
     * Constante que representa o número total de pessoas na simulação.
     */
    private static final int NUM_PESSOAS = 100;

    /**
     * Constante que representa o número total de iterações que a simulação deve executar.
     */
    private static final int NUM_ITERACOES = 1000;

    /**
     * O método principal da classe Simulacao.
     * Ele configura e inicia a simulação com base nas constantes definidas.
     *
     * @param args Uma array de strings que pode conter argumentos de linha de comando.
     * @throws InterruptedException Se a thread principal for interrompida durante a simulação.
     */

    // Método principal
    public static void main(String[] args) throws InterruptedException {
        /**
         * Representa o mundo em que a simulação ocorrerá.
         */
        Mundo mundo = new Mundo(LINHAS, COLUNAS);

        /**
         * Uma lista para armazenar todas as pessoas que serão parte da simulação.
         */
        List<Pessoa> pessoas = new ArrayList<>();

        /**
         * Um objeto Random usado para gerar números aleatórios ao longo da simulação.
         */
        Random random = new Random();
        
     
        /**
         * Este loop é usado para criar pessoas e adicionar à lista 'pessoas'.
         * Cada pessoa é inicializada com coordenadas aleatórias e um ID de WhatsApp único.
         */
        for (int i = 0; i < NUM_PESSOAS; i++) {
            /**
             * Coordenada X aleatória para a pessoa.
             */
            int x = random.nextInt(LINHAS);

            /**
             * Coordenada Y aleatória para a pessoa.
             */
            int y = random.nextInt(COLUNAS);

            /**
             * ID de WhatsApp para a pessoa, que é uma string única 'ID' concatenada com o índice atual do loop.
             */
            String whatsappID = "ID" + i;

            /**
             * Cria uma pessoa bem informada com as coordenadas e ID de WhatsApp definidos acima e a adiciona à lista de pessoas.
             */
            Pessoa pessoa = new PessoaBemInformada(x, y, whatsappID);
            pessoas.add(pessoa);
        }

        /**
         * Cria uma IA geradora de fake news e a inicializa com coordenadas aleatórias.
         */
        IAGeradoraFakeNews iaGeradoraFakeNews = new IAGeradoraFakeNews(random.nextInt(LINHAS), random.nextInt(COLUNAS));

        /**
         * Cria uma IA destruidora de fake news e a inicializa com coordenadas aleatórias.
         */
        IADestruidoraFakeNews iaDestruidoraFakeNews = new IADestruidoraFakeNews(random.nextInt(LINHAS), random.nextInt(COLUNAS));

        /**
         * Cria um meio de comunicação confiável e o inicializa com coordenadas aleatórias.
         */
        MeioComunicacaoConfiavel meioComunicacaoConfiavel = new MeioComunicacaoConfiavel(random.nextInt(LINHAS), random.nextInt(COLUNAS));
        
        
        /**
         * Este loop executa a simulação para o número de iterações especificado pela constante NUM_ITERACOES.
         */
        for (int iteracao = 0; iteracao < NUM_ITERACOES; iteracao++) {
            /**
             * Este loop percorre todas as pessoas da simulação e as move usando o método 'mover'.
             */
            for (Pessoa pessoa : pessoas) {
                /**
                 * Atualiza o estado da pessoa e suas interações, movendo-a dentro dos limites do mundo da simulação.
                 */
                pessoa.mover(LINHAS, COLUNAS);
            }

            /**
             * Este bloco atualiza o estado do mundo e as interações entre as pessoas.
             */
            for (Pessoa pessoa : pessoas) {
                for (Pessoa outraPessoa : pessoas) {
                    /**
                     * Evita que a pessoa interaja consigo mesma.
                     */
                    if (pessoa != outraPessoa) {
                        /**
                         * Checa se a pessoa e a outra pessoa estão próximas o suficiente (distância de 1 unidade em qualquer direção).
                         */
                        if (Math.abs(pessoa.getX() - outraPessoa.getX()) <= 1 && Math.abs(pessoa.getY() - outraPessoa.getY()) <= 1) {
                            /**
                             * Troca números de WhatsApp se eles ainda não estiverem na lista de contatos um do outro.
                             */
                            if (!pessoa.getAgendaContatos().contains(outraPessoa.getWhatsappID())) {
                                pessoa.getAgendaContatos().add(outraPessoa.getWhatsappID());
                                outraPessoa.getAgendaContatos().add(pessoa.getWhatsappID());
                            }

                            /**
                             * Se a pessoa é uma PessoaMalInformada e a outra pessoa é uma PessoaBemInformada, a fake news é espalhada.
                             * A PessoaBemInformada se torna uma PessoaMalInformada se a resistência à fake news dela expirou.
                             */
                            if (pessoa instanceof PessoaMalInformada && outraPessoa instanceof PessoaBemInformada) {
                                if (System.currentTimeMillis() - outraPessoa.getFakeNewsResistanceTimestamp() >= 30000) {
                                    int index = pessoas.indexOf(outraPessoa);
                                    pessoas.set(index, new PessoaMalInformada(outraPessoa.getX(), outraPessoa.getY(), outraPessoa.getWhatsappID()));
                    }
                }
            }
        }
    }

        /**
        * Checa o contato da pessoa com a IAGeradoraFakeNews.
        * Se a pessoa está próxima (distância de 1 unidade em qualquer direção) da IAGeradoraFakeNews, e é uma PessoaBemInformada,
        * ela se torna uma PessoaMalInformada.
        */
       if (Math.abs(pessoa.getX() - iaGeradoraFakeNews.getX()) <= 1 && Math.abs(pessoa.getY() - iaGeradoraFakeNews.getY()) <= 1) {
           if (pessoa instanceof PessoaBemInformada) {
               int index = pessoas.indexOf(pessoa);
               pessoas.set(index, new PessoaMalInformada(pessoa.getX(), pessoa.getY(), pessoa.getWhatsappID()));
           }
       }

       /**
        * Checa o contato da pessoa com a IADestruidoraFakeNews.
        * Se a pessoa está próxima (distância de 1 unidade em qualquer direção) da IADestruidoraFakeNews, e é uma PessoaMalInformada,
        * ela se torna uma PessoaBemInformada.
        */
       if (Math.abs(pessoa.getX() - iaDestruidoraFakeNews.getX()) <= 1 && Math.abs(pessoa.getY() - iaDestruidoraFakeNews.getY()) <= 1) {
           if (pessoa instanceof PessoaMalInformada) {
               int index = pessoas.indexOf(pessoa);
               pessoas.set(index, new PessoaBemInformada(pessoa.getX(), pessoa.getY(), pessoa.getWhatsappID()));
           }
       }

       /**
        * Checa o contato da pessoa com o MeioComunicacaoConfiavel.
        * Se a pessoa está próxima (distância de 1 unidade em qualquer direção) do MeioComunicacaoConfiavel,
        * ela ganha resistência à fake news, marcada pelo timestamp corrente.
        */
       if (Math.abs(pessoa.getX() - meioComunicacaoConfiavel.getX()) <= 1 && Math.abs(pessoa.getY() - meioComunicacaoConfiavel.getY()) <= 1) {
           pessoa.setFakeNewsResistanceTimestamp(System.currentTimeMillis());
       }
   }


                /**
                * Inicializa o mapa do mundo com espaços vazios.
                * O tamanho do mapa é definido pelas constantes LINHAS e COLUNAS.
                */
                for (int i = 0; i < LINHAS; i++) {
                    for (int j = 0; j < COLUNAS; j++) {
                        mundo.mapa[i][j] = ' ';
                    }
                }

                /**
                 * Para cada pessoa na lista de pessoas, determina seu tipo (PessoaBemInformada ou PessoaMalInformada)
                 * e representa-a no mapa com um 'B' ou 'M', respectivamente.
                 */
                for (Pessoa pessoa : pessoas) {
                    if (pessoa instanceof PessoaBemInformada) {
                        mundo.mapa[pessoa.getX()][pessoa.getY()] = 'B';
                    } else if (pessoa instanceof PessoaMalInformada) {
                        mundo.mapa[pessoa.getX()][pessoa.getY()] = 'M';
                    }
                }

                /**
                 * Representa a IAGeradoraFakeNews, IADestruidoraFakeNews e MeioComunicacaoConfiavel no mapa com seus respectivos símbolos.
                 */
                mundo.mapa[iaGeradoraFakeNews.getX()][iaGeradoraFakeNews.getY()] = iaGeradoraFakeNews.symbol;
                mundo.mapa[iaDestruidoraFakeNews.getX()][iaDestruidoraFakeNews.getY()] = iaDestruidoraFakeNews.symbol;
                mundo.mapa[meioComunicacaoConfiavel.getX()][meioComunicacaoConfiavel.getY()] = meioComunicacaoConfiavel.symbol;

                /**
                 * Imprime uma linha de divisão e limpa a tela.
                 */
                System.out.println("============================================================");
                System.out.println("\033[H\033[2J");

                /**
                 * Desenha o mapa do mundo atualizado.
                 */
                mundo.desenhaMundo();

            
                /**
                * Inicializa contadores para acompanhar o número de pessoas com fake news,
                * sem fake news e resistentes a fake news.
                */
               int pessoasComFakeNews = 0;
               int pessoasSemFakeNews = 0;
               int pessoasResistentesFakeNews = 0;

               /**
                * Para cada pessoa na lista de pessoas, verifica se é uma PessoaMalInformada ou PessoaBemInformada.
                * Se for uma PessoaMalInformada, incrementa o contador de pessoas com fake news.
                * Se for uma PessoaBemInformada, incrementa o contador de pessoas sem fake news.
                * Se a PessoaBemInformada é resistente a fake news (ou seja, se passaram menos de 30000 milissegundos desde a última resistência a fake news),
                * incrementa o contador de pessoas resistentes a fake news.
                */
               for (Pessoa pessoa : pessoas) {
                   if (pessoa instanceof PessoaMalInformada) {
                       pessoasComFakeNews++;
                   } else if (pessoa instanceof PessoaBemInformada) {
                       pessoasSemFakeNews++;
                       if (System.currentTimeMillis() - pessoa.getFakeNewsResistanceTimestamp() < 30000) {
                           pessoasResistentesFakeNews++;
                       }
                   }
               }

               /**
                * Imprime o número atual de pessoas mal informadas, bem informadas e resistentes a fake news.
                */
               System.out.println("Mal informadas: " + pessoasComFakeNews);
               System.out.println("Bem informadas: " + pessoasSemFakeNews);
               System.out.println("Pessoas resistentes a fake news: " + pessoasResistentesFakeNews);

               /**
                * Pausa a execução por 1000 milissegundos (1 segundo) antes de passar para a próxima iteração da simulação.
                */
               Thread.sleep(1000);

        }
    }
}