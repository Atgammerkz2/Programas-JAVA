//Turma: Engenharia de Software - 3º Período
//Aluno: Michael Marinho da Silva

import model.Aluno;
import java.util.Scanner;
import java.util.Stack;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static Stack<Aluno> alunos = new Stack<>();

    public static void main(String[] args) throws java.io.IOException {

        int opcao = 0;
        while (opcao < 1 || opcao > 7) {
            System.out.println("======================== MENU ========================");
            System.out.println("1 - Cadastrar aluno");
            System.out.println("2 - Cadastrar nota");
            System.out.println("3 - Calcular média de um aluno");
            System.out.println("4 - Listar os nomes dos aluns sem notas");
            System.out.println("5 - Excluir aluno");
            System.out.println("6 - Excluir nota");
            System.out.println("7 - Sair\n");
            System.out.print("Escolha a opção desejada: ");
            opcao = scanner.nextInt();

            switch (opcao){
                case 1:
                    cadastrarAluno();
                    break;

                case 2:
                    cadastrarNota();
                    break;

                case 3:
                    obterMediaAluno();
                    break;

                case 4:
                    listarSemNotas();
                    break;

                case 5:
                    excluirAluno();
                    break;

                case 7:
                    return;

                default:
                    System.out.printf("Opção inválida!\n");
                    continue;
            }

            opcao = 0;

            /*System.out.println("\nPressione ENTER para voltar ao menu principal...");
            System.in.read();
            System.out.println();*/
        }
    }

    private static void cadastrarAluno(){
        System.out.print("Informe o nome do aluno a ser cadastrado: ");
        Aluno aluno = new Aluno();
        aluno.setId(alunos.size() + 1);
        aluno.setNome(scanner.next());
        alunos.push(aluno);

        System.out.printf("\nAluno cadastrado com sucesso! Número: %d", alunos.size());
    }

    private static void cadastrarNota(){
        System.out.print("Informe o número do aluno ao qual você deseja cadastrar a nota: ");
        int numAluno = scanner.nextInt();

        try {
            Aluno aluno = alunos.elementAt(numAluno - 1);
            System.out.print("Informe a nota: ");
            double nota = scanner.nextDouble();
            aluno.getNotas().add(nota);

            System.out.println("\nNota cadastrada com sucesso!");
        } catch (Exception ex){
            System.out.println("\nAluno não cadastrado!");
        }
    }

    private static void obterMediaAluno(){
        System.out.print("Informe o número do aluno ao qual você deseja cadastrar a nota: ");
        int numAluno = scanner.nextInt();

        try {
            Aluno aluno = alunos.elementAt(numAluno - 1);

            if(aluno.getNotas().isEmpty()){
                System.out.println("\nAluno sem notas!");
            } else {
                System.out.printf("\nNome do aluno: %s\n", aluno.getNome());
                System.out.printf("Média do aluno: %.2f\n", aluno.calcularMedia());
            }
        } catch (Exception ex){
            System.out.println("\nAluno não cadastrado!");
        }
    }

    private static void listarSemNotas(){
        if(alunos.isEmpty()){
            System.out.println("\nNenhum aluno cadastrado!");
            return;
        }

        if(alunos.stream().anyMatch(aluno -> !aluno.getNotas().isEmpty())){
            System.out.println("\nTodos os alunos possuem notas!");
        } else {
            System.out.println("\n\nAlunos sem notas:");
            alunos.stream().filter(aluno -> aluno.getNotas().isEmpty()).forEach(aluno -> {
                System.out.printf("%d - %s\n", aluno.getId(), aluno.getNome());
            });
        }
    }

    private static void excluirAluno() {
        if(alunos.isEmpty()){
            System.out.println("Pilha de alunos vazia!");
            return;
        }

        System.out.print("Você tem certeza que deseja excluir o aluno do topo da pilha? (S/N) ");
        if(scanner.next().equalsIgnoreCase("S")){
            Aluno aluno = alunos.peek();
            if(aluno.getNotas().isEmpty()){
                alunos.pop();
                System.out.printf("Aluno '%s' excluido com sucesso!\n", aluno.getNome());
            } else{
                System.out.println("Este aluno possui notas, logo, não poderá ser excluído.\n");
            }
        }
    }
}