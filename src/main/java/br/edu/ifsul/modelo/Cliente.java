package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

/**
 *
 * @author camila
 */
@Entity
@Table(name = "cliente")
public class Cliente implements Serializable {
    
    @Id
    @SequenceGenerator(name = "seq_cliente", sequenceName = "seq_cliente_id",
            allocationSize = 1)
    @GeneratedValue(generator = "seq_cliente", strategy = GenerationType.SEQUENCE)
    private Integer id;
    
    @NotBlank(message = "O nome deve ser informado!") // restrição para rejeitar campo em branco
    @Length(max = 40, message = "O nome não pode ter mais que {max} caracteres!") // restrição para tamanho
    @Column(name = "nome", nullable = false, length = 40)
    private String nome;
    
    @NotBlank(message = "O CPF deve ser informado!") // restrição para rejeitar campo em branco
    @Length(max = 11, min = 11, message = "O CPF deve ter {max} caracteres!") // restrição para tamanho
    @Column(name = "cpf", nullable = false, length = 11)
    private String cpf;
    
    @Temporal(TemporalType.DATE)
    @NotNull(message = "A data de cadastro deve ser informada!")
    @Column(name = "datacad", nullable = false)
    private Calendar dataCad = Calendar.getInstance();
    
    @NotBlank(message = "O email deve ser informado!") // restrição para rejeitar campo em branco
    @Length(max = 40, message = "O email não pode ter mais que {max} caracteres!") // restrição para tamanho
    @Column(name = "email", nullable = false, length = 40)
    private String email;
    
    @NotBlank(message = "O telefone deve ser informado!") // restrição para rejeitar campo em branco
    @Length(max = 11, min = 10, message = "O telefone deve entre {min} e {max} caracteres!") // restrição para tamanho
    @Column(name = "telefone", nullable = false, length = 11)
    private String telefone;
    
    @Temporal(TemporalType.DATE)
    @NotNull(message = "A data de nascimento deve ser informada!")
    @Column(name = "datanasc", nullable = false)
    private Calendar dataNasc = Calendar.getInstance();

    public Calendar getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(Calendar dataNasc) {
        this.dataNasc = dataNasc;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Cliente() {
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Cliente other = (Cliente) obj;
        return Objects.equals(this.id, other.id);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Calendar getDataCad() {
        return dataCad;
    }

    public void setDataCad(Calendar dataCad) {
        this.dataCad = dataCad;
    }
}
