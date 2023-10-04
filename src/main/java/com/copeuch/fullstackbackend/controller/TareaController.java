package com.copeuch.fullstackbackend.controller;

import com.copeuch.fullstackbackend.exception.TareaNotFoundException;
import com.copeuch.fullstackbackend.model.Tarea;
import com.copeuch.fullstackbackend.repository.TareaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/* Created by Arjun Gautam */
@RestController
@CrossOrigin("http://localhost:3000")
public class TareaController {

    @Autowired
    private TareaRepository tareaRepository;

    @PostMapping("/tarea")
    Tarea newTarea(@RequestBody Tarea newTarea) {
        return tareaRepository.save(newTarea);
    }

    @GetMapping("/tareas")
    List<Tarea> getAllTareas() {
        return tareaRepository.findAll();
    }

    @GetMapping("/tarea/{id}")
    Tarea getTareaById(@PathVariable Long id) {
        return tareaRepository.findById(id)
                .orElseThrow(() -> new TareaNotFoundException(id));
    }

    @PutMapping("/tarea/{id}")
    Tarea updateTarea(@RequestBody Tarea newTarea, @PathVariable Long id) {
        return tareaRepository.findById(id)
                .map(tarea -> {
                    tarea.setDescripcion(newTarea.getDescripcion());
                    tarea.setFecha(newTarea.getFecha());
                    tarea.setVigente(newTarea.getVigente());
                    return tareaRepository.save(tarea);
                }).orElseThrow(() -> new TareaNotFoundException(id));
    }

    @DeleteMapping("/tarea/{id}")
    String deleteTarea(@PathVariable Long id){
        if(!tareaRepository.existsById(id)){
            throw new TareaNotFoundException(id);
        }
        tareaRepository.deleteById(id);
        return  "Tarea with id "+id+" has been deleted success.";
    }



}
