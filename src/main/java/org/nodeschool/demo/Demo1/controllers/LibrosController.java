package org.nodeschool.demo.Demo1.controllers;

import org.nodeschool.demo.Demo1.Response.ResponseWrapper;
import org.nodeschool.demo.Demo1.models.Libros;
import org.nodeschool.demo.Demo1.repository.LibrosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/libros/")
public class LibrosController {

    @Autowired
    private LibrosRepository librosRepository;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseWrapper<String> guardar(@RequestBody Libros libros){
        ResponseWrapper<String> response = new ResponseWrapper<>();

        try{
            librosRepository.save(libros);
            response.setResponse("Se guardo un nuevo libro");
        }catch(Exception e){
            response.setErrorCode(HttpStatus.INTERNAL_SERVER_ERROR.toString());
            response.setErrorMessage("No se guardo libro ");
        }

        return response;
    }

    @RequestMapping(method = RequestMethod.PUT)
    public ResponseWrapper<String> actualizar(@RequestBody Libros libros){
        ResponseWrapper<String> response = new ResponseWrapper<>();

        try{
            librosRepository.save(libros);
            response.setResponse("Se actualizo libro");
        }catch(Exception e){
            response.setErrorCode(HttpStatus.INTERNAL_SERVER_ERROR.toString());
            response.setErrorMessage("No se actualizo ");
        }

        return response;
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public ResponseWrapper<String> delete(@RequestBody Libros libros){
        ResponseWrapper<String> response = new ResponseWrapper<>();

        try{
            librosRepository.save(libros);
            response.setResponse("Se elimino un libro");
        }catch(Exception e){
            response.setErrorCode(HttpStatus.INTERNAL_SERVER_ERROR.toString());
            response.setErrorMessage("No se elimino  libro ");
        }

        return response;
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public ResponseWrapper<Optional<Libros>> obtenerPorId(@PathVariable(value = "id", required = true) Integer idLibro){
        ResponseWrapper<Optional<Libros>> response = new ResponseWrapper<>();

        try{
            response.setResponse(librosRepository.findById(idLibro));
        }catch(Exception e){
            response.setErrorCode(HttpStatus.INTERNAL_SERVER_ERROR.toString());
            response.setErrorMessage("No se encontro libro ".concat(idLibro.toString()));
        }

        return response;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseWrapper<List<Libros>> obtenerTodo(){
        ResponseWrapper<List<Libros>> response = new ResponseWrapper<>();

        try{
            response.setResponse(librosRepository.findAll());
        }catch(Exception e){
            response.setErrorCode(HttpStatus.INTERNAL_SERVER_ERROR.toString());
            response.setErrorMessage("No se encontro data ");
        }

        return response;
    }

}
