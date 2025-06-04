import java.util.Random;
import java.util.Scanner;

public class JogoDoMilhao {
    static Scanner sc = new Scanner(System.in);
    static Scanner sc2 = new Scanner(System.in);
    static Random rd = new Random();
    public static void main(String[] args) {
    start();
    }

    //Declaração de métodos
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
        int qttAcertos = 0;

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

                    case 1: case 2: case 3: case 4: case 5: case 6: case 7: case 8: case 9: case 10: 
                    gaming = resultPergunta(teste, resposta, vPos, qttAcertos); 

                    if(gaming){
                        qttAcertos++;
                    }
                    if(qttAcertos == 10){ 
                    // por algum motivo provavelmetne devido a primeira condiçao do while deixar de ser true, quando vc acerta tudo
                    // não mostra a premião max. tentei colocar esse if dentro da função e n funciona, se deixar ele fora do while funciona tbm
                    //mas optei por deixar assim
                    System.out.println("PARABÉNS, CAMPEÃ (O)!!");
                    System.out.println("VOCÊ TERMINOU COM UM PRÊMIO DE R$ 1.000.000!");
                }
                    break; 
            }
        }
    }
}

    public static String randomConsultarAmigo(int nPergunta){

    String teste = "";
    String letraletra ="";

    do{
        char letra = (char) (rd.nextInt(3) + 'a');
        letraletra = String.valueOf(letra); 
        teste = letraletra;
    }
    while(teste.equalsIgnoreCase(perguntas[nPergunta][1])); //professor pode perguntar o porquê do dowhile
    return teste;
}

    public static void totalPremio(int qttAcertos){
        System.out.println("VOCÊ TERMINOU COM UM PRÊMIO DE " + premio[qttAcertos]+"!");
    }

    public static boolean resultPergunta(int nPergunta, String resposta, int posPergunta, int acertos){ //junta os metodos de mostrar pergunta e verificar se tá certo ou errado
        System.out.print("PERGUNTA " + (acertos+1) +": ");                                          // apenas um metodo para parametrizar os cases em 1 linha só
        showPergunta(nPergunta);
        System.out.println("\nX = USAR DICA");                                                       
        System.out.print("\nSUA RESPOSTA: ");
        resposta = sc.nextLine();
        return verify(resposta, posPergunta, acertos);
    }

    public static void showPergunta(int p){
        System.out.println(perguntas[p][0].toUpperCase() + "\n");

        for(String a : alternativas[p-1]){
            System.out.println(a.toUpperCase());
        }
    }

    public static boolean verify(String resposta, int posicaoDaPergunta, int qttAcertos){
        if(resposta.equalsIgnoreCase(perguntas[posicaoDaPergunta][1])){
            System.out.println("\nBOA\n");
            return true;
        }else if(resposta.equalsIgnoreCase("x")){
            System.out.println("\nEscolha uma dica");
            System.out.println("\n1 = Pular pergunta\n2 = Eliminar respostas\n3 = Consultar um amigo\n4 = Voltar");
            System.out.print("\nEscolha: ");
            resposta = sc.nextLine();
            

            switch (resposta) {

                case "3": 
                if(dicaAmigo){
                System.out.println("\nRenato: Eu acho que a resposta é " + randomConsultarAmigo(posicaoDaPergunta).toUpperCase() + " ou " + (perguntas[posicaoDaPergunta][1]));
                System.out.print("Sua escolha: ");
                resposta = sc.nextLine();

                if(resposta.equalsIgnoreCase(perguntas[posicaoDaPergunta][1])){
                System.out.println("\nBOA\n");
                dicaAmigo = false;
                return true;
                }
                else{
                    System.out.println("");
                    totalPremio(qttAcertos);
                    System.out.println("GAME OVER");
                    return false;
                } 
                }

                case "4": return false;

                
                default: return false;
            }
        }
        else{
            System.out.println("");
            totalPremio(qttAcertos);
            System.out.println("GAME OVER");
            return false;
        }
    }
    
    public static void limparConsole() {
        System.out.print("\033[H\033[2J"); //"oq significa os dois comandos?" não lembro, tenho de pesquisar novamente, hahaha
        System.out.flush();
    }

    //Declaração de variaveis
    static boolean dicaAmigo = true;

    public static String perguntas [][] = { //pergunta + alternativa correta
        {"Essa posição zero não vai rodar nas perguntas por questões da lógica usada na randomização de perguntas", "FABIOSEIXASSALES"}, //pq o vetor por padrão vem com valor 0 ai a pergunta(numero) 0 caia sempre como já utlizado
        {"Qual item não foi excluído do league of legends?","A"},   
        {"Em que local a Lady Maria de \"Bloodborne: The Old Hunters\" é encontrada?" , "C"},
        {"Qual o país foi mais afetado pela dissolução da Iugoslávia?", "A"},
        {"Qual o mais novo pacote do valorant?", "B"},
        {"Quantos processos Fabio Seixas Sales possui envolvimento?", "B"},
        {"Qual o nome da empresa de assistência técnica de Fábio Sales?", "C"},
        {"Qual campeão não escala com AD e AP?", "D"},
        {"unta", "B"},
        {"osana", "B"},
        {"thiago", "B"},
    };

    public static String alternativas [][] = { //perguntas 10x4
        {"A) Sedenta por Sangue" , "B) Pistola Laminar Hextec", "C) Hemodrenário", "D) Poção Corrupta"},
        {"A) Caelid ", "B) Universidade Católica do Salvador", "C) Torre do relógio astral", "D) Noxus"},
        {"A) Bósnia e Herzegovina", "B) Eslovênia", "C) Croácia", "D) Sérvia"},
        {"A) Cyrax", "B) Beta Remasted", "C) Divergencia", "D) Arcane"},
        {"A) 4", "B) 6", "C) 7", "D) 1"},
        {"A) FABIO TECH", "B) COMPUTER ASSISTENCE", "C) GAF ASSESSORIA", "D) FSS"},
        {"A) Akali", "B) Katarina", "C) Qiyana", "D) Leblanc"},
        {"A) teste", "B) tesete", "C) testb", "D) teeee"},
        {"A) teste", "B) tesete", "C) testb", "D) teeee"},
        {"A) teste", "B) tesete", "C) testb", "D) teeee"},
    };

    public static String premio [] = {"R$ 0","R$ 500" , "R$ 1.000","R$ 5.000","R$ 10.000","R$ 50.000","R$ 100.000","R$ 250.000","R$ 500.000","R$ 750.000","R$ 1.000.000"};
}
