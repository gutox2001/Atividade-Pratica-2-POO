package br.ufv.caf;

import java.util.Objects;

public class FolhaDePagamento {
    
    private double calculaSalarioBruto(Funcionario f1, int horas_trabalhadas){
        double valor = f1.getSalario();
        if (Objects.equals(f1.getTipoContrato(), Funcionario.Tipo_contrato.Horista)) {
            valor = f1.getSalario()*horas_trabalhadas;
        }
        return valor;
    }

    private double calculaDescontoINSS(double salario_bruto){
        double percentual = 1;
        double valor_contribuicao = 0;
        if (salario_bruto < 1659.38) {
            percentual = 0.08;
            valor_contribuicao = salario_bruto*percentual;
        } else {
            if (salario_bruto < 2765.66) {
                percentual = 0.09;
                valor_contribuicao = salario_bruto*percentual;
            } else {
                percentual = 0.11;
                valor_contribuicao = salario_bruto*percentual;
                if (salario_bruto > 5531.31) {
                    valor_contribuicao = 5531.31*percentual;    
                }
            }
        }
        return valor_contribuicao;
    }
    
    private double calculaImpostoDeRenda(double salario_bruto){
        double percentual = 1;
        double valor_IR = 0; //valor do Imposto de Renda
        if (salario_bruto > 1903.99 && salario_bruto < 2826.65) {
            percentual = 0.075;
            valor_IR = (salario_bruto * percentual) - 142.80;
        } 
        else {
            if (salario_bruto > 2826.65 && salario_bruto < 3751.05) {
                percentual = 0.150;
                valor_IR = (salario_bruto * percentual) - 354.80;
            }
            if (salario_bruto > 3751.05 && salario_bruto < 4664.68) {
                percentual = 0.225;
                valor_IR = (salario_bruto * percentual) - 636.13;
            }
            if (salario_bruto > 4664.68) {
                percentual = 0.275;
                valor_IR = (salario_bruto * percentual) - 869.36;
            }
        }
        return valor_IR;
    }

    private double calculaSalarioLiquido(Funcionario f1, double salario_bruto){
        double valor_salario_liquido = 0;
        valor_salario_liquido = salario_bruto-this.calculaDescontoINSS(salario_bruto)-this.calculaImpostoDeRenda(salario_bruto);
        return valor_salario_liquido;
    }

    public void mostraFolhaDePagamento(Funcionario f1, int horas_trabalhadas){
        System.out.printf("-> FOLHA PAGAMENTO DO FUNCIONARIO ", f1.getNome());
        System.out.println("SALARIO BRUTO DO FUNCIONARIO: R$"+this.calculaSalarioBruto(f1, horas_trabalhadas));
        System.out.println("VALOR A PAGAR DE INSS PELO FUNCIONARIO: R$"+this.calculaDescontoINSS(this.calculaSalarioBruto(f1, horas_trabalhadas)));
        System.out.println("VALOR A PAGAR DE IMPOSTO DE RENDA: R$"+this.calculaImpostoDeRenda(this.calculaSalarioBruto(f1, horas_trabalhadas)));
        System.out.println("SALARIO LIQUIDO: R$"+this.calculaSalarioLiquido(f1, this.calculaSalarioBruto(f1, horas_trabalhadas)));
    }
}
