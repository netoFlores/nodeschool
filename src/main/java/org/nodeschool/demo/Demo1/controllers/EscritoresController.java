package org.nodeschool.demo.Demo1.controllers;

import org.nodeschool.demo.Demo1.Response.ResponseWrapper;
import org.nodeschool.demo.Demo1.models.Escritor;
import org.nodeschool.demo.Demo1.repository.EscritorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "api/escritores")
public class EscritoresController {

    @Autowired
    private EscritorRepository escritorRepository;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseWrapper<String> guardar(@RequestBody Escritor escritor){
        ResponseWrapper<String> response = new ResponseWrapper<>();

        try{
            escritorRepository.save(escritor);
            System.out.println(escritor.toString());
            response.setResponse("Se guardo un nuevo escritor.");
        }catch(Exception e){
            response.setErrorCode(HttpStatus.INTERNAL_SERVER_ERROR.toString());
            response.setErrorMessage("Error al guardar escritor");
        }

        return response;
    }

    @RequestMapping(method = RequestMethod.PUT)
    public ResponseWrapper<String> actualizar(@RequestBody Escritor escritor){
        ResponseWrapper<String> response = new ResponseWrapper<>();

        try{
            escritorRepository.save(escritor);
            response.setResponse("Se actualizo un nuevo escritor.");
        }catch(Exception e){
            response.setErrorCode(HttpStatus.INTERNAL_SERVER_ERROR.toString());
            response.setErrorMessage("Error al actualizo  escritor");
        }

        return response;
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public ResponseWrapper<String> eliminar(@RequestBody Escritor escritor){
        ResponseWrapper<String> response = new ResponseWrapper<>();

        try{
            escritorRepository.delete(escritor);
            response.setResponse("Se elimino escritor.");
        }catch(Exception e){
            response.setErrorCode(HttpStatus.INTERNAL_SERVER_ERROR.toString());
            response.setErrorMessage("Error al elimino escritor");
        }

        return response;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseWrapper<Optional<Escritor>> buscarPorId(@PathVariable(value = "id") Integer idEscritor){
        ResponseWrapper<Optional<Escritor>> response =  new ResponseWrapper<>();

        try{
            response.setResponse(escritorRepository.findById(idEscritor));
        }catch(Exception e){
            response.setErrorCode(HttpStatus.INTERNAL_SERVER_ERROR.toString());
            response.setErrorMessage("No se encontro escritor ".concat(idEscritor.toString()));
        }

        return response;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseWrapper<List<Escritor>> all(){
        ResponseWrapper<List<Escritor>> response = new ResponseWrapper<>();

        try{
            response.setResponse(escritorRepository.findAll());
        }catch(Exception e){
            response.setErrorCode(HttpStatus.INTERNAL_SERVER_ERROR.toString());
            response.setErrorMessage("No se encontro escritor ");
        }

        return response;
    }
}
