/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.digis01.ERoqueProgramacionNCapasWeb.Controller;

import com.digis01.ERoqueProgramacionNCapasWeb.DAO.ColoniaDAOImplementation;
import com.digis01.ERoqueProgramacionNCapasWeb.DAO.DireccionDAOImplementation;
import com.digis01.ERoqueProgramacionNCapasWeb.DAO.UsuarioDAOImplementation;
import com.digis01.ERoqueProgramacionNCapasWeb.DAO.RolDAOImplementation;
import com.digis01.ERoqueProgramacionNCapasWeb.DAO.EstadoDAOImplementation;
import com.digis01.ERoqueProgramacionNCapasWeb.DAO.MunicipioDAOImplementation;
import com.digis01.ERoqueProgramacionNCapasWeb.DAO.PaisDAOImplementation;
import com.digis01.ERoqueProgramacionNCapasWeb.JPA.Colonia;
import com.digis01.ERoqueProgramacionNCapasWeb.JPA.Direccion;
import com.digis01.ERoqueProgramacionNCapasWeb.JPA.Estado;
import com.digis01.ERoqueProgramacionNCapasWeb.JPA.Municipio;
import com.digis01.ERoqueProgramacionNCapasWeb.JPA.Pais;
import com.digis01.ERoqueProgramacionNCapasWeb.JPA.Rol;
import com.digis01.ERoqueProgramacionNCapasWeb.JPA.Usuario;
import com.digis01.ERoqueProgramacionNCapasWeb.JPA.UsuarioDireccion;
import jakarta.validation.Valid;
import java.io.IOException;

import java.util.List;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author digis
 */
@Controller
@RequestMapping("/usuario")
public class UsuarioController {

    private UsuarioDAOImplementation usuarioDAOImplementation;
    private RolDAOImplementation rolDAOImplementation;
    private DireccionDAOImplementation direccionDAOImplementation;
    private EstadoDAOImplementation estadoDAOImplementation;
    private PaisDAOImplementation paisDAOImplementation;
    private MunicipioDAOImplementation municipioDAOImplementation;
    private ColoniaDAOImplementation coloniaDAOImplementation;

    @Autowired
    public UsuarioController(UsuarioDAOImplementation usuarioDAOImplementation,
            RolDAOImplementation rolDAOImplementation, DireccionDAOImplementation direccionDAOImplementation,
            EstadoDAOImplementation estadoDAOImplementation, PaisDAOImplementation paisDAOImplementation,
            MunicipioDAOImplementation municipioDAOImplementation, ColoniaDAOImplementation coloniaDAOImplementation) {
        this.usuarioDAOImplementation = usuarioDAOImplementation;
        this.rolDAOImplementation = rolDAOImplementation;
        this.direccionDAOImplementation = direccionDAOImplementation;
        this.estadoDAOImplementation = estadoDAOImplementation;
        this.paisDAOImplementation = paisDAOImplementation;
        this.municipioDAOImplementation = municipioDAOImplementation;
        this.coloniaDAOImplementation = coloniaDAOImplementation;
    }

    @GetMapping("/listado")
    private String listadoUsuarios(Model model) {

        Usuario usuario = new Usuario();
        usuario.setNombre("");
        usuario.setApellidopaterno("");
        usuario.setApellidomaterno("");
        List<Usuario> usuarios = usuarioDAOImplementation.GetAll(usuario);
        model.addAttribute("Usuarios", usuarios);
        model.addAttribute("usuariobusqueda", new Usuario());    //Cambio

        return "listadoUsuarios";
    }

    @PostMapping("/listado")
    private String listadoUsuarios(Model model, @ModelAttribute("usuariobusqueda") Usuario usuariobusqueda) {
        List<Usuario> usuarios = usuarioDAOImplementation.GetAll(usuariobusqueda);
        model.addAttribute("Usuarios", usuarios);
        model.addAttribute("usuariobusqueda", usuariobusqueda);    //Cambio

        return "listadoUsuarios";
    }

