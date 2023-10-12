/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.digis01.ERoqueProgramacionNCapasWeb.JPA;


import jakarta.persistence.Basic;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author digis
 */


@Entity 
public class Usuario implements Serializable {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int idusuario;
    
    
    @NotEmpty(message = "Ingresa datos")
    @Size(min = 3, max = 5, message = "Cadena entre 3 y 5")
    private String nombre;
    private String apellidopaterno;
    private String apellidomaterno;
    
    
    private String sexo;
    private String username;
    private String email;
    private String password;
    private String telefono;
    private String celular;
    private String curp;
    
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    @Temporal(TemporalType.DATE)
    private Date fechanacimiento;
    
    @ManyToOne
    @JoinColumn(name="idrol")
    private Rol rol;

    
    @Lob
    private String imagen;
    
    private String status;

    public Usuario() {
    }
   

//    public Usuario(String nombre, String apellido_pa, String apellido_ma, Date fecha_nacimiento ,String sexo) {
//        this.nombre = nombre;
//        this.apellido_pa = apellido_pa;
//        this.apellido_ma = apellido_ma;
//        this.fecha_nacimiento = fecha_nacimiento;
//        this.sexo = sexo;
//    }

//    public Usuario(int idusuario, String nombre, String apellido_pa, String apellido_ma, Date fecha_nacimiento,String sexo) {
//        this.idusuario = idusuario;
//        this.nombre = nombre;
//        this.apellido_pa = apellido_pa;
//        this.apellido_ma = apellido_ma;
//        this.fecha_nacimiento = fecha_nacimiento;
//        this.sexo = sexo;
//    }

    public Usuario(int idusuario) {
        this.idusuario = idusuario;
    }
    
    

    public Usuario(String nombre, String apellidopaterno, String apellidomaterno, String sexo, String username, String email, String password, String telefono, String celular, String curp, Date fechanacimiento, Rol rol) {
        this.nombre = nombre;
        this.apellidopaterno = apellidopaterno;
        this.apellidomaterno = apellidomaterno;
        this.sexo = sexo;
        this.username = username;
        this.email = email;
        this.password = password;
        this.telefono = telefono;
        this.celular = celular;
        this.curp = curp;
        this.fechanacimiento = fechanacimiento;
        this.rol = rol;
    }

    public Usuario(int idusuario, String nombre, String apellidopaterno, String apellidomaterno, String sexo, String username, String email, String password, String telefono, String celular, String curp, Date fechanacimiento, Rol rol) {
        this.idusuario = idusuario;
        this.nombre = nombre;
        this.apellidopaterno = apellidopaterno;
        this.apellidomaterno = apellidomaterno;
        this.sexo = sexo;
        this.username = username;
        this.email = email;
        this.password = password;
        this.telefono = telefono;
        this.celular = celular;
        this.curp = curp;
        this.fechanacimiento = fechanacimiento;
        this.rol = rol;
    }

    public Usuario(String nombre, String apellidopaterno, String apellidomaterno) {
        this.nombre = nombre;
        this.apellidopaterno = apellidopaterno;
        this.apellidomaterno = apellidomaterno;
    }
    
    

    public int getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(int idusuario) {
        this.idusuario = idusuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidopaterno() {
        return apellidopaterno;
    }

    public void setApellidopaterno(String apellidopaterno) {
        this.apellidopaterno = apellidopaterno;
    }

    public String getApellidomaterno() {
        return apellidomaterno;
    }

    public void setApellidomaterno(String apellidomaterno) {
        this.apellidomaterno = apellidomaterno;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getCurp() {
        return curp;
    }

    public void setCurp(String curp) {
        this.curp = curp;
    }

    public Date getFechanacimiento() {
        return fechanacimiento;
    }

    public void setFechanacimiento(Date fechanacimiento) {
        this.fechanacimiento = fechanacimiento;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    

    

    

    


    
   

    
    
    

    
    
    

   
    

   
    
    
    
    

    
    
    
    

    
}
