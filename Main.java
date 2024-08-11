import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        String temConta;
        int opt  ;
        String nomeCadastro,emailCadastro, cpfCadastro, loginCadastro,senhaCadastro;




        Cliente user = new Cliente();
        Scanner read = new Scanner(System.in);
        System.out.println("****************************");
        System.out.println("Bem vindo ao Velloso's Bank!!\n");
        System.out.println("Já possui cadastro no Velloso's Bank? (sim|não)");
        temConta = read.nextLine();

       // CADASTRO

        if (temConta.equals("não")){
            System.out.println("Gostaria de fazer um cadastro conosco ? 1 = sim | 2 = não ");
            opt = read.nextInt();

            switch (opt) {

                case 1:
                    System.out.println("Ok, vamos começar o seu cadastro!");

                    System.out.println("Digite seu nome:\n");
                    nomeCadastro = read.next();
                    user.setNome(nomeCadastro);

                    System.out.println("Digite seu email:\n");
                    emailCadastro = read.next();
                    user.setEmail(emailCadastro);

                    System.out.println("Digite seu cpf:\n");
                    cpfCadastro = read.next();
                    user.setCpf(cpfCadastro);

                    System.out.println("Digite seu login desejado:\n");
                    loginCadastro = read.next();
                    user.setLogin(loginCadastro);

                    System.out.println("Digite sua senha:\n");
                    senhaCadastro = read.next();
                    user.setSenha(senhaCadastro);

                    break;
                case 2:
                    System.out.println("Ok, até a próxima");
                    System.exit(0);
                    return ;
                default:
                    System.out.println("Opção inválida");
            }

        }


        // LOGIN

        String login, senha;

        System.out.println("Informe seus dados!!");
        System.out.println("Digite seu login");
        login = read.next();
        System.out.println("Digite sua senha");
        senha= read.next();


        if (login.equals(user.login)  || senha.equals(user.senha)) {
            System.out.println("Bem vindo " + user.nome);
            int opcao;
            int valor;
            String menu = """
                       Operações:
                       
                       1-Consulte seu saldo
                       2-Saque
                       3-Transferir valor
                       4-Sair
                       
                       """;

            System.out.println(menu);

            // OPERAÇÕES BANCÁRIAS

            while (true) {
                System.out.print("Digite a opção desejada: ");
                opcao = read.nextInt();

                switch (opcao) {
                    case 1:
                        System.out.println("Seu saldo atual é de " + user.saldo);
                        System.out.println("Deseja encerrar a operação, se não digite 4 ?");
                        break;
                    case 2:
                        System.out.print("Qual valor do saque? ");
                        valor = read.nextInt();
                        if (valor > user.saldo) {
                            System.out.println("Saldo insuficiente");
                        } else {
                            user.saldoAtt =user.saldo - valor;
                            System.out.println("Seu saldo atual é de: " + user.saldoAtt);
                            user.saldo = user.saldoAtt;
                        }
                        System.out.println("Deseja encerrar a operação, se não digite 4 ?");
                        break;
                    case 3:
                        System.out.print("Digite o valor da transferência: ");
                        valor = read.nextInt();
                        if (valor > user.saldo) {
                            System.out.println("Saldo insuficiente");
                        } else {
                            user.saldoAtt = user.saldo - valor;
                            System.out.println("Seu saldo atual é de: " + user.saldoAtt);
                            user.saldo = user.saldoAtt;
                        }
                        System.out.println("Deseja encerrar a operação, se não digite 4 ?");
                        break;
                    case 4:
                        System.out.println("Saindo...");
                        return;
                    default:
                        System.out.println("Opção inválida");
                }
            }
        } else {
            System.out.println("Senha incorreta");
        }
    }
}