package com.emerson;

import io.micrometer.core.annotation.Counted;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("pessoa")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PessoaResource {

    @Counted(value = "counted.getPessoa", description = "Quantidade de vezes que o endpoint getPessoa foi chamado")
    @GET
    public List<Pessoa> getPessoa() {
        return Pessoa.listAll();
    }

    @POST
    @Transactional
    public Pessoa addPessoa(Pessoa pessoa) {
        pessoa.id = null;
        pessoa.persist();

        return pessoa;
    }

    @PUT
    @Transactional
    public Pessoa updatePessoa(Pessoa pessoa) {
        Pessoa pessoaBanco = Pessoa.findById(pessoa.id);

        if (pessoaBanco == null) {
            throw new NotFoundException();
        }

        pessoaBanco.nome = pessoa.nome;
        pessoaBanco.anoNascimento = pessoa.anoNascimento;
        pessoaBanco.persist();

        return pessoaBanco;
    }

    @DELETE
    @Transactional
    public void deletePessoa(int id) {
        Pessoa.deleteById(id);
    }

    @GET
    @Path("/findByAnoNascimento")
    public List<Pessoa> findByAnoNascimento(@QueryParam("anoNascimento") int anoNascimento) {
        return Pessoa.findByAnoNascimento(anoNascimento);
    }
}
