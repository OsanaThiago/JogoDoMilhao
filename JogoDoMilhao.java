import java.util.Random;
import java.util.Scanner;

/**
* Trabalho LPA
UCSAL 2025.1
* Prof. Fabio Sales
* Tema: <Tema do Trabalho>
*
* Alunos:
* Lucas Moura Ribeiro
* Osaná Thiago Santos de Freitas
* Phillipe Gabriel Alves Sanson
* Renato de Britto Trindade Rodrigues
* Yuane de Oliveira Miranda
*/

public class JogoDoMilhao {
    static Scanner sc = new Scanner(System.in);
    static Scanner sc2 = new Scanner(System.in);
    static Random rd = new Random();

    public static void main(String[] args) {
    start();
    }

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
        char letra = (char) (rd.nextInt(4) + 'a');
        letraletra = String.valueOf(letra); 
        teste = letraletra;
    } while(teste.equalsIgnoreCase(perguntas[nPergunta][1])); 
    
    return teste;   
    }

    public static void totalPremio(int qttAcertos){
        System.out.println("VOCÊ TERMINOU COM UM PRÊMIO DE " + premio[qttAcertos]+"!");
    }

    public static boolean resultPergunta(int nPergunta, String resposta, int posPergunta, int acertos){ 
        while(true){
            System.out.print("PERGUNTA " + (acertos+1) +": ");                                     
            showPergunta(nPergunta);
            System.out.println("\nX = USAR DICA");                                                       
            System.out.print("\nSUA RESPOSTA: ");
            resposta = sc.nextLine().toUpperCase(); 
        
            while (!resposta.equals("A") && !resposta.equals("B") && !resposta.equals("C") && !resposta.equals("D") && !resposta.equals("X")) {
                System.out.println("Opção inválida! Digite apenas A, B, C ou D.");
                System.out.print("\nSUA RESPOSTA: ");
                resposta = sc.nextLine().toUpperCase();
            }
           
        Boolean resultado = verify(resposta, posPergunta, acertos);

        if(resultado != null){
            return resultado;
        }
    }
    }

    public static void showPergunta(int p){
        System.out.println(perguntas[p][0].toUpperCase() + "\n");

        for(String a : alternativas[p-1]){
            System.out.println(a.toUpperCase());
        }
    }

    public static Boolean verify(String resposta, int posicaoDaPergunta, int qttAcertos){
        if(resposta.equalsIgnoreCase(perguntas[posicaoDaPergunta][1])){ 
            System.out.println("\nBOA\n");
            return true;
        }else if(resposta.equalsIgnoreCase("x")){
            System.out.println("\nEscolha uma dica");
            System.out.println("\n1 = Pular pergunta\n2 = Eliminar respostas\n3 = Consultar um amigo\n4 = Voltar");
            System.out.print("\nEscolha: ");
            resposta = sc.nextLine();
            
            switch (resposta) {

                case "1":

                    if (pulouPergunta) {
                        pulouPergunta = false; 
                        System.out.println("\nPergunta pulada! Vamos para a próxima...\n");
                        getPergunta();
                        
                            if(resposta.equalsIgnoreCase(perguntas[posicaoDaPergunta][1])){
                                System.out.println("\nBOA\n");
                                return true;
                            }else{
                                return false;
                            }
                        } else {
                            System.out.println("\nVocê já usou sua opção de pular! Escolha uma alternativa (A, B, C ou D).");
                            return null;                       
                        }
                
                case "2":
                
                if(dicaEliminar){
                    System.out.println("");
                    System.out.println(randomConsultarAmigo(posicaoDaPergunta).toUpperCase());
                    System.out.println(perguntas[posicaoDaPergunta][1]);
                    System.out.println("\nSua nova resposta: ");
                    resposta = sc.nextLine();
                    dicaEliminar = false;
                    
                        if(resposta.equalsIgnoreCase(perguntas[posicaoDaPergunta][1])){
                            System.out.println("\nBOA\n");
                            return true;
                        }else{
                            System.out.println("");
                            totalPremio(qttAcertos);
                            System.out.println("GAME OVER");
                            return false;
                    } 

                }else{
                    System.out.println("Você só pode usar uma vez cada dica por partida.\n");
                    return null;                    
                } 

                case "3": 

                if(dicaAmigo){
                    System.out.println("\nRenato: Eu acho que a resposta é " + randomConsultarAmigo(posicaoDaPergunta).toUpperCase() + " ou " + (perguntas[posicaoDaPergunta][1]));
                    System.out.print("Sua escolha: ");
                    resposta = sc.nextLine();
                    dicaAmigo = false;

                    if(resposta.equalsIgnoreCase(perguntas[posicaoDaPergunta][1])){
                        System.out.println("\nBOA\n");
                        return true;
                    }
                    else{
                        System.out.println("");
                        totalPremio(qttAcertos);
                        System.out.println("GAME OVER");
                        return false;
                    } 
                }
                else{
                    System.out.println("Você só pode usar uma vez cada dica por partida.\n");
                    return null;
                } 

                case "4": return null;
                default: return null;
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
        System.out.print("\033[H\033[2J"); 
        System.out.flush();
    }

    static boolean dicaAmigo = true;
    static boolean dicaEliminar = true;
    static boolean dicaPular = true;
    static boolean pulouPergunta = true;

    public static String premio [] = {"R$ 0","R$ 500" , "R$ 1.000","R$ 5.000","R$ 10.000","R$ 50.000","R$ 100.000","R$ 250.000","R$ 500.000","R$ 750.000","R$ 1.000.000"};
  
    public static String perguntas [][] = { 
        {"Essa posição zero não vai rodar nas perguntas por questões da lógica usada na randomização de perguntas", "FABIOSEIXASSALES"},
        {"Qual desse itens não foram excluídos do league of legends?","A"},   
        {"Qual o bairro mais populoso de Salvador, sengundo o Censo IBGE 2022?" , "C"},
        {"Qual o elemento considerado mais importante em um computador", "D"},
        {"Qual o mais novo pacote do Jogo Valorant?", "B"},
        {"Qual passiva exclusiva da Fanny reduz o custo de energia ao acertar múltiplos cabos?", "A"},
        {"Qual o nome da maior empresa de tecnologia do mundo?", "C"},
        {"A linguagem JAVA é de qual década?", "D"},
        {"Qual o Estado mais tecnológico do Brasil", "B"},
        {"Qual time de Futebol do Nordeste possui a maior torcida?", "C"},
        {"Qual o jogo de videogame mais vendido do mundo ate hoje", "B"},
    };

    public static String alternativas [][] = { 
        {"A) Criptoflora" , "B) Pistola Laminar Hextec", "C) Hemodrenário", "D) Garra do Espreitador"},
        {"A) Brotas", "B) São Caetano", "C) Itapuã", "D) Pituba"},
        {"A) Mouse", "B) Tela", "C) Teclado", "D) CPU"},
        {"A) Cyrax", "B) Beta Remasted", "C) Divergencia", "D) Arcane"},
        {"A) Steel Threads", "B) Tornado Edge", "C) Cut throat", "D) Cable Reset"},
        {"A) IBM", "B) COMPUTER ASSISTENCE", "C) APPLE", "D) CISCO"},
        {"A) 60", "B) 70", "C) 80", "D) 90"},
        {"A) Santa Catarina", "B) São Paulo", "C) Bahia", "D) Rio de Janeiro"},
        {"A) Vitória", "B) Bahia", "C) Sport", "D) Fortaleza"},
        {"A) Mario Kart 8", "B) Minecraft", "C) Grand Theft Auto V", "D) Pac-Man"},
    };
}
