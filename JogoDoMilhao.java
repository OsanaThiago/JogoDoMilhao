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
        System.out.println("\nSEJA MUITO BEM VINDO AO JOGO DO MILHÃO!!");   
        System.out.println("PREPARADO VOLTAR PARA CASA MILIONÁRIO?\n\n1 = Iniciar \n2 = Sair\n");
        System.out.print("Resposta: ");
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
        boolean gaming = true;

            while(numero[9] == 0 && gaming){

            teste = rd.nextInt(1,11);
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

                    case 1:
                    gaming = resultPergunta(teste, resposta, vPos, gaming);
                    break;
                    
                    case 2:
                    gaming = resultPergunta(teste, resposta, vPos, gaming);
                    break;
                    
                    case 3:
                    gaming = resultPergunta(teste, resposta, vPos, gaming);
                    break;

                    case 4:
                    gaming = resultPergunta(teste, resposta, vPos, gaming);
                    break;

                    case 5:
                    gaming = resultPergunta(teste, resposta, vPos, gaming);
                    break;

                    case 6:
                    gaming = resultPergunta(teste, resposta, vPos, gaming);
                    break;

                    case 7:
                    gaming = resultPergunta(teste, resposta, vPos, gaming);
                    break;

                    case 8:
                    gaming = resultPergunta(teste, resposta, vPos, gaming);
                    break;

                    case 9:
                    gaming = resultPergunta(teste, resposta, vPos, gaming);
                    break;

                    case 10:
                    gaming = resultPergunta(teste, resposta, vPos, gaming);
                    break;
            }

        }
    }
        }

    public static void totalPremio(int qttAcertos){

    }

    public static boolean resultPergunta(int nPergunta, String resposta, int posPergunta, boolean control){ //junta os metodos de mostrar pergunta e verificar se tá certo ou errado
        showPergunta(nPergunta);                                                       // apenas um metodo para parametrizar os cases em 1 linha só
        System.out.print("\nSua resposta: ");
        resposta = sc.nextLine();
        return verify(resposta, posPergunta);
    }

    public static void showPergunta(int p){
        System.out.println(perguntas[p][0] + "\n");
        for(String a : alternativas[p-1]){
            System.out.println(a);
        }
    }

    public static boolean verify(String r, int pos){
        if(r.equalsIgnoreCase(perguntas[pos][1])){
            System.out.println("\nBOA");
            return true;
        }else{
        System.out.println("\ngame over");
        return false;
        }
    }
    
    public static void limparConsole() {
        System.out.print("\033[H\033[2J"); //"oq significa os dois comandos?" não lembro, tenho de pesquisar novamente, hahaha
        System.out.flush();
    }


    public static String perguntas [][] = { //pergunta + alternativa correta
        {"Essa posição zero não vai rodar nas perguntas por questões da lógica usada na randomização de perguntas", "FABIOSEIXASSALES"},
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
