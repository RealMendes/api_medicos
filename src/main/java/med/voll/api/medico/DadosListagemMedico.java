package med.voll.api.medico;

public record DadosListagemMedico(String nome, String crm, String email, Especialidade especialidade, Long id) {

    public  DadosListagemMedico(Medico medico){
        this(medico.getNome(), medico.getCrm(), medico.getEmail(), medico.getEspecialidade(), medico.getId());
    }



}

