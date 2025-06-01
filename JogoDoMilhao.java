import java.util.Random;
import java.util.Scanner;

public class JogoDoMilhao {
    static Scanner sc = new Scanner(System.in);
    static Scanner sc2 = new Scanner(System.in);
    static Random rd = new Random();
    public static void main(String[] args) {

    start();

    }

    //Declaração de métodos/Variaveis 

    public static void start(){
        System.out.println("SEJA MUITO BEM VINDO AO JOGO DO MILHÃO!!");   
        System.out.println("PREPARADO VOLTAR PARA CASA MILIONÁRIO?\n\n1 = INICIAR \n2 = SAIR");
        int play = sc2.nextInt();

        if(play == 1){
            limparConsole();
            getPergunta();
        }
        else{
            System.out.println("Adeus!");
        }
    }

    public static void getPergunta(){

        int [] numero = new int[10];
        int teste;
        int posicao = -1;

        for(int i = 0; i<10; i++){
            teste = rd.nextInt(1,2);
            teste -=1;
            boolean contem = false;

            for(int j = 0; j<numero.length;j++){
                if(teste == numero[j]){
                    contem = true;
                }
            }

            if(contem == false){
                posicao += 1;
                numero[posicao] = teste;
                int vPos = teste;
                String resposta = "";

                switch (teste) {

                    case 0:
                    resultPergunta(teste, resposta, vPos);
                    break;
                    
                    case 1:
                    resultPergunta(teste, resposta, vPos);
                    break;
                    
                    case 2:
                    resultPergunta(teste, resposta, vPos);
                    break;

                    case 3:
                    resultPergunta(teste, resposta, vPos);
                    break;

                    case 4:
                    resultPergunta(teste, resposta, vPos);
                    break;

                    case 5:
                    resultPergunta(teste, resposta, vPos);
                    break;

                    case 6:
                    resultPergunta(teste, resposta, vPos);
                    break;

                    case 7:
                    resultPergunta(teste, resposta, vPos);
                    break;

                    case 8:
                    resultPergunta(teste, resposta, vPos);
                    break;

                    case 9:
                    resultPergunta(teste, resposta, vPos);
                    break;

                    default: System.out.println("Não tem esse case ainda ou seila"); break;
            }

        }
    }

    }


    public static void totalPremio(int qttAcertos){

    }

    public static void resultPergunta(int nPergunta, String resposta, int posPergunta){ //junta os metodos de mostrar pergunta e verificar se tá certo ou errado
        showPergunta(nPergunta);                                                       // apenas um metodo para parametrizar os cases em 1 linha só
        System.out.print("\nSua resposta: ");
        resposta = sc.nextLine();
        verify(resposta, posPergunta);
    }

    public static void showPergunta(int p){
        System.out.println(perguntas[p][0] + "\n");
        for(String a : alternativas[p]){
            System.out.println(a);
        }
    }

    public static void verify(String r, int pos){
        if(r.equalsIgnoreCase(perguntas[pos][1])){
            System.out.println("\nBOA");
        }else{
        System.out.println("\ngame over");
        }
    }
    
    public static void limparConsole() {
        System.out.print("\033[H\033[2J"); //"oq significa os dois comandos?" não lembro, tenho de pesquisar novamente, hahaha
        System.out.flush();
    }


    public static String perguntas [][] = { //pergunta + alternativa correta
        {"PRIMEIRA PERGUNTA VALENDO 500 REAIS!" +"\nQual desse itens não foram excluídos do league of legends?","A"},   
        {"Em que local a Lady Maria de \"Bloodborne: The Old Hunters\" é encontrada?" , "C"},
        {"Qual o país foi mais afetado pela dissolução da Iugoslávia?", "A"},
        {"Qual o mais novo pacote do valorant?", "B"},
        {"Quantos processos Fabio Seixas Sales possui envolvimento?", "B"},
        {"Qual o nome da empresa de assistência técnica de Fábio Sales?", "C"},
        {"SÉTIMA PERGUNTA VALENDO XXX ", "B"},
        {"OITAVA PERGUNTA VALENDO XXX ", "B"},
        {"NONA PERGUNTA VALENDO XXX ", "B"},
        {"ÚLTIMA PERGUNTA VALENDO XXX ", "B"},
    };

    
    public static String alternativas [][] = { //perguntas
        {"A = Criptoflora" , "B = Pistola Laminar Hextec", "C = Hemodrenário", "D = Garra do Espreitador"},
        {"A = Caelid ", "B = Universidade Católica do Salvador", "C = Torre do relógio astral", "D = Noxus"},
        {"A = Bósnia e Herzegovina", "B = Eslovênia", "C = Croácia", "D = Sérvia"},
        {"A = Cyrax", "B = Beta Remasted", "C = Divergencia", "D = Arcane"},
        {"A = 4", "B = 6", "C = 7", "D = 1"},
        {"A = FABIO TECH", "B = COMPUTER ASSISTENCE", "C = GAF ASSESSORIA", "D = FSS"},
        {"A = teste", "B = tesete", "C = testb", "D = teeee"},
        {"A = teste", "B = tesete", "C = testb", "D = teeee"},
        {"A = teste", "B = tesete", "C = testb", "D = teeee"},
        {"A = teste", "B = tesete", "C = testb", "D = teeee"},
    };

    public static String premio [] = {"R$ 500" , "R$ 1.000","R$ 5.000","R$ 10.000","R$ 50.000","R$ 100.000","R$ 250.000","R$ 500.000","R$ 750.000","R$ 1.000.000"};
    //valor do premio conforme quantidade de acertos

}
