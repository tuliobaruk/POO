import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SistemaRh {
    private List<Funcionario> funcionarios = new ArrayList<>();
    private List<Ferias> listaDeFerias = new ArrayList<>();

    public SistemaRh(){};

    public void calcularFerias(Funcionario func){
        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        System.out.println(
                STR."Nome: \{func.getNome()}\n"
                + STR."Cargo: \{func.getCargo()}\n"
                + STR."Data de Admissão: "
                + STR."\{func.getDataDeAdimissao().getDayOfMonth()}/"
                + STR."\{func.getDataDeAdimissao().getMonthValue()}/"
                + STR."\{func.getDataDeAdimissao().getYear()}"
        );

        System.out.println("\nInforme a data de inicio (dia/mês/ano): ");
        String entradaData = scanner.nextLine();
        LocalDate dataDeInicioFerias = LocalDate.parse(entradaData,formatter);
        System.out.println(dataDeInicioFerias);

        System.out.println("Informe a duração desejada: ");
        int duracaoFerias = scanner.nextInt();
        System.out.println(duracaoFerias);


        long mesesDesdeAdmissao = ChronoUnit.MONTHS.between(func.getDataDeAdimissao(), dataDeInicioFerias);
        System.out.println(mesesDesdeAdmissao);

        if (mesesDesdeAdmissao < 12){
            System.out.println("o funcionário não possui direito a\n" +
                    "férias no momento, de acordo com as regras da CLT.");
            return;
        } else if (duracaoFerias > 30) {
            System.out.println("O período de férias não pode ser superior a 30 dias corridos.");
            return;
        } else if (func.calcularSaldo() >= duracaoFerias){
            Ferias feriasFuncionario = new Ferias(func, dataDeInicioFerias, dataDeInicioFerias.plusDays(duracaoFerias));

            System.out.println(
                    STR."Funcionario: \{feriasFuncionario.getFuncionario().getNome()}"
                            + STR."Data de Inicio: \{feriasFuncionario.getDataDeInicio()}\n"
                            + STR."Data de Termino: \{feriasFuncionario.getDataDeTermino()}"
            );

            System.out.println("\n Deseja confirmar (Sim/Não): ");
            String confirmacao = scanner.nextLine();
            while (confirmacao.toLowerCase() != "sim" && confirmacao.toLowerCase() != "não"){
                System.out.println("Digite sim ou não");
                confirmacao = scanner.nextLine();
            }
            if (confirmacao.toLowerCase() == "sim"){
                func.setEmFerias(true);
                listaDeFerias.add(feriasFuncionario);
            }
        }
    }
    public void listarFerias(){
        for (Ferias f: listaDeFerias) System.out.println(f);
    };
}
