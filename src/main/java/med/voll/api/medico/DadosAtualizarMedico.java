package med.voll.api.medico;

import jakarta.validation.constraints.NotNull;
import med.voll.api.endereco.DadosEndereco;

public record DadosAtualizarMedico(

        String nome,
        String telefone,
        DadosEndereco endereco,
        String email) {
}

