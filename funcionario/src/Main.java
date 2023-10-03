import java.util.ArrayList;

import java.util.List;

import java.util.Scanner;



// Classe abstrata Funcionario

abstract class Funcionario {

    private String nome;
    private String cpf;
    private String endereco;
    private String telefone;
    private String setor;

    public Funcionario(String nome, String cpf, String endereco, String telefone, String setor) {

        this.nome = nome;
        this.cpf = cpf;
        this.endereco = endereco;
        this.telefone = telefone;
        this.setor = setor;

    }



    // Método abstrato para cálculo de salário

    public abstract double calcularSalario();

    // Método para aplicar aumento

    public void aplicarAumento(double percentualAumento) {
        // Implemente a lógica para aplicar aumento de acordo com o tipo de funcionário
    }

    // Método para exibir informações do funcionário
    public void mostrarDados() {

        System.out.println("Nome: " + nome);
        System.out.println("CPF: " + cpf);
        System.out.println("Endereço: " + endereco);
        System.out.println("Telefone: " + telefone);
        System.out.println("Setor: " + setor);
    }

}



// Classe para funcionários assalariados

class FuncionarioAssalariado extends Funcionario {

    private double salario;

    public FuncionarioAssalariado(String nome, String cpf, String endereco, String telefone, String setor, double salario) {

        super(nome, cpf, endereco, telefone, setor);
        this.salario = salario;

    }



    @Override

    public double calcularSalario() {

        return salario;

    }

}



// Classe para funcionários horistas

class FuncionarioHorista extends Funcionario {

    private double horasTrabalhadas;

    private double valorHora;



    public FuncionarioHorista(String nome, String cpf, String endereco, String telefone, String setor, double horasTrabalhadas, double valorHora) {

        super(nome, cpf, endereco, telefone, setor);

        this.horasTrabalhadas = horasTrabalhadas;

this.valorHora = valorHora;

    }



    @Override

    public double calcularSalario() {

        return horasTrabalhadas * valorHora;

    }

}



public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<Funcionario> funcionarios = new ArrayList<>();



        // Solicitar dados para até dez funcionários

        for (int i = 0; i < 10; i++) {

            System.out.println("Informe o tipo de funcionário (Assalariado ou Horista): ");

            String tipo = scanner.nextLine();



            System.out.println("Informe o nome: ");

            String nome = scanner.nextLine();



            System.out.println("Informe o CPF: ");

            String cpf = scanner.nextLine();



            System.out.println("Informe o endereço: ");

            String endereco = scanner.nextLine();

System.out.println("Informe o telefone: ");

            String telefone = scanner.nextLine();



            System.out.println("Informe o setor: ");

            String setor = scanner.nextLine();



            if (tipo.equalsIgnoreCase("Assalariado")) {

                System.out.println("Informe o salário: ");

                double salario = scanner.nextDouble();

                scanner.nextLine(); // Limpar o buffer

                funcionarios.add(new FuncionarioAssalariado(nome, cpf, endereco, telefone, setor, salario));

            } else if (tipo.equalsIgnoreCase("Horista")) {

                System.out.println("Informe as horas trabalhadas: ");

                double horasTrabalhadas = scanner.nextDouble();

                scanner.nextLine(); // Limpar o buffer

                System.out.println("Informe o valor da hora: ");

                double valorHora = scanner.nextDouble();

                scanner.nextLine(); // Limpar o buffer

                funcionarios.add(new FuncionarioHorista(nome, cpf, endereco, telefone, setor, horasTrabalhadas, valorHora));

            } else {

                System.out.println("Tipo de funcionário inválido. Digite 'Assalariado' ou 'Horista'.");

            }

        }



        // Exibir os dados e pagamentos de cada funcionário

        for (Funcionario funcionario : funcionarios) {

            funcionario.mostrarDados();

            System.out.println("Pagamento: R$ " + funcionario.calcularSalario());

            System.out.println();

        }



        // Aplicar aumento geral

        System.out.println("Informe o percentual de aumento geral: ");

        double percentualAumento = scanner.nextDouble();

        for (Funcionario funcionario : funcionarios) {

            funcionario.aplicarAumento(percentualAumento);

        }



        // Exibir os dados e pagamentos atualizados

        System.out.println("Aplicando aumento de " + percentualAumento + "% para todos os funcionários.");

        for (Funcionario funcionario : funcionarios) {

            funcionario.mostrarDados();

            System.out.println("Pagamento atualizado: R$ " + funcionario.calcularSalario());

            System.out.println();

        }

    }

}