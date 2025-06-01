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
        System.out.println("PREPARADO VOLTAR PARA CASA MILIONÁRIO?\n\n1 = COMEÇAR\n2 = SAIR");
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
        int qttAcertos = 0;

        for(int i = 0; i<10; i++){
            teste = rd.nextInt(10);
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
                qttAcertos++;
                String resposta;

                switch (teste) {

                    case 1:

                    showPergunta(teste);
                    System.out.print("Sua resposta: ");
                    resposta = sc.nextLine(); 
                    verify(resposta, vPos);
                    

                    break;
                    
                    case 2:

                    showPergunta(teste);
                    System.out.print("Sua resposta: ");
                    resposta = sc.nextLine(); 
                    verify(resposta, vPos); 
                    break;
                

                    default: System.out.println("Não tem esse case ainda ou seila"); break;
            }

        }
    }

    }


    public static void totalPremio(int qttAcertos){

    }

    public static void showPergunta(int p){
        System.out.println(perguntas[p][0]);
        for(String a : alternativas[p]){
            System.out.println(a);
        }
    }

    public static void verify(String r, int pos){
        if(r.equalsIgnoreCase(perguntas[pos][1])){
            System.out.println("BOA");
            System.out.println("Prêmio atual = ");
        }else{
        System.out.println("game over");
        }
    }
    
    public static void limparConsole() {
        System.out.print("\033[H\033[2J"); //"oq significa os dois comandos?" não lembro, tenho de pesquisar novamente, hahaha
        System.out.flush();
    }


    public static String perguntas [][] = { //pergunta + alternativa correta
        {"PRIMEIRA PERGUNTA VALENDO 500 REAIS!" +"\nQual desse itens não foram excluídos do league of legends?","A"},   
        {"Em que local a Lady Maria de \"Bloodborne: The Old Hunters\" é encontrada?" , "C"},
        {"Qual o país foi mais afetado pela dissolução da Iugoslávia", "A"},
        {"Qual o mais novo pacote do valorant?", "B"},
        {"Quantos processos Fabio Seixas Sales possui envolvimento?", "B"},
        {"Qual o nome da empresa de assistência técnico de Fábio Sales?", "C"},
        {"pergunta n7", "B"},
        {"pergunta n8", "B"},
        {"pergunta n9", "B"},
        {"pergunta n10", "B"},
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
