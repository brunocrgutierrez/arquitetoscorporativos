package br.gov.serpro.sri.servicos.rest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import java.net.URI;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriInfo;

import br.gov.frameworkdemoiselle.BadRequestException;
import br.gov.frameworkdemoiselle.NotFoundException;
import br.gov.frameworkdemoiselle.security.LoggedIn;
import br.gov.frameworkdemoiselle.security.RequiredPermission;
import br.gov.frameworkdemoiselle.transaction.Transactional;
import br.gov.frameworkdemoiselle.util.ValidatePayload;
import br.gov.serpro.sri.dominio.business.DARFBC;
import br.gov.serpro.sri.dominio.business.RetencaoBC;
import br.gov.serpro.sri.dominio.entity.DARF;
import br.gov.serpro.sri.dominio.entity.Retencao;
import br.gov.serpro.sri.servicos.util.Util;

@Api(value = "darfs")
@Path("darfs")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class DARFREST {

	@Inject
	private DARFBC bc;
	
	@Inject
	private RetencaoBC retencaoBC;
	
	
	@GET
	@LoggedIn
    @ApiOperation(value = "Lista com paginação no servidor", response = Response.class, notes="Se não informar os parâmetros, todos os registros são retornados.")
	@ApiResponses(value = {@ApiResponse(code = 200, message = "Operacação realizada com sucesso", response = Response.class),
						   @ApiResponse(code = 400, message = "Parâmetros inválidos", response = Response.class)})
    public Response list(@ApiParam(name="sort", value="Representa o campo/ordem(asc/desc). O prefixo \"-\" indica ordem inversa", example="http://localhost:8080/sri-servicos/darfs?sort=-name&offset=30&limit=10") @QueryParam("sort") String sort, 
    					 @ApiParam(name="offset", value="Representa a posição do primeiro registro") @QueryParam("offset") int offset, 
    					 @ApiParam(name="limit", value="Representa a quantidade de registros (tamanho da página)") @QueryParam("limit") int limit) throws NotFoundException 
	{
		
        if ((offset > -1) && (limit > 0) && !sort.isEmpty() && (sort.startsWith("-") ? Util.fieldInClass(sort.substring(1), DARF.class) : Util.fieldInClass(sort, DARF.class))) {
        	
        	String order = sort.startsWith("-") ? "desc" : "asc";
        	
            return Response.ok().entity(bc.list(sort.startsWith("-") ? sort.substring(1) : sort, order, offset, limit)).build();
        }
        else if ((sort == null || sort.isEmpty()) && offset == 0 && limit == 0){ // se não informar os parâmetros, retorna todos os registros
        	return Response.ok().entity(bc.findAll()).build();
        }
        else{
        	return Response.status(Status.BAD_REQUEST).entity(null).build();
        }

        	
        	
    }
	
	@Path("/rnf/c1-c2")
	@GET
    @ApiOperation(value = "Cenários 1 e 2 para testes de RNF. Lista com paginação no servidor", response = Response.class, notes="Se não informar os parâmetros, todos os registros são retornados.")
	@ApiResponses(value = {@ApiResponse(code = 200, message = "Operacação realizada com sucesso", response = Response.class),
						   @ApiResponse(code = 400, message = "Parâmetros inválidos", response = Response.class)})
    public Response list2(@ApiParam(name="sort", value="Representa o campo/ordem(asc/desc). O prefixo \"-\" indica ordem inversa", example="http://localhost:8080/sri-servicos/darfs?sort=-name&offset=30&limit=10") @QueryParam("sort") String sort, 
    					 @ApiParam(name="offset", value="Representa a posição do primeiro registro") @QueryParam("offset") int offset, 
    					 @ApiParam(name="limit", value="Representa a quantidade de registros (tamanho da página)") @QueryParam("limit") int limit) throws NotFoundException 
	{
		
        if ((offset > -1) && (limit > 0) && !sort.isEmpty() && (sort.startsWith("-") ? Util.fieldInClass(sort.substring(1), DARF.class) : Util.fieldInClass(sort, DARF.class))) {
        	
        	String order = sort.startsWith("-") ? "desc" : "asc";
        	
            return Response.ok().entity(bc.list(sort.startsWith("-") ? sort.substring(1) : sort, order, offset, limit)).build();
        }
        else if ((sort == null || sort.isEmpty()) && offset == 0 && limit == 0){ // se não informar os parâmetros, retorna todos os registros
        	return Response.ok().entity(bc.findAll()).build();
        }
        else{
        	return Response.status(Status.BAD_REQUEST).entity(null).build();
        }

        	
        	
    }
	
	@Path("/rnf/c3")
	@GET
    @LoggedIn
    @ApiOperation(value = "Cenários 3 para testes de RNF. Lista com paginação no servidor", response = Response.class, notes="Se não informar os parâmetros, todos os registros são retornados.")
	@ApiResponses(value = {@ApiResponse(code = 200, message = "Operacação realizada com sucesso", response = Response.class),
						   @ApiResponse(code = 400, message = "Parâmetros inválidos", response = Response.class)})
    public Response list3(@ApiParam(name="sort", value="Representa o campo/ordem(asc/desc). O prefixo \"-\" indica ordem inversa", example="http://localhost:8080/sri-servicos/darfs?sort=-name&offset=30&limit=10") @QueryParam("sort") String sort, 
    					 @ApiParam(name="offset", value="Representa a posição do primeiro registro") @QueryParam("offset") int offset, 
    					 @ApiParam(name="limit", value="Representa a quantidade de registros (tamanho da página)") @QueryParam("limit") int limit) throws NotFoundException 
	{
		
        if ((offset > -1) && (limit > 0) && !sort.isEmpty() && (sort.startsWith("-") ? Util.fieldInClass(sort.substring(1), DARF.class) : Util.fieldInClass(sort, DARF.class))) {
        	
        	String order = sort.startsWith("-") ? "desc" : "asc";
        	
            return Response.ok().entity(bc.list(sort.startsWith("-") ? sort.substring(1) : sort, order, offset, limit)).build();
        }
        else if ((sort == null || sort.isEmpty()) && offset == 0 && limit == 0){ // se não informar os parâmetros, retorna todos os registros
        	return Response.ok().entity(bc.findAll()).build();
        }
        else{
        	return Response.status(Status.BAD_REQUEST).entity(null).build();
        }

        	
        	
    }
	
	@Path("/rnf/c4-c5-c6-c7")
	@GET
    @LoggedIn
    @RequiredPermission(resource="darf", operation="consultar")
    @ApiOperation(value = "Cenários 4, 5, 6 e 7 para testes de RNF. Lista com paginação no servidor", response = Response.class, notes="Se não informar os parâmetros, todos os registros são retornados.")
	@ApiResponses(value = {@ApiResponse(code = 200, message = "Operacação realizada com sucesso", response = Response.class),
						   @ApiResponse(code = 400, message = "Parâmetros inválidos", response = Response.class)})
    public Response list4(@ApiParam(name="sort", value="Representa o campo/ordem(asc/desc). O prefixo \"-\" indica ordem inversa", example="http://localhost:8080/sri-servicos/darfs?sort=-name&offset=30&limit=10") @QueryParam("sort") String sort, 
    					 @ApiParam(name="offset", value="Representa a posição do primeiro registro") @QueryParam("offset") int offset, 
    					 @ApiParam(name="limit", value="Representa a quantidade de registros (tamanho da página)") @QueryParam("limit") int limit) throws NotFoundException 
	{
		
        if ((offset > -1) && (limit > 0) && !sort.isEmpty() && (sort.startsWith("-") ? Util.fieldInClass(sort.substring(1), DARF.class) : Util.fieldInClass(sort, DARF.class))) {
        	
        	String order = sort.startsWith("-") ? "desc" : "asc";
        	
            return Response.ok().entity(bc.list(sort.startsWith("-") ? sort.substring(1) : sort, order, offset, limit)).build();
        }
        else if ((sort == null || sort.isEmpty()) && offset == 0 && limit == 0){ // se não informar os parâmetros, retorna todos os registros
        	return Response.ok().entity(bc.findAll()).build();
        }
        else{
        	return Response.status(Status.BAD_REQUEST).entity(null).build();
        }

        	
        	
    }
	
	@GET
    @Path("count")
    @LoggedIn
    @ApiOperation(value = "Quantidade de registro",
                  notes = "Usado para trabalhar as tabelas com paginação no servidor",
                  response = Response.class
    )
    public Response count() throws NotFoundException {
        return Response.ok().entity(bc.count()).build();
    }
	
	@GET
	@Path("/{id}")
	@LoggedIn
	@ApiOperation(value = "Busca darf pelo id", notes = "É obrigatório informar o parâmetro", response = Response.class)	
	@ApiResponses(value = { @ApiResponse(code = 400, message = "É obrigatório informar o parâmetro") })
	public Response load(@ApiParam(value = "id do darf") @PathParam("id") Long id) throws Exception {
		DARF result = bc.load(id);

		if (result == null) {
			throw new NotFoundException();
		}
		
		return Response.ok().entity(result).build();
		
	}
	
	@POST
	@LoggedIn
	@Transactional
	@ValidatePayload
	@RequiredPermission(resource = "darf", operation = "inserir")
	@ApiOperation(value = "Insere darf", response = Response.class)	
	@ApiResponses(value = { @ApiResponse(code = 400, message = "Erro nos parâmetros informados") })
	public Response insert(DARF darf, @Context UriInfo uriInfo) throws Throwable {

		checkId(darf);
		
		Retencao retencao = retencaoBC.load(darf.getRetencao().getId());
		
		darf.setRetencao(retencao);
		DARF darfNovo = bc.insert(darf);
		URI location = uriInfo.getRequestUriBuilder().path(darfNovo.getId().toString()).build();
	
		return Response.created(location).entity(darfNovo).build();
	}
	
	@PUT
	@Path("/{id}")
	@Transactional
	@LoggedIn
	@ValidatePayload
	@ApiOperation(value = "Atualiza um DARF já existente", notes = "É obrigatório informar o parâmetro", response = Response.class)	
	@ApiResponses(value = { @ApiResponse(code = 400, message = "É obrigatório informar o parâmetro") })
	public Response update(@ApiParam(value = "id do darf", required=true) @PathParam("id") Long id, DARF darf, @Context UriInfo uriInfo) throws Exception {
		
		darf.setId(id);
		DARF darfAtualizado = bc.update(darf);
		
		if (darfAtualizado == null) {
			return Response.status(Status.NOT_FOUND).build();
		} else {
			
			URI location = uriInfo.getRequestUriBuilder().build();
			
			return Response.noContent().location(location).entity(darfAtualizado).build();
		}
	}

	@DELETE
	@LoggedIn
	@Path("/{id}")
	@Transactional
	@ApiOperation(value = "Exclui DARF pelo id", notes = "É obrigatório informar o parâmetro")	
	@ApiResponses(value = { @ApiResponse(code = 400, message = "É obrigatório informar o parâmetro") })
	public Response delete(@ApiParam(value = "id do DARF", required=true) @PathParam("id") Long id) throws Exception {
		
		bc.delete(id);
		
		return Response.noContent().build();
	}

	private void checkId(DARF entity) throws Exception {
		if (entity.getId() != null) {
			throw new BadRequestException();
		}
	}
	
}
