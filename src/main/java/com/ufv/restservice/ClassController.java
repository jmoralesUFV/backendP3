package com.ufv.restservice;

import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;

@RestController
public class ClassController {

    Jsonreadernew jsons = new Jsonreadernew();

    public ArrayList<Usuario> usuarios = jsons.leerUsuarios();
    public ArrayList<Equipo> equipos = jsons.leerEquipos();
    public ArrayList<Prestamos> prestamos = jsons.leePrestamos();

    public int contadorU = usuarios.size();
    public int contagorE = equipos.size();
    public int contadorP = prestamos.size();

    //public Agenda agendaU;
    private final String urlU = "/users";
    private final String urlE = "/devices";
    private final String urlP = "/loans";

    public ClassController()
    {

    }

    /*
        -------------------------------------------------
        CJTO DE FUNCIONES PARA EL LLAMAMIENTO DE USUARIOS
        -------------------------------------------------
    */


    @GetMapping("/")
    public String saludar() {
        // ---
        return "Hola!";
    }

    @GetMapping(urlU+"/{id}")
    public Usuario getUsuarioByIdREST(@PathVariable int id) {
        //
        return this.usuarios.get(id);
    }

    @GetMapping(urlU)
    public ArrayList<Usuario> getAllUsuarios() {
        //
        return this.usuarios;
    }

    @PostMapping(urlU)
    public Usuario addUsuario(@RequestBody Usuario c) {

        // Recoger el contacto del request

        c.setId(contadorU);
        contadorU++;

        // Guardo el contacto
        this.usuarios.add(c);

        jsons.EscribirUsers(usuarios);

        // Devolver el contacto creado (Buena práctica)
        return c;
    }

    @PutMapping(urlU+"/{id}")
    public Usuario updateUsuarioByIdREST(@RequestBody Usuario c, @PathVariable int id) {
        //

        this.usuarios.get(id).setNombre(c.getNombre());
        this.usuarios.get(id).setDepartamento(c.getDepartamento());
        this.usuarios.get(id).setTlf(c.getTlf());
        this.usuarios.get(id).setEmailContact(c.getEmailContact());
        this.usuarios.get(id).setUbicacion(c.getUbicacion());

        jsons.EscribirUsers(usuarios);

        return c;

    }

    @DeleteMapping(urlU+"/{id}")
    public Usuario deleteUserByIdREST(@PathVariable int id) {
        //
        Usuario user = this.usuarios.get(id);
        this.usuarios.remove(id);

        jsons.EscribirUsers(usuarios);

        return user;
    }

    /*
        -------------------------------------------------
        CJTO DE FUNCIONES PARA EL TRATAMIENTO DE EQUIPOS
        -------------------------------------------------
    */

    @GetMapping(urlE+"/{id}")
    public Equipo getEquipoByIdREST(@PathVariable int id) {
        //
        return this.equipos.get(id);
    }

    @GetMapping(urlE)
    public ArrayList<Equipo> getEquipos() {
        //
        return this.equipos;
    }

    @PostMapping(urlE)
    public Equipo addEquipo(@RequestBody Equipo E) {

        // Recoger el contacto del request

        E.setId_del_equipo(contagorE);
        contagorE++;

        // Guardo el contacto
        this.equipos.add(E);

        jsons.EscribirEquipos(equipos);


        // Devolver el equipo creado (Buena práctica)
        return E;
    }

    @PutMapping(urlE+"/{id}")
    public Equipo updateEquipoByIdREST(@RequestBody Equipo e, @PathVariable int id) {
        //

        this.equipos.get(id).setId_del_equipo(e.getId_del_equipo());
        this.equipos.get(id).setTipo_de_equipo(e.getTipo_de_equipo());
        this.equipos.get(id).setMarca_del_equipo(e.getMarca_del_equipo());
        this.equipos.get(id).setUso_del_equipo(e.getUso_del_equipo());
        this.equipos.get(id).setSistema_operativo(e.getSistema_operativo());
        this.equipos.get(id).setHardware(e.getHardware());
        this.equipos.get(id).setLista_software(e.getLista_software());

        jsons.EscribirEquipos(equipos);

        return e;

    }

    @DeleteMapping(urlE+"/{id}")
    public Equipo deleteEquipoByIdREST(@PathVariable int id) {
        //

        Equipo equipo = equipos.get(id);
        this.equipos.remove(id);

        jsons.EscribirEquipos(equipos);

        return equipo;
    }

    /*
        -------------------------------------------------
        CJTO DE FUNCIONES PARA EL TRATAMIENTO DE PRESTAMOS
        -------------------------------------------------
    */

    @GetMapping(urlP+"/{id}")
    public Prestamos getPrestamoByIdREST(@PathVariable int id) {
        //
        return this.prestamos.get(id);

    }

    @GetMapping(urlP)
    public ArrayList<Prestamos> getPrestamos() {
        //
        return this.prestamos;
    }

    @PostMapping(urlP)
    public Prestamos addPrestamo(@RequestBody Prestamos P) {

        // Recoger el contacto del request
        P.setId(contadorP);
        contadorP++;

        // Guardo el contacto
        this.prestamos.add(P);

        jsons.EscribirPrestamos(prestamos);

        // Devolver el préstamo creado (Buena práctica)
        return P;
    }

    @PutMapping(urlP+"/{id}")
    public Prestamos updatePrestamoByIdREST(@RequestBody Prestamos p, @PathVariable int id) {
        //
        this.prestamos.get(id).setId(p.getId());
        this.prestamos.get(id).setUserID(p.getUserID());
        this.prestamos.get(id).setEquipoID(p.getEquipoID());
        this.prestamos.get(id).setFiniPrestamo(p.getFiniPrestamo());
        this.prestamos.get(id).setFfinPrestamo(p.getFfinPrestamo());
        this.prestamos.get(id).setFrealPrestanmo(p.getFrealPrestanmo());
        this.prestamos.get(id).setComentarios(p.getComentarios());

        jsons.EscribirPrestamos(prestamos);

        return p;
    }


    @DeleteMapping(urlP+"/{id}")
    public Prestamos deletePrestamoByIdREST(@PathVariable int id) {
        //

        Prestamos prestamo = prestamos.get(id);
        this.prestamos.remove(id);

        jsons.EscribirPrestamos(prestamos);

        return prestamo;
    }

}
