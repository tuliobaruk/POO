import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Funcionario {
    static int numeroDeFuncionarios = 0;
    private int codigo;
    private String nome;
    private String cargo;
    private LocalDate dataDeAdimissao;
    private LocalDate periodoAquisitivo;
    private double saldoFerias;
    private boolean emFerias;

    public Funcionario(){
        this.codigo = numeroDeFuncionarios + 1;
        numeroDeFuncionarios +=1;

        this.saldoFerias = 0;
    };

    public Funcionario(String nome, String cargo, LocalDate dataDeAdimissao) {
        this();
        this.nome = nome;
        this.cargo = cargo;
        this.dataDeAdimissao = dataDeAdimissao;
        this.periodoAquisitivo = dataDeAdimissao;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public LocalDate getDataDeAdimissao() {
        return dataDeAdimissao;
    }

    public void setDataDeAdimissao(LocalDate dataDeAdimissao) {
        this.dataDeAdimissao = dataDeAdimissao;
    }

    public boolean isEmFerias() {
        return emFerias;
    }

    public void setEmFerias(boolean emFerias) {
        this.emFerias = emFerias;
    }

    public LocalDate getPeriodoAquisitivo() {
        return periodoAquisitivo;
    }

    public void setPeriodoAquisitivo(LocalDate periodoAquisitivo) {
        this.periodoAquisitivo = periodoAquisitivo;
    }

    public double getSaldoFerias() {
        return saldoFerias;
    }

    public void setSaldoFerias(double saldoFerias) {
        this.saldoFerias = saldoFerias;
    }

    public double calcularSaldo(){
        long mesesDePeriodoAquisitivo = ChronoUnit.MONTHS.between(this.getPeriodoAquisitivo(), LocalDate.now());
        if (saldoFerias == 0){
            if (mesesDePeriodoAquisitivo >= 12){
                this.saldoFerias = (mesesDePeriodoAquisitivo * 2.5);
                this.periodoAquisitivo = LocalDate.now();
            }
        } else {
            if (mesesDePeriodoAquisitivo >= 12){
                this.saldoFerias = this.getSaldoFerias() + (mesesDePeriodoAquisitivo * 2.5);
                this.periodoAquisitivo = LocalDate.now();
            }
        }

        return this.saldoFerias;
    };
}
