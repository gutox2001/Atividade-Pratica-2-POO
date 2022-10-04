package br.ufv.caf;

import java.util.Calendar;

public class Funcionario { 
    protected enum Tipo_contrato{
        Efetivo, Horista;
    }

    private String nome; //data_nascimento, data_admissão;
    private Calendar data_nascimento = Calendar.getInstance();
    private Calendar data_admissao = Calendar.getInstance();
    private double salario;
    private int num_filhos_menores;
    private Tipo_contrato contrato;

    public Funcionario(String nome, int dia_nascimento, int mes_nascimento, int ano_nascimento){
        this.nome = nome;
        this.data_nascimento.set(Calendar.DAY_OF_MONTH, dia_nascimento);
        this.data_nascimento.set(Calendar.MONTH, mes_nascimento-1);
        this.data_nascimento.set(Calendar.YEAR, ano_nascimento);
        this.contrato = Tipo_contrato.Efetivo;
        this.num_filhos_menores = 0;
        this.salario = 0.0;
        this.data_admissao.set(Calendar.DAY_OF_MONTH, data_admissao.get(Calendar.DAY_OF_MONTH));
        this.data_admissao.set(Calendar.MONTH, data_admissao.get(Calendar.MONTH));
        this.data_admissao.set(Calendar.YEAR, data_admissao.get(Calendar.YEAR));
    }

    //Funções set.atributos: alteram atributos do Funcionário;
    private void setNum_filhos_menores(int num){
        this.num_filhos_menores = num;
        }
    private void setTipoContrato(Tipo_contrato contrato){
        this.contrato = contrato;
    }
    private void setSalario(double salario){
        this.salario = salario;
    }
    private void setData_admissao(int dia_admissao, int mes_admissao, int ano_admissao){
        this.data_admissao.set(Calendar.DAY_OF_MONTH, dia_admissao);
        this.data_admissao.set(Calendar.MONTH, mes_admissao-1);
        this.data_admissao.set(Calendar.YEAR, data_admissao.get(Calendar.YEAR));
    }

    public void contratar(int num_filhos_menores, Tipo_contrato contrato, double salario, int dia_admissao, int mes_admissao, int ano_admissao){
        setNum_filhos_menores(num_filhos_menores);
        setTipoContrato(contrato);
        setSalario(salario);
        setData_admissao(dia_admissao, mes_admissao, ano_admissao);
    }

    //Funções get.atributos: retornam atributos do Funcionário;
    public String getNome(){
        return nome;
        }
    public int getDia_nascimento(){
        return data_nascimento.get(Calendar.DAY_OF_MONTH);
    }
    public int getMes_nascimento(){
        return data_nascimento.get(Calendar.MONTH)+1;
    }
    public int getAno_nascimento(){
        return data_nascimento.get(Calendar.YEAR);
    }
    public int getNum_filhos_menores(){
        return num_filhos_menores;
        }
    public Tipo_contrato getTipoContrato(){
        return contrato;
    }
    public double getSalario(){
        return salario;
    }
    public Integer getDia_admissao(){
        return data_admissao.get(Calendar.DAY_OF_MONTH);
    }
    public Integer getMes_admissao(){
        int mes_saída = data_admissao.get(Calendar.MONTH)+1;
        return mes_saída;
    }
    public Integer getAno_admissao(){
        return data_admissao.get(Calendar.YEAR);
    }

    public void mostraFuncionario(){
        System.out.println("----------------------------------------------\n");
        System.out.println("NOME DO FUNCIONÁRIO: "+this.getNome());
        System.out.println("DATA DE NASCIMENTO: "+this.getDia_nascimento()+"/"+this.getMes_nascimento()+"/"+this.getAno_nascimento());
        System.out.println("NÚMERO DE FILHOS MENORES: "+this.num_filhos_menores);
        System.out.println("DATA DE ADMISSÃO: "+this.getDia_admissao()+"/"+this.getMes_admissao()+"/"+this.getAno_admissao());
        System.out.println("TIPO DE CONTRATO: "+this.getTipoContrato());
        System.out.println("----------------------------------------------\n");
    }

    /*Date trasnformaEmData(String data) throws ParseException{
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        Date dataFormatada = formato.parse(data);
        return dataFormatada;
    }*/

}