    @GetMapping("/form/{idusuario}")
    public String Form(@PathVariable int idusuario, Model model) {

//         List<Rol> roles = rolDAOImplementation.GetAll();
//         model.addAttribute("roles", roles);
        model.addAttribute("roles", rolDAOImplementation.GetAll());
        model.addAttribute("paises", paisDAOImplementation.GetAll());
        model.addAttribute("estados", estadoDAOImplementation.GetAll());
        model.addAttribute("municipios", municipioDAOImplementation.GetAll());
        model.addAttribute("colonias", coloniaDAOImplementation.GetAll());

        if (idusuario == 0) {
            model.addAttribute("usuariodireccion", new UsuarioDireccion());
            return "formUsuarioEditable";

        } else {

//        Usuario usuario = usuarioDAOImplementation.GetById(idusuario);
//        model.addAttribute("usuario", usuario);}
            UsuarioDireccion usuarioDireccion = new UsuarioDireccion();

            usuarioDireccion.setUsuario(usuarioDAOImplementation.GetById(idusuario));
            usuarioDireccion.setDireccion(direccionDAOImplementation.GetByIdUsuario(idusuario));
            

            if (usuarioDireccion.getDireccion() != null) {
                
                model.addAttribute("Estados", estadoDAOImplementation.GetByIdPais(usuarioDireccion.getDireccion().getColonia().getMunicipio().getEstado().getPais().getIdpais()));
                model.addAttribute("Municipios", municipioDAOImplementation.GetByIdEstado(usuarioDireccion.getDireccion().getColonia().getMunicipio().getEstado().getIdestado()));
                model.addAttribute("Colonias", coloniaDAOImplementation.GetByIdMunicipio(usuarioDireccion.getDireccion().getColonia().getMunicipio().getIdmunicipio()));
            }
            model.addAttribute("usuariodireccion", usuarioDireccion);

            return "formUsuarioEditable";

        }
    }
    //Validacion a partir de la informacion del cliente

//    @PostMapping("/form")
//    public String Update(@ModelAttribute UsuarioDireccion usuariodireccion){
//        
//    if(usuariodireccion.getUsuario().getIdusuario() > 0 ){
//    usuarioDAOImplementation.Update(usuariodireccion.getUsuario());
//    
//    }else{
//    int idUsuario = usuarioDAOImplementation.Add(usuariodireccion.getUsuario());
//    
//   
////    Direccion direccion = new Direccion("Reforma", "09", "199", new Colonia(1), new Usuario(idUsuario));
////    usuariodireccion.setDireccion(direccion);
//    usuariodireccion.getDireccion().setUsuario(new Usuario(idUsuario));
//    direccionDAOImplementation.Add(usuariodireccion.direccion);
//    }
//    
//    return "redirect:/usuario/listado";
//    }
    //Validacion del cliente-servidor
    @PostMapping("/form")
    public String Update(@Valid @ModelAttribute("usuariodireccion") UsuarioDireccion usuariodireccion,
            @RequestParam("imagenFile") MultipartFile imagenFile,
            BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            model.addAttribute("usuariodireccion", usuariodireccion);

            return "formUsuarioEditable";
        }

        try {
            if (!imagenFile.isEmpty()) {
                byte[] bytes = imagenFile.getBytes();
                String imagenBase64 = Base64.encodeBase64String(bytes);
                usuariodireccion.getUsuario().setImagen(imagenBase64);
            } else {
                usuariodireccion.getUsuario().setImagen(null);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (usuariodireccion.getUsuario().getIdusuario() > 0) { //UPDATE
            usuarioDAOImplementation.Update(usuariodireccion.getUsuario());
        } else {
            int idUsuario = usuarioDAOImplementation.Add(usuariodireccion.getUsuario()); //Regresar el IDINSERTADO

            usuariodireccion.getDireccion().setUsuario(new Usuario(idUsuario));
            direccionDAOImplementation.Add(usuariodireccion.direccion);
        }

        return "redirect:/alumno/listado";
    }

    @GetMapping("/eliminarUsuario/{idusuario}")
    public String Delete(@PathVariable int idusuario, Model model) {

        Usuario usuario = usuarioDAOImplementation.GetById(idusuario);

        model.addAttribute("usuario", usuario);
        usuarioDAOImplementation.Delete(usuario);

        //getByID --> precargar elforumalrio JPQL
        // precargarlo con el model 
        return "redirect:/usuario/listado";
    }

    @GetMapping("/GetEstadoByIdPais")
    @ResponseBody
    public List<Estado> GetEstadoByIdPais(@RequestParam("IdPais") int IdPais) {
        List<Estado> estados = estadoDAOImplementation.GetByIdPais(IdPais);
        return estados;
    }

    @GetMapping("/GetMunicipioByIdEstado")
    @ResponseBody
    public List<Municipio> GetMunicipioByIdEstado(@RequestParam("IdEstado") int IdEstado) {
        List<Municipio> municipios = municipioDAOImplementation.GetByIdEstado(IdEstado);
        return municipios;
    }

    @GetMapping("/GetColoniaByIdMunicipio")
    @ResponseBody
    public List<Colonia> GetColoniaByIdMunicipio(@RequestParam("IdMunicipio") int IdMunicipio) {
        List<Colonia> colonias = coloniaDAOImplementation.GetByIdMunicipio(IdMunicipio);
        return colonias;
    }

    @GetMapping("/GetDireccionByIdColonia")
    @ResponseBody
    public List<Direccion> GetDireccionByIdColonia(@RequestParam("IdColonia") int IdColonia) {
        List<Direccion> direcciones = (List<Direccion>) direccionDAOImplementation.GetByIdColonia(IdColonia);
        return direcciones;
    }

    @GetMapping("/ChangeStatus")
    @ResponseBody
    public void ChangeStatus(@RequestParam("idUsuario") int idUsuario, @RequestParam("status") boolean status) {
        usuarioDAOImplementation.ChangeStatus(idUsuario, status);
    }

//    
//    @PostMapping("/deleteUsuario")
//    public String Delete(@ModelAttribute Usuario usuario){
//        
//        if(usuario != null){
//    usuarioDAOImplementation.Delete(usuario);}
//    
//    return "redirect:/usuario/listado";
//    }
//    @GetMapping("/add")
//    public String Add (Model model){
//    
//        model.addAttribute("usuario", new Usuario());
//        return "formUsuario";
//    }
//    @PostMapping("addusuario")
//    public String Add(@ModelAttribute Usuario usuario){
//    usuarioDAOImplementation.Add(usuario);
//    
//     return "redirect:/usuario/listado";
//    }
}
