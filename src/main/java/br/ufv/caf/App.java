package br.ufv.caf;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

import br.ufv.caf.Funcionario.Tipo_contrato;

public class App 
{
    public static void main( String[] args )
    {

        ArrayList<Funcionario> quadro_funcionario = new ArrayList<Funcionario>();
        Scanner scan = new Scanner(System.in);
        FolhaDePagamento folha = new FolhaDePagamento();

        String resposta = "SIM";
        String nome = "NOVATO";
        int dia = 1, mes = 0, ano = 2000;
        int num_filhos_menores, dia_admissao, mes_admissao, ano_admissao;
        double salario;
        String definir_contrato;
        Tipo_contrato contrato;
        do {
            System.out.print("Entre com o nome do novo Funcionario: ");
            nome = scan.nextLine();
            System.out.print("Entre com o dia de nascimento do novo Funcionario: ");
            dia = scan.nextInt();
            System.out.print("Entre com o mes de nascimento do novo Funcionario: ");
            mes = scan.nextInt();
            System.out.print("Entre com o ano de nascimento do novo Funcionario: ");
            ano = scan.nextInt();
            Funcionario novo = new Funcionario(nome, dia, mes, ano);
            System.out.print("Quantos filhos menores o funcionario "+novo.getNome()+" tem? ");
            num_filhos_menores = scan.nextInt();
            System.out.print("Qual o tipo de contrato do funcionario "+novo.getNome()+": Horista ou Efetivo?");
            definir_contrato = scan.next().toUpperCase();
            if (Objects.equals(definir_contrato, "HORISTA")) {
                contrato = Tipo_contrato.Horista;
            } else {
                contrato = Tipo_contrato.Efetivo;
            }
            System.out.print("Qual o salario do funcionario "+novo.getNome()+"? ");
            scan.nextLine();
            salario = Double.parseDouble(scan.nextLine());
            System.out.print("Qual o dia da admissao?");
            dia_admissao = scan.nextInt();
            System.out.print("Qual o mes da admissao?");
            mes_admissao = scan.nextInt();
            System.out.print("Qual o ano da admissao?");
            ano_admissao = scan.nextInt();
            novo.contratar(num_filhos_menores, contrato,  salario, dia_admissao, mes_admissao, ano_admissao);
            quadro_funcionario.add(novo);
            novo = new Funcionario(nome, dia, mes, ano);
            System.out.println("DESEJA ADICIONAR OUTRO FUNCIONARIO? DIGITE 'SIM' PARA CONTINUAR OU 'NAO' PARA ENCERRAR A APLICAÇÃO!");
            resposta = scan.next().toUpperCase();
            scan.nextLine();
        } while (Objects.equals(resposta, "SIM"));
        
        for (Funcionario funcionario : quadro_funcionario) {
            funcionario.mostraFuncionario();
            folha.mostraFolhaDePagamento(funcionario, 50);
        }
        
        scan.close();
    }
}
