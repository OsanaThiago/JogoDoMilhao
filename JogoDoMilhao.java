import java.util.Random;
import java.util.Scanner;

public class JogoDoMilhao {
    static Scanner sc = new Scanner(System.in);
    static Random rd = new Random();
    public static void main(String[] args) {

    start();

    }

    //Declaração de métodos/Variaveis 

    public static void start(){
        System.out.println("SEJA MUITO BEM VINDO AO JOGO DO MILHÃO");   
        System.out.println("PREPARADO ? 1 = COMEÇAR 2 = SAIR");
        int play = sc.nextInt();

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

                String resposta;
                switch (teste) {

                    case 1:

                    System.out.println(perguntas[0][0] + "\n");

                    for (String a : alternativas[0]) {
                        System.out.println(a);
                    }

                    System.out.print("\nSua resposta: ");
                    resposta = sc.next(); 
                    
                    if(resposta.equals(perguntas[0][1])){
                        System.out.println("BOA 500 na conta");
                    }else{
                        System.out.println("game over");
                    }

                    break;
                    
                    case 2:
                    System.out.println(perguntas[1][1]);
                    for (String a : alternativas[1]) {
                        System.out.println(a);
                    }
                    resposta = sc.nextLine(); break;

                    default: System.out.println("Não tem esse case ainda ou seila"); break;
            }

        }
        }



    }
    
    public static void limparConsole() {
        System.out.print("\033[H\033[2J"); //"oq significa os dois comandos?" não lembro, tenho de pesquisar novamente, hahaha
        System.out.flush();
    }


    public static String perguntas [][] = { //pergunta + alternativa correta
        {"PRIMEIRA PERGUNTA VALENDO 500 REAIS!" +"\nQual desse itens não foram excluídos do league of legends?","A"},   
        {"Em que local a Lady Maria de \"Bloodborne: The Old Hunters\" é encontrada?" , "C"},
    };

    
    public static String alternativas [][] = { //perguntas
        {"A = Criptoflora" , "B = Pistola Laminar Hextec", "C = Hemodrenário", "D = Garra do Espreitador"},
        {"A = Casa da sua mãe", "B = Universidade Católica do Salvador", "C = Torre do relógio astral", "D = fodase"},

    };

    public static String premio [] = {"R$ 500" , "R$ 1.000","R$ 5.000","R$ 10.000","R$ 50.000","R$ 100.000","R$ 250.000","R$ 500.000","R$ 750.000","R$ 1.000.000"};
    //valor do premio conforme quantidade de acertos

}
