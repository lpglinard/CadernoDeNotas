import java.util.ArrayList;
import java.util.Scanner;

public class SistemaControleNotas {
    private static ArrayList<Aluno> alunos = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean continuar = true;

        while (continuar) {
            System.out.println("\nSistema de Controle de Notas");
            System.out.println("1. Adicionar aluno");
            System.out.println("2. Adicionar nota a aluno");
            System.out.println("3. Calcular média do aluno");
            System.out.println("4. Listar alunos e notas");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();  // Limpa o buffer

            switch (opcao) {
                case 1:
                    adicionarAluno();
                    break;
                case 2:
                    adicionarNota();
                    break;
                case 3:
                    calcularMedia();
                    break;
                case 4:
                    listarAlunos();
                    break;
                case 5:
                    continuar = false;
                    System.out.println("Saindo do sistema...");
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        }
    }

    private static void adicionarAluno() {
        System.out.print("Digite o nome do aluno: ");
        String nome = scanner.nextLine();
        Aluno aluno = new Aluno(nome);
        alunos.add(aluno);
        System.out.println("Aluno " + nome + " adicionado com sucesso!");
    }

    private static void adicionarNota() {
        System.out.print("Digite o nome do aluno: ");
        String nome = scanner.nextLine();
        Aluno aluno = buscarAluno(nome);
        if (aluno != null) {
            System.out.print("Digite a nota: ");
            double nota = scanner.nextDouble();
            aluno.adicionarNota(nota);
            System.out.println("Nota " + nota + " adicionada ao aluno " + nome);
        } else {
            System.out.println("Aluno não encontrado!");
        }
    }

    private static void calcularMedia() {
        System.out.print("Digite o nome do aluno: ");
        String nome = scanner.nextLine();
        Aluno aluno = buscarAluno(nome);
        if (aluno != null) {
            double media = aluno.calcularMedia();
            System.out.println("Média do aluno " + nome + ": " + media);
        } else {
            System.out.println("Aluno não encontrado!");
        }
    }

    private static void listarAlunos() {
        if (alunos.isEmpty()) {
            System.out.println("Nenhum aluno cadastrado!");
        } else {
            for (Aluno aluno : alunos) {
                aluno.listarNotas();
            }
        }
    }

    private static Aluno buscarAluno(String nome) {
        for (Aluno aluno : alunos) {
            if (aluno.getNome().equalsIgnoreCase(nome)) {
                return aluno;
            }
        }
        return null;
    }
}